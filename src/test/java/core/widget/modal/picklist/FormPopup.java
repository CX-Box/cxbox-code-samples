package core.widget.modal.picklist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import core.widget.form.FormWidget;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import java.time.Duration;

@RequiredArgsConstructor
public class FormPopup {

    protected final SelenideElement widget;

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Getting the Popup Header
     * @return String
     */
    public String getNameFormPopup() {
        return widget
                .$("div[class=\"ant-modal-title\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .text();
    }

    private ElementsCollection getButtons() {
        return widget.$$(By.tagName("button"));
    }

    /**
     * Clicking on the button by name
     * @param nameButton The name of the button or the text in it
     */
    @Step("Clicking on the button {nameButton}")
    public void clickButton(String nameButton) {
        getButtons().findBy(Condition.text(nameButton)).click();
    }

    /**
     * Calling FormWidget to access the base fields
     * @return FormWidget
     */
    @Step("Calling FormWidget to access the base fields")
    @Attachment
    public FormWidget getFieldByName() {
        return new FormWidget(null, widget);
    }


}
