package core.element.widget.field.type.fileUpload;

import static com.codeborne.selenide.Selenide.$$;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.common.IterableElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.util.List;
import org.openqa.selenium.By;

/**
 * The windows of file progress at the top right: the Upload progress window of each field or action that uploads and the
 * Download progress window of the app. Business notifications are not in the list.
 */
public class FileUploadPopups implements IterableElement {

	/** A notification with the list of files inside */
	static final String WINDOW = "div.ant-notification-notice:has([data-test-notification-inner-container='true'])";

	static final String TITLE = "div.ant-notification-notice-message";

	private final ExpectationPattern expectations = new CxBoxExpectations();

	@Override
	public ElementsCollection element() {
		return $$(WINDOW);
	}

	/**
	 * The titles of the windows in the order they were opened; on the screen the order can be reversed
	 */
	public List<String> names() {
		return Allure.step(message("fileUploadPopups.names"), () -> {
			var names = $$(WINDOW + " " + TITLE)
					.shouldHave(CollectionCondition.sizeGreaterThan(0), expectations.getTimeout())
					.texts();
			StepReport.value(names);
			return names;
		});
	}

	/**
	 * The window with this title, e.g. {@code Constants.FileUploadPopup.DOWNLOAD_TITLE}
	 */
	public FileUploadPopup<?, ?> popup(String title) {
		return new FileUploadPopup<>(expectations, null, StepReport.service(message("popup.get", message("report.popup.progress", title)),
				() -> element()
						.findBy(Condition.match("window " + title, window -> title.equals(window.findElement(By.cssSelector(TITLE)).getText())))
						.shouldBe(Condition.visible, expectations.getTimeout())));
	}

}
