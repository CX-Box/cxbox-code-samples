package core.element.widget.list.filter.header.modal;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;
import io.qameta.allure.Allure;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import java.util.List;

@RequiredArgsConstructor
public abstract class BasePopup<E> {

	protected final ExpectationPattern expectationPattern = new CxBoxExpectations();

	protected E popup;

	public BasePopup(E popup) {
		this.popup = popup;
	}

	public abstract SelenideElement findPopup();

	/**
	 * Closing the modal window via a cross
	 */
	public void close() {
		findPopup().$("span[class=\"ant-modal-close-x\"]")
				.shouldBe(Condition.exist, expectationPattern.getTimeout())
				.click();
		findPopup().shouldNotBe(Condition.visible, expectationPattern.getTimeout());
	}

	/**
	 * Clicking on the button by Name
	 *
	 * @param actionName Button's name
	 */
	public void clickButton(String actionName) {
		SelenideElement button = getButton(actionName);
		button.shouldBe(Condition.enabled, expectationPattern.getTimeout()).click();
	}

	/**
	 * Clicking on the button Ok, found by its test mark: its text depends on the language
	 */
	public void clickOk() {
		Allure.step(message("popup.ok"), () -> clickMarked("ok"));
	}

	/**
	 * Clicking on the button Cancel, found by its test mark
	 */
	public void clickCancel() {
		Allure.step(message("popup.cancel"), () -> clickMarked("cancel"));
	}

	/**
	 * The button with the mark {@code data-test-<popup>-popup-button-<button>}, as the confirm popup of a widget finds it;
	 * the line of the report names the pressed button
	 */
	private void clickMarked(String button) {
		var found = findPopup().$("[data-test-" + popup + "-popup-button-" + button + "=\"true\"]")
				.shouldBe(Condition.enabled, expectationPattern.getTimeout());
		StepReport.value(found.getText());
		found.click();
	}

	/**
	 * Displaying a list of all buttons in a widget
	 *
	 * @return List<String>
	 */
	public List<String> getButtons() {
		return getContainersActions().texts();
	}

	private SelenideElement getContainer() {
		return findPopup()
				.shouldBe(Condition.exist, expectationPattern.getTimeout())
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getContainersActions() {
		return getContainer()
				.$$(By.tagName("button"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
	}

	private SelenideElement getButton(String actionName) {
		return getContainersActions()
				.find(Condition.match("check action name: " + actionName, b -> b.getText().equals(actionName)));
	}

	/**
	 * Getting the element text
	 *
	 * @param locator Element Locator
	 * @return String
	 */
	public String getTextElement(String locator) {
		var text = findPopup()
				.$(locator)
				.shouldBe(Condition.visible, expectationPattern.getTimeout())
				.text();
		StepReport.value(text);
		return text;
	}
}
