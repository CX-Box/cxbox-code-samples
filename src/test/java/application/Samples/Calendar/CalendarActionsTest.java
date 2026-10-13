package application.Samples.Calendar;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.widget.calendar.CalendarWidget;
import core.element.widget.calendar.PlatformCalendarMonthWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Standard actions of the CalendarList widget (samples widgets/calendarlist/actions): create inline-form (popup)
 * and with view, edit inline-form (popover) and with view. Analogue of the List action samples.
 */
@DisplayName("Calendar. Standard actions: create and edit (inline-form, with view)")
@Epic("Samples")
@Feature(CalendarActionsTest.ARTICLE)
@Tag("Samples")
public class CalendarActionsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/calendarlist";

	private static final String FIELD = "Custom Field";

	/** a day of the current month without the events of the test data */
	private static final LocalDate DAY = LocalDate.now().withDayOfMonth(15);

	/** capital letters and three days: the new event stands out from the events of the test data (small letters) */
	private static final String NEW_EVENT = "MY NEW EVENT";

	/** Opens the screen of the sample by the menu and checks its address (a screen of one view has no view in the address). */
	private static PlatformCalendarMonthWidget calendar(String screen, String url, String widget) {
		return PlatformApp.screen(screen)
				.view()
				.checkUrl(actual -> assertThat(actual).contains(url))
				.calendarByName(widget);
	}

	private static String unique(String prefix) {
		return prefix + " " + System.currentTimeMillis() % 100000;
	}

	private static <W extends CalendarWidget<W>> List<String> titles(W calendar) {
		return calendar.rows().streamCurrentPage().map(row -> row.input(FIELD).getValue()).toList();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create inline-form")
	@Description("Create opens the form of options.create in a popup over the calendar; after Save the event is shown in the calendar.")
	void createInlineForm() {
		var calendar = calendar("CalendarList widget action create inline-form", "#/screen/myexample5061",
				"MyExample5061");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar_create_with_widget.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		calendar.actions().click("Create");
		var form = PlatformApp.currentScreen().view().formByName("myEntity5061CreateForm");
		String value = unique("Created");
		form.input(FIELD).setValue(value);
		form.dateTime("Start Date Time").setValue(DAY.atTime(12, 0));
		form.dateTime("End Date Time").setValue(DAY.atTime(13, 0));
		form.actions().action("Save").click();
		calendar.waitLoaded();
		DocShots.stop();
		assertThat(titles(calendar)).contains(value);

		calendar.rows().streamCurrentPage()
				.filter(row -> row.input(FIELD).getValue().equals(value))
				.findFirst()
				.orElseThrow()
				.burgerAction("Delete")
				.click();
		calendar.waitLoaded();
		assertThat(titles(calendar)).doesNotContain(value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create, then edit the created event")
	@Description("After Save of the create popup a click on the new event opens the form of options.edit with the values of the new event.")
	void createThenEditCreated() {
		var calendar = calendar("CalendarList widget action create inline-form", "#/screen/myexample5061",
				"MyExample5061");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.actions().click("Create");
		var form = PlatformApp.currentScreen().view().formByName("myEntity5061CreateForm");
		form.input(FIELD).setValue(NEW_EVENT);
		form.dateTime("Start Date Time").setValue(DAY.atTime(9, 0));
		form.dateTime("End Date Time").setValue(DAY.plusDays(2).atTime(18, 0));
		form.actions().action("Save").click();
		calendar.waitLoaded();
		var edit = calendar.rows().streamCurrentPage()
				.filter(row -> row.input(FIELD).getValue().equals(NEW_EVENT))
				.findFirst()
				.orElseThrow()
				.clickPencil();
		assertThat(edit.input(FIELD).getValue()).isEqualTo(NEW_EVENT);
		DocShots.stop();

		edit.burgerAction("Delete").click();
		calendar.waitLoaded();
		assertThat(titles(calendar)).doesNotContain(NEW_EVENT);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create with view")
	@Description("Create drills down to the form view; Save and Close returns to the calendar with the new event.")
	void createWithView() {
		var calendar = calendar("CalendarList widget action create with view", "#/screen/myexample5062",
				"MyExample5062");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar_create_with_view.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.actions().click("Create");
		var form = PlatformApp.currentScreen().view()
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5062/view/myexample5062form"))
				.formByName("MyExample5062Form");
		String value = unique("Created with view");
		form.input(FIELD).setValue(value);
		form.dateTime("Start Date Time").setValue(DAY.atTime(14, 0));
		form.dateTime("End Date Time").setValue(DAY.atTime(15, 0));
		form.actions().action("Save and Close").click();
		calendar = PlatformApp.currentScreen().view()
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5062/view/myexample5062list"))
				.calendarByName("MyExample5062");
		calendar.waitLoaded();
		DocShots.stop();
		assertThat(titles(calendar)).contains(value);

		calendar.rows().streamCurrentPage()
				.filter(row -> row.input(FIELD).getValue().equals(value))
				.findFirst()
				.orElseThrow()
				.burgerAction("Delete")
				.click();
		calendar.waitLoaded();
		assertThat(titles(calendar)).doesNotContain(value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline-form")
	@Description("A click on the event opens the form of options.edit in a popover; the changed value is saved and shown in the event.")
	void editInlineForm() {
		var calendar = calendar("CalendarList widget action edit inline-form", "#/screen/myexample5064",
				"MyExample5064");
		String original = calendar.rows().row(0).input(FIELD).getValue();
		DocShots.gif(ARTICLE, "calendar_edit_with_widget.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		var form = calendar.rows().row(0).clickPencil();
		String value = unique("Edited");
		form.input(FIELD).setValue(value);
		form.actions().action("Save").click();
		calendar.waitLoaded();
		DocShots.stop();
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(value);

		form = calendar.rows().row(0).clickPencil();
		form.input(FIELD).setValue(original);
		form.actions().action("Save").click();
		calendar.waitLoaded();
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(original);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline-form: clickRow, editRow and clickPencil open the same popover")
	@Description("clickRow and editRow open the edit popover of the event; clickPencil returns its form without a second click; the menu of the form has the row actions.")
	void editInlineFormOpenedByRowClick() {
		var calendar = calendar("CalendarList widget action edit inline-form", "#/screen/myexample5064",
				"MyExample5064");
		String title = calendar.rows().row(1).input(FIELD).getValue();

		calendar.rows().clickRow(1);
		assertThat(calendar.rows().row(1).clickPencil().input(FIELD).getValue()).isEqualTo(title);

		calendar.rows().row(0).editRow();
		var form = calendar.rows().row(0).clickPencil();
		assertThat(form.input(FIELD).getValue()).isEqualTo(calendar.rows().row(0).input(FIELD).getValue());
		assertThat(form.burgerAction("Delete").element().getText()).isEqualTo("Delete");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit with view")
	@Description("Edit of the event menu drills down to the form view; Save and Close returns to the calendar with the changed event.")
	void editWithView() {
		var calendar = calendar("CalendarList widget action edit with view", "#/screen/myexample5065",
				"MyExample5065");
		String original = calendar.rows().row(0).input(FIELD).getValue();
		DocShots.gif(ARTICLE, "calendar_edit_with_view.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.rows().row(0).burgerAction("Edit").click();
		var form = PlatformApp.currentScreen().view()
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5065/view/myexample5065form"))
				.formByName("MyExample5065Form");
		String value = unique("Edited with view");
		form.input(FIELD).setValue(value);
		form.actions().action("Save and Close").click();
		calendar = PlatformApp.currentScreen().view()
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample5065/view/myexample5065list"))
				.calendarByName("MyExample5065");
		DocShots.stop();
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(value);

		calendar.rows().row(0).burgerAction("Edit").click();
		form = PlatformApp.currentScreen().view().formByName("MyExample5065Form");
		form.input(FIELD).setValue(original);
		form.actions().action("Save and Close").click();
		Selenide.sleep(1000);
		calendar = PlatformApp.currentScreen().view().calendarByName("MyExample5065");
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(original);
	}

}
