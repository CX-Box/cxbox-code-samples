package core.element.widget.modal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * What "Copy details" of an error popup puts on the clipboard: where the error happened and the {@link RequestDetails}
 * the popup also shows on screen.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ErrorDetails(
		String login,
		String location,
		String screen,
		String view,
		String errorType,
		Integer code,
		String message,
		/**
		 * The browser and its version as support would name it, or the whole user agent when it is not recognised
		 */
		String userAgent,
		/**
		 * Whether the browser has the Web Locks API: without it the tabs do not queue their token renewals
		 */
		Boolean webLocks,
		/**
		 * Whether the browser has IndexedDB: without it a refresh token cannot be recorded as sent and is never sent, the
		 * session lives by the SSO cookie alone. Support has to see both from the copied details rather than ask
		 */
		Boolean indexedDb,
		/**
		 * The three build constants of the authorization ({@code ui/src/constants/index.ts}) as this browser runs them:
		 * {@code rotationSafe} or {@code original}
		 */
		String userManager,
		/**
		 * {@code soft} or {@code strict}
		 */
		String authErrorMode,
		/**
		 * {@code oidcResponse} or {@code signInCallbackParam}
		 */
		String signInCallbackDetection,
		RequestDetails request
) {

	/**
	 * The clipboard JSON is flat
	 */
	@JsonCreator
	ErrorDetails(
			@JsonProperty("login") String login,
			@JsonProperty("location") String location,
			@JsonProperty("screen") String screen,
			@JsonProperty("view") String view,
			@JsonProperty("errorType") String errorType,
			@JsonProperty("code") Integer code,
			@JsonProperty("message") String message,
			@JsonProperty("userAgent") String userAgent,
			@JsonProperty("webLocks") Boolean webLocks,
			@JsonProperty("indexedDb") Boolean indexedDb,
			@JsonProperty("userManager") String userManager,
			@JsonProperty("authErrorMode") String authErrorMode,
			@JsonProperty("signInCallbackDetection") String signInCallbackDetection,
			@JsonProperty("sessionId") String sessionId,
			@JsonProperty("statusCode") Integer statusCode,
			@JsonProperty("statusText") String statusText,
			@JsonProperty("method") String method,
			@JsonProperty("url") String url,
			@JsonProperty("startedAt") String startedAt,
			@JsonProperty("finishedAt") String finishedAt
	) {
		this(login, location, screen, view, errorType, code, message, userAgent, webLocks, indexedDb,
				userManager, authErrorMode, signInCallbackDetection,
				new RequestDetails(sessionId, statusCode, statusText, method, url, startedAt, finishedAt));
	}

}
