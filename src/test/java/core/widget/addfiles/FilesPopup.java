package core.widget.addfiles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.lang3.tuple.Pair;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class FilesPopup {

    private final SelenideElement popup = $("div[class=\"ant-notification ant-notification-topRight\"]");
    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Getting the header value
     *
     * @return String
     */
    @Step("Getting the header value")
    @Attachment
    public String getTitle() {
        return popup
                .$("div[class=\"ant-notification-notice-message\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .getText();
    }

    /**
     * Getting a list of files and their status
     *
     * @return List Pair
     */
    @Step("Getting a list of files and their status")
    @Attachment
    public List<Pair<String, String>> getFileNameAndStatusUpload() {
        List<Pair<String, String>> pairs = new ArrayList<Pair<String, String>>();
        for (SelenideElement file : getFilesList()) {
            String key = file.getAttribute("data-test-file-name");
            String value = file.getAttribute("data-test-file-status");
            pairs.add(Pair.of(key, value));
        }
        return pairs;
    }

    /**
     * Closing window
     */
    @Step("Closing window")
    public void close() {
        popup
                .$("i[aria-label=\"icon: close\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

    private ElementsCollection getFilesList() {
        return popup
                .$("div[data-test-file-upload-prgress-list=\"true\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("div[class*=\"UploadList__fileRow\"]");
    }
}
