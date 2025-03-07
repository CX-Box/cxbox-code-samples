package core.widget.filter;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.OriginExpectations.CxBoxExpectations;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.DownloadOptions.using;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;
import static com.codeborne.selenide.Selenide.$;

public class GearMenu {
    final SelenideElement MENU = $("ul[class=\"ant-dropdown-menu ant-dropdown-menu-light ant-dropdown-menu-root ant-dropdown-menu-vertical\"]");

    protected final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    private ElementsCollection getMenuItems() {
        return MENU
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("li[role=\"menuitem\"]");
    }

    /**
     * Getting a list of options меню
     *
     * @return List(String)
     */
    @Step("Getting a list of options меню")
    @Attachment
    public List<String> getOptions() {
        return getMenuItems().texts();
    }

    /**
     * Selecting an option in the menu
     *
     * @param option The name of the option. Use a separate method for exporting
     */
    @Step("Selecting an option {option} in the menu")
    @Attachment
    public void setOption(String option) {
        getMenuItems()
                .findBy(Condition.text(option))
                .click();
    }

    /**
     * Exporting a file
     *
     * @return File table in Excel
     */
    @Step("Exporting a file")
    @Attachment
    @SneakyThrows
    public File getExportFile() {
        return getMenuItems()
                .findBy(Condition.text("Excel"))
                .download(using(FOLDER));
    }

}
