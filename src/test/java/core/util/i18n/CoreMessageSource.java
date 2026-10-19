package core.util.i18n;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * The texts of the test core in the language of the locale of the JVM ({@code -Duser.language=ru}): the steps of the
 * report. English is {@code core/messages.properties}, Russian is {@code core/messages_ru.properties}.
 */
public final class CoreMessageSource {

	private static final ResourceBundle MESSAGES = ResourceBundle.getBundle("core.messages");

	private CoreMessageSource() {
	}

	public static String message(String code, Object... args) {
		return MessageFormat.format(MESSAGES.getString(code), args);
	}

}
