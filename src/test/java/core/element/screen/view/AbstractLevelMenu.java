package core.element.screen.view;

import core.util.report.StepReport;
import java.util.List;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Allure;

public abstract class AbstractLevelMenu extends PlatformView {

	public abstract ElementsCollection element();

	/** The texts of the tabs of the level */
	public List<String> names() {
		return Allure.step(message("view.tabs"), () -> {
			var names = element().texts();
			StepReport.value(names);
			return names;
		});
	}

	public PlatformView view(String name) {
		return Allure.step(message("view.open", name), step -> {
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
