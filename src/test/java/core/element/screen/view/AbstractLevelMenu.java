package core.element.screen.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Allure;

public abstract class AbstractLevelMenu extends PlatformView {

	public abstract ElementsCollection element();

	public PlatformView view(String name) {
		return Allure.step("Open view: " + name, step -> {
			element()
					.find(Condition.exactText(name))
					.shouldBe(Condition.enabled)
					.click();
			return new PlatformView();
		});
	}
}
