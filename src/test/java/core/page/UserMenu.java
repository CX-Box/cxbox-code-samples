package core.page;

import static core.element.PlatformApp.config;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.action.PageRequests;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.openqa.selenium.Rectangle;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * The user menu in the application header (the avatar button): the roles of the user and the logout.
 * A project with a menu of its own overrides the protected methods: its elements and the way it opens.
 */
public class UserMenu {

	protected final ExpectationPattern expectations = new CxBoxExpectations();

	/**
	 * The avatar sits inside a button, the button is what receives the click
	 */
	protected SelenideElement avatar() {
		return $x("//button[.//span[contains(@class, 'ant-avatar')]]");
	}

	protected SelenideElement menu() {
		return $("[data-test-menu-user]");
	}

	protected ElementsCollection roleItems() {
		return menu().$$("[data-test-menu-user-role]");
	}

	/**
	 * The wrapper of the button of the active role is marked as checked
	 */
	protected SelenideElement activeRoleItem() {
		return menu().$(config().selectors.userMenuActiveRole);
	}

	protected void open() {
		avatar().shouldBe(Condition.visible, expectations.getTimeout()).click();
		menu().shouldBe(Condition.visible, expectations.getTimeout());
	}

	/**
	 * The roles are in the menu itself
	 */
	protected void openRoles() {
		open();
	}

	protected void close() {
		avatar().click();
		menu().shouldNot(Condition.visible, expectations.getTimeout());
	}

	/**
	 * The avatar is rendered once the session is active: the OIDC callback has finished and the backend accepted the token.
	 * Waiting for it after a sign in makes sure nothing is still in flight when the test goes on (or ends).
	 */
	public UserMenu shouldBeDisplayed() {
		return Allure.step(message("userMenu.wait"), step -> {
			avatar().shouldBe(Condition.visible, expectations.getOverTimeout());
			return this;
		});
	}

	public List<String> roles() {
		return Allure.step(message("userMenu.roles"), step -> {
			openRoles();
			var roles = roleItems().shouldHave(CollectionCondition.sizeGreaterThan(0), expectations.getTimeout()).texts();
			close();
			StepReport.list(roles, "roles");
			return roles;
		});
	}

	public String activeRole() {
		return Allure.step(message("userMenu.activeRole"), step -> {
			open();
			var role = activeRoleItem().shouldBe(Condition.visible, expectations.getTimeout()).getText();
			close();
			StepReport.value(role);
			return role;
		});
	}

	/**
	 * Makes the role active. The application signs in again with the role and opens its first screen: the switch is over
	 * when these requests are done, a click before that is lost when the first screen opens.
	 */
	public void role(String role) {
		Allure.step(message("userMenu.role", role), step -> {
			openRoles();
			var item = roleItems().findBy(Condition.exactText(role)).shouldBe(Condition.visible, expectations.getTimeout());
			// the submenu of the roles opens with an animation: a click while the item still moves misses it, and the menu stays
			// open; the item is clicked when two reads of its place agree
			var place = new AtomicReference<Rectangle>();
			Selenide.Wait().withTimeout(expectations.getTimeout()).until(driver -> item.getRect().equals(place.getAndSet(item.getRect())));
			PageRequests.runAndWaitDelayedRequests(item::click, Duration.ofMillis(500), expectations.getTimeout());
			menu().shouldNot(Condition.visible, expectations.getTimeout());
			$("div[data-test-loading='true']").shouldNot(Condition.exist, expectations.getTimeout());
		});
	}

	/**
	 * "Log out" through the menu, as a user does it (the same thing "Sign out" of the popup on 401 and 403 does).
	 * For cleaning up between tests the OIDC end-session link is faster, see {@link core.config.OidcProvider#logoutUrl}.
	 */
	public void logout() {
		Allure.step(message("userMenu.logout"), step -> {
			$("div[data-test-loading='true']").shouldNot(Condition.exist, expectations.getTimeout());
			open();
			menu().$("[data-test-menu-user-logout]").shouldBe(Condition.visible, expectations.getTimeout()).click();
			avatar().shouldNot(Condition.exist, expectations.getTimeout());
		});
	}

}
