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
        // Указываем путь к FFmpeg
        //String ffmpegPath = "C:/ffmpeg-master-latest-win64-gpl/bin/ffmpeg.exe ";

        // Создаем объект FFmpeg
        FFmpeg ffmpeg = new FFmpeg();

        // Создаем билдер для настройки FFmpeg
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(":0.0") // Захват экрана (для Linux)
                .overrideOutputFiles(true) // Перезаписывать выходной файл, если он существует
                .addOutput(outputFile) // Выходной файл
                .setFormat("mp4") // Формат видео
                .setVideoCodec("mpeg4") // Кодек видео
                .setVideoFrameRate(30) // FPS
                .setVideoResolution(320, 240) // Разрешение видео
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