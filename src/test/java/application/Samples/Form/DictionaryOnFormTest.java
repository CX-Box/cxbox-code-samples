package application.Samples.Form;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Form. Checking the basic functions for the Dictionary in the widget Form")
@Epic("application/Samples")
@Tag("application/Samples")
public class DictionaryOnFormTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp
				.screen("Dictionary enum placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.dictionary("Custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp
				.screen("Dictionary enum color")
				.secondLevelView("Form")
				.form("Form title");
		form.dictionary("Custom Field")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp
				.screen("Dictionary enum readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.dictionary("Custom Field")
				.checkReadOnly(readonly -> assertThat(readonly).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		var form = PlatformApp.screen("Dictionary enum basic")
				.secondLevelView("Form")
				.form("Form title");
		form.dictionary("Custom Field")
				.setValue("Tver region");
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var form = PlatformApp
				.screen("Dictionary enum drillDown")
				.secondLevelView("Form")
				.form("Form title");
		form.dictionary("Custom Field")
				.checkDrillDownSupported(ds -> assertThat(ds).isFalse());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = PlatformApp.screen("Dictionary enum validation business exception")
				.secondLevelView("Form")
				.form("Form title");
		var dictionary = form.dictionary("Custom Field");
		dictionary.setValue("Middle");
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Text.textOnly("'High'")))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = PlatformApp.screen("Dictionary enum validation runtime exception")
				.secondLevelView("Form")
				.form("Form title");
		var dictionary = form.dictionary("Custom Field");
		dictionary.clear();
		form.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = PlatformApp.screen("Dictionary enum validation confirm")
				.secondLevelView("Form")
				.form("Form title");
		var dictionary = form.dictionary("Custom Field");
		dictionary.setValue("Low");
		form.actions().click("save");
		form.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidationAnnotation() {
		var form = PlatformApp.screen("Dictionary enum validation field level annotation")
				.secondLevelView("Form")
				.form("Form title");
		var dictionary = form.dictionary("Custom Field");
		dictionary.setValue("Low");
		form.actions().click("Save");
		dictionary.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = PlatformApp.screen("Dictionary enum validation field level dynamic")
				.secondLevelView("Form")
				.form("Form title");
		form.actions().click("Save");
		form.dictionary("Custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
		form.dictionary("Custom Field Additional")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.MessageAboutError));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Dictionary enum required")
				.secondLevelView("Form")
				.form("Form title");
		var dictionary = form.dictionary("Custom Field");
		dictionary.clear()
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
		form.actions().click("Save");
		dictionary.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}

	@Test
	@Severity(MINOR)
	@Tag("Positive")
	@DisplayName("A test to check the options of the drop-down list")
	void options() {
		var form = PlatformApp.screen("Dictionary enum basic")
				.secondLevelView("Form")
				.form("Form title");
		assertThat(form.dictionary("Custom Field").getOptions())
				.isEqualTo(List.of(
						"Belgorod region",
						"Bryansk region",
						"Vladimir region",
						"Voronezh region",
						"Ivanovo region",
						"Kaluga region",
						"Kostroma region",
						"Kursk region",
						"Moscow region",
						"Oryol region",
						"Ryazan region",
						"Smolensk region",
						"Tambov region",
						"Tver region"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking the icon")
	@Description("The test check icon's name from the drop-down list ")
	void icon() {
		var form = PlatformApp.screen("Dictionary enum icon")
				.secondLevelView("Form")
				.form("Form Mode default");
		assertThat(form.dictionary("Custom Field Dictionary").getOptions())
				.isEqualTo(List.of("High", "Upper middle", "Middle", "Low"));
		var form1 = PlatformApp.screen("Dictionary enum icon")
				.secondLevelView("Form")
				.form("Form Mode default");
		assertThat(form1.dictionary("Custom Field Dictionary").getOptions())
				.isEqualTo(List.of("High", "Upper middle", "Middle", "Low"));
	}
}
