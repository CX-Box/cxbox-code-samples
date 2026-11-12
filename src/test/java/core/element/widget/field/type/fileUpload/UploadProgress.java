package core.element.widget.field.type.fileUpload;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import java.time.Duration;

/**
 * The window of the upload progress: a line for each file with its status and the text of the status (the tooltip of
 * the line). The upload of a field and the upload of an action show the same window.
 */
public class UploadProgress {

	private final Duration timeout;

	public UploadProgress(Duration timeout) {
		this.timeout = timeout;
	}

	/**
	 * The line of the file, when its upload is over (the status is not {@code init} or {@code uploading})
	 */
	private SelenideElement line(String fileName) {
		var line = $("[data-test-file-upload-prgress-item='true'][data-test-file-name='" + fileName + "']");
		line.shouldNotHave(Condition.attributeMatching("data-test-file-status", "init|uploading"), timeout);
		return line;
	}

	/**
	 * The status of the file: {@code done}, {@code error}, {@code canceled}...
	 */
	public String status(String fileName) {
		return Allure.step("Status of the upload of " + fileName, step -> {
			return line(fileName).getAttribute("data-test-file-status");
		});
	}

	/**
	 * The text of the status, the tooltip of the line shows it
	 */
	public String statusInformation(String fileName) {
		return Allure.step("Text of the status of the upload of " + fileName, step -> {
			return line(fileName).getAttribute("data-test-file-status-information");
		});
	}

	/**
	 * The tooltip of the line, as the user sees it on hover
	 */
	public String tooltip(String fileName) {
		return Allure.step("Tooltip of the upload of " + fileName, step -> {
			// the tooltip of another line hides with an animation: the mouse goes to the title of the window, then the tooltip
			// is waited to hide
			var line = line(fileName);
			line.closest(".ant-notification-notice").$(".ant-notification-notice-message").hover();
			$$(".ant-tooltip:not(.ant-tooltip-hidden)").shouldHave(CollectionCondition.size(0), timeout);
			line.$("[class*='fileName']").hover();
			return $(".ant-tooltip:not(.ant-tooltip-hidden) .ant-tooltip-inner")
					.shouldBe(Condition.visible, timeout)
					.getText();
		});
	}

}
