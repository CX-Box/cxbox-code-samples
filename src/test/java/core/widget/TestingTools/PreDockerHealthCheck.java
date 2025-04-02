package core.widget.TestingTools;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@UtilityClass
public class PreDockerHealthCheck {

    @SneakyThrows
    public static void waitAppLoginPageReady(String url, Duration totalWait, Duration retryPeriod) {
        log.info("Application url:" + url);
        OkHttpClient client = new OkHttpClient.Builder().build();
        boolean success = false;
        for (LocalDateTime end = LocalDateTime.now().plusMinutes(totalWait.toMinutes());
             LocalDateTime.now().isBefore(end); ) {
            try {
                Request request = new Request.Builder().url(url).build();
                Call call = client.newCall(request);
                try (Response response = call.execute()) {
                    if (response.code() == 200) {
                        log.info("App login page is ready. Starting tests");
                        success = true;
                        return;
                    }
                }
            } catch (Exception exception) {
                //skip
            }
            log.info("App login page is not ready. Retrying app health check util success or " + end);
            Thread.sleep(retryPeriod.toMillis());
        }
        if (!success) {
            log.error("Application has not been started!!");
 			throw new IllegalStateException();
        }
    }

}