package core.page.auth.keycloak;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.config.AppChecks;
import core.expectation.CxBoxExpectations;
import core.page.auth.AuthPage;
import core.page.auth.AuthWithUsernameAndPassword;
import io.qameta.allure.Allure;

import java.net.URI;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static core.element.widget.AbstractWidget.logTime;

public class KeycloackAuthPage extends AuthPage implements AuthWithUsernameAndPassword {

	public static final SelenideElement login = $x("//*[@id='username']");

	public static final SelenideElement password = $x("//*[@id='password']");

	public static final SelenideElement signInButton = $x("//*[@id='kc-login']");

	private static final SelenideElement menuItem = $("aside[data-test='LEFT_SIDER'] li[data-test='MAIN_MENU_ITEM']");

	/**
	 * Opens the application with a page load, so nothing is left from the previous test. The session stays when the
	 * application is signed in by this user; otherwise the user signs in with the username and password (the session of
	 * another user is logged out first).
	 */
	public void checkUserOrElseAuthWithUsernameAndPassword(String username, String password, URI appUri) {
		Allure.step(
				"Checking the signed in user " + username + " or else authorization", step -> {
					logTime(step);
					step.parameter("login", username);
					// the same address with another hash is not loaded again
					Selenide.open("about:blank");
					Selenide.open(appUri.toString());
					// the application shows the menu when it has accepted the session, otherwise it goes to the login form
					Selenide.Wait()
							.withTimeout(new CxBoxExpectations().getOverTimeout())
							.withMessage("the application has shown neither the menu nor the login form")
							.until(driver -> menuItem.exists() || KeycloackAuthPage.login.exists());
					if (KeycloackAuthPage.login.exists()) {
						authWithUsernameAndPassword(username, password, appUri);
						return;
					}
					String signedInUsername = signedInUsername();
					step.parameter("signed in user", signedInUsername);
					if (!username.equalsIgnoreCase(signedInUsername)) {
						logout(appUri);
						authWithUsernameAndPassword(username, password, appUri);
					}
				}
		);
	}

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

	/** Keycloak username of the session that the application keeps in the local storage (ui/src/auth/index.ts). */
	private static String signedInUsername() {
		return Selenide.executeJavaScript("""
				const key = Object.keys(localStorage).find(key => key.startsWith('oidc.user:'));
				return key ? JSON.parse(localStorage.getItem(key)).profile.preferred_username : null;
				""");
	}

	/** Direct link logout is x3 faster than logout with the UI button; the login form opens after it. */
	private static void logout(URI appUri) {
		Allure.step(
				"Logout", step -> {
					logTime(step);
					String logoutUrl = AppChecks.logout(appUri);
					Selenide.executeJavaScript("sessionStorage.clear(); localStorage.clear();");
					Selenide.open(logoutUrl);
					Selenide.clearBrowserCookies();
					Selenide.open(appUri.toString());
				}
		);
	}


}
