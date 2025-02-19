package core.widget.modal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class FilterGroupSettingsPopup {

    private final SelenideElement POPUP = $("div[class=\"ant-modal\"]");

    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    /**
     * Setting the filter name
     *
     * @param name filter name
     */
    @Step("Setting the filter name {nme}")
    public void setName(String name) {
        SelenideElement input = POPUP.$("input").shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout));
        if (!input.has(Condition.attribute("disabled"))) {
            input.setValue(name);
        } else {
            log.error("Поле не активно. Фильтрация не выполнена.");
        }
    }

    /**
     * Creating a filter
     */
    @Step("Creating a filter")
    public void clickButtonCreate() {
        SelenideElement create = POPUP.$("button[type=\"submit\"]").shouldBe(Condition.enabled, Duration.ofSeconds(waitingForTests.Timeout));
        if (!create.has(Condition.attribute("disabled"))) {
            create.click();
        } else {
            log.error("Поле не активно. Фильтрация не выполнена.");
        }
    }

    private ElementsCollection settingsFilter() {
        if (POPUP.$("div[class*=\"FilterSettingModal__filterGroups\"]").is(Condition.visible)) {
            SelenideElement settings = POPUP.$("div[class*=\"FilterSettingModal__filterGroups\"]").shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout));
            return settings.$$("div");
        }
        return null;
    }

    /**
     * Getting a list of created filters
     *
     * @return String
     */
    @Step("Getting a list of created filters")
    @Attachment
    public String getFilterSettings() {
        if (settingsFilter() == null) {
            log.info("Сохраненных фильтров нет");
            return null;
        }
        return String.valueOf(settingsFilter().texts());
    }

    /**
     * Cleaning of all filters
     */
    @Step("Cleaning of all filters")
    public void clearAllFilterSettings() {
        settingsFilter().forEach(element -> element.$("i[aria-label=\"icon: close\"]").click());
    }
}