package core.element.widget.list.filter.header.modal;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static core.element.widget.AbstractWidget.logTime;

/**
 * File viewer: the header with the file name and the hint, the Fullscreen and Download buttons, the file and the
 * arrows over the records of the business component. The FilePreview widget shows it on the page
 * ({@code filePreview(...).viewer()}), the eye of a file opens it in a popup ({@link FileViewerPopup}).
 */
@RequiredArgsConstructor
public class FileViewer {

	private static final String PAGINATION = "div[class*=\"ArrowPagination__compact\"]";

	private static final String FULLSCREEN = "div[class*='FullscreenLayout__root']";

	protected final SelenideElement root;

	protected final ExpectationPattern waitingForTests = new CxBoxExpectations();

	/**
	 * Getting the header: the file name, or the value of preview.titleKey
	 *
	 * @return String
	 */
	public String getTitle() {
		return Allure.step("Getting the header", step -> {
			logTime(step);

			// the title is empty for a record without a file, so the header is waited for, not the title
			return header().$("span[class*=\"Header__title\"]").getText();
		});

	}

	/** The hint under the header: the value of preview.hintKey, empty without it. */
	public String getHint() {
		return Allure.step("Getting the hint", step -> {
			logTime(step);
			return header().$("span[class*=\"Header__hint\"]").getText();
		});
	}

	/**
	 * The text shown instead of the file: "There is no file in this row" or "This file type cannot be viewed". Empty
	 * when the file is shown.
	 */
	public String getMessage() {
		return Allure.step("Getting the message instead of the file", step -> {
			logTime(step);
			header();
			// a pdf viewer keeps a hidden fallback of the same kind inside its <object>
			SelenideElement empty = root.$$("div[class*='Empty__root']").filter(Condition.visible).first();
			return empty.exists() ? empty.getText() : "";
		});
	}

	private SelenideElement header() {
		return root.$("div[class*='Header__header']").shouldBe(Condition.visible, waitingForTests.getTimeout());
	}

	private ElementsCollection getButtons() {
		return root.$$(By.tagName("button"));
	}

	/**
	 * Clicking on the button FullScreen
	 */
	public void switchFullscreenMode() {
		Allure.step("Clicking on the button FullScreen", step -> {
			logTime(step);

			getButtons()
					.findBy(Condition.text("Fullscreen"))
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.click();
		});

	}

	/** Clicking on the cross of the fullscreen mode; waits until the file is back in its place. */
	public void closeFullscreen() {
		Allure.step("Closing the fullscreen mode", step -> {
			logTime(step);

			Selenide.$(FULLSCREEN)
					.$("i[aria-label='icon: close']")
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.click();
			Selenide.$$(FULLSCREEN).shouldBe(CollectionCondition.size(0), waitingForTests.getTimeout());
		});
	}

	/**
	 * Getting a file from a field in File format
	 *
	 * @return File
	 */
	@SneakyThrows
	public File getValueFile() {
		return Allure.step("Getting a file from a field in File format", step -> {
			logTime(step);

			File file = getButtons()
					.findBy(Condition.text("Download"))
					.download(using(FOLDER));
			WebDriverWait wait = new WebDriverWait(getWebDriver(), waitingForTests.getTimeout());
			wait.until(driver -> file.exists());
			return file;
		});

	}

	/**
	 * Pagination management in FileViewer: each click waits until the viewer shows the next record
	 *
	 * @param button Button name Left/Right
	 * @param count  Number of clicks
	 */
	public void clickPaginationButton(String button, int count) {
		Allure.step("Page navigation. Clicking on " + button + ", " + count + " times", step -> {
			logTime(step);
			step.parameter("Button's name", button);
			step.parameter("Count of click", count);

			String icon;
			if (button.equalsIgnoreCase("left") || button.equalsIgnoreCase("влево")) {
				icon = "left";
			} else if (button.equalsIgnoreCase("right") || button.equalsIgnoreCase("вправо")) {
				icon = "right";
			} else {
				throw new UnsupportedOperationException("No such button exists");
			}
			SelenideElement element = root.$(PAGINATION).shouldBe(Condition.visible, waitingForTests.getTimeout());
			for (int i = 0; i < count; i++) {
				String page = element.getText();
				element.$("i[aria-label=\"icon: " + icon + "\"]").closest("button").click();
				element.shouldNotHave(Condition.exactText(page), waitingForTests.getTimeout());
			}
		});


	}

	/**
	 * Getting the current page
	 *
	 * @return 1 of 3
	 */
	public String getPagePagination() {
		return Allure.step("Getting the current page", step -> {
			logTime(step);

			return root
					.$(PAGINATION)
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.getText();
		});
	}

}
