package application.config.props;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

@UtilityClass
public class Env {

	private final static Duration TIMEOUT = Duration.ofSeconds(3);

	private final static Duration OVER_TIMEOUT = Duration.ofSeconds(3);

	private final static Integer POLLING_RATE  = 10;

	public static boolean videoEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_RECORDER"));
	}

	public static boolean logEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_LOGGER"));
	}

	public static Duration timeout() {
		var timeout = System.getenv("TIMEOUT");

		if (timeout == null) {
			return TIMEOUT;
		}
		return Duration.ofSeconds(Long.parseLong(timeout));
	}

	public static Duration overTimeout() {
		var timeout = System.getenv("OVER_TIMEOUT");

		if (timeout == null) {
			return OVER_TIMEOUT;
		}
		return Duration.ofSeconds(Long.parseLong(timeout));
	}

	public static Integer poolingRate() {
		var rate = System.getenv("POOLING_RATE");

		if (rate == null) {
			return POLLING_RATE;
		}

		return Integer.parseInt(rate);
	}

	@NonNull
	@SneakyThrows
	public static URI uri() {
		var url = System.getenv("APP_URL");

		if (!isValidURL(url)) {
			return new URI("http://code-samples.cxbox.org/ui/#/");
		}
		return new URI(url);
	}

	@SneakyThrows
	static boolean isValidURL(@Nullable String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
