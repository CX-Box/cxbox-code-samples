package core.config.selenide;

import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.impl.WebElementSource;
import core.element.widget.modal.ErrorPopupException;
import org.jspecify.annotations.Nullable;

/**
 * The commands of Selenide that stop when the error popup of the application is on the screen: every command of the test
 * core (a click, an input, a check, each retry of a wait) goes through here. The popup can come after any line of an
 * action; the next command stops at once with {@link ErrorPopupException}, not with a covered element or a timeout.
 * The commands on the popup itself go on. Selenide takes this class instead of its own by
 * {@code META-INF/services/com.codeborne.selenide.commands.Commands}.
 */
public class ErrorPopupCommands extends Commands {

	@Override
	public <T> @Nullable T execute(Object proxy, WebElementSource webElementSource, String methodName, Object @Nullable [] args) {
		if (!webElementSource.getSearchCriteria().contains(ErrorPopupException.SELECTOR)) {
			ErrorPopupException.throwIfShown();
		}
		return super.execute(proxy, webElementSource, methodName, args);
	}

}
