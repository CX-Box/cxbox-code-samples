package core.element.widget.list.filter.header.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.filter.header.modal.confirm.ConfirmPopup;
import core.element.widget.list.filter.header.modal.error.ErrorPopup;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class Popup {

	private final ExpectationPattern expectationPattern = new CxBoxExpectations();

	/**
	 * Modal error window
	 *
	 * @return ErrorPopup
	 */
	@Step("Calling Error Popup")
	public ErrorPopup errorPopup() {
		return new ErrorPopup();
	}

	/**
	 * Modal confirmation window
	 *
	 * @return ConfirmPopup
	 */
	@Step("Calling Confirm Popup")
	public ConfirmPopup confirmPopup() {
		return new ConfirmPopup();
	}

//	/**
//	 * Calling a modal window with line editing function
//	 *
//	 * @param title Title
//	 * @return RowsHelper
//	 */
//	public RowsHelper picklistPopup(String title) {
//		return Allure.step("Calling Picklist Popup with row editing function", step -> {
//			logTime(step);
//			step.parameter("Title", title);
//
//			SelenideElement widget = findWidgetByTypesAndTitle("PickListPopup", title);
//			return new RowsHelper(title, widget);
//		});
//
//	}

	private SelenideElement findWidgetByTypesAndTitle(String type, String title) {
		return $("div[data-test='WIDGET'][data-test-widget-type='" + type + "'][data-test-widget-title='" + title
				+ "']")
				.shouldBe(Condition.enabled, expectationPattern.getTimeout());
	}
}
