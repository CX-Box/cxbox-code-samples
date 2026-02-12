package application.Samples;

import application.config.BaseTestForSamples;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

//TODO >> refactor test
public class HiddenOnTests extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Dynamic hidden")
	@Description("A test that verifies that the element disappears after the parameter is changed")
	void dynamic() {
//        MainPages.click("CXBOX-812");
//        MainPages.FirstLevelMenu.click("For Project");
//        MainPages.SecondLevelMenu.click("Example 2");
//        FormWidget form = $box.findFormWidgetByTitle("Form");
//
//        var hiddenField = form.pickList("Инстанция FA");
//        var changedField = form.dictionary("Тип объекта FA");
//
//        assertThat(hiddenField.isHidden()).isFalse();
//        changedField.setValue("Object type 1");
//        assertThat(hiddenField.isHidden()).isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Hidden static test")
	@Description("A test that looks at whether a hidden field is hidden")
	void nonDynamicForm() {
//        MainPages.click("Hidden basic");
//        MainPages.FirstLevelMenu.click("Form");
//        FormWidget form = $box.findFormWidgetByTitle("Form title");
//
//        var hiddenField = form.hidden("customField");
//
//        assertThat(hiddenField.isHidden()).isTrue();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Hidden static test")
	@Description("A test that looks at whether a hidden field is hidden")
	@Disabled
	void nonDynamicList() {
//        MainPages.click("Hidden basic");
//        MainPages.FirstLevelMenu.click("List");
//        var list = $box.findListWidgetByTitle("List title");
//
//
//        var hiddenField = list.findRowSegmentById("customField", 1101484).hidden();
//
//        assertThat(hiddenField.isHidden()).isFalse();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Hidden static test")
	@Description("A test that looks at whether a hidden field is hidden")
	void nonDynamicInfo() {
//        MainPages.click("Hidden basic");
//        MainPages.FirstLevelMenu.click("Info");
//        InfoWidget info = $box.findInfoWidgetByTitle("Info title");
//
//        var hiddenField = info.hidden("");
//
//        assertThat(hiddenField.isHidden()).isTrue();
	}
}
