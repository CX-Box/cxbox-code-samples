package application.Samples;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import core.widget.info.InfoWidget;
import core.widget.list.actions.MenuRow;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

public class HiddenOnTests extends BaseTestForSamples {

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Dynamic hidden List widget")
    @Description("A test that verifies that the element disappears after the parameter is changed")
    void dynamicList() {
        MainPages.click("Widget property field setHidden");
        MainPages.FirstLevelMenu.click("Family List, Assoc, Popup, 2D, 1D");
        MainPages.SecondLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List");

        List<Long> listRowsId = list.getListRowsId();
        var row = list.findRowSegmentById("Custom Field Dictionary", listRowsId.get(0));
        var customFieldDictionary = row.dictionary();

        customFieldDictionary.setValue("High");
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        var hiddenField1 = list.findRowSegmentById("Custom Field", listRowsId.get(0)).input();
        assertThat(hiddenField1.isHidden()).isFalse();

        customFieldDictionary.setValue("Low");
        assertThat(menuRow).isPresent();
        menuRow = row.findMenuRow();
        menuRow.get().clickOption("Save");
        var hiddenField2 = list.findRowSegmentById("Custom Field", listRowsId.get(0)).input();
        assertThat(hiddenField2.isHidden()).isFalse();
     }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Dynamic hidden GroupingHierarchy (GH) widget")
    @Description("A test that verifies that the element disappears after the parameter is changed")
    void dynamicGH() {
        MainPages.click("Widget property field setHidden");
        MainPages.FirstLevelMenu.click("Family List, Assoc, Popup, 2D, 1D");
        MainPages.SecondLevelMenu.click("List");
        var gh = $box.findGroupingHierarchyWidgetByTitle("GroupingHierarchy (GH) widget");

        List<String> ghRows = gh.getListGroupingRows();
        var row = gh.findRowGoupingFieldsById("Custom Field Dictionary", Long.parseLong(ghRows.get(0)));
        var customFieldDictionary = row.dictionary();

        customFieldDictionary.setValue("High");
        Optional<MenuRow> menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        var noHiddenField =gh.findRowGoupingFieldsById("Custom Field", Long.parseLong(ghRows.get(0))).input();
        assertThat(noHiddenField.isHidden()).isFalse();

        customFieldDictionary.setValue("Low");
        menuRow = row.findMenuRow();
        assertThat(menuRow).isPresent();
        menuRow.get().clickOption("Save");
        var hiddenField = gh.findRowGoupingFieldsById("Custom Field", Long.parseLong(ghRows.get(0))).input();
        assertThat(hiddenField.isHidden()).isFalse();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Dynamic hidden GroupingHierarchy (GH) widget")
    @Description("A test that verifies that the element disappears after the parameter is changed")
    void dynamicForm() {
        MainPages.click("Widget property field setHidden");
        MainPages.FirstLevelMenu.click("Family Form,Info");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customFieldDictionary = form.dictionary("Custom Field Dictionary");

        customFieldDictionary.setValue("High");
        form.clickButton("Save");
        var noHiddenField = form.input("Custom Field");
        assertThat(noHiddenField.isHidden()).isFalse();

        customFieldDictionary.setValue("Low");
        form.clickButton("Save");
        var hiddenField = form.hidden("Custom Field");
        assertThat(hiddenField.isHidden()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Dynamic hidden GroupingHierarchy (GH) widget")
    @Description("A test that verifies that the element disappears after the parameter is changed")
    void dynamicInfo() {
        MainPages.click("Widget property field setHidden");
        MainPages.FirstLevelMenu.click("Family Form,Info");
        FormWidget form = $box.findFormWidgetByTitle("Form");
        var customFieldDictionary = form.dictionary("Custom Field Dictionary");
        customFieldDictionary.setValue("High");
        form.clickButton("Save");

        InfoWidget info = $box.findInfoWidgetByTitle("Info");
        var noHiddenField = info.input("Custom Field");
        assertThat(noHiddenField.isHidden()).isFalse();

        customFieldDictionary.setValue("Low");
        form.clickButton("Save");
        var hiddenField = form.hidden("Custom Field");
        assertThat(hiddenField.isHidden()).isTrue();

    }


    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Hidden static test")
    @Description("A test that looks at whether a hidden field is hidden")
    void nonDynamicForm() {
        MainPages.click("Hidden basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form title");

        var hiddenField = form.hidden("customField");

        assertThat(hiddenField.isHidden()).isTrue();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Hidden static test")
    @Description("A test that looks at whether a hidden field is hidden")
    @Disabled
    void nonDynamicList() {
        MainPages.click("Hidden basic");
        MainPages.FirstLevelMenu.click("List");
        var list = $box.findListWidgetByTitle("List title");


        var hiddenField = list.findRowSegmentById("customField", 1101484).hidden();

        assertThat(hiddenField.isHidden()).isFalse();
    }

    @Test
    @Severity(CRITICAL)
    @Tag("Positive")
    @DisplayName("Hidden static test")
    @Description("A test that looks at whether a hidden field is hidden")
    void nonDynamicInfo() {
        MainPages.click("Hidden basic");
        MainPages.FirstLevelMenu.click("Info");
        InfoWidget info = $box.findInfoWidgetByTitle("Info title");

        var hiddenField = info.hidden("");

        assertThat(hiddenField.isHidden()).isTrue();
    }
}
