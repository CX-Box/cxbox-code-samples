package core.element.screen;

import java.time.Duration;
import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.element.PlatformApp;
import core.element.screen.view.*;
import core.expectation.CxBoxExpectations;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static core.element.PlatformApp.config;

@Slf4j
public class PlatformScreen extends AbstractScreen {

	public PlatformScreen(String name) {
		super(new CxBoxExpectations());
		Allure.step(message("screen.select", name), step -> {
			step.parameter(message("parameter.screen"), name);
			// one lookup in the browser: a filter of the item collection asks the driver for the text of every item before the match;
			// the name is the title of the item (CXBOX-121), not its whole text: a project may show a counter or an icon in the
			// item. It is compared like Condition.exactText: ignoring case and extra spaces
			$x("//aside[@data-test='LEFT_SIDER']//ul[@data-test='MAIN_MENU']//li[@data-test='MAIN_MENU_ITEM']"
					+ "[translate(normalize-space(" + config().selectors.menuItemName + "), '" + UPPER_CASE + "', '" + LOWER_CASE + "')="
					+ xpathLiteral(name.strip().replaceAll("\\s+", " ").toLowerCase(Locale.ROOT)) + "]")
					.shouldBe(Condition.enabled)
					// the menu can be long: the item is scrolled to the middle first, otherwise the sticky footer of the sidebar intercepts the click
					.scrollIntoView("{block: \"center\"}").click();
			checkPageLoaded();
		});

	}

	private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

	private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyzабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

	/** The name as an XPath string literal: a name may contain quotes. */
	private static String xpathLiteral(String value) {
		if (!value.contains("'")) {
			return "'" + value + "'";
		}
		if (!value.contains("\"")) {
			return "\"" + value + "\"";
		}
		return "concat('" + value.replace("'", "', \"'\", '") + "')";
	}

	/**
	 * The screen that is open now: the test works with it when its page is loaded
	 */
	public PlatformScreen() {
		super(new CxBoxExpectations());
		waitLoaded(message("screen.current"), getPattern().getTimeout());
	}

	/** Passes the address of the current page ({@link PlatformApp#getUrl()}) to the check. */
	public PlatformScreen checkUrl(Consumer<String> checkUrl) {
		checkUrl.accept(PlatformApp.getUrl());
		return this;
	}

	/** The tabs of the views of the second level */
	public SecondLevelMenu secondLevelMenu() {
		return new SecondLevelMenu();
	}

	public PlatformView secondLevelView(String name) {
		return secondLevelMenu().view(name);
	}

	public PlatformView thirdLevelView(String name) {
		return new ThirdLevelMenu().view(name);
	}

	public PlatformView fourthLevelView(String name) {
		return new FourthLevelMenu().view(name);
	}

	public <T extends AbstractView> T view(Supplier<T> viewSupplier) {
		return viewSupplier.get();
	}

	public PlatformView view() {
		return config().parts.view.get();
	}

	@Override
	public PlatformScreen checkPageLoaded() {
		waitLoaded(message("screen.loaded"), getPattern().getTimeout());
		return this;
	}

	/** Waits until the page has no loading indicator: a service step named {@code name} */
	private static void waitLoaded(String name, Duration timeout) {
		StepReport.service(name, () -> {
			// one request to the browser: the page has no loading indicator (two exists() for a debug log line made three
			// requests a check)
			$("div[data-test-loading=\"true\"]").shouldNotBe(Condition.exist, timeout);
		});
	}

	@Override
	public ElementsCollection element() {
		return $("aside[data-test='LEFT_SIDER']")
				.$("ul[data-test='MAIN_MENU']")
				.$$("li[data-test='MAIN_MENU_ITEM']");
	}
}
