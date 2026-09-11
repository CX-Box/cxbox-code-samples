package core.element;

import core.element.widget.modal.SignInAgainPopup;
import core.element.widget.modal.ErrorPopup;
import core.page.UserMenu;
import core.element.screen.PlatformScreen;
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
	 * The "Sign in again?" popup shown on 401 (session expired) and 403 (insufficient permissions)
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

	public static UserMenu userMenu() {
		return new UserMenu();
	}

}
