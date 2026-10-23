package core.element.widget.list.filter.header.modal;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;

/** {@link FileViewer} in a popup: the eye of a file field or of a card opens it. */
public class FileViewerPopup extends FileViewer {

	private final SelenideElement widget;

	public FileViewerPopup(SelenideElement popup, SelenideElement widget) {
		super(popup);
		this.widget = widget;
	}

	private String getTypeWidget() {
		return widget.getAttribute("data-test-widget-type");
	}

	/**
	 * Closing FileViewer Popup
	 */
	public void closePopup() {
		Allure.step(message("viewer.close"), step -> {

			root.$("div[class=\"ant-modal-header\"]")
					.$("i[aria-label=\"icon: close\"]")
					.scrollIntoView("{block: \"center\"}")
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.click();
		});
	}
}
