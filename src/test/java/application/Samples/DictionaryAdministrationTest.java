package application.Samples;

import application.config.BaseTestForSamples;
import core.MainPages;
import core.widget.form.FormWidget;
import core.widget.list.field.dictionary.DictionaryAdministration;
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
    @Description("The test creates a new field in the admin panel")
    void create() {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        List<String> listRows = list.getListRows();
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("CLIENT_IMPORTANCE", "TEST", "Test", 2);
        dictionaryAdministration.clickButton("Clear Cache");
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
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        List<String> listRows = list.getListRows();
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.delete("CLIENT_IMPORTANCE","TEST");
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
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        List<String> listRows = list.getListRows();
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("CLIENT_IMPORTANCE", "TEST", "Test", 2);
        dictionaryAdministration.clickButton("Clear Cache");
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
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        List<FileRow> listRow = dictionaryAdministration.downloadExportFile("Export");
        assertTrue(dictionaryAdministration.checkExportSort(listRow));
        for (FileRow row : listRow) {
            assertEquals(row.KEY, row.KEY.toUpperCase(), "KEY must be uppercase: " + row.KEY);
            assertTrue(row.VALUE.matches("([A-Z][a-z\\.\\-]*)( [A-Z][a-z\\.\\-]*)*"), "VALUE format incorrect: " + row.VALUE);
        }
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test region at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void regionsList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("REGIONS", "TEST_CITY", "TestCity", 2);
        dictionaryAdministration.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary basic");
        MainPages.FirstLevelMenu.click("List");
        var listExample = $box.findListWidgetByTitle("List configurable dictionary basic");
        List<String> listRows = listExample.getListRowsByColumnName("Custom Field Lov");
        var customField = listExample.findRowSegmentByValue("Custom Field Lov", listRows.get(0)).dictionary();
        assertThat(customField.getOptions()).contains("TestCity");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        DictionaryAdministration dictionaryAdministration2 = new DictionaryAdministration();
        dictionaryAdministration2.delete("REGIONS","TEST_CITY");
        dictionaryAdministration.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test region at Form")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void regionsForm() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("REGIONS", "TEST_CITY", "TestCity", 2);
        dictionaryAdministration.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary basic");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form configurable dictionary basic");
        var customField = form.dictionary("Custom Field Lov");
        assertThat(customField.getOptions()).contains("TestCity");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var listDelete = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration2 = new DictionaryAdministration();
        dictionaryAdministration2.delete("REGIONS","TEST_CITY");
        dictionaryAdministration.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test sorting at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void sortingList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("CUSTOM_DICTIONARY_SORTING", "TEST", "test", 2);
        dictionaryAdministration.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary sorting");
        MainPages.FirstLevelMenu.click("List");
        var listExample = $box.findListWidgetByTitle("List Dictionary configurable dictionary sorting");
        List<String> listRows = listExample.getListRowsByColumnName("Custom Field Dictionary");
        var customField = listExample.findRowSegmentByValue("Custom Field Dictionary", listRows.get(0)).dictionary();
        assertThat(customField.getOptions()).contains("test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var listDelete = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration2 = new DictionaryAdministration();
        dictionaryAdministration2.delete("CUSTOM_DICTIONARY_SORTING","TEST");
        dictionaryAdministration.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test filtering at List")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void filterList() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("CUSTOM_DICTIONARY_FILTRATION", "TEST", "Test", 2);
        dictionaryAdministration.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary filtration");
        var listExample = $box.findListWidgetByTitle("List configurable dictionary filtration");
        List<String> strings = listExample.findFilterColumn("Custom Field Dictionary").dictionaryFilter().getFilters();
        assertThat(strings).contains("Test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var listDelete = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration2 = new DictionaryAdministration();
        dictionaryAdministration2.delete("CUSTOM_DICTIONARY_FILTRATION","TEST");
        dictionaryAdministration.clickButton("Clear Cache");
    }

    @Test
    @Tag("Positive")
    @DisplayName("Test sorting at Form")
    @Description("The test checks the creation and deletion in the dictionary and the result of this work on another screen.")
    void sortingForm() throws IOException {
        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var list = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration = new DictionaryAdministration();
        dictionaryAdministration.createValue("CUSTOM_DICTIONARY_SORTING", "TEST", "Test", 2);
        dictionaryAdministration.clickButton("Clear Cache");

        MainPages.click("Dictionary configurable dictionary sorting");
        MainPages.FirstLevelMenu.click("Form");
        FormWidget form = $box.findFormWidgetByTitle("Form Dictionary configurable dictionary sorting");
        var customField = form.dictionary("customFieldDictionary");
        assertThat(customField.getOptions()).contains("Test");

        MainPages.click("Dictionary configurable dictionary administration");
        MainPages.FirstLevelMenu.click("Dictionary administration");
        var listDelete = $box.findDictionaryAdminWidgetByTitle("Dictionary configurable dictionary administration");
        DictionaryAdministration dictionaryAdministration2 = new DictionaryAdministration();
        dictionaryAdministration2.delete("CUSTOM_DICTIONARY_SORTING","TEST");
        dictionaryAdministration.clickButton("Clear Cache");
    }



}
