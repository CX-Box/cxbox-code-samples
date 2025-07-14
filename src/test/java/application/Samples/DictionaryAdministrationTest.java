package application.Samples;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import core.widget.list.field.dictionary.FileRow;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Checking the basic functions for the Dictionary administration panel")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DictionaryAdministrationTest extends BaseTestForSamples {

    @Test
    @Tag("Positive")
    @DisplayName("Test for creating admin value")
    @Description("The test creates and delete a new field in the admin panel")
    void create() {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("CLIENT_IMPORTANCE", "TEST", "Test", 2);
        customField.clickButton("Clear Cache");
        MainPages.FirstLevelMenu.click("Example");
        var form = $box.findFormWidgetByTitle("Dictionary Client Importance");
        assertThat(form.dictionary("Dictionary").getOptions()).contains("Test");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test for deleting admin value")
    @Description("The test delete a field in the admin panel")
    void delete() {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.delete("CLIENT_IMPORTANCE","TEST");
        MainPages.FirstLevelMenu.click("Example");
        var form = $box.findFormWidgetByTitle("Dictionary Client Importance");
        assertThat(form.dictionary("Dictionary").getOptions()).doesNotContain("Test");
    }


    @Test
    @Tag("Positive")
    @DisplayName("Test for edit admin value")
    @Description("The test edit a new field in the admin panel")
    void edit() {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("CLIENT_IMPORTANCE", "TEST", "Test", 2);
        customField.clickButton("Clear Cache");
        MainPages.FirstLevelMenu.click("Example");
        var form = $box.findFormWidgetByTitle("Dictionary Client Importance");
        assertThat(form.dictionary("Dictionary").getOptions()).contains("Test");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test export button")
    @Description("Test click \"Export\" and check the file for standards.")
    void testExprotFile() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        List<FileRow> listRow = customField.downloadExportFile("Export");
        assertTrue(customField.checkExportSort(listRow));
        for (FileRow row : listRow) {
            assertEquals(row.KEY, row.KEY.toUpperCase(), "KEY must be uppercase: " + row.KEY);
            assertTrue(row.VALUE != null && !row.VALUE.isBlank()
                , "VALUE format incorrect: " + row.VALUE);
        }
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test region at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void regionsList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("REGIONS", "TEST_CITY", "TestCity", 2);
        customField.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary basic");
        MainPages.FirstLevelMenu.click("List");
        var listExample = $box.findListWidgetByTitle("List configurable dictionary basic");
        List<String> listRows = listExample.getListRowsByColumnName("Custom Field Lov");
        var customFieldList = listExample.findRowSegmentByValue("Custom Field Lov", listRows.get(0)).dictionary();
        assertThat(customFieldList.getOptions()).contains("TestCity");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");

        customField.delete("REGIONS","TEST_CITY");
        customField.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test region at Form")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void regionsForm() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("REGIONS", "TEST_CITY", "TestCity", 2);
        customField.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form configurable dictionary basic");
        var customFieldList = form.dictionary("Custom Field Lov");
        assertThat(customFieldList.getOptions()).contains("TestCity");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        customField.delete("REGIONS","TEST_CITY");
        customField.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test sorting at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void sortingList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("CUSTOM_DICTIONARY_SORTING", "TEST", "test", 2);
        customField.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary sorting");
        MainPages.FirstLevelMenu.click("List");
        var listExample = $box.findListWidgetByTitle("List Dictionary configurable dictionary sorting");
        List<String> listRows = listExample.getListRowsByColumnName("Custom Field Dictionary");
        var customFieldList = listExample.findRowSegmentByValue("Custom Field Dictionary", listRows.get(0)).dictionary();
        assertThat(customFieldList.getOptions()).contains("test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        customField.delete("CUSTOM_DICTIONARY_SORTING","TEST");
        customField.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test filtering at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void filterList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("CUSTOM_DICTIONARY_FILTRATION", "TEST", "Test", 2);
        customField.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary filtration");
        var listExample = $box.findListWidgetByTitle("List configurable dictionary filtration");
        List<String> strings = listExample.findFilterColumn("Custom Field Dictionary").dictionaryFilter().getFilters();
        assertThat(strings).contains("Test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        customField.delete("CUSTOM_DICTIONARY_FILTRATION","TEST");
        customField.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test sorting at Form")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void sortingForm() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findGroupingHierarchyWidgetByTitle("Dictionary configurable dictionary administration");
        var customField = list.dictionaryAdministration();
        customField.createValue("CUSTOM_DICTIONARY_SORTING", "TEST", "Test", 2);
        customField.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form Dictionary configurable dictionary sorting");
        var customFieldList = form.dictionary("customFieldDictionary");
        assertThat(customFieldList.getOptions()).contains("Test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        customField.delete("CUSTOM_DICTIONARY_SORTING","TEST");
        customField.clickButton("Clear Cache");
    }



}
