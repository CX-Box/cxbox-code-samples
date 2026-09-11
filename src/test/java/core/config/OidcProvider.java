package core.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.URLEncoder;
import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * The OIDC provider of the application, as the application itself sees it: authority and client id come from
 * {@code /api/v1/auth/oidc.json}, the endpoints from the provider's {@code .well-known/openid-configuration}.
 * The single place the tests learn about the provider from; provider-specific administration (Keycloak, Blitz, ...)
 * is built on top of it in the application layer.
 */
@Slf4j
@Getter
public class OidcProvider {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	private final String authority;

	private final String clientId;

	private final String endSessionEndpoint;

	private final String tokenEndpoint;

	@SneakyThrows
	private OidcProvider(@NonNull AuthConfig config) {
		this.authority = config.authority();
		this.clientId = config.clientId();
		var discovery = objectMapper.readValue(get(authority + "/.well-known/openid-configuration"), Discovery.class);
		this.endSessionEndpoint = discovery.endSessionEndpoint();
		this.tokenEndpoint = discovery.tokenEndpoint();
		log.info("OIDC provider of the application: {} (client {})", authority, clientId);
	}

	@SneakyThrows
	public static OidcProvider ofApp(@NonNull URI appUri) {
		return new OidcProvider(objectMapper.readValue(get(appUri.resolve("/api/v1/auth/oidc.json").toString()), AuthConfig.class));
	}

	/**
	 * Whether the application has a signed-in user in its storage: the sign in callback is done and the tokens are there.
	 * Before that point the browser state is in flight: a logout would miss the {@code id_token_hint}, a storage cleanup would be undone.
	 */
	public static boolean isUserStored() {
		return storedUser() != null;
	}

	/**
	 * The end-session url to open in the browser: ends the provider session of the user the application has stored
	 * ({@code id_token_hint} is read from the application's storage) and returns to the application.
	 */
	@SneakyThrows
	public String logoutUrl(@NonNull URI returnTo) {
		var url = endSessionEndpoint
				+ "?client_id=" + clientId
				+ "&post_logout_redirect_uri=" + URLEncoder.encode(returnTo.toString(), UTF_8)
				+ "&redirect_uri=" + URLEncoder.encode(returnTo.toString(), UTF_8);
		var storedUser = storedUser();
		if (storedUser == null) {
			log.warn("no user stored by the application: logging out without id_token_hint");
			return url;
		}
		return url + "&id_token_hint=" + objectMapper.readTree(storedUser).path("id_token").asText();
	}

	/**
	 * The user oidc-client-ts stored for the application (JSON), null when nobody is signed in
	 */
	private static String storedUser() {
		return executeJavaScript("""
				    var key = Object.keys(localStorage).find(k => k.startsWith('oidc.user:'));
				    return key ? localStorage.getItem(key) : null;
				""");
	}

	@SneakyThrows
	private static String get(String url) {
		try (var response = new OkHttpClient().newCall(new Request.Builder().url(url).build()).execute()) {
			if (!response.isSuccessful()) {
				throw new IllegalStateException("GET " + url + " -> " + response.code());
			}
			return response.body().string();
		}
	}

	// TODO >> this config related which version used ( oidc standard  or old oidc keyclock conf on application.yaml)
	@JsonIgnoreProperties(ignoreUnknown = true)
	private record AuthConfig(@JsonProperty("authority") String authority, @JsonProperty("client_id") String clientId) {

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	private record Discovery(
			@JsonProperty("end_session_endpoint") String endSessionEndpoint,
			@JsonProperty("token_endpoint") String tokenEndpoint
	) {

	}

}
