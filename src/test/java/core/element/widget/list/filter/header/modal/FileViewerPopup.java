package core.element.widget.list.filter.header.modal;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@RequiredArgsConstructor
public class FileViewerPopup {

	private final SelenideElement popup;

	private final SelenideElement widget;

	private final ExpectationPattern waitingForTests = new CxBoxExpectations();

	/**
	 * Getting the header
	 *
	 * @return String
	 */
	public String getTitle() {
		return Allure.step(message("popup.header"), step -> {

			return popup
					.$("span[class*=\"Header__title\"]")
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.getText();
		});

	}

	private String getTypeWidget() {
		return widget.getAttribute("data-test-widget-type");
	}

	private ElementsCollection getButtons() {
		return popup.$$(By.tagName("button"));
	}

	/**
	 * Clicking on the button FullScreen
	 */
	public void switchFullscreenMode() {
		Allure.step(message("viewer.fullScreen"), step -> {

			getButtons()
					.findBy(Condition.text("Fullscreen"))
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.click();
		});

	}

	/**
	 * Getting a file from a field in File format
	 *
	 * @return File
	 */
	@SneakyThrows
	public File getValueFile() {
		return Allure.step(message("viewer.file"), step -> {

			File file = getButtons()
					.findBy(Condition.text("Download"))
					.download(using(FOLDER));
			WebDriverWait wait = new WebDriverWait(getWebDriver(), waitingForTests.getTimeout());
			wait.until(driver -> file.exists());
			return file;
		});

	}

	/**
	 * Pagination management in FileViewerPopup
	 *
	 * @param button Button name Left/Right
	 * @param count  Number of clicks
	 */
	public void clickPaginationButton(String button, int count) {
		Allure.step(message("viewer.pages", button, count), step -> {
			step.parameter(message("parameter.button"), button);
			step.parameter(message("parameter.clicks"), count);

			SelenideElement element = popup.$("div[class*=\"ArrowPagination__compact\"]")
					.shouldBe(Condition.visible, waitingForTests.getTimeout());
			for (int i = 0; i < count; i++) {
				if (button.equalsIgnoreCase("left") | button.equalsIgnoreCase("влево")) {
					element
							.$("i[aria-label=\"icon: left\"]")
							.parent()
							.click();
				}
				if (button.equalsIgnoreCase("right") | button.equalsIgnoreCase("вправо")) {
					element
							.$("i[aria-label=\"icon: right\"]")
							.parent()
							.click();
				} else {
					throw new UnsupportedOperationException("No such button exists");
				}
			}
		});


	}

	/**
	 * Getting the current page
	 *
	 * @return 1 of 3
	 */
	public String getPagePagination() {
		return Allure.step(message("viewer.currentPage"), step -> {

			return popup
					.$("div[class*=\"ArrowPagination__compact\"]")
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.getText();
		});
	}

	/**
	 * Closing FileViewer Popup
	 */
	public void closePopup() {
		Allure.step(message("viewer.close"), step -> {

			popup.$("div[class=\"ant-modal-header\"]")
					.$("i[aria-label=\"icon: close\"]")
					.scrollIntoView("{block: \"center\"}")
					.shouldBe(Condition.visible, waitingForTests.getTimeout())
					.click();
		});
	}
}
