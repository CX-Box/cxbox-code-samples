package application.Samples.CalendarYearList;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.CRITICAL;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.PlatformApp;
import core.util.DocShots;
import core.util.DocShots.Frame;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("CalendarYearList. The year calendar of one-day events and its table mode")
@Epic("Samples")
@Feature(CalendarYearListTest.ARTICLE)
@Tag("Samples")
@Tag("CalendarYearList")
public class CalendarYearListTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/calendaryearlist";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 1000;

	private static SelenideElement calendar() {
		return $("[data-test-widget-name='myexample5039']").shouldBe(Condition.visible);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Basics: the events of the current year")
	@Description("The calendar shows twelve months of the current year with the five one-day events of the sample")
	void basics() {
		PlatformApp.screen("CalendarYearList widget basic").view();
		SelenideElement widget = calendar();
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(5));
		widget.$(".fc-event").shouldHave(Condition.text("Meeting 1"));
		DocShots.png(widget, ARTICLE, "calendaryearlist.png", WIDTH, HEIGHT);
	}

	@Test
	@Tag("Positive")
	@DisplayName("Year navigation: the arrows show the next and the previous year")
	@Description("The next year has no events; the previous arrow returns to the current year with its events")
	void yearNavigation() {
		PlatformApp.screen("CalendarYearList widget basic").view();
		SelenideElement widget = calendar();
		int year = LocalDate.now().getYear();
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(5));
		DocShots.gif(ARTICLE, "year_navigation.gif", 1660, 1000, Frame.WITHOUT_SIDEBAR);
		widget.$("button .anticon-right").closest("button").click();
		widget.shouldHave(Condition.text(String.valueOf(year + 1)));
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(0));
		widget.$("button .anticon-left").closest("button").click();
		widget.shouldHave(Condition.text(String.valueOf(year)));
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(5));
		DocShots.stop();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Table mode: the events as rows, back to the calendar")
	@Description("The gear menu switches the calendar to the table and back")
	void tableMode() {
		PlatformApp.screen("CalendarYearList widget basic").view();
		SelenideElement widget = calendar();
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(5));
		DocShots.gif(ARTICLE, "table_mode.gif", 1660, 1000, Frame.WITHOUT_SIDEBAR);
		widget.$(".anticon-setting").closest("button").click();
		$(".ant-dropdown:not(.ant-dropdown-hidden)").$$("li").findBy(Condition.text("Table")).click();
		widget.$$(".ant-table-tbody tr.ant-table-row").shouldHave(CollectionCondition.size(5));
		widget.$(".anticon-setting").closest("button").click();
		$(".ant-dropdown:not(.ant-dropdown-hidden)").$$("li").findBy(Condition.text("Calendar")).click();
		widget.$$(".fc-event").shouldHave(CollectionCondition.size(5));
		DocShots.stop();
	}

}
