package core.element.screen.view;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Allure;

public abstract class AbstractLevelMenu extends PlatformView {

	public abstract ElementsCollection element();

	public PlatformView view(String name) {
		return Allure.step("Open view: " + name, step -> {
			// the tabs bar is a carousel: a tab out of its visible part is clipped, so it has no rendered text
			// for the driver; the tab is matched by the DOM text and scrolled to before the click
			element()
					.find(Condition.match("tab " + name,
							el -> name.trim().equalsIgnoreCase(String.valueOf(el.getAttribute("textContent")).trim())))
					.shouldBe(Condition.enabled)
					.scrollIntoView("{block: \"nearest\", inline: \"nearest\"}")
					.click();
			return new PlatformView();
		});
	}
}
