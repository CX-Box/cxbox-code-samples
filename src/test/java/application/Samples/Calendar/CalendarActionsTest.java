package application.Samples.Calendar;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.calendar.CalendarWidget;
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

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(2500);
		return PlatformApp.currentScreen().view();
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
		var calendar = open("myexample5061", "myexample5061list").calendarByName("MyExample5061");
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
	@DisplayName("Create with view")
	@Description("Create drills down to the form view; Save and Close returns to the calendar with the new event.")
	void createWithView() {
		var calendar = open("myexample5062", "myexample5062list").calendarByName("MyExample5062");
		calendar.waitLoaded();
		DocShots.gif(ARTICLE, "calendar_create_with_view.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.actions().click("Create");
		Selenide.sleep(2000);
		var form = PlatformApp.currentScreen().view().formByName("MyExample5062Form");
		String value = unique("Created with view");
		form.input(FIELD).setValue(value);
		form.dateTime("Start Date Time").setValue(DAY.atTime(14, 0));
		form.dateTime("End Date Time").setValue(DAY.atTime(15, 0));
		form.actions().action("Save and Close").click();
		Selenide.sleep(2500);
		calendar = PlatformApp.currentScreen().view().calendarByName("MyExample5062");
		calendar.waitLoaded();
		DocShots.stop();
		assertThat(titles(calendar)).contains(value);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit inline-form")
	@Description("A click on the event opens the form of options.edit in a popover; the changed value is saved and shown in the event.")
	void editInlineForm() {
		var calendar = open("myexample5064", "myexample5064list").calendarByName("MyExample5064");
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
		var calendar = open("myexample5064", "myexample5064list").calendarByName("MyExample5064");
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
		var calendar = open("myexample5065", "myexample5065list").calendarByName("MyExample5065");
		String original = calendar.rows().row(0).input(FIELD).getValue();
		DocShots.gif(ARTICLE, "calendar_edit_with_view.gif", 1660, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		calendar.rows().row(0).burgerAction("Edit").click();
		Selenide.sleep(2000);
		var form = PlatformApp.currentScreen().view().formByName("MyExample5065Form");
		String value = unique("Edited with view");
		form.input(FIELD).setValue(value);
		form.actions().action("Save and Close").click();
		Selenide.sleep(2500);
		calendar = PlatformApp.currentScreen().view().calendarByName("MyExample5065");
		DocShots.stop();
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(value);

		calendar.rows().row(0).burgerAction("Edit").click();
		Selenide.sleep(2000);
		form = PlatformApp.currentScreen().view().formByName("MyExample5065Form");
		form.input(FIELD).setValue(original);
		form.actions().action("Save and Close").click();
		Selenide.sleep(2500);
		calendar = PlatformApp.currentScreen().view().calendarByName("MyExample5065");
		assertThat(calendar.rows().row(0).input(FIELD).getValue()).isEqualTo(original);
	}

}
