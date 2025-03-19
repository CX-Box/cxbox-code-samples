package core;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static core.widget.TestingTools.CellProcessor.logTime;

@Slf4j
public class MainPages {


    public static final SelenideElement MAIN_MENU = ContextUtils.LEFT_SIDER
            .$("ul[data-test='MAIN_MENU']");

    private static final ElementsCollection MAIN_SECTIONS = MAIN_MENU
            .$$("li[data-test='MAIN_MENU_ITEM']");

    /**
     * Select a section in the left menu
     *
     * @param sectionName Section name
     *
     * @serialData DateTime
     */

    public static void click(String sectionName) {
        Allure.step("Selecting the " + sectionName + " section in the left menu.", step -> {
            step.parameter("sectionName", sectionName);
            logTime(step);
            MAIN_SECTIONS
                    .find(Condition.exactText(sectionName))
                    .shouldBe(Condition.enabled)
                    .click();
            checkSkeleton();
        });
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
        public static void click(String sectionName) {
            Allure.step("Selecting a tab " + sectionName + " on a page", step -> {
                logTime(step);
                step.parameter("Name of tab", sectionName);

                FIRST_LEVEL_SECTIONS
                        .find(Condition.exactText(sectionName))
                        .shouldBe(Condition.enabled)
                        .click();
                checkSkeleton();
            });

        }


    }
    /**
     * Waiting for the page to load
     */
    private static void checkSkeleton() {
        SelenideElement element = $(By.className("ant-skeleton-paragraph"));
        System.out.println("\n\n");
        log.info("checkSection -> ant-skeleton exists " + element.exists());
        element.shouldNot(Condition.exist, Duration.ofSeconds(1));
        log.info("checkSkeleton -> finished. exists:" + element.exists());
        System.out.println("\n\n");
        System.out.println("\n\n");
    }
}
