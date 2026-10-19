package core.config.selenide;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bytedeco.ffmpeg.global.avutil;
import org.bytedeco.javacv.FFmpegFrameRecorder;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;

/**
 * The video of a test from the frames that Chrome itself sends: the DevTools screencast over an own connection to the tab
 * ({@link AllureVideoRecorder} plans and attaches it).
 * The recorder of Selenide takes screenshots through the session of the test: at 3 frames a second the session was busy
 * with them 40 % of the time, and the commands of the test waited. Chrome sends a frame when the screen changes and the
 * session of the test is not used. The video takes the last frame FRAMES_PER_SECOND times a second at most, whatever the
 * number of changes; a frame stays in the video until the next one, so the video keeps the time of the test.
 */
@Slf4j
public final class ScreencastRecorder implements WebSocket.Listener {

	private static final ObjectMapper JSON = new ObjectMapper();

	private static final int FRAMES_PER_SECOND = 5;

	private static final ThreadLocal<Path> PLANNED = new ThreadLocal<>();

	private static final ThreadLocal<ScreencastRecorder> CURRENT = new ThreadLocal<>();

	private final Path file;

	private final long start = System.nanoTime();

	private final WebSocket socket;

	private final StringBuilder message = new StringBuilder();

	private final AtomicInteger lastId = new AtomicInteger();

	/**
	 * The last frame of Chrome that is not in the video yet
	 */
	private final AtomicReference<Frame> pending = new AtomicReference<>();

	private final ScheduledExecutorService encoder = Executors.newSingleThreadScheduledExecutor(task -> {
		var thread = new Thread(task, "screencast-encoder");
		thread.setDaemon(true);
		return thread;
	});

	/**
	 * The fields below are used by the encoder thread only
	 */
	private final Java2DFrameConverter converter = new Java2DFrameConverter();

	private FFmpegFrameRecorder recorder;

	private BufferedImage lastImage;

	private long lastFrameNumber = -1;

	private record Frame(byte[] jpeg, long micros) {

	}

	private ScreencastRecorder(Path file, WebDriver driver) {
		this.file = file;
		var options = (Map<?, ?>) ((HasCapabilities) driver).getCapabilities().getCapability("goog:chromeOptions");
		var url = "ws://" + options.get("debuggerAddress") + "/devtools/page/" + driver.getWindowHandle();
		socket = HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(URI.create(url), this).join();
		encoder.scheduleAtFixedRate(this::encodePending, 0, 1000 / FRAMES_PER_SECOND, TimeUnit.MILLISECONDS);
		// a smaller frame and every second frame: Chrome encodes and sends each of them, at every change of the screen
		send("Page.startScreencast", Map.of("format", "jpeg", "quality", 50, "maxWidth", 1280, "maxHeight", 720, "everyNthFrame", 2));
	}

	/**
	 * The test is recorded into the file from the moment its browser is opened ({@link #startIfPlanned()})
	 */
	public static void plan(Path file) {
		PLANNED.set(file);
	}

	/**
	 * Opens the browser of the test if it is not open yet and starts the recording, once a test
	 */
	public static void startIfPlanned() {
		var file = PLANNED.get();
		if (file == null || CURRENT.get() != null) {
			return;
		}
		PLANNED.remove();
		try {
			CURRENT.set(new ScreencastRecorder(file, WebDriverRunner.getAndCheckWebDriver()));
		} catch (RuntimeException e) {
			log.warn("The test is not recorded: the screencast did not start", e);
		}
	}

	/**
	 * Stops the recording of the test; the video, if the test opened the browser and Chrome sent frames
	 */
	public static Optional<Path> finish() {
		PLANNED.remove();
		var recorder = CURRENT.get();
		CURRENT.remove();
		return recorder == null ? Optional.empty() : recorder.stop();
	}

	@Override
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
		message.append(data);
		if (last) {
			var text = message.toString();
			message.setLength(0);
			onMessage(text);
		}
		webSocket.request(1);
		return null;
	}

	/**
	 * A frame is acknowledged at once, Chrome sends the next one after it; only the last one waits for the encoder
	 */
	private void onMessage(String text) {
		try {
			var json = JSON.readTree(text);
			if (!"Page.screencastFrame".equals(json.path("method").asText())) {
				return;
			}
			var params = json.path("params");
			send("Page.screencastFrameAck", Map.of("sessionId", params.path("sessionId").asInt()));
			pending.set(new Frame(Base64.getDecoder().decode(params.path("data").asText()), (System.nanoTime() - start) / 1000));
		} catch (IOException | RuntimeException e) {
			log.debug("A message of the screencast is skipped", e);
		}
	}

	private synchronized void send(String method, Map<String, Object> params) {
		try {
			socket.sendText(JSON.writeValueAsString(Map.of("id", lastId.incrementAndGet(), "method", method, "params", params)), true).join();
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
	}

	private void encodePending() {
		var frame = pending.getAndSet(null);
		if (frame == null) {
			return;
		}
		try {
			var image = ImageIO.read(new ByteArrayInputStream(frame.jpeg()));
			if (image != null) {
				record(image, frame.micros());
				lastImage = image;
			}
		} catch (Exception e) {
			log.debug("A frame of the screencast is skipped", e);
		}
	}

	private void record(BufferedImage image, long micros) throws IOException {
		long frameNumber = micros * FRAMES_PER_SECOND / 1_000_000;
		if (frameNumber <= lastFrameNumber) {
			frameNumber = lastFrameNumber + 1;
		}
		if (recorder == null) {
			Files.createDirectories(file.getParent());
			// yuv420p takes even sizes only
			recorder = new FFmpegFrameRecorder(file.toFile(), image.getWidth() / 2 * 2, image.getHeight() / 2 * 2);
			recorder.setFormat("webm");
			recorder.setVideoCodecName("libvpx");
			recorder.setPixelFormat(avutil.AV_PIX_FMT_YUV420P);
			recorder.setFrameRate(FRAMES_PER_SECOND);
			recorder.setVideoBitrate(2_000_000);
			recorder.setVideoOption("deadline", "realtime");
			recorder.setVideoOption("cpu-used", "8");
			recorder.start();
		}
		recorder.setFrameNumber((int) frameNumber);
		recorder.record(converter.convert(image));
		lastFrameNumber = frameNumber;
	}

	private Optional<Path> stop() {
		try {
			send("Page.stopScreencast", Map.of());
		} catch (RuntimeException e) {
			log.debug("The screencast is not stopped by the browser", e);
		}
		socket.abort();
		long end = (System.nanoTime() - start) / 1000;
		encoder.execute(() -> close(end));
		encoder.shutdown();
		try {
			encoder.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		try {
			return Files.exists(file) && Files.size(file) > 0 ? Optional.of(file) : Optional.empty();
		} catch (IOException e) {
			return Optional.empty();
		}
	}

	/**
	 * The last frame of Chrome goes in, and the last frame stays till the end of the test
	 */
	private void close(long end) {
		encodePending();
		if (recorder == null) {
			return;
		}
		try {
			if (lastImage != null && end * FRAMES_PER_SECOND / 1_000_000 > lastFrameNumber) {
				record(lastImage, end);
			}
			recorder.stop();
			recorder.release();
		} catch (Exception e) {
			log.warn("The video of the test is not finished", e);
		}
	}

}
