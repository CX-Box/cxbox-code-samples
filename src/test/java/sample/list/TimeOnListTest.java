package sample.list;

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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the Time")
@Epic("application/Samples")
@Tag("application/Samples")
public class TimeOnListTest extends BaseTestForSamples {

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering by the specified column.")
	void filtration() {
		var list = PlatformApp.screen("Time filtration")
				.secondLevelView("List")
				.listInline("List title");
		LocalDateTime from = LocalDateTime.of(LocalDate.MIN, LocalTime.now().minusHours(8));
		LocalDateTime to = LocalDateTime.of(LocalDate.MIN, LocalTime.now().minusHours(6));
		list.headers().filter(fb -> fb.timeFromTo("Custom Field h:mm", from, to, "HH:mm"));
		var values = list.rows().streamCurrentPage()
				.map(r -> r.time("Custom Field h:mm", "HH:mm").getValue())
				.toList();
		assertThat(values).isNotEmpty();
		assertThat(values.size()).isEqualTo(1);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Test for getting the Placeholder value")
	@Description("The test gets the value from the placeholder attribute and returns it in String format")
	void placeholder() {
		var list = PlatformApp.screen("Time placeholder")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.time("Custom Field", "HH:mm:ss")
				.checkPlaceholder(pl -> assertThat(pl).isEqualTo("11:25:58"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to get the field color value in Hex format")
	@Description("The test gets the value from the style attribute in RGB format, and then converts it to Hex format")
	void color() {
		var list = PlatformApp.screen("Time color")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.time("Custom Field", "HH:mm:ss")
				.checkColor(color -> assertThat(color).isEqualTo("#EDA6A6"));
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The test checks for the disabled attribute.")
	void readonly() {
		var list = PlatformApp.screen("Time readonly")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.time("Custom Field", "HH:mm:ss")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A test for setting a value in a field")
	@Description("The test sets the value in the field, and then checks the value in the field with what should be set")
	void edit() {
		String pattern = "HH:mm:ss";
		var list = PlatformApp.screen("Time base")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		var customValHHmmSS = (LocalDate.MIN.atTime(11, 54, 25));
		var customValHH = (LocalDate.MIN.atTime(11, 0));
		var customValHmm = (LocalDate.MIN.atTime(11, 54));
		var customValHmmA = (LocalDate.MIN.atTime(11, 54));
		var customValHmmSSA = (LocalDate.MIN.atTime(11, 54, 25));

		var customFieldHHmmSS = row.time("Custom Field h:mm:ss", "HH:mm:ss");
		var customFieldHH = row.time("Custom Fieldh", "HH");
		var customFieldHmm = row.time("Custom Field h:mm", "HH:mm");
		var customFieldHmmA = row.time("Custom Field h:mm A", "h:mm a");
		var customFieldHmmSSA = row.time("Custom Field h:mm:ss A", "hh:mm:ss a");

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
	@Tag("Positive")
	@DisplayName("The DrillDown test")
	@Description("Checking the url before the transition and after the transition/click on a special element")
	void drillDown() {
		var list = PlatformApp.screen("Time drilldown")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().row(0);
		row.time("Custom Field", "HH:mm:ss")
				.checkDrillDownSupported(ds -> assertThat(ds).isTrue());
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting by the specified column.")
	void sorting() {
		var list = PlatformApp.screen("Time sorting")
				.secondLevelView("List")
				.listInline("List title");
		var expectedValue = Stream.of("12:58:54", "12:28:54", "10:58:54", "05:58:54")
				.map(v -> LocalDateTime.of(LocalDate.MIN, LocalTime.parse(v)))
				.collect(Collectors.toList());
		var actualValue = list.rows().streamCurrentPage()
				.map(r -> r.time("Custom Field h:mm:ss", "HH:mm:ss").getValue())
				.collect(Collectors.toList());
		assertThat(actualValue).isEqualTo(expectedValue);

		list.headers().sort(sb -> sb.sort("Custom Field h:mm:ss"));
		var actualReverseOrderSortedValue = list.rows().streamCurrentPage()
				.map(r -> r.time("Custom Field h:mm:ss", "HH:mm:ss").getValue())
				.collect(Collectors.toList());
		expectedValue.sort(Comparator.reverseOrder());
		assertThat(actualReverseOrderSortedValue).isEqualTo(expectedValue);

		list.headers().sort(sb -> sb.sort("Custom Field h:mm:ss"));
		var actualNaturalOrderSortedValue = list.rows().streamCurrentPage()
				.map(r -> r.time("Custom Field h:mm:ss", "HH:mm:ss").getValue())
				.collect(Collectors.toList());
		expectedValue.sort(Comparator.naturalOrder());
		assertThat(actualNaturalOrderSortedValue).isEqualTo(expectedValue);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message text Verification field test")
	@Description("The test clears the field and clicks the Save button. Then validates the message that the field is required.")
	void required() {
		var list = PlatformApp.screen("Time required")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.time("Custom Field", "HH:mm:ss")
				.clear()
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.RequiredMessage));
	}
}
