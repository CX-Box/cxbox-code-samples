//package core.widget.TestingTools;
//
//import io.qameta.allure.Allure;
//import lombok.Getter;
//import org.junit.jupiter.api.extension.AfterEachCallback;
//import org.junit.jupiter.api.extension.BeforeEachCallback;
//import org.junit.jupiter.api.extension.ExtensionContext;
//import org.junit.jupiter.api.extension.TestWatcher;
//import org.selenide.videorecorder.core.VideoRecorder;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//@Getter
//public class TestStatusExtension implements TestWatcher, BeforeEachCallback, AfterEachCallback {
//
//    private boolean testFailed = false;
//    private String videoPath;
//    private VideoRecorder videoRecorder = new VideoRecorder();
//
//    @Override
//    public void testFailed(ExtensionContext context, Throwable cause) {
//        testFailed = true;
//        if (getEnv()) {
//            try {
//                int index = videoPath.indexOf("target");
//                Allure.addAttachment("Video of the dropped test.", "video/webm", Files.newInputStream(Path.of(videoPath.substring(index))), ".webm");
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public void testSuccessful(ExtensionContext context) {
//        testFailed = false; // Тест выполнен успешно
//        System.out.println("Test passed: " + context.getDisplayName());
//    }
//
//    @Override
//    public void beforeEach(ExtensionContext context) throws Exception {
//        if (getEnv()) {
//            videoRecorder = new VideoRecorder();
//            videoRecorder.start();
//        }
//    }
//
//    @Override
//    public void afterEach(ExtensionContext context) throws Exception {
//        if (getEnv()) {
//            videoRecorder.finish();
//            videoPath = videoRecorder.videoUrl().get();
//        }
//    }
//
//    private boolean getEnv() {
//        String recorder = System.getenv("CXBOX_RECORDER");
//        return recorder != null && recorder.equalsIgnoreCase("true");
//    }
//}