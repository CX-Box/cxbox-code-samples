package core.widget.groupingHierarchy;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import core.OriginExpectations.CxBoxExpectations;
import core.widget.ListHelper;
import core.widget.addfiles.AddFiles;
import core.widget.addfiles.DragAndDropFileZone;
import core.widget.filter.ListFilter;
import core.widget.form.FormWidget;
import core.widget.list.ListWidget;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

import java.time.Duration;
import java.util.*;

import static java.lang.String.format;

@Slf4j
@RequiredArgsConstructor
public class GroupingHierarchyWidget {

    private final String title;
    private final SelenideElement widget;
    private final ListHelper helper;
    private final CxBoxExpectations waitingForTests = new CxBoxExpectations();

    public GroupingHierarchyWidget(SelenideElement widget, String title) {
        this.title = title;
        this.widget = widget;
        this.helper = new ListHelper(this.widget);
    }


    /**
     * Getting all the values of strings with the type Row
     *
     * @return List String
     */
    @Step("Getting all the values of strings with the type Row")
    @Attachment
    public List<String> getListRows() {
        List<String> rows = new ArrayList<>();
        for (SelenideElement row : helper.getListRows()) {
            waitingForTests.getWaitAllElements(row);
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    row.is(Condition.visible)) {
                row
                        .should(Condition.visible, Condition.exist, Condition.enabled)
                        .scrollIntoView("{block: \"center\"}");
                if (Objects.requireNonNull(row.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                                .getAttribute("data-test-widget-list-row-type"))
                        .equals("Row")) {
                    rows.add(Objects.requireNonNull(row.getText()).replace("\n", ", "));
                }
            }

        }
        return rows;
    }

    /**
     * Getting all the values of strings with the type GroupingRow
     *
     * @return List String
     */
    @Step("Getting all the values of strings with the type GroupingRow")
    @Attachment
    public List<String> getListGroupingRows() {
        List<String> rows = new ArrayList<>();
        waitingForTests.getWaitAllElements(widget);
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    row.is(Condition.visible)) {
                row
                        .should(Condition.visible, Condition.exist, Condition.enabled)
                        .scrollIntoView("{block: \"center\"}");
                if (Objects.requireNonNull(row.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                                .getAttribute("data-test-widget-list-row-type"))
                        .equals("GroupingRow")) {
                    rows.add(row.getAttribute("data-test-widget-list-row-id"));
                }
            }
        }
        return rows;

    }

    /**
     * Getting a Row Id by value from any segment
     *
     * @param value Segment's value
     * @return Long Id
     */
    @Step("Getting a Row Id by the {value} value from any segment")
    @Attachment
    public Long findRowId(String value) {
        return helper
                .getListRows()
                .shouldHave(CollectionCondition.sizeGreaterThan(0))
                .stream()
                .filter(r -> {
                    for (String columnName : helper.getColumns().texts()) {
                        if (helper.getColumnByName(columnName, r).getText().equals(value)) {
                            return true;
                        }
                    }
                    return false;
                })
                .findFirst()
                .map(r -> r.attr("data-test-widget-list-row-id"))
                .map(Long::valueOf)
                .orElseThrow(() -> new IllegalArgumentException(format("no row with value=%s found", value)));
    }

    /**
     * Row search by column name and row id
     *
     * @param columnName String
     * @param id         long
     * @return ListWidget with access to all fields
     */
    @Step("Searching for a row by column name {columnName} and lines id {id}")
    @Attachment
    public ListWidget findRowById(String columnName, long id) {
        waitingForTests.getWaitAllElements(widget);
        return new ListWidget(columnName, widget, String.valueOf(id), this.helper, checkSorting(columnName), checkFilterColumn(columnName));
    }

    /**
     * Searching for a row by column name and by value in the segment
     *
     * @param columnName String
     * @param value      String
     * @return ListWidget with access to all fields
     */
    @Step("Searching for a row by column name {columnName} and by value in the segment {value}")
    public ListWidget findRowByValue(String columnName, String value) {
        waitingForTests.getWaitAllElements(widget);
        long id = findRowId(value);
        return new ListWidget(columnName, widget, String.valueOf(id), this.helper, checkSorting(columnName), checkFilterColumn(columnName));
    }

    /**
     * Revealing the hierarchy by branch name
     *
     * @param branchName String
     */
    @Step("Opening the branch hierarchy {branchName}")
    public void openBranch(String branchName) {
        waitingForTests.getWaitAllElements(widget);
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    Objects.requireNonNull(row.getAttribute("data-test-widget-list-row-id"))
                            .equals(branchName)) {
                row.$("i[aria-label=\"icon: up\"]")
                        .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                        .scrollIntoView("{block: \"center\"}")
                        .click();
            }
        }
    }

    /**
     * Closing the hierarchy by branch name
     *
     * @param branchName String
     */
    @Step("Closing the branch hierarchy {branchName}")
    public void closeBranch(String branchName) {
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    Objects.requireNonNull(row.getAttribute("data-test-widget-list-row-id"))
                            .equals(branchName)) {
                row
                        .$("i[aria-label=\"icon: down\"]")
                        .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                        .scrollIntoView("{block: \"center\"}")
                        .click();
            }
        }
    }

    /**
     * Getting the term value by level
     *
     * @param numberLevel Integer
     * @return List String
     */
    @Step("Getting the term value by level {numberLevel}")
    @Attachment
    public List<String> getListRowLevel(Integer numberLevel) {
        List<String> rows = new ArrayList<>();
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    Objects.requireNonNull(row.getAttribute("data-test-widget-list-row-type")).equals("Row")
                    &&
                    Objects.requireNonNull(row
                                    .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                                    .getAttribute("class"))
                            .equals("ant-table-row ant-table-row-level-" + numberLevel)) {
                rows.add(row.getText().replace("\n", ", "));
            }
        }
        return rows;
    }

    /**
     * Bulk file upload..
     *
     * @return class AddFiles
     */
    @Step("Validation of the mass upload field")
    @Attachment
    public Optional<AddFiles> findAddFiles() {
        if (widget
                .$("div[class=\"ant-upload ant-upload-select ant-upload-select-text\"]")
                .$("button[data-test-widget-action-item=\"true\"]")
                .scrollIntoView("{block: \"center\"}")
                .is(Condition.visible)) {
            return Optional.of(new AddFiles(widget));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Clicking on the button by its name
     *
     * @param actionName Name button
     */
    @Step("Clicking on the button {actionName}")
    public void clickButton(String actionName) {
        SelenideElement button = getButton(actionName);
        button
                .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .click();
        waitingForTests.getWaitAllElements(widget);
    }

    /**
     * Displaying a list of all buttons in a widget
     */
    @Step("Getting a list of buttons")
    @Attachment
    public List<String> getButtons() {
        return getContainersActions().texts();
    }

    private SelenideElement getButton(String actionName) {
        return getContainersActions()
                .find(Condition.match("check action name: " + actionName, b -> b.getText().equals(actionName)));
    }

    private ElementsCollection getContainersActions() {
        return getContainer()
                .$$(By.tagName("button"))
                .shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    private SelenideElement getContainer() {
        return widget
                .scrollIntoView("{block: \"center\"}")
                .shouldBe(Condition.enabled);
    }

    /**
     * Checking the sorting of a column
     *
     * @param column Column's name
     * @return Boolean true/false
     */
    @Step("Checking the sorting option for a column {column}")
    @Attachment
    public Boolean checkSorting(String column) {
        boolean isColumnFound = false;
        for (SelenideElement c : helper.getColumns()) {
            if (c.getText().equals(column)) {
                isColumnFound = true;
                if (!c.$("i[data-test-widget-list-header-column-sort=\"true\"]")
                        .shouldBe(Condition.exist, Duration.ofSeconds(waitingForTests.Timeout))
                        .exists()) {
                    return false;
                }
            }
        }
        return isColumnFound;
    }

    /**
     * Checking the filtering option for a column
     *
     * @param column Column's name
     * @return Boolean true/false
     */
    @Step("Checking the filtering option for a column {column}")
    @Attachment
    public Boolean checkFilterColumn(String column) {
        return getColumn(column).$("div[data-test-widget-list-header-column-filter=\"true\"]")
                .is(Condition.visible);
    }

    private SelenideElement getColumn(String columnName) {
        for (SelenideElement c : helper.getColumns()) {
            if (c.getText().equals(columnName)) {
                return c;
            }
        }
        throw new RuntimeException("Столбец " + columnName + " не найден");
    }

    /**
     * Getting the column type
     *
     * @param column Column's name
     * @return String
     */
    @Step("Getting the column type {column}")
    @Attachment
    public String getTypeColumn(String column) {
        return getColumn(column).getAttribute("data-test-widget-list-header-column-type");
    }

    /**
     * Filtering search for the selected column
     *
     * @param column Column's name
     * @return Filter Sheet
     */
    public ListFilter findFilterColumn(String column) {
        try {
            if (checkFilterColumn(column)) {
                getColumn(column)
                        .$("div[data-test-widget-list-header-column-filter=\"true\"]")
                        .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                        .click();
                return new ListFilter(getTypeColumn(column), column, helper, widget);
            }
        } catch (ElementNotFound e) {
            log.error("Элемент не найден");
        }
        throw new RuntimeException("Фильтр для столбца " + column + " не найден.");
    }

    /**
     * Sorting. If the column has a sorting function.
     *
     * @param column Column's name
     */
    @Step("Sorting in a column {column}")
    public void setSorting(String column) {
        waitingForTests.getWaitAllElements(widget);
        helper.returnFirstPage();
        try {
            if (checkSorting(column)) {
                helper.setSorting(column);
                waitingForTests.getWaitAllElements(widget);
            } else {
                throw new RuntimeException("Сортировка для столбца " + column + " не найдена. Или недоступна.");
            }
        } catch (Exception e) {
            log.error("Ошибка при установке сортировки для столбца {}: {}", column, e.getMessage());
        }
    }

    /**
     * Switching a widget from a Hierarchy to a List
     */
    @Step("Switching a widget from a Hierarchy to a List")
    public void switchList() {
        widget
                .$("i[aria-label=\"icon: apartment\"]")
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .scrollIntoView("{block: \"center\"}")
                .parent()
                .click();
    }

    /**
     * Collapse of all lines
     */
    @Step("Collapse of all lines")
    public void collapseColumns() {
        SelenideElement iconCollapse = widget
                .$("i[aria-label=\"icon: unordered-list\"]").parent();
        if (iconCollapse.is(Condition.enabled)) {
            iconCollapse.click();
        } else {
            throw new ElementNotInteractableException("Element not interactable");
        }
    }

    /**
     * Getting the value without focusing on the field.
     * To get the exact value, you should use the following methods:
     * findRowSegmentByValue or findRowSegmentById  with field type selection
     *
     * @param columnName Column's name
     * @return String
     */
    @Step("Getting the values of the {columnName} column without field focus")
    @Attachment
    public List<String> getNoFocusValues(String columnName) {
        List<String> list = new ArrayList<>();
        waitingForTests.getWaitAllElements(widget);
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    Objects.requireNonNull(row.getAttribute("data-test-widget-list-row-type")).equals("Row")) {
                ElementsCollection segments = row.$$("td > div[data-test=\"FIELD\"]");
                for (SelenideElement segment : segments) {
                    if (Objects.requireNonNull(segment.getAttribute("data-test-field-title")).equals(columnName)) {
                        list.add(segment.getText());
                    }
                }
            }

        }
        return list;
    }

    /**
     * Getting a status without focusing on the field.
     *
     * @param columnName Column's name
     * @return List Boolean true/false
     */
    @Step("Getting the status of the {columnName} column without field focus")
    @Attachment
    public List<Boolean> getNoFocusStatusValues(String columnName) {
        List<Boolean> list = new ArrayList<>();
        waitingForTests.getWaitAllElements(widget);
        for (SelenideElement row : helper.getListRows()) {
            if (row.is(Condition.attribute("data-test-widget-list-row-type"))
                    &&
                    Objects.requireNonNull(row.getAttribute("data-test-widget-list-row-type")).equals("Row")) {
                ElementsCollection segments = row.$$("td > div[data-test=\"FIELD\"]");
                for (SelenideElement segment : segments) {
                    if (Objects.requireNonNull(segment.getAttribute("data-test-field-title")).equals(columnName)) {
                        list.add(segment.isSelected());
                    }
                }
            }

        }
        return list;
    }



    /**
     * Opening the InlineForm for editing
     *
     * @return FormWidget
     */
    @Step("Opening the InlineForm for editing")
    @Attachment
    public Optional<FormWidget> openAndFindInlineFormForCreate() {
        String inlineForm = "div[data-test-widget-list-row-type=\"InlineForm\"]";
        clickButton("Add");
        if (widget.$(inlineForm)
                .shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout))
                .scrollIntoView("{block: \"center\"}")
                .is(Condition.visible)) {
            return Optional.of(new FormWidget(title, widget.$(inlineForm)));
        } else {
            return Optional.empty();
        }
    }

    /**
     * Validation of the file upload zone
     *
     * @return DragAndDropFileZone
     */
    @Step("Validation of the file upload zone")
    @Attachment
    public Optional<DragAndDropFileZone> findDragAndDropFileZone() {
        String dragZone = "div[class*=\"ant-upload-drag FileUpload\"]";
        if (widget.$(dragZone).shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).is(Condition.visible)) {
            return Optional.of(new DragAndDropFileZone(widget.$(dragZone)));
        } else {
            log.info("Drag And Drop File Zone is not visible of not found");
            return Optional.empty();
        }
    }

    /**
     * Getting a list of fields in a heading and type pair
     *
     * @return HashMap(String, String)
     */
    @Step("Getting a list of fields in a heading and type pair")
    @Attachment
    public HashMap<String, String> getFieldTitleAndType() {
        HashMap<String, String> values = new HashMap<>();
        for (SelenideElement field : widget.shouldBe(Condition.visible, Duration.ofSeconds(waitingForTests.Timeout)).$$("div[data-test]")) {
            String title = field.attr("data-test-field-title");
            String type = field.attr("data-test-field-type");
            values.put(title, type);
        }
        return values;
    }

}
