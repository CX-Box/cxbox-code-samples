package core.widget.form.field.fileupload;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DownloadOptions;
import core.widget.addfiles.FilesPopup;
import core.widget.form.FormWidget;
import core.widget.form.field.BaseField;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.FileDownloadMode.FOLDER;

@Getter
public class FileUpload extends BaseField<File> {

    private final FilesPopup popup;

    public FileUpload(FormWidget formWidget, String title) {
        super(formWidget, title, "fileUpload");
        this.popup = new FilesPopup();
    }

    public String getValueTag() {
        return "input[type=\"file\"]";
    }

    /**
     * Uploading a file from a field, getting the path to it
     *
     * @return File
     */
    @Override
    @Step("Getting a value from a field")
    @Attachment
    public File getValue() {
        return getFieldByName().$("button").download(DownloadOptions.using(FOLDER));
    }

    @Override
    public void setValue(File value) {

    }

    /**
     * Uploading a file to the field
     *
     * @param value File
     * {@code example} Hope.jpg
     */

    @Step("Uploading a file to the {value} field")
    @SneakyThrows
    public void setValue(String value) {
        getFieldByName().$(getValueTag()).uploadFromClasspath(value);
        getFieldByName()
                .$("button")
                .shouldHave(Condition.text(value), Duration.ofSeconds(waitingForTests.Timeout));
    }

    /**
     * Getting the name of the downloaded file
     *
     * @return String
     */
    @Step("Getting the downloaded file name")
    @Attachment
    public String getValueName() {
        return getFieldByName()
                .$("button")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .download(DownloadOptions.using(FOLDER))
                .getName();
    }

    /**
     * Getting the file name in the field
     *
     * @return String NameFile
     */
    @Step("Getting the file name in the field")
    @Attachment
    public String getNameFileInField() {
        return getFieldByName()
                .$("button")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    /**
     * Getting the placeholder text
     *
     * @return String text
     */
    @Step("Getting the Placeholder value")
    @Attachment
    public String getPlaceholder() {
        return getFieldByName()
                .$("span[title=\"Placeholder text\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    /**
     * Checking if a field is unavailable for download
     *
     * @return Boolean true/false
     */
    @Step("Checking the field for inactivity")
    @Attachment
    public boolean getReadOnly() {
        return !getFieldByName().$(getValueTag()).is(Condition.exist);
    }

    /**
     * Clearing the field. Deleting a file.
     */
    @Step("Clearing the field. Deleting a file.")
    public void clear() {
        getFieldByName().$("i[title=\"Delete\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        getFieldByName()
                .$("button")
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldBe(Condition.empty, Duration.ofSeconds(waitingForTests.Timeout));
    }
}
