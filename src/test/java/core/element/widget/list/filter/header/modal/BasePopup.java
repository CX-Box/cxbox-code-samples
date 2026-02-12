package core.element.widget.list.filter.header.modal;

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
	 * Clicking on the button Ok
	 */
	public void clickOk() {
		clickButton("Ok");
	}

	/**
	 * Clicking on the button Cancel
	 */
	public void clickCancel() {
		clickButton("Cancel");
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
		return findPopup()
				.$(locator)
				.shouldBe(Condition.visible, expectationPattern.getTimeout())
				.text();
	}
}
