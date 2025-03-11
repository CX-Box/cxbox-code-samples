package core.widget.form.actions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;

import java.time.Duration;

@RequiredArgsConstructor
public class ButtonWithMenu {

    private final SelenideElement menu;

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    public ElementsCollection getOptions() {
        return menu.$$(By.tagName("li"));
    }

    /**
     * Selecting an option from the button menu
     *
     * @param nameOption String
     */
    @Step("Selecting the {name Option} option from the button menu")
    public void clickOption(String nameOption) {
        getOptions()
                .find(Condition.text(nameOption))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
    }

}
