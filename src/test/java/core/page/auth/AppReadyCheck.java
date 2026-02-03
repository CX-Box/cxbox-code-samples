package core.page.auth;

import lombok.NonNull;

import java.net.URI;
import java.time.Duration;

public abstract class AppReadyCheck {

	/**
	 * Checks ready app started
	 *
	 * @param uri uri to check app ready
	 * @return url to start test
	 */
	public abstract String appReady(URI uri);

	/**
	 * Check auth page available
	 *
	 * @param uri         auth page uri
	 * @param totalWait   Duration max wait response auth page
	 * @param retryPeriod Duration retry period for check auth page
	 */
	public abstract void waitAppLoginPageReady(@NonNull URI uri, @NonNull Duration totalWait, @NonNull Duration retryPeriod);
}
