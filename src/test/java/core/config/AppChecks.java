package core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import org.awaitility.Awaitility;

import java.net.URI;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.function.Supplier;

import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@UtilityClass
@ThreadSafe
public class AppChecks {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	@NonNull
	@SneakyThrows
	public static String logoutAndRedirectToLoginPageUri(@NonNull URI uri) {
		log.debug("app server url: {}", uri);
		var authConfigUri = new Builder()
				.url(uri.getScheme() + "://" + uri.getHost() + (uri.getPort() != -1 ? ":" + uri.getPort() : "")
						+ "/api/v1/auth/oidc.json")
				.build();
		var client = new OkHttpClient.Builder().build();
		try (var rs = client.newCall(authConfigUri).execute()) {
			if (rs.body() != null) {
				var cfg = objectMapper.readValue(rs.body().string(), AuthConfig.class);
				log.debug("Auth server url: {}", cfg.authServerUrl());
				var authUri = new URI(cfg.authServerUrl());
				String logoutUri =
						authUri.getScheme() + "://" + authUri.getHost() + (authUri.getPort() != -1 ? ":" + authUri.getPort() : "")
								+ "/auth/realms/" + cfg.realm() + "/protocol/openid-connect/logout"
								+ "?redirect_uri=" + URLEncoder.encode(uri.toString(), UTF_8);
				log.debug("logout uri: {}", logoutUri);
				return logoutUri;
			}
		}
		throw new IllegalStateException("cannot determine authUri");
	}

	@SneakyThrows
	public static void waitAppLoginPageReady(@NonNull URI uri, @NonNull Duration totalWait,
											 @NonNull Duration retryPeriod) {
		log.info("Application url: " + uri);
		OkHttpClient client = new OkHttpClient.Builder().build();
		var request = new Builder().url(uri.toString()).build();
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
		try {
			Awaitility.await().atMost(totalWait)
					.pollInterval(retryPeriod)
					.pollDelay(Duration.ZERO)
					.untilAsserted(supplier::get);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public record AuthConfig(String realm, @JsonProperty("auth-server-url") String authServerUrl) {

	}

}