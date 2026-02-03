package Samples.List;

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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("unchecked")

@DisplayName("List. Checking the basic functions for the Date in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class DateOnListTest extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Date placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("29.05.2023"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Date color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.date("custom Field")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Date readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set.")
	void edit() {
		LocalDate date = LocalDate.of(2020, 10, 11);
		var list = PlatformApp.screen("Date basic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field")
				.setValue(date)
				.checkValue(ad -> assertThat(ad).isEqualTo(date));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		LocalDate from = LocalDate.of(2021, 3, 7);
		LocalDate to = LocalDate.of(2023, 3, 7);
		LocalDate expectedDate = LocalDate.of(2022, 5, 13);
		var list = PlatformApp.screen("Date filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.dateFromTo("custom Field", from, to));
		list.rows().row(0)
				.date("custom Field")
				.checkValue(val -> assertThat(val).isEqualTo(expectedDate));
	}

	@Test
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Date drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.date("custom Field")
				.drilldown(url -> assertThat(url).contains("/screen/DateDrillDown/view/DateDrillDownform/dateDrillDown"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Business Exception Validation Test")
	@Description("The test sets the value in the field. After approval, the popup window, the title, the text in it, and the buttons are validated.")
	void businessException() {
		LocalDate date = LocalDate.of(2023, 3, 7);
		var list = PlatformApp.screen("Date validation business exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field").setValue(date);
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
		var list = PlatformApp.screen("Date validation runtime exception")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field").clear();
		row.burgerAction("Save").click();
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
		LocalDate date = LocalDate.of(2023, 3, 7);
		var list = PlatformApp.screen("Date confirm")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field").setValue(date);
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
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		LocalDate date = LocalDate.of(2023, 3, 7);
		var list = PlatformApp.screen("Date validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("Custom Field").setValue(date);
		row.burgerAction("Save").click();
		list.rows().row(0)
				.date("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MoreThatCurrentDate));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for multiple fields")
	@Description("The test sets a value with the wrong data type in several fields for different widgets. After approval, it checks the text under the field, which informs about the correctness of the type of data entered")
	void fieldLevelValidation() {
		LocalDate date = LocalDate.of(2023, 3, 7);
		var list = PlatformApp.screen("Date validation field level dynamic")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customField = row.date("Custom Field");
		var customFieldAdditional = row.date("Custom Field Additional");
		customField.setValue(date);
		customFieldAdditional.setValue(date);
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		List<LocalDate> expectedValue = Stream.of("15.07.2025",
						"15.06.2025",
						"15.05.2023",
						"15.05.2024",
						"13.05.2025",
						"14.05.2023",
						"13.05.2022",
						"15.04.2025",
						"15.05.2025")
				.map(s -> LocalDate.parse(s, formatter))
				.collect(Collectors.toList());
		var list = PlatformApp.screen("Date sorting")
				.secondLevelView("List")
				.listInline("List title");
		var headers = list.headers();
		List<LocalDate> actualData = list.rows().streamAllPages()
				.map(r -> r.date("custom Field").getValue())
				.collect(Collectors.toList());
		assertThat(actualData).isEqualTo(expectedValue);
		headers.sort(sb -> sb.sort("custom Field"));
		expectedValue.sort(Comparator.reverseOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.date("custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
		headers.sort(sb -> sb.sort("custom Field"));
		expectedValue.sort(Comparator.naturalOrder());
		assertThat(list.rows().streamAllPages()
				.map(r -> r.date("custom Field").getValue())
				.collect(Collectors.toList())).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Date Required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.date("custom Field").clear();
		row.burgerAction("save").click();
		list.rows().row(0)
				.date("custom Field")
				.checkRequired(rm -> assertThat(rm).isEqualTo(Constants.RequiredMessage));
	}
}
