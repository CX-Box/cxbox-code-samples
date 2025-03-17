package core.widget.TestingTools;

import io.qameta.allure.Allure;
import lombok.Getter;
import org.junit.jupiter.api.extension.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

@Getter
public class TestStatusExtension implements TestWatcher, BeforeEachCallback, AfterEachCallback {

    private boolean testFailed = false;
    private String videoPath;
    private VideoRecorder videoRecorder;

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testFailed = true;
        File videoFile = Objects.requireNonNull(new File(videoPath).listFiles())[0];
        try {
            Allure.addAttachment("Video of the dropped test.", "video/avi", Files.newInputStream(videoFile.toPath()), ".avi");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testFailed = false; // Тест выполнен успешно
        System.out.println("Test passed: " + context.getDisplayName());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        videoPath = "target/videos/" + System.currentTimeMillis() + ".avi";
        videoRecorder = new VideoRecorder();
        videoRecorder.startRecording(videoPath);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        videoRecorder.stopRecording();
    }
}