package core.widget.TestingTools;

import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
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
    private static final int FAILURE_LIMIT = 15;
    private boolean testFailed = false;
    private String videoPath;
    private VideoRecorder videoRecorder = new VideoRecorder();
    private final Set<String> droppedTest = new HashSet<>();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testFailed = true;
        if (getVideoEnv()) {
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
        testFailed = false; // Тест выполнен успешно
        log.info("Test passed: " + context.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        if (getVideoEnv()) {
            videoRecorder = new VideoRecorder();
            videoRecorder.start();
        }
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        if (getVideoEnv()) {
            videoRecorder.finish();
            videoPath = videoRecorder.videoUrl().get();
        }
    }

    /**
     * Counts the dropped tests and terminates all tests if more than FAILURE_LIMIT has fallen.
     *
     * Maven-surefire method skipAfterFailureCount currently does not work with junit 5,
     * as soon as it works, we will use it
     */
    @Override
    @DisplayName("skipAfterFailureCount")
    public void afterTestExecution(ExtensionContext context) throws Exception {
        droppedTest.add(context.getDisplayName());
        log.info("\n\n");
        log.info("Test " + context.getDisplayName() +  " dropped: Number of dropped test {}", droppedTest.size());

        if (droppedTest.size() >= FAILURE_LIMIT) {
            log.info("\nThe maximum number of errors has been reached. Completing the tests. \n");
            System.exit(1); // Принудительное завершение тестов
        }
    }

    private boolean getVideoEnv() {
        String recorder = System.getenv("CXBOX_RECORDER");
        return recorder != null && recorder.equalsIgnoreCase("true");
    }
}