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
			@JsonProperty("sessionId") String sessionId,
			@JsonProperty("statusCode") Integer statusCode,
			@JsonProperty("statusText") String statusText,
			@JsonProperty("method") String method,
			@JsonProperty("url") String url,
			@JsonProperty("startedAt") String startedAt,
			@JsonProperty("finishedAt") String finishedAt
	) {
		this(login, location, screen, view, errorType, code, message,
				new RequestDetails(sessionId, statusCode, statusText, method, url, startedAt, finishedAt));
	}

}
