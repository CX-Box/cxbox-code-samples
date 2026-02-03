package application.Samples.Form;

import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

public class TimeOnFormTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for the Form widget")
	void filtration() {
//        var form = PlatformApp.screen("Date filtration")
//              .secondLevelView("Form")
//              .form("Form title");
//        var customField = form.date("Custom Field");
//        assertThatThrownBy(customField::setFiltration).isInstanceOf(UnsupportedOperationException.class);
	}

	@Disabled
	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
//        var form = PlatformApp.screen("Time drilldown")
//              .secondLevelView("Form")
//              .form("Form title");
//        var customField = form.time("Custom Field", "HH:mm a");
//        assertThatThrownBy(customField::drillDown).isInstanceOf(UnsupportedOperationException.class);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var form = PlatformApp.screen("Time placeholder")
				.secondLevelView("Form")
				.form("Form title");
		form.time("Custom Field", "HH:mm:ss")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("11:25:58"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var form = PlatformApp.screen("Time color")
				.secondLevelView("Form")
				.form("Form title");
		form.time("Custom Field", "HH:mm:ss")
				.checkColor(color -> assertThat(color).isNull());
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute")
	void readonly() {
		var form = PlatformApp.screen("Time readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.time("Custom Field", "HH:mm:ss")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		LocalDateTime date = LocalDateTime.of(2024, 12, 5, 11, 25, 58);
		String pattern = "HH:mm:ss";
		var form = PlatformApp.screen("Time base")
				.secondLevelView("Form")
				.form("Form title");

		var customValHHmmSS = (LocalDate.MIN.atTime(11, 54, 25));
		var customValHH = (LocalDate.MIN.atTime(11, 0));
		var customValHmm = (LocalDate.MIN.atTime(11, 54));
		var customValHmmA = (LocalDate.MIN.atTime(11, 54));
		var customValHmmSSA = (LocalDate.MIN.atTime(11, 54, 25));

		var customFieldHHmmSS = form.time("Custom Field h:mm:ss", "HH:mm:ss");
		var customFieldHH = form.time("Custom Fieldh", "HH");
		var customFieldHmm = form.time("Custom Field h:mm", "HH:mm");
		var customFieldHmmA = form.time("Custom Field h:mm A", "h:mm a");
		var customFieldHmmSSA = form.time("Custom Field h:mm:ss A", "hh:mm:ss a");

		customFieldHHmmSS.setValue(customValHHmmSS).checkValue(value -> assertThat(value).isNotNull())
				.checkValue(value -> assertThat(value).isEqualTo(customValHHmmSS));
		customFieldHH.setValue(customValHH).checkValue(value -> assertThat(value).isNotNull())
				.checkValue(value -> assertThat(value).isEqualTo(customValHH));
		customFieldHmm.setValue(customValHmm).checkValue(value -> assertThat(value).isNotNull())
				.checkValue(value -> assertThat(value).isEqualTo(customValHmm));
		customFieldHmmA.setValue(customValHmmA).checkValue(value -> assertThat(value).isNotNull())
				.checkValue(value -> assertThat(value).isEqualTo(customValHmmA));
		customFieldHmmSSA.setValue(customValHmmSSA).checkValue(value -> assertThat(value).isNotNull())
				.checkValue(value -> assertThat(value).isEqualTo(customValHmmSSA));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required")
	void required() {
		var form = PlatformApp.screen("Time required")
				.secondLevelView("Form")
				.form("Form title");
		form.time("Custom Field", "HH:mm:ss")
				.clear()
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
