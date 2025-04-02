package core.widget.TestingTools;

import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.*;
import org.selenide.videorecorder.core.VideoRecorder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

@Getter
@Slf4j
public class TestStatusExtension implements TestWatcher, BeforeEachCallback, AfterEachCallback, AfterTestExecutionCallback {
    private static final int FAILED_TESTS_COUNT = 10;
    private boolean testFailed = false;
    private String videoPath;
    private VideoRecorder videoRecorder = new VideoRecorder();
    private final Set<String> failedTestsSet = new HashSet<>();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testFailed = true;
        if (getEnv()) {
            try {
                int index = videoPath.indexOf("target");
                Allure.addAttachment("Video of the dropped test.", "video/webm", Files.newInputStream(Path.of(videoPath.substring(index))), ".webm");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testFailed = false;
        String completedTest = context.getTestClass().get().getName()+"#"+context.getTestMethod().get().getName();
        log.info("Test passed: " + completedTest);
        failedTestsSet.remove(completedTest);
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        if (getEnv()) {
            videoRecorder = new VideoRecorder();
            videoRecorder.start();
        }
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (getEnv()) {
            videoRecorder.finish();
            videoPath = videoRecorder.videoUrl().get();
        }
    }

    private boolean getEnv() {
        String recorder = System.getenv("CXBOX_RECORDER");
        return recorder != null && recorder.equalsIgnoreCase("true");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        String failedTest = extensionContext.getTestClass().get().getName()+"#"+extensionContext.getTestMethod().get().getName();
        failedTestsSet.add(failedTest);
        log.info("Test " + failedTest + " failed, count of dropped test: " + failedTestsSet.size());

        if (failedTestsSet.size() >= FAILED_TESTS_COUNT) {
            log.info("Count of failed test > " + FAILED_TESTS_COUNT + " skip remaining tests");
            System.exit(1);
        }
    }
}