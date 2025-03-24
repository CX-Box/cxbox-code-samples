package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.$x;
import static core.widget.TestingTools.CellProcessor.logTime;

public class LoginPage {

	public static final SelenideElement login = $x("//*[@id='username']");
	public static final SelenideElement password = $x("//*[@id='password']");
	public static final SelenideElement signInButton = $x("//*[@id='kc-login']");

	public WidgetPage loginKeyCloak(String login, String password) {
		return Allure.step("Authorization via KeyCloak with login: " + login + " and password", step -> {
			logTime(step);
			step.parameter("login", login);

			enterUsername(login);
			enterPassword(password);
			clickSignInButton();
			Selenide.sleep(200);
			return new WidgetPage();
		});
	}

	private void enterUsername(String login) {
		Allure.step("Entering a username: " + login, step -> {
			logTime(step);
			step.parameter("login", login);

			LoginPage.login
					.shouldBe(Condition.enabled)
					.setValue(login);
		});
	}

	private void enterPassword(String password) {
		Allure.step("Entering a password", step -> {
			logTime(step);

			LoginPage.password
					.shouldBe(Condition.enabled)
					.setValue(password);
		});

	}

	private void clickSignInButton() {
		Allure.step("Clicking on the Login button", step -> {
			logTime(step);

			signInButton
					.shouldBe(Condition.visible)
					.click();
		});

	}


}
