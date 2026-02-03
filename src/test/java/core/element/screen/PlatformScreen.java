package core.element.screen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.screen.view.AbstractView;
import core.element.screen.view.PlatformView;
import core.element.screen.view.SecondLevelMenu;
import core.element.screen.view.ThirdLevelMenu;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.function.Supplier;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class PlatformScreen extends AbstractScreen {

	public PlatformScreen(String name) {
		super();
		Allure.step("Selecting the screen " + name, step -> {
			step.parameter("screen", name);
			logTime(step);
			$("aside[data-test='LEFT_SIDER']")
					.$("ul[data-test='MAIN_MENU']")
					.$$("li[data-test='MAIN_MENU_ITEM']")
					.find(Condition.exactText(name))
					.shouldBe(Condition.enabled).click();
			checkPageLoaded();
			;
		});

	}

	public PlatformScreen() {
		super();
		// need for check loaded page
		element();
		checkPageLoaded();
	}

	public PlatformView secondLevelView(String name) {
		return new SecondLevelMenu().view(name);
	}

	public PlatformView thirdLevelView(String name) {
		return new ThirdLevelMenu().view(name);
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
			element.shouldNotBe(Condition.exist, Duration.ofSeconds(2));
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
