package core.common.highlight;

import com.codeborne.selenide.Command;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.WebElementSource;

public class HighlightedCommand<T> implements Command<T> {

	private final Command<T> originalCommand;

	public HighlightedCommand(Command<T> originalCommand) {
		this.originalCommand = originalCommand;
	}

	@Override
	public T execute(SelenideElement proxy, WebElementSource locator, Object[] args) {
		try {

			HighlightManager.getInstance().highlight(proxy);
			T result = originalCommand.execute(proxy, locator, args);

			return result;
		} finally {
			// Optional: unhighlight after action
			// locator.getWebElement().execute(new Unhighlight());
		}
	}
}
