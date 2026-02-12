package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the dateTimeWithSec in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
@Slf4j
public class DateTimeWithSecondsOnListTest extends BaseTestForSamples {

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("DateTimeWithSeconds placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.editRow()
				.dateTimeWithSec("custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("29.05.2023 11:25:58"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("DateTimeWithSeconds color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.dateTimeWithSec("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var form = PlatformApp.screen("DateTimeWithSeconds readonly")
				.secondLevelView("Form")
				.form("Form title");
		form.dateTimeWithSecond("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 11, 10, 10, 10, 10);
		var list = PlatformApp.screen("DateTimeWithSeconds basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dateTimeWithSec("custom Field")
				.setValue(dateTime)
				.checkValue(val -> assertThat(val).isEqualTo(dateTime));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		LocalDateTime dateTime = LocalDateTime.of(2022, 5, 20, 8, 47, 34);
		LocalDateTime dateTime2 = LocalDateTime.of(2023, 6, 25, 8, 47, 34);
		var expectedValues = Stream.of("15.05.2023 09:20:42")
				.map(str -> LocalDateTime.parse(str, FORMATTER))
				.collect(Collectors.toList());
		var list = PlatformApp.screen("DateTimeWithSeconds filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.dateWithSecondFromTo("custom Field", dateTime, dateTime2));
		var actualData = list.rows().streamCurrentPage()
				.map(r -> r.dateTimeWithSec("custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValues);
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("DateTimeWithSeconds drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.dateTimeWithSec("Custom Field")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
		var list = PlatformApp.screen("DateTimeWithSeconds validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dateTimeWithSec("Custom Field").setValue(dateTime);
		row.burgerAction("Save").click();
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.MoreThatCurrentDate))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Run-time exception validation test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void runtimeException() {
		var list = PlatformApp.screen("DateTimeWithSeconds validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dateTimeWithSec("custom Field").clear();
		list.errorPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ErrorPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SystemError))
				.close();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Confirmation Popup Validation Test")
	@Description("The test sets the value in the field. After approval, by clicking on the save button, the popup window, the title, the text in it, and the buttons are validated.")
	void confirm() {
		LocalDateTime dateTime = LocalDateTime.of(2020, 9, 10, 10, 10, 10);
		var list = PlatformApp.screen("DateTimeWithSeconds validation confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dateTimeWithSec("custom Field").setValue(dateTime);
		row.burgerAction("save").click();
		list.confirmPopup()
				.checkTitleAndMessage(
						title -> assertThat(title).isEqualTo(Constants.ConfirmPopup.TITLE),
						message -> assertThat(message).isEqualTo(Constants.SaveValue))
				.clickOk();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		LocalDateTime dateTime = LocalDateTime.of(1999, 11, 10, 10, 10, 10);
		var list = PlatformApp.screen("DateTimeWithSeconds validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.dateTimeWithSec("Custom Field");
		var customFieldAdditional = row.dateTimeWithSec("Custom Field Additional");
		customField.setValue(dateTime);
		customFieldAdditional.setValue(dateTime);
		row.burgerAction("Save").click();
		customField.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textMoreThatCurrentDate("customField")));
		customFieldAdditional.checkRequired(rm -> assertThat(rm).isEqualTo(Text.textMoreThatCurrentDate("customFieldAdditional")));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		List<LocalDateTime> expectedValue = Stream.of("15.07.2025 09:20:42",
						"15.06.2025 06:05:42",
						"13.05.2025 09:05:42",
						"15.05.2024 05:05:42",
						"13.05.2025 09:05:42",
						"14.05.2025 07:17:42",
						"15.05.2025 06:50:42",
						"15.05.2023 09:20:42",
						"15.05.2025 08:50:42")
				.map(str -> LocalDateTime.parse(str, FORMATTER))
				.collect(Collectors.toList());
		var list = PlatformApp.screen("DateTimeWithSeconds sorting")
				.secondLevelView("List")
				.listInline("List title");
		var headers = list.headers();
		var actualData = list.rows().streamAllPages()
				.map(r -> r.dateTimeWithSec("custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("custom Field"));
		expectedValue.sort(Comparator.reverseOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.dateTimeWithSec("custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);

		headers.sort(sb -> sb.sort("custom Field"));
		expectedValue.sort(Comparator.naturalOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.dateTimeWithSec("custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("DateTimeWithSeconds required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.dateTimeWithSec("custom Field").clear();
		row.burgerAction("Save").click();
		list.rows().row(0)
				.dateTimeWithSec("custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}
}


