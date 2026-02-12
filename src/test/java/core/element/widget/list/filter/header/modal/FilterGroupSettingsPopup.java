package core.element.widget.list.filter.header.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class FilterGroupSettingsPopup {

	private final SelenideElement POPUP = $("div[class=\"ant-modal\"]");

	private final ExpectationPattern expectationPattern = new CxBoxExpectations();

	/**
	 * Setting the filter name
	 *
	 * @param name filter name
	 */
	public void setName(String name) {
		Allure.step("Setting the filter name " + name, step -> {
			logTime(step);

			SelenideElement input = POPUP.$("input").shouldBe(Condition.enabled, expectationPattern.getTimeout());
			if (!input.has(Condition.attribute("disabled"))) {
				input.setValue(name);
			} else {
				log.error("Field inactive. Filtering is not completed");
			}
		});
	}

	/**
	 * Creating a filter
	 */
	public void clickButtonCreate() {
		Allure.step("Creating a filter", step -> {
			logTime(step);

			SelenideElement create = POPUP.$("button[type=\"submit\"]").shouldBe(Condition.enabled, expectationPattern.getTimeout());
			if (!create.has(Condition.attribute("disabled"))) {
				create.click();
			} else {
				log.error("Field inactive. Filtering is not completed");
			}
		});
	}

	private ElementsCollection settingsFilter() {
		if (POPUP.$("div[class*=\"FilterSettingModal__filterGroups\"]").is(Condition.visible)) {
			SelenideElement settings = POPUP.$("div[class*=\"FilterSettingModal__filterGroups\"]").shouldBe(Condition.visible, expectationPattern.getTimeout());
			return settings.$$("div");
		}
		return null;
	}

	/**
	 * Getting a list of created filters
	 *
	 * @return String
	 */
	public String getFilterSettings() {
		return Allure.step("Getting a list of created filters", step -> {
			logTime(step);

			if (settingsFilter() == null) {
				log.info("Сохраненных фильтров нет");
				return null;
			}
			return String.valueOf(settingsFilter().texts());
		});
	}

	/**
	 * Cleaning of all filters
	 */
	public void clearAllFilterSettings() {
		Allure.step("Cleaning of all filters", step -> {
			logTime(step);
			settingsFilter().forEach(element -> element.$("i[aria-label=\"icon: close\"]").click());
		});
	}
}