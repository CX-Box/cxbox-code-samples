package core.config.selenide;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.WebDriverRunner;
import core.util.FileUtil;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;

/**
 * The video of the test in its Allure report, from the frames that Chrome sends ({@link ScreencastRecorder}): the commands
 * of the test do not wait for screenshots, as with the recorder of Selenide. On with {@code selenide.video.enabled=true};
 * the video of a failed test is attached, of every test with {@code selenide.video.save.mode=ALL}. The recording starts
 * when the browser of the test is open: after the sign in of {@code @BeforeEach}, or later by
 * {@link ScreencastRecorder#startIfPlanned()} where the test opens the browser itself.
 *
 * <h5>Usage Example</h5>
 * <pre>{@code
 * @ExtendWith( {AllureJunit5.class, AllureVideoRecorder.class} )
 * public class MyTestForSamples {
 * }
 * }</pre>
 */
public class AllureVideoRecorder implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

	private static final AtomicLong COUNTER = new AtomicLong();

	@Override
	public void beforeTestExecution(ExtensionContext context) {
		if (!Boolean.getBoolean("selenide.video.enabled")) {
			return;
		}
		ScreencastRecorder.plan(Path.of("target", "videos", System.currentTimeMillis() + "." + COUNTER.incrementAndGet() + ".webm"));
		if (WebDriverRunner.hasWebDriverStarted()) {
			ScreencastRecorder.startIfPlanned();
		}
	}

	@Override
	public void afterTestExecution(ExtensionContext context) {
		var keep = context.getExecutionException().isPresent() || "ALL".equals(System.getProperty("selenide.video.save.mode"));
		ScreencastRecorder.finish().filter(video -> keep)
				.ifPresent(video -> Allure.addAttachment(message("report.video"), "video/webm", FileUtil.newInputStreamSneaky(video), ".webm"));
	}

}
