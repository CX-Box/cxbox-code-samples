package core.page.auth;

import application.config.props.Env;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Unstable
 * Make  test is flaky  and slow time x3  than logout with direct link
 */
@Deprecated
@Slf4j
public class LogoutPage {

	public static SelenideElement appBarContainer = $("[class*='AppBar_container']");
	public static SelenideElement appBarUserButton = $x(".//span[contains(@class, 'ant-avatar')]/ancestor::button");
	public static SelenideElement userMenu = $(".ant-popover-inner-content [data-test-menu-user='true']");
	public static SelenideElement logoutButton = userMenu.$("button[data-test-menu-user-logout='true']");
	private static final ExpectationPattern expectationPattern = new CxBoxExpectations();

	@SneakyThrows
	public void logout() {
		if (!WebDriverRunner.hasWebDriverStarted()) {
			Selenide.open(Env.uri().toURL());
		}
		if (appBarContainer.exists()) {
			Selenide.open();
			appBarContainer.shouldBe(Condition.visible, expectationPattern.getTimeout());
			appBarUserButton.shouldBe(Condition.visible, expectationPattern.getTimeout())
					.click();
			logoutButton.shouldBe(Condition.interactable, expectationPattern.getTimeout())
					.click();
		} else {
			log.debug("Cannot find appBar container");
		}
	}
}
