package core.element.screen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
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
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class PlatformScreen extends AbstractScreen {

	public PlatformScreen(String name) {
		super(new CxBoxExpectations());
		Allure.step("Selecting the screen " + name, step -> {
			step.parameter("screen", name);
			logTime(step);
			// one lookup in the browser: a filter of the item collection asks the driver for the text of every item before the match;
			// the text is compared like Condition.exactText: ignoring case and extra spaces
			$x("//aside[@data-test='LEFT_SIDER']//ul[@data-test='MAIN_MENU']//li[@data-test='MAIN_MENU_ITEM']"
					+ "[translate(normalize-space(.), '" + UPPER_CASE + "', '" + LOWER_CASE + "')="
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

	public PlatformScreen() {
		super(new CxBoxExpectations());
		// need for check loaded page
		element();
		checkPageLoaded();
	}

	/** Passes the address of the current page ({@link PlatformApp#getUrl()}) to the check. */
	public PlatformScreen checkUrl(Consumer<String> checkUrl) {
		checkUrl.accept(PlatformApp.getUrl());
		return this;
	}

	public PlatformView secondLevelView(String name) {
		return new SecondLevelMenu().view(name);
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
		return new PlatformView();
	}

	@Override
	public PlatformScreen checkPageLoaded() {
		return Allure.step("Checking page loaded", step -> {
			SelenideElement element = $("div[data-test-loading=\"true\"]");
			log.debug("data-test-loading=true check -> started. exists:  {}", element.exists());
			// TODO >> need see and maybe change
			element.shouldNotBe(Condition.exist, getPattern().getTimeout());
			log.debug("data-test-loading=true check -> finished. exists: {}", element.exists());
			return this;
		});
	}

	@Override
	public ElementsCollection element() {
		return Allure.step("Selecting the screen ", step -> {
			logTime(step);
			return $("aside[data-test='LEFT_SIDER']")
					.$("ul[data-test='MAIN_MENU']")
					.$$("li[data-test='MAIN_MENU_ITEM']");
		});
	}
}
