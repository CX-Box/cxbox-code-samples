package core.util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.LogEvent;
import com.codeborne.selenide.logevents.LogEventListener;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pictures of the documentation articles, taken by the ordinary tests.
 * Every method is a no-op unless the tests run with {@code -DdocShots=<docs folder of the doc repository>}.
 * The size of the browser window is given explicitly for every picture: it defines how the page is laid out on it.
 * <ul>
 *   <li>{@link #png}: a screenshot of an element into the folder of an article;</li>
 *   <li>{@link #gif}/{@link #stop}: a GIF of the browser window whose frames are taken after every
 *   action of the test core (click, hover, set value...) between the two calls.</li>
 * </ul>
 */
public final class DocShots {

	private static final Path ROOT = Path.of(System.getProperty("docShots", ""));

	private static final Dimension SHOT_WINDOW = new Dimension(1600, 1000);

	private static final int FRAME_MS = 1500;

	private static final int CLICK_FRAME_MS = 600;

	private static final int LAST_FRAME_MS = 2500;

	private static final String LISTENER = "docShots";

	/**
	 * Remembers the last click of the page for the click indicator of the GIF frames. The script lives in the page
	 * only while a GIF is recorded (between {@link #gif} and {@link #stop}); it changes nothing in the application.
	 */
	private static final String CLICK_TRACKER = "window.__docShotsClick = null;"
			+ "document.addEventListener('mousedown', function (e) { window.__docShotsClick = {x: e.clientX, y: e.clientY, t: Date.now()}; }, true);";

	/** Position of the last click in the viewport, or null when the click is older than the previous frame. */
	private static final String LAST_CLICK = "var c = window.__docShotsClick; return (!c || c.t < arguments[0]) ? null : [c.x, c.y];";

	private static final int CLICK_RADIUS = 14;

	private static long lastFrameTime;


	private static final List<BufferedImage> FRAMES = new ArrayList<>();

	/** Delay of every frame in milliseconds. */
	private static final List<Integer> DELAYS = new ArrayList<>();

	private static Path gifFile;

	/** What a frame of the GIF is. */
	public enum Frame {
		/** The whole browser window: for the scenarios with a popup, which is centered in the window. */
		WITH_SIDEBAR,
		/** The page without the side menu: for the scenarios on the page itself. */
		WITHOUT_SIDEBAR
	}

	private static Frame frameOf;



	private static boolean capturing;

	private DocShots() {
	}

	public static boolean enabled() {
		return !ROOT.toString().isEmpty();
	}

	/** Chrome arguments that keep the pictures of the same scale on every machine. */
	public static List<String> chromeArguments() {
		return enabled() ? List.of("--force-device-scale-factor=1") : List.of();
	}

	public static String browserSize() {
		return SHOT_WINDOW.getWidth() + "x" + SHOT_WINDOW.getHeight();
	}

	/**
	 * Saves the element as a PNG of the article.
	 *
	 * @param article folder of the article under docs, e.g. {@code widget/fields/field/pickTree}
	 * @param width   width of the browser window while the picture is taken
	 * @param height  height of the browser window while the picture is taken
	 */
	public static void png(SelenideElement element, String article, String file, int width, int height) {
		if (!enabled()) {
			return;
		}
		window(width, height);
		try {
			Path target = ROOT.resolve(article).resolve(file);
			Files.createDirectories(target.getParent());
			Files.copy(element.shouldBe(Condition.visible).screenshot().toPath(), target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	/** Saves the whole page (with the modals) as a PNG of the article. */
	public static void png(String article, String file, int width, int height) {
		png(Selenide.$("body"), article, file, width, height);
	}

	/**
	 * Starts a GIF of the article: the browser window is set to the size, the first frame is taken at once,
	 * a frame is added after every action of the test core until {@link #stop()}.
	 *
	 * @param width  width of the browser window while the GIF is recorded
	 * @param height height of the browser window while the GIF is recorded
	 * @param frame  the whole window (a popup is centered in it) or the page without the side menu
	 */
	public static void gif(String article, String file, int width, int height, Frame frame) {
		if (!enabled()) {
			return;
		}
		gifFile = ROOT.resolve(article).resolve(file);
		frameOf = frame;
		FRAMES.clear();
		DELAYS.clear();
		window(width, height);
		Selenide.executeJavaScript(CLICK_TRACKER);
		lastFrameTime = 0;
		frame();
		SelenideLogger.addListener(LISTENER, new FrameListener());
	}

	/** Sets the browser window and lets the page re-render. */
	private static void window(int width, int height) {
		WebDriverRunner.getWebDriver().manage().window().setSize(new Dimension(width, height));
		Selenide.sleep(700);
	}

	/** Writes the GIF started by {@link #gif}. */
	public static void stop() {
		if (!enabled() || gifFile == null) {
			return;
		}
		SelenideLogger.removeListener(LISTENER);
		frame();
		DELAYS.set(DELAYS.size() - 1, LAST_FRAME_MS);
		try {
			AnimatedGif.write(FRAMES, DELAYS, gifFile);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
		FRAMES.clear();
		DELAYS.clear();
		gifFile = null;
	}

	private static void frame() {
		if (capturing) {
			return;
		}
		capturing = true;
		try {
			Selenide.sleep(700);
			SelenideElement page = Selenide.$(frameOf == Frame.WITH_SIDEBAR ? "body" : "main");
			BufferedImage cut = page.screenshotAsImage();
			if (cut == null) {
				return;
			}
			// the click is shown briefly on a copy of the previous frame, where the clicked element is still visible
			BufferedImage clicked = FRAMES.isEmpty() ? null : markClick(FRAMES.get(FRAMES.size() - 1), page.getLocation());
			if (clicked != null) {
				FRAMES.add(clicked);
				DELAYS.add(CLICK_FRAME_MS);
			}
			if (FRAMES.isEmpty() || !same(FRAMES.get(FRAMES.size() - 1), cut)) {
				FRAMES.add(cut);
				DELAYS.add(FRAME_MS);
			}
			lastFrameTime = System.currentTimeMillis();
		} finally {
			capturing = false;
		}
	}

	/** A copy of the frame with the click indicator, or null when no click happened after the previous frame. */
	private static BufferedImage markClick(BufferedImage source, Point origin) {
		List<?> click = Selenide.executeJavaScript(LAST_CLICK, lastFrameTime);
		if (click == null || click.size() < 2) {
			return null;
		}
		int x = ((Number) click.get(0)).intValue() - origin.getX();
		int y = ((Number) click.get(1)).intValue() - origin.getY();
		if (x < 0 || y < 0 || x >= source.getWidth() || y >= source.getHeight()) {
			return null;
		}
		BufferedImage frame = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics2D g = frame.createGraphics();
		g.drawImage(source, 0, 0, null);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(new Color(255, 140, 0, 90));
		g.fillOval(x - CLICK_RADIUS, y - CLICK_RADIUS, 2 * CLICK_RADIUS, 2 * CLICK_RADIUS);
		g.setColor(new Color(255, 120, 0));
		g.setStroke(new BasicStroke(3));
		g.drawOval(x - CLICK_RADIUS, y - CLICK_RADIUS, 2 * CLICK_RADIUS, 2 * CLICK_RADIUS);
		g.dispose();
		return frame;
	}

	private static boolean same(BufferedImage a, BufferedImage b) {
		if (a.getWidth() != b.getWidth() || a.getHeight() != b.getHeight()) {
			return false;
		}
		int[] pa = a.getRGB(0, 0, a.getWidth(), a.getHeight(), null, 0, a.getWidth());
		int[] pb = b.getRGB(0, 0, b.getWidth(), b.getHeight(), null, 0, b.getWidth());
		return Arrays.equals(pa, pb);
	}

	/** Adds a frame after every action of the test core; checks (should...) add nothing. */
	private static final class FrameListener implements LogEventListener {

		private static final List<String> ACTIONS = List.of("click", "hover", "set value", "press", "select", "send keys", "clear", "double click");

		@Override
		public void afterEvent(LogEvent event) {
			if (event.getStatus() != LogEvent.EventStatus.PASS || capturing) {
				return;
			}
			String subject = String.valueOf(event.getSubject()).toLowerCase();
			if (ACTIONS.stream().anyMatch(subject::startsWith)) {
				frame();
			}
		}

		@Override
		public void beforeEvent(LogEvent event) {
			// nothing to do
		}

	}

}
