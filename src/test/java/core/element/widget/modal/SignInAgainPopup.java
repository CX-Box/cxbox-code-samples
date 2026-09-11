package core.element.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

/**
 * The "Sign in again?" popup. The backend answered 401 (the session has expired) or 403 (insufficient permissions),
 * see {@link #checkReason}; the user presses {@link #clickYes()} (sign in again) or {@link #clickNo()} (continue at own risk).
 * <p>
 * A plain selector: the first call that touches the popup waits for it to appear (the DSL timeout).
 */
public class SignInAgainPopup implements SingleElement {

	private final ExpectationPattern expectations = new CxBoxExpectations();

	/**
	 * The popup follows a failed token renewal: up to 3 attempts 1 second apart, each a roundtrip to the OIDC provider (a silent
	 * sign-in through an iframe when there is no stored user), so it takes longer to appear than an element of the page
	 */
	private static final Duration APPEARS_WITHIN = Duration.ofSeconds(15);

	/**
	 * The wrapper carrying the status; a non-waiting locator, so the "shown or not" checks do not throw
	 */
	private final SelenideElement root = $("div[data-test-auth-error-popup='true']");

	private SelenideElement modal;

	/**
	 * Why the popup was shown
	 */
	public enum Reason {
		SESSION_EXPIRED,
		INSUFFICIENT_PERMISSIONS
	}

	@Override
	public SelenideElement element() {
		if (modal == null) {
			modal = root.$(".ant-modal").shouldBe(Condition.visible, APPEARS_WITHIN);
		}
		return modal;
	}

	public SignInAgainPopup checkReason(Consumer<Reason> checkReason) {
		return Allure.step("Getting the reason", step -> {
			logTime(step);
			var status = root.shouldBe(Condition.exist, APPEARS_WITHIN).getAttribute("data-test-auth-error-popup-status");
			checkReason.accept("403".equals(status) ? Reason.INSUFFICIENT_PERMISSIONS : Reason.SESSION_EXPIRED);
			return this;
		});
	}

	public SignInAgainPopup checkTitle(Consumer<String> checkTitle) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			checkTitle.accept(getTextElement("[data-test-auth-error-popup-title]"));
			return this;
		});
	}

	/**
	 * The text under the title (in soft mode the "continue at your own risk" hint)
	 */
	public SignInAgainPopup checkMessage(Consumer<String> checkMessage) {
		return Allure.step("Getting the message text", step -> {
			logTime(step);
			checkMessage.accept(getTextElement("[data-test-auth-error-popup-hint]"));
			return this;
		});
	}

	public SignInAgainPopup checkTitleAndMessage(Consumer<String> checkTitle, Consumer<String> checkMessage) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			checkTitle.accept(getTextElement("[data-test-auth-error-popup-title]"));
			checkMessage.accept(getTextElement("[data-test-auth-error-popup-hint]"));
			return this;
		});
	}

	/**
	 * Hands over what "Copy details" put on the clipboard
	 */
	public SignInAgainPopup checkDetails(Consumer<ErrorDetails> checkDetails) {
		return Allure.step("Getting the copied details", step -> {
			logTime(step);
			checkDetails.accept(copyDetails());
			return this;
		});
	}

	/**
	 * Hands over what "Copy details" put on the clipboard and what the expanded panel shows
	 */
	public SignInAgainPopup checkDetails(BiConsumer<ErrorDetails, RequestDetails> checkDetails) {
		return Allure.step("Getting the copied and the expanded details", step -> {
			logTime(step);
			checkDetails.accept(copyDetails(), expandDetails());
			return this;
		});
	}

	public ErrorDetails copyDetails() {
		return details().copy();
	}

	public RequestDetails expandDetails() {
		return details().expand();
	}

	/**
	 * "Yes": signs in again, the login page follows
	 */
	public void clickYes() {
		clickButton("Yes", "ok");
	}

	/**
	 * "No": continues at own risk, the popup closes
	 */
	public void clickNo() {
		clickButton("No", "cancel");
	}

	/**
	 * Waits up to the period for the popup to show; false when it did not
	 */
	public boolean isShown(Duration period) {
		return root.is(Condition.visible, period);
	}

	/**
	 * Waits until the popup is not shown (it closed, or never opened)
	 */
	public void shouldNotBeShown() {
		shouldNotBeShown(expectations.getTimeout());
	}

	/**
	 * Fails unless the popup is not shown for the whole period (e.g. the "No" answer is remembered and does not reopen it)
	 */
	public void shouldNotBeShown(Duration period) {
		root.shouldNotBe(Condition.visible, period);
	}

	private void clickButton(String label, String kind) {
		Allure.step("Clicking on the " + label + " button", step -> {
			logTime(step);
			element().$("button[data-test-auth-error-popup-button-" + kind + "]")
					.shouldBe(Condition.enabled, expectations.getTimeout())
					.click();
		});
	}

	private RequestErrorDetailsRow details() {
		return new RequestErrorDetailsRow(element(), expectations);
	}

	private String getTextElement(String locator) {
		return element().$(locator).shouldBe(Condition.visible, expectations.getTimeout()).text();
	}

}
