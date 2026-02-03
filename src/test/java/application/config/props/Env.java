package application.config.props;

import jakarta.annotation.Nullable;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.net.URI;
import java.net.URL;

@UtilityClass
public class Env {

	public static boolean videoEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_RECORDER"));
	}

	public static boolean logEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_LOGGER"));
	}

	@NonNull
	@SneakyThrows
	public static URI uri() {
		var url = System.getenv("APP_URL");

		if (!isValidURL(url)) {
			return new URI("http://localhost:3000");
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
