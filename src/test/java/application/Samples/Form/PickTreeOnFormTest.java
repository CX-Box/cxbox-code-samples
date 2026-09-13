package application.Samples.Form;

import application.config.BaseTestForSamples;
import application.custom.Position;
import core.config.Constants;
import core.element.PlatformApp;
import core.element.widget.form.PlatformFormWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Form. Checking the basic functions for the PickTree in the widget Form")
@Epic("application/Samples")
@Feature(PickTreeOnFormTest.ARTICLE)
@Tag("application/Samples")
@Tag("Form")

public class PickTreeOnFormTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/pickTree";

	static final String POPUP_ARTICLE = "widget/type/picktreepopup";

	private static final String FIELD = "Custom Field";

	private static PlatformFormWidget form(String screen) {
		return PlatformApp.screen(screen)
				.secondLevelView("Form")
				.form("Form title");
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = form("Picktree placeholder");
		form.pickTree(FIELD)
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("Placeholder text"));
		DocShots.png(form.element(), ARTICLE, "img_plchldr_form.png", 1600, 1000);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	@Disabled
	void color() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var form = form("Picktree readonly");
		form.pickTree(FIELD)
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		DocShots.png(form.element(), ARTICLE, "img_ro_form.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@Feature(PickTreeOnFormTest.POPUP_ARTICLE)
	@DisplayName("A test for setting a value in a field")
	@Description("The test opens the popup, sets the value in the field via the popup, saves the form and checks the value in the field")
	void edit() {
		var form = form("Picktree basic");
		var customField = form.pickTree(FIELD);
		var popup = customField.openPopup();
		popup.loadNext();
		DocShots.png(popup.dialog(), POPUP_ARTICLE, "pickTreePopupBasic.png", 1600, 1000);
		popup.close();
		DocShots.gif(ARTICLE, "img_form.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		customField.clear();
		customField.setValue(FIELD, "New data");
		form.actions().action("Save").click();
		DocShots.stop();
		customField.checkValue(val -> assertThat(val).isEqualTo("New data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for checking a value in a field")
	@Description("The test gets the value in the field, and then checks the value in the field with what should be")
	void read() {
		form("Picktree basic")
				.pickTree(FIELD)
				.checkValue(val -> assertThat(val).isEqualTo("New data"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void businessException() {
		var form = form("Picktree validation business exception");
		form.pickTree(FIELD).setValue(FIELD, "1234");
		var error = form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.OnlyLetters));
		DocShots.png(ARTICLE, "img_business_error.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated")
	void runtimeException() {
		var form = form("Picktree runtime");
		form.pickTree(FIELD).setValue(FIELD, "Test data");
		var error = form.errorPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SystemError));
		DocShots.png(ARTICLE, "img_runtime_error.png", 1600, 1000);
		error.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated")
	void confirm() {
		var form = form("Picktree validation confirm");
		form.pickTree(FIELD).setValue(FIELD, "Test data");
		form.actions().action("save").click();
		var confirm = form.confirmPopup()
				.checkTitle(title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE))
				.checkMessage(message -> assertThat(message).isEqualTo(Constants.SaveValue));
		DocShots.png(ARTICLE, "confirm_form.png", 1600, 1000);
		confirm.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test clicks Save with the wrong values in several fields. After approval, it checks the text under the fields, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		var form = form("Picktree validation field level dynamic");
		form.actions().action("Save").click();
		form.pickTree(FIELD)
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customField' can contain only letters."));
		form.pickTree("Custom Field Additional")
				.checkRequired(message -> assertThat(message).isEqualTo("The field 'customFieldAdditional' can contain only letters."));
		DocShots.png(form.element(), ARTICLE, "img_javax_stat_form.png", 1600, 1000);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = form("Picktree required");
		var customField = form.pickTree(FIELD).clear();
		form.actions().action("Save").click();
		customField.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
		DocShots.png(form.element(), ARTICLE, "img_req_form.png", 1600, 1000);
	}

	@Test
	void position() {
		assertTrue(Position.checkPosition(302, 95, form("Picktree basic").element()));
	}

}
