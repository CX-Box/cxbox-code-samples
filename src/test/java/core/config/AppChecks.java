package core.config;

import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;

import java.net.URI;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

@Slf4j
@UtilityClass
@ThreadSafe
public class AppChecks {

	/**
	 * Waits until the application answers its start url with HTTP 200: a cold start takes minutes, so this is polled over plain HTTP
	 * once per run, before any browser is opened. It says nothing about what a browser shows; whether the browser is on the login
	 * page is checked with Selenide and the usual short timeout, see {@code BaseTestForSamples#shouldBeOnLoginPage()}.
	 */
	@SneakyThrows
	public static void waitAppStarted(@NonNull URI uri, @NonNull Duration totalWait, @NonNull Duration retryPeriod) {
		log.info("Application url: " + uri);
		OkHttpClient client = new OkHttpClient.Builder().build();
		var request = new Builder().url(uri.toString())
				// webpack dev server answers 404 to a request without Accept header, a browser always sends one
				.header("Accept", "text/html,*/*").build();
		boolean appReady = awaitIsTrue(
				totalWait, retryPeriod, "app started", () -> {
					try (var response = client.newCall(request).execute()) {
						if (response.code() == 200) {
							log.info("App login page is ready. Starting tests");
							return true;
						}
					} catch (Exception exception) {
						//skip
					}
					return false;
				}
		);
		if (!appReady) {
			throw new RuntimeException("App login page is not ready");
		}
	}

	/**
	 * <br>Repeatedly evaluates a boolean condition, provided by a supplier,
	 * until it returns true or the specified wait time elapsed.
	 * <br>The evaluation is retried at a specified interval.
	 * <br>If supplier thous error - it is equivalent as if supplier returned false
	 *
	 * @param totalWait   the total duration to wait before giving up
	 * @param retryPeriod the duration between evaluation retries
	 * @param target      a description of the target goal or condition being evaluated
	 * @param supplier    a supplier providing the condition to evaluate.
	 * @return true if the condition evaluates to true within the specified wait time, false otherwise
	 */
	@SneakyThrows
	public static boolean awaitIsTrue(Duration totalWait, Duration retryPeriod, String target,
									  Supplier<Boolean> supplier) {
		for (var end = LocalDateTime.now().plusNanos(totalWait.toNanos()); LocalDateTime.now().isBefore(end); ) {
			try {
				if (supplier.get()) {
					return true;
				}
			} catch (Exception exception) {
				//retry
			}

			log.info("Retrying to achieve target '{}' check util success or {}", target, end);
			Thread.sleep(retryPeriod.toMillis());
		}
		log.error("target '{}' has not been achieved!!", target);
		return false;
	}

}
