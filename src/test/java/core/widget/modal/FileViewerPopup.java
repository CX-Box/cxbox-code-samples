package core.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@RequiredArgsConstructor
public class FileViewerPopup {

    private final SelenideElement popup;

    private final SelenideElement widget;

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Getting the header
     *
     * @return String
     */
    @Step("Getting the header ")
    @Attachment
    public String getTitle() {
        return popup
                .$("span[class*=\"Header__title\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
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
    @Step("Clicking on the button FullScreen")
    public void switchFullscreenMode() {
        getButtons()
                .findBy(Condition.text("Fullscreen"))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    /**
     * Getting a file from a field in File format
     *
     * @return File
     */
    @SneakyThrows
    @Step("Getting a file from a field in File format")
    @Attachment
    public File getValueFile() {
        File file = getButtons()
                .findBy(Condition.text("Download"))
                .download(using(FOLDER));
        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(waitingForTests.Timeout));
        wait.until(driver -> file.exists());
        return file;
    }

    /**
     * Pagination management in FileViewerPopup
     *
     * @param button Button name Left/Right
     * @param count  Number of clicks
     */
    @Step("Page navigation. Clicking on {button}, {count} times")
    public void clickPaginationButton(String button, int count) {
        SelenideElement element = popup.$("div[class*=\"ArrowPagination__compact\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout));
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

    }

    /**
     * Getting the current page
     *
     * @return 1 of 3
     */
    @Step("Getting the current page")
    @Attachment
    public String getPagePagination() {
        return popup
                .$("div[class*=\"ArrowPagination__compact\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }

    /**
     * Closing FileViewer Popup
     */
    @Step("Closing FileViewer Popup")
    public void closePopup() {
        popup.$("div[class=\"ant-modal-header\"]")
                .$("i[aria-label=\"icon: close\"]")
                .scrollIntoView("{block: \"center\"}")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }
}
