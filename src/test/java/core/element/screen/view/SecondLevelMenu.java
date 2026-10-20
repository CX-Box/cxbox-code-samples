package core.element.screen.view;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static core.element.PlatformApp.config;

public class SecondLevelMenu extends AbstractLevelMenu {

	@Override
	public ElementsCollection element() {
		var menu = config().selectors.secondLevelMenu;
		var tab = config().selectors.secondLevelMenuTab;
		return menu.isEmpty() ? $$(tab) : $(menu).$$(tab);
	}

}
