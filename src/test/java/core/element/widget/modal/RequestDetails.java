package core.element.widget.modal;

/**
 * The part of {@link ErrorDetails} an error popup shows on screen once expanded: session, status, request and timings
 */
public record RequestDetails(
		String sessionId,
		Integer statusCode,
		String statusText,
		String method,
		String url,
		String startedAt,
		String finishedAt
) {

}
