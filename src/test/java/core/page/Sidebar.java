package core.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

/**
 * The left sidebar of the application (menu and its search field).
 */
public class Sidebar {

	private final ExpectationPattern expectations = new CxBoxExpectations();

	private final SelenideElement search = $("aside[data-test='LEFT_SIDER'] input.ant-input");

	/**
	 * Reads the clipboard the way a user would: pastes it into the search field (a neutral text input), reads the value and clears it.
	 * The browser must have been granted clipboard access first.
	 */
	public String readClipboard() {
		return Allure.step("Read the clipboard through the sidebar search field", step -> {
			logTime(step);
			// no click: a modal mask may cover the field, sendKeys focuses it anyway
			search.shouldBe(Condition.visible, expectations.getTimeout()).sendKeys(Keys.chord(Keys.CONTROL, "v"));
			String text = search.shouldNotBe(Condition.empty, expectations.getTimeout()).getValue();
			search.clear();
			return text;
		});
	}

}
