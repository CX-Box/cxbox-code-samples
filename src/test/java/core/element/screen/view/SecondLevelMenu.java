package core.element.screen.view;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;

public class SecondLevelMenu extends AbstractLevelMenu {

	@Override
	public ElementsCollection element() {
		return $("div[data-test-widget-type='SecondLevelMenu']")
				.$$("span[data-test-navigation-tabs-item='true']");
	}

}
