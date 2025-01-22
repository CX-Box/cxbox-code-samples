package core.widget.addfiles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;
import java.util.List;

@Getter
@Setter
public class AddFiles {
    protected final SelenideElement widget;

    protected FilesPopup popup;

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();


    public AddFiles(SelenideElement widget) {
        this.widget = widget;
        this.popup = new FilesPopup();
    }

    /**
     * Uploading a file to the field
     *
     * @param file File name or path to it
     */
    @Step("Загрузка файла {file} in the field")
    public void setValue(File file) {
        widget.$("div[class=\"ant-upload ant-upload-select ant-upload-select-text\"]")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .$(By.tagName("input"))
                .uploadFile(file);
    }

    /**
     * Uploading files in the field
     *
     * @param files A list of files or a list of file paths
     */
    @Step("Uploading files in the field. Files list: {files}")
    public void setValues(List<File> files) {
        for (File file : files) {
            widget.$("div[class=\"ant-upload ant-upload-select ant-upload-select-text\"]")
                    .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                    .$(By.tagName("input"))
                    .uploadFile(file);
        }

    }
}
