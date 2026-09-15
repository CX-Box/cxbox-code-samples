package core.page.auth.keycloak;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.page.auth.AuthPage;
import core.page.auth.AuthWithUsernameAndPassword;
import io.qameta.allure.Allure;

import java.net.URI;

import static com.codeborne.selenide.Selenide.$x;
import static core.element.widget.AbstractWidget.logTime;

public class KeycloackAuthPage extends AuthPage implements AuthWithUsernameAndPassword {

	public static final SelenideElement login = $x("//*[@id='username']");

	public static final SelenideElement password = $x("//*[@id='password']");

	public static final SelenideElement signInButton = $x("//*[@id='kc-login']");

	@Override
	public void authWithUsernameAndPassword(String login, String password, URI appUri) {
		Allure.step(
				"Authorization via KeyCloak with login: " + login + " and password", step -> {
					logTime(step);
					step.parameter("login", login);
					enterUsername(login);
					enterPassword(password);
					clickSignInButton();
				}
		);
	}


	private void enterUsername(String login) {
		Allure.step(
				"Entering a username: " + login, step -> {
					logTime(step);
					step.parameter("login", login);
					KeycloackAuthPage.login
							.shouldBe(Condition.enabled)
							.setValue(login);
				}
		);
	}

	private void enterPassword(String password) {
		Allure.step(
				"Entering a password", step -> {
					logTime(step);
					KeycloackAuthPage.password
							.shouldBe(Condition.enabled)
							.setValue(password);
				}
		);
	}

	private void clickSignInButton() {
		Allure.step(
				"Clicking on the Login button", step -> {
					logTime(step);
					signInButton
							.shouldBe(Condition.visible)
							.click();
					waitSignedIn();
				}
		);
	}

	/**
	 * The application stores the session after the redirect back from Keycloak. A test that ends earlier logs out
	 * without the id_token_hint: Keycloak asks to confirm the logout, the session stays and the next test finds no login form.
	 */
	private void waitSignedIn() {
		Selenide.Wait().withTimeout(new CxBoxExpectations().getOverTimeout()).until(driver -> {
			try {
				return Boolean.TRUE.equals(Selenide.executeJavaScript(
						"return Object.keys(localStorage).some(key => key.startsWith('oidc.user:'));"));
			} catch (RuntimeException e) {
				return false;
			}
		});
	}


}
