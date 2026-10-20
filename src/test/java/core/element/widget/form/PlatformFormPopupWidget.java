package core.element.widget.form;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.util.function.Consumer;

/**
 * The form in a window: the widget {@code FormPopup} that the action opens with {@code PreAction.confirmWithWidget}. The
 * fields are the fields of a form; the window has its title, OK, Cancel and the cross, as the window of
 * {@code PreAction.confirm} ({@link core.element.widget.modal.ConfirmPopup}).
 *
 * <h5>Usage Example</h5>
 * <pre>{@code
 * form.actions().click("Activate FormPopup");
 * var popup = form.confirmWithWidgetPopup();      // or view.formPopup("FormPopup"), view.formPopupByName(...)
 * popup.input("customField").setValue("5700");
 * popup.checkTitle(title -> assertThat(title).isEqualTo("CustomTitleText"))
 *         .checkOkText(text -> assertThat(text).isEqualTo("CustomYesText"))
 *         .checkCancelText(text -> assertThat(text).isEqualTo("CustomNoText"))
 *         .clickOk();
 * }</pre>
 */
public class PlatformFormPopupWidget extends PlatformFormWidget {

	public PlatformFormPopupWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.FORM_POPUP;
	}

	/**
	 * Passes the title of the window to the check: the title of the pre action, else the title of the widget, else an
	 * empty one
	 */
	public PlatformFormPopupWidget checkTitle(Consumer<String> checkTitle) {
		return Allure.step(message("popup.header"), step -> {
			var title = element().$(".ant-modal-title").shouldBe(Condition.exist, getExpectations().getTimeout()).text();
			StepReport.value(title);
			checkTitle.accept(title);
			return this;
		});
	}

	/**
	 * Passes the text of OK to the check: {@code yesText} of the pre action or the default one
	 */
	public PlatformFormPopupWidget checkOkText(Consumer<String> checkText) {
		return checkButtonText("ok", message("popup.okText"), checkText);
	}

	/**
	 * Passes the text of Cancel to the check: {@code noText} of the pre action or the default one
	 */
	public PlatformFormPopupWidget checkCancelText(Consumer<String> checkText) {
		return checkButtonText("cancel", message("popup.cancelText"), checkText);
	}

	/**
	 * OK of the window: the text of the button is {@code yesText} of the pre action or the default one
	 */
	public void clickOk() {
		Allure.step(message("popup.ok"), () -> clickMarked("ok"));
	}

	/**
	 * Cancel of the window: the text of the button is {@code noText} of the pre action or the default one
	 */
	public void clickCancel() {
		Allure.step(message("popup.cancel"), () -> clickMarked("cancel"));
	}

	/**
	 * Closes the window by its cross, as Cancel does
	 */
	public void close() {
		Allure.step(message("popup.close"), () -> {
			element().$(".ant-modal-close").shouldBe(Condition.visible, getExpectations().getTimeout()).click();
			element().$(".ant-modal-close").shouldNot(Condition.exist, getExpectations().getTimeout());
		});
	}

	/**
	 * The button with the mark {@code data-test-popup-button-<button>}; the line of the report names the pressed button
	 */
	private void clickMarked(String button) {
		var found = marked(button);
		StepReport.value(found.getText());
		found.click();
	}

	private PlatformFormPopupWidget checkButtonText(String button, String line, Consumer<String> checkText) {
		return Allure.step(line, step -> {
			var text = marked(button).getText();
			StepReport.value(text);
			checkText.accept(text);
			return this;
		});
	}

	private SelenideElement marked(String button) {
		return element().$("[data-test-popup-button-" + button + "=\"true\"]")
				.shouldBe(Condition.enabled, getExpectations().getTimeout());
	}

}
