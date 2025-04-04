package core.config;

import java.net.URI;
import java.net.URL;
import javax.annotation.Nullable;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Env {

	public boolean videoEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_RECORDER"));
	}

	public static boolean logEnabled() {
		return "true".equalsIgnoreCase(System.getenv("CXBOX_LOGGER"));
	}

	@NonNull
	@SneakyThrows
	public static URI uri() {
		var url = System.getenv("APP_URL"); //local app run - "http://localhost:8080/ui/#/";
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
