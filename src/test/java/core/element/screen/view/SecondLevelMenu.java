package core.element.screen.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Allure;

import static com.codeborne.selenide.Selenide.$;

public class SecondLevelMenu extends PlatformView {

	public PlatformView view(String name) {
		return Allure.step("Get view " + name, step -> {
			element().find(Condition.exactText(name))
					.shouldBe(Condition.enabled)
					.click();
			return new PlatformView();
		});
	}


	@Override
	public ElementsCollection element() {
		return $("div[data-test-widget-type='SecondLevelMenu']")
				.$$("span[data-test-navigation-tabs-item='true']");
	}

}
