package core.widget.modal.picklist;

import com.codeborne.selenide.*;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

public class MultiValueModal extends AbstractPickList {
    public MultiValueModal(String title) {
        super("AssocListPopup", title);
    }

    @Override
    protected SelenideElement getIcon() {
        return null;
    }

    @Override
    protected SelenideElement getCheckBoxAll() {
        return this.widget
                .$("thead[class=\"ant-table-thead\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$("th[class=\"ant-table-selection-column\"]")
                .$(By.tagName("input"));
    }

    @Override
    protected SelenideElement getSubmitButton() {
        return this.widget
                .$("button[data-test-widget-list-close=\"true\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout));
    }

    @Override
    protected SelenideElement getSelectionRow(SelenideElement row) {
        return row.$(By.cssSelector("td[class='ant-table-selection-column']"))
                .$(By.tagName("input"))
                .shouldBe(Condition.enabled);
    }

    /**
     * Setting the list of values with pre-clearing of the field.
     *
     * @param columnName Table's name
     * @param value      List String list of values
     * @param status     Boolean true/false
     */
    @Step("Setting the list of values")
    @Override
    public void setValues(String columnName, List<String> value, Boolean status) {
        clear();
        setMultiValue(columnName, value, status);
        close();
    }

    /**
     * Setting a single value
     *
     * @param value  String value
     * @param status Boolean true/false
     */
    @Step("Setting the {value} value to {status}")
    public void setValue(String value, Boolean status) {
        while (true) {
            getColumnName().forEach(column -> setValuesOnCurrentPage(column, Collections.singletonList(value), status));
            if (isLastPage()) {
                break;
            }
            pressRight(1);
        }
        close();
    }

    /**
     * Setting multiple values, without clearing the field
     *
     * @param columnName Table's name
     * @param value      List String list of values
     * @param status     Boolean true/false
     */
    @Step("Setting multiple values, without clearing the field")
    @Override
    public void setMultiValue(String columnName, List<String> value, Boolean status) {
        while (true) {
            setValuesOnCurrentPage(columnName, value, status);
            if (isLastPage()) {
                break;
            }
            pressRight(1);
        }
    }

    private void setValuesOnCurrentPage(String columnName, List<String> values, Boolean status) {
        helper.getListRows()
                .shouldBe(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .filter(r -> values.contains(helper.getColumnByName(columnName, r).getText()))
                .forEach(row -> {
                    if (getSelectionRow(row).shouldBe(Condition.enabled).isSelected() == status) {
                        getSelectionRow(row).click();
                    }
                    if (!getSelectionRow(row).shouldBe(Condition.enabled).isSelected() == status) {
                        getSelectionRow(row).click();
                    }
                });
    }

    /**
     * Setting all values
     */
    @Step("Setting all values")
    public void setValueAll() {
        while (true) {
            getCheckBoxAll().click();
            if (isLastPage()) {
                break;
            }
            pressRight(1);
        }
        Selenide.sleep(100);
        if(Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"")).exists()) {
            return;
        }
        close();
    }

    public List<String> getColumnName() {
        return helper.getColumnNames();
    }

    /**
     * Clearing the field
     */
    @Step("Clearing the field")
    public void clear() {
        ElementsCollection icons = this.widget
                .$("div[class=\"ant-modal-title\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .$$("i[aria-label=\"icon: close\"]");
        for (SelenideElement i : icons) {
            i.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                    .click();
            sleep(100);
        }
    }

    /**
     * Getting all the values from the status column
     *
     * @param columnName Column's name
     * @return List Pair Boolean String статус и имя
     */
    @Step("Getting all values from the {columnName} column with the status")
    @Attachment
    public List<Pair<Boolean, String>> getStatusValue(String columnName) {
        List<Pair<Boolean, String>> statusAndNames = new ArrayList<>();
        while (true) {
            helper.getListRows()
                    .shouldBe(CollectionCondition.sizeGreaterThan(0))
                    .stream()
                    .forEach(row -> {
                        Boolean status = getSelectionRow(row).isSelected();
                        String name = helper.getColumnByName(columnName, row).getText();
                        statusAndNames.add(Pair.of(status, name));
                    });
            if (isLastPage()) {
                break;
            }
            pressRight(1);
        }
        return statusAndNames;
    }

    /**
     * Clicking on the button Close
     */
    @Step("Clicking on the button Close")
    public void close() {
        getSubmitButton()
                .click();
    }
}
