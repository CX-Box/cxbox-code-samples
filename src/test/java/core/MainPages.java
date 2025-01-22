package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class MainPages {

    public static final SelenideElement MAIN_MENU = ContextUtils.LEFT_SIDER
            .$("ul[data-test='MAIN_MENU']");

    private static final ElementsCollection MAIN_SECTIONS = MAIN_MENU
            .$$("li[data-test='MAIN_MENU_ITEM']");

    /**
     * Select a section in the left menu
     *
     * @param sectionName Section name
     */
    @Step("Selecting the {section Name} section in the left menu")
    public static void click(String sectionName) {
        MAIN_SECTIONS
                .find(Condition.exactText(sectionName))
                .shouldBe(Condition.enabled)
                .click();
        checkSkeleton();
    }


    public static class FirstLevelMenu {

        private static final ElementsCollection FIRST_LEVEL_SECTIONS = $(
                "div[data-test-widget-name='SecondLevelMenu']")
                .$$("span[data-test-navigation-tabs-item='true']");

        /**
         * Selecting a tab on a page
         *
         * @param sectionName Name of the tab
         */
        @Step("Selecting a tab {sectionName} on a page")
        public static void click(String sectionName) {
            FIRST_LEVEL_SECTIONS
                    .find(Condition.exactText(sectionName))
                    .shouldBe(Condition.enabled)
                    .click();
            checkSkeleton();
        }


    }
    /**
     * Waiting for the page to load
     */
    private static void checkSkeleton() {
        SelenideElement element = $(By.className("ant-skeleton"));
        element.shouldNot(Condition.exist, Duration.ofSeconds(1));
    }
}
