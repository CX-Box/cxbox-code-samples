package core.element.widget.list.filter.header.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.Objects;

import static core.element.widget.AbstractWidget.logTime;

@Deprecated
public class ShowMessage {

	private final SelenideElement alert;

	private final ExpectationPattern expectationPattern = new CxBoxExpectations();

	public ShowMessage(SelenideElement alert) {
		this.alert = alert;
	}

	/**
	 * Getting the icon test
	 *
	 * @return String
	 */
	public String getIcon() {
		return Allure.step("Getting the icon test", step -> {
			logTime(step);

			return Objects.requireNonNull(alert
					.$("i[class*=\"anticon\"]").$("svg")
					.shouldBe(Condition.visible, expectationPattern.getTimeout())
					.getAttribute("data-icon"));
		});
	}

	/**
	 * Getting the message text
	 *
	 * @return String
	 */
	public String getAlertMessage() {
		return Allure.step("Getting the message text", step -> {
			logTime(step);

			return alert
					.$("span[class=\"ant-alert-message\"]")
					.shouldBe(Condition.visible, expectationPattern.getTimeout())
					.getText();
		});
	}

	/**
	 * Getting the Message Description
	 *
	 * @return String
	 */
	public String getAlertDescription() {
		return Allure.step("Getting the Message Description", step -> {
			logTime(step);

			return alert
					.$("span[class=\"ant-alert-description\"]")
					.shouldBe(Condition.visible, expectationPattern.getTimeout())
					.getText();
		});

	}

	/**
	 * Closing the message
	 */
	public void close() {
		Allure.step("Closing the message", step -> {
			logTime(step);

			alert
					.$("button[type=\"button\"][class=\"ant-alert-close-icon\"]")
					.shouldBe(Condition.visible, expectationPattern.getTimeout())
					.click();
		});
	}
}
