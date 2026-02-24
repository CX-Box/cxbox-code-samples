package application.Samples.Form;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the Suggestion PickList in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
public class SuggestionPickListOnFormTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for the Form widget")
	void sorting() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("SuggestionPicklist placeholder")
				.secondLevelView("Form")
				.form("Form Widget with suggestionPickList placeholder");
		form.suggestionPickList("customField")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field via Popup using a unique id, and then checks the value in the field with what needs to be set")
	void edit() {
		var form = PlatformApp.screen("SuggestionPicklist basic")
				.thirdLevelView("Form")
				.form("Form Widget with suggestionPickList basic");
		var suggestionPickList = form.suggestionPickList("customField");
		suggestionPickList.setValue("Test data8")
				.checkValue(val -> assertThat(val).isEqualTo("Test data8"));
		suggestionPickList.clear();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("SuggestionPicklist validation business exception")
				.view()
				.form("Form");
		var suggestionPickList = form.suggestionPickList("customField");
		suggestionPickList.setValue("Test data9");
		form.actions().action("Save").click();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("SuggestionPicklist validation runtime exception")
				.view()
				.form("Form");
		var suggestionPickList = form.suggestionPickList("customField");
		suggestionPickList.setValue("Test data9");
		form.actions().action("Save").click();
		form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("SuggestionPicklist validation confirm")
				.view()
				.form("Form");
		var suggestionPickList = form.suggestionPickList("customField");
		suggestionPickList.setValue("Test data9");
		form.actions().action("save").click();
		form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
		suggestionPickList.clear();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("SuggestionPicklist validation field level dynamic")
				.secondLevelView("Form")
				.form("Form");
		var customField = form.suggestionPickList("customField");
		var customFieldAdditional = form.suggestionPickList("customFieldAdditional");
		customField.setValue("Test data9");
		customFieldAdditional.setValue("Test data10");
		form.actions().action("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo("The field 'customField' can contain only letters."));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo("The field 'customFieldAdditional' can contain only letters."));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("SuggestionPicklist required")
				.secondLevelView("Form")
				.form("Form");
		var suggestionPickList = form.suggestionPickList("customField");
		suggestionPickList.clear();
		form.actions().action("Save").click();
		suggestionPickList.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("SuggestionPicklist readonly")
				.secondLevelView("Form")
				.form("Form");
		form.suggestionPickList("customField")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}
}
