package core.element.widget.field.type.fileUpload;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractFieldImpl;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class FileUploadPopup<W extends AbstractWidget<ExpectationPattern, W>, F extends AbstractFieldImpl<ExpectationPattern, W, File, F>> {

	private final SelenideElement popup = $("div[class=\"ant-notification ant-notification-topRight\"]");
	private final ExpectationPattern cxBoxExpectations;
	private final F parent;

	public FileUploadPopup(ExpectationPattern cxBoxExpectations, F parent) {
		this.cxBoxExpectations = cxBoxExpectations;
		this.parent = parent;
	}

	public FileUploadPopup<W, F> checkTitle(Consumer<String> title) {
		return Allure.step("Getting the header value", step -> {
			logTime(step);
			title.accept(popup
					.$("div[class=\"ant-notification-notice-message\"]")
					.shouldBe(Condition.visible, cxBoxExpectations.getTimeout())
					.getText());
			return this;
		});
	}

	/**
	 * Getting a list of files and their status
	 *
	 * @return List Pair
	 */

	public FileUploadPopup<W, F> checkFileNameAndStatusUpload(Consumer<List<Pair<String, String>>> checkNameAndStatus) {
		return Allure.step("Getting a list of files and their status", step -> {
			logTime(step);

			List<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
			for (SelenideElement file : getFilesList()) {
				String key = file.getAttribute("data-test-file-name");
				String value = file.getAttribute("data-test-file-status");
				pairs.add(Pair.of(key, value));
			}
			checkNameAndStatus.accept(pairs);
			return this;
		});
	}

	/**
	 * Closing window
	 */
	public F close() {
		return Allure.step("Closing window", step -> {
			logTime(step);

			popup
					.$("i[aria-label=\"icon: close\"]")
					.shouldBe(Condition.visible, cxBoxExpectations.getTimeout())
					.click();
			return this.parent;
		});
	}

	private ElementsCollection getFilesList() {
		return popup
				.$("div[data-test-file-upload-prgress-list=\"true\"]")
				.shouldBe(Condition.visible, cxBoxExpectations.getTimeout())
				.$$("div[class*=\"UploadList__fileRow\"]");
	}
}
