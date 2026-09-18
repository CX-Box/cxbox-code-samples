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
 * The popup of a lost session. The backend answered 401 (the session has expired) or 403 (insufficient permissions), see
 * {@link #checkReason}. The user presses {@link #clickSignInAgain()} (to the OIDC provider and back, no login page while the SSO
 * session lives), {@link #clickSignOut()} (logout, the login page follows) or {@link #close()} (stays on the page, the popup
 * comes back later).
 * <p>
 * A plain selector: the first call that touches the popup waits for it to appear (the DSL timeout).
 */
public class SignInAgainPopup implements SingleElement {

	private final ExpectationPattern expectations = new CxBoxExpectations();

	/**
	 * The popup follows a token renewal that did not work out: a request with the refresh token, then a silent sign in through a
	 * hidden iframe (up to 30 seconds where it gets no answer), so it takes longer to appear than an element of the page
	 */
	private static final Duration APPEARS_WITHIN = Duration.ofSeconds(45);

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
	 * The text under the title (in soft mode the hint that the popup can be closed to copy unsaved data)
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
	 * The line the popup shows after "Sign in again" or "Sign out" could not reach the OIDC provider: the popup stays open, and
	 * what the user has typed on the screen is not lost
	 */
	public SignInAgainPopup checkProviderNotReachable(Consumer<String> checkMessage) {
		return Allure.step("Getting the message that the provider is not reachable", step -> {
			logTime(step);
			checkMessage.accept(getTextElement("[data-test-auth-error-popup-redirect-failed]"));
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
	 * "Sign in again": to the OIDC provider and back. While the SSO session lives there is no login page, the application comes
	 * back signed in on the same screen; with the SSO session over the login page follows
	 */
	public void clickSignInAgain() {
		clickButton("Sign in again", "button[data-test-auth-error-popup-button-sign-in]");
	}

	/**
	 * "Sign out": the same as "Log out" of the user menu, the login page follows
	 */
	public void clickSignOut() {
		clickButton("Sign out", "button[data-test-auth-error-popup-button-sign-out]");
	}

	/**
	 * The cross of the popup: the page stays as it is, the popup does not come back for a while (no cross in strict mode)
	 */
	public void close() {
		clickButton("close", "[data-test-auth-error-popup-close]");
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
	 * Fails unless the popup is not shown for the whole period (e.g. a closed popup does not reopen at once)
	 */
	public void shouldNotBeShown(Duration period) {
		root.shouldNotBe(Condition.visible, period);
	}

	private void clickButton(String label, String locator) {
		Allure.step("Clicking on the " + label + " button", step -> {
			logTime(step);
			element().$(locator)
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
