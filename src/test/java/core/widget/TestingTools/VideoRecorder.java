package core.widget.TestingTools;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

import java.io.IOException;

public class VideoRecorder {

    private FFmpegExecutor executor;
    private String outputFile;

    public VideoRecorder(String outputFile) {
        this.outputFile = outputFile;
    }

    public void startRecording() throws IOException {
        // Указываем путь к FFmpeg (если он не в PATH)

        // Создаем объект FFmpeg
        FFmpeg ffmpeg = new FFmpeg();

        // Создаем билдер для настройки FFmpeg
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput("desktop") // Захват экрана (для Windows)
                // .setInput(":0.0") // Захват экрана (для Linux)
                // .setInput("video=Integrated Camera") // Захват с веб-камеры (Windows)
                .overrideOutputFiles(true) // Перезаписывать выходной файл, если он существует
                .addOutput(outputFile) // Выходной файл
                .setFormat("mp4") // Формат видео
                .setVideoCodec("libx264") // Кодек видео
                .setVideoFrameRate(30) // FPS
                .setVideoResolution(1280, 720) // Разрешение видео
                .done();

        // Создаем исполнитель и запускаем FFmpeg
        executor = new FFmpegExecutor(ffmpeg);
        executor.createJob(builder).run();
    }

    public void stopRecording() {
        if (executor != null) {
            // Останавливаем FFmpeg (завершаем процесс)
            executor = null;
            System.out.println("Запись видео завершена. Файл сохранен: " + outputFile);
        }
    }
}