package application.Samples;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.HighlightOptions;
import core.element.PlatformApp;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowsInline;
import core.element.widget.statblock.StatsBlock;
import core.element.widget.statblock.StatsBlockWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Disabled("Test logic")
@DisplayName("Test")
@Epic("test")
@Tag("test")
@Tag("test")
@Slf4j
public class TestLogic extends BaseTestForSamples {

	@Test
	@Tag("Positive")
	@DisplayName("inline edit ")
	@Description("inline edit")
	public void testInlineLogic() {
//		PlatformApp.screen("List widget action create inline-form")
//				.view()
//				.listInlineForm("List")
//				.rows()
//				.row(0);
////				.actions().action("Cancel");

		PlatformInlineFormWidget formWidget = PlatformApp.screen("List widget action create inline-form")
				.view()
				.listInlineForm("List")
				.rows()
				.row(0).clickPencil();
		formWidget.element().highlight(HighlightOptions.border());
		formWidget
				.input("Custom Field")
				.setValue("test 123");
//		formWidget.actions().action("Cancel").click()
//				.row().burgerAction();

		var row = PlatformApp.screen("List widget action create inline-form")
				.view()
				.listInlineForm("List")
				.rows()
				.row(0).clickPencil();
		row.input("Custom Field")
				.setValue("test")
				.widget()
				.actions().action("Save");


		PlatformApp.screen("List widget action create inline-form")
				.view()
				.listInlineForm("List")
				.actions().action("Add").click()
				.rows()
				.row(0).clickPencil()
				.input("Custom Field")
				.setValue("test 123")
				.widget()
				.actions().action("Save");


	}

	@Test
	void additionalInfo() {
		PlatformApp.screen("AdditionalInfo widget basic")
				.view()
				.additionalInfo("Additional information")
				.date("Custom Field Date")
				.checkValue(value -> assertThat(value).isEqualTo(LocalDate.now()));
	}

	@Test
	void groupingHierarchy() {
		PlatformApp.screen("GroupingHierarchy (GH) widget basic")
				.view().listInlineByName("").rows();
		// добавить группы

		var values = PlatformApp.screen("GroupingHierarchy (GH) widget basic")
				.view()
				.groupingHierarchyInline("GroupingHierarchy (GH) widget basic")
				.expandAll()
				.rows()
				// придумать
				.streamCurrentPage().map(r -> r.input("customField").getValue())
				.toList();
//		Selenide.sleep(2000);
//		assertThat(values.size()).isGreaterThan(0);
//		log.info("values {}", values);
	}

	@Test
	public void testStatBlock() {
		StatsBlockWidget statsBlockWidget = PlatformApp.screen("StatsBlock widget filter for List widget")
				.view()
				.statBlockByName("MyExample4210List");


		PlatformListRowsInline rows = PlatformApp.screen("StatsBlock widget filter for List widget")
				.view()
				.listInline("List title")
				.rows();

		assertThat(statsBlockWidget.allBlocks().size()).isEqualTo(3);
		StatsBlock newRecord = statsBlockWidget.block("New record");
		assertThat(newRecord).isNotNull();
		assertThat(newRecord.description()).isEqualTo("New record");
		assertThat(newRecord.count()).isEqualTo("3");
		assertThat(newRecord.icon()).isEqualTo("icon: calendar");
		newRecord.click();
		assertThat(rows.streamCurrentPage().count()).isEqualTo(3);
		StatsBlock inProgress = statsBlockWidget.block("In progress");
		StatsBlock close = statsBlockWidget.block("Close");
		inProgress.click();
		assertThat(rows.streamCurrentPage().count()).isEqualTo(Integer.parseInt(inProgress.count()));
		statsBlockWidget.blockById(2).click();
		assertThat(rows.streamCurrentPage().count()).isEqualTo(Integer.parseInt(close.count()));

	}

	@Test
	public void testActionGroup() {
		var view = PlatformApp.screen("Existing microservice").secondLevelView("Form");
		var widget = view.form("Form title");
		widget.actions().action("Actions").action("Save").click();
	}
}
