package core.element.widget.modal;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.formpopup.PlatformFormPopupWidget;
import io.qameta.allure.Allure;
import java.util.function.Consumer;

public class ConfirmWithWidgetPopup implements SingleElement {

	private final PlatformFormPopupWidget widget;

	private SelenideElement selenideElement;

	public ConfirmWithWidgetPopup(PlatformFormPopupWidget widget) {
		this.widget = widget;
	}

	public PlatformFormPopupWidget close() {
		element().$(".ant-modal-close-x")
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.click();
		return widget;
	}

	public ConfirmWithWidgetPopup checkTitle(Consumer<String> checkTitle) {
		return Allure.step("Getting the header value of FormPopup", step -> {
			logTime(step);
			checkTitle.accept(getTextElement(".ant-modal-title"));
			return this;
		});
	}

	public ConfirmWithWidgetPopup checkMessage(Consumer<String> checkMessage) {
		return Allure.step("Getting the message text of FormPopup", step -> {
			logTime(step);
			SelenideElement body = element().$(".ant-modal-body");
			String text = body.$("textarea").exists() ? body.$("textarea").getValue() : body.getText();
			checkMessage.accept(text);
			return this;
		});
	}

	public ConfirmWithWidgetPopup checkTitleAndMessage(Consumer<String> title, Consumer<String> message) {
		checkTitle(title);
		checkMessage(message);
		return this;
	}

	private String getTextElement(String locator) {
		return element()
				.$(locator)
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.text()
				.trim();
	}

	public PlatformFormPopupWidget and() {
		return widget;
	}

	@Override
	public SelenideElement element() {
		if (selenideElement == null) {
			selenideElement = $(".ant-modal-content")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout());
		}
		return selenideElement;
	}

	public void click(String actionName) {
		SelenideElement button = getContainersActions()
				.find(Condition.match("check action name: " + actionName, b -> b.getText().trim().equalsIgnoreCase(actionName.trim())));
		button.shouldBe(Condition.enabled, widget.getExpectations().getTimeout()).click();
	}

	private SelenideElement getContainer() {
		return element()
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getContainersActions() {
		return getContainer()
				.$$(".ant-modal-footer button, button")
				.shouldBe(CollectionCondition.sizeGreaterThan(0));
	}

}
