package core.element.widget.modal;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import java.time.Duration;
import java.util.function.Supplier;
import org.openqa.selenium.By;

/**
 * The error popup of the application is on the screen. The test core throws it from the next command after the popup
 * came, wherever in an action it came ({@link core.config.selenide.ErrorPopupCommands}): a test that expects the popup
 * takes it with {@code expectErrorPopup}, any other test fails with the text of the popup.
 *
 * <h5>Usage Example</h5>
 * <pre>{@code
 * form.expectErrorPopup(() -> form.date("Custom Field").setValue(date))
 *         .checkTitleAndMessage(
 *                 title -> assertThat(title).isEqualTo("Error"),
 *                 message -> assertThat(message).isEqualTo("The date is less than the current one"))
 *         .close();
 * }</pre>
 */
public class ErrorPopupException extends RuntimeException {

	/**
	 * The error popup of the application
	 */
	public static final String SELECTOR = "div[data-test-error-popup=\"true\"]";

	/**
	 * The test works with the popup: copying its details uses the message of the page and the clipboard, outside of the popup
	 */
	private static final ThreadLocal<Integer> WORK = ThreadLocal.withInitial(() -> 0);

	private final transient ErrorPopup<?> popup;

	private ErrorPopupException(String text) {
		super(message("report.errorPopup", text));
		this.popup = new ErrorPopup<>();
	}

	/**
	 * The popup that stopped the action, for the checks of the test
	 */
	public ErrorPopup<?> popup() {
		return popup;
	}

	/**
	 * Stops the command when the error popup is on the screen, unless the test works with the popup now
	 */
	public static void throwIfShown() {
		if (WORK.get() > 0) {
			return;
		}
		var popups = WebDriverRunner.getWebDriver().findElements(By.cssSelector(SELECTOR));
		if (!popups.isEmpty()) {
			throw new ErrorPopupException(popups.get(0).getText().replaceAll("\\s+", " ").strip());
		}
	}

	/**
	 * The work of the test with the open popup: its commands outside of the popup go on
	 */
	static <T> T inside(Supplier<T> work) {
		WORK.set(WORK.get() + 1);
		try {
			return work.get();
		} finally {
			WORK.set(WORK.get() - 1);
		}
	}

	/**
	 * Runs the action that ends with the error popup: the action stopped by the popup, or the popup after the action.
	 * No popup within the timeout fails the test.
	 */
	public static void expect(Runnable action, Duration timeout) {
		try {
			action.run();
		} catch (ErrorPopupException expected) {
			return;
		}
		if (!Selenide.$(SELECTOR).is(Condition.exist, timeout)) {
			throw new AssertionError(message("errorPopup.none"));
		}
	}

}
