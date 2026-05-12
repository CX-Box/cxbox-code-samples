package core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.jcip.annotations.ThreadSafe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

import java.net.URI;
import java.net.URLEncoder;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
@UtilityClass
@ThreadSafe
public class AppChecks {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	// TODO >> cxbox >> need universal logic for auth
	@NonNull
	@SneakyThrows
	public static String logout(@NonNull URI uri) {
		log.info("app server url: {}", uri);
		var authConfigUri = new Builder()
				.url(uri.getScheme() + "://" + uri.getHost() + (uri.getPort() != -1 ? ":" + uri.getPort() : "")
						+ "/api/v1/auth/oidc.json")
				.build();
		var client = new OkHttpClient.Builder().build();
		try (var rs = client.newCall(authConfigUri).execute()) {
			if (rs.body() != null) {
				var cfg = objectMapper.readValue(rs.body().string(), AuthConfig.class);
				log.info("Auth server url: {}", cfg.authority());
				var authUri = new URI(cfg.authority());
				Request request = new Request.Builder()
						.url(authUri + "/.well-known/openid-configuration")
						.build();
				try (Response response = new OkHttpClient().newCall(request).execute()) {
					JsonNode json = objectMapper.readTree(response.body().string());
					String endSessionEndpoint = json.get("end_session_endpoint").asText(); // get
					var logoutUrl = endSessionEndpoint
							+ "?client_id=" + cfg.clientId
							+ "&post_logout_redirect_uri=" + URLEncoder.encode(uri.toString(), UTF_8)
							+ "&redirect_uri=" + URLEncoder.encode(uri.toString(), UTF_8);
					try {
						String sessionUserData = executeJavaScript("""
								    var key = Object.keys(localStorage).find(k => k.startsWith('oidc.user:'));
								    return key ? localStorage.getItem(key) : null;
								""");
						if (sessionUserData != null) {
							String idToken = objectMapper.readTree(sessionUserData).path("id_token").asText();
							if (!idToken.isEmpty()) {
								logoutUrl += "&id_token_hint=" + idToken;
							}
						}
					} catch (Exception e) {
						log.error("Cannot find session data from storage");
					}
					return logoutUrl;
				}
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

	// TODO >> this config related which version used ( oidc standard  or old oidc keyclock conf on application.yaml)
	@JsonIgnoreProperties(ignoreUnknown = true)
	public record AuthConfig(@JsonProperty("authority") String authority, @JsonProperty("client_id") String clientId) {

	}

}