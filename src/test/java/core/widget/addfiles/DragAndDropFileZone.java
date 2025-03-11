package core.widget.addfiles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.List;

@Getter
public class DragAndDropFileZone {

    protected final SelenideElement dragZone;

    protected FilesPopup popup;

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();


    public DragAndDropFileZone(SelenideElement dragZone) {
        this.dragZone = dragZone;
        this.popup = new FilesPopup();
    }

    /**
     * Sending a file to the download area
     *
     * @param file File name or path to it
     */
    @Step("Sending the {file} file to the download area")
    public void setValue(File file) {
        dragZone.$("input")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .uploadFile(file);
    }

    /**
     * Getting a used icon in the download area
     *
     * @return String attribute values
     */
    @Step("Getting a used icon in the download area")
    @Attachment
    public String getIconZone() {
        return dragZone
                .$("p[class*=\"FileUpload__icon\"]")
                .find(By.tagName("i"))
                .getAttribute("aria-label");
    }

    /**
     * Getting the button text in the download area
     *
     * @return String
     */
    @Step("Getting the button text in the download area")
    @Attachment
    public String getImitationButtonZone() {
        return dragZone
                .$("p[class*=\"FileUpload__imitationButton\"]")
                .getText();
    }

    /**
     * Getting the main text of the download area
     *
     * @return List String
     */
    @Step("Getting the main text of the download area")
    @Attachment
    public List<String> getTextZone() {
        return dragZone
                .$$("p[class*=\"FileUpload__text\"]")
                .texts();
    }

    /**
     * Getting HintText from the download area
     *
     * @return List String
     */
    @Step("Getting HintText from the download area")
    @Attachment
    public List<String> getHintText() {
        return dragZone
                .$$("p[class*=\"FileUpload__hint\"]")
                .texts();
    }
}
