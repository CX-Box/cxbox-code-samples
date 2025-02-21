package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

	public static final SelenideElement login = $x("//*[@id='username']");
	public static final SelenideElement password = $x("//*[@id='password']");
	public static final SelenideElement signInButton = $x("//*[@id='kc-login']");

	@Step("Authorization via KeyCloak with login: {login} and password")
	public WidgetPage loginKeyCloak(String login, String password) {
		enterUsername(login);
		enterPassword(password);
		clickSignInButton();
		Selenide.sleep(200);
		return new WidgetPage();
	}

	@Step("Entering a username: {login}")
	private void enterUsername(String login) {
		LoginPage.login
				.shouldBe(Condition.enabled)
				.setValue(login);
	}

	@Step("Entering a password")
	private void enterPassword(String password) {
		LoginPage.password
				.shouldBe(Condition.enabled)
				.setValue(password);
	}

	@Step("Clicking on the Login button")
	private void clickSignInButton() {
		signInButton
				.shouldBe(Condition.visible)
				.click();
	}


}
