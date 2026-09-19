package core.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static core.element.widget.AbstractWidget.logTime;

/**
 * The user menu in the application header (the avatar button)
 */
public class UserMenu {

	private final ExpectationPattern expectations = new CxBoxExpectations();

	/**
	 * The avatar sits inside a button, the button is what receives the click
	 */
	private final SelenideElement button = $x("//button[.//span[contains(@class, 'ant-avatar')]]");

	private final SelenideElement logoutButton = $("button[data-test-menu-user-logout]");

	/**
	 * The avatar is rendered once the session is active: the OIDC callback has finished and the backend accepted the token.
	 * Waiting for it after a sign in makes sure nothing is still in flight when the test goes on (or ends).
	 */
	public UserMenu shouldBeDisplayed() {
		return Allure.step("Waiting for the user menu: the session is active", step -> {
			logTime(step);
			button.shouldBe(Condition.visible, expectations.getOverTimeout());
			return this;
		});
	}

	/**
	 * "Log out" through the menu, as a user does it (the same thing "Yes" of the "Sign in again?" popup does).
	 * For cleaning up between tests the OIDC end-session link is faster, see {@link core.config.OidcProvider#logoutUrl}.
	 */
	public void logout() {
		Allure.step("Log out through the user menu", step -> {
			logTime(step);
			$("div[data-test-loading='true']").shouldNot(Condition.exist, expectations.getTimeout());
			button.shouldBe(Condition.visible, expectations.getTimeout()).click();
			logoutButton.shouldBe(Condition.visible, expectations.getTimeout()).click();
			button.shouldNot(Condition.exist, expectations.getTimeout());
		});
	}

}
