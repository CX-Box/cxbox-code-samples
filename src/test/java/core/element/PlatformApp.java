package core.element;

import com.codeborne.selenide.Selenide;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.modal.SignInAgainPopup;
import core.element.widget.modal.ErrorPopup;
import core.element.widget.modal.ErrorPopupException;
import core.expectation.CxBoxExpectations;
import core.page.UserMenu;
import core.element.screen.PlatformScreen;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PlatformApp {

	public static PlatformScreen screen(String name) {
		return new PlatformScreen(name);
	}

	public static PlatformScreen currentScreen() {
		return new PlatformScreen();
	}

	/**
	 * Refreshes the page, as F5 does
	 */
	public static void refresh() {
		Allure.step(message("app.refresh"), Selenide::refresh);
	}

	/**
	 * The address of the current page ({@code .../#/screen/<screen>/view/<view>}): the links to the samples in the
	 * documentation lead there.
	 */
	public static String getUrl() {
		return Allure.step(message("app.url"), step -> {
			return WebDriverRunner.url();
		});
	}

	/**
	 * The popup shown on 401 ("Session has expired") and 403 ("Insufficient permissions"), with "Sign in again" and "Sign out"
	 */
	public static SignInAgainPopup signInAgainPopup() {
		return new SignInAgainPopup();
	}

	/**
	 * The error popup that is not bound to a widget (e.g. the record of a form view could not be loaded)
	 */
	public static ErrorPopup<?> errorPopup() {
		return new ErrorPopup<>();
	}

	/**
	 * The action that ends with the error popup that is not bound to a widget: as
	 * {@link core.element.widget.PlatformWidget#expectErrorPopup}
	 */
	public static ErrorPopup<?> expectErrorPopup(Runnable action) {
		return Allure.step(message("errorPopup.expect"), () -> {
			ErrorPopupException.expect(action, new CxBoxExpectations().getTimeout());
			return errorPopup();
		});
	}

	public static UserMenu userMenu() {
		return new UserMenu();
	}

}
