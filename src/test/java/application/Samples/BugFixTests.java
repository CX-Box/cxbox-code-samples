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

@DisplayName("Checking the functions for bug fix")
@Epic("Samples")
@Tag("Samples")
public class BugFixTests extends BaseTestForSamples {

	@Test
	@DisplayName("Include Id when No Fields In Widgets On Bc ")
	@Description("Id field should be automatically added to the API response when no fields of the Business Component (BC) are added to widgets on the screen during the initial load. Check when the BC has no visible fields but acts as a parent BC, child bc data should load")
	public void testIncludeIdWhenNoFieldsInWidgetsOnBc () {
	//CXBOX-1242
	var list = PlatformApp.screen("ShowCondition example")
			.view()
			.listInline("Child Bc");
	var row = list.rows().clickRow(0);
	row.text("Custom Field");
	}

	@Test
	@DisplayName("Row menu of the second list on a view")
	@Description("The view has two lists, each with the row menu. The test changes a row of the second list and saves it by the row menu of this list.")
	public void rowMenuOfSecondList() {
		//CXBOX-1371
		var list = PlatformApp.screen("List widget title")
				.secondLevelView("List widget empty title")
				.listInlineByName("MyExample3104EmptyTitle");
		var row = list.rows().clickRow(0);
		row.input("Custom Field widget2: Empty Title").setValue("Row menu of the second list");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.input("Custom Field widget2: Empty Title")
				.checkValue(value -> assertThat(value).isEqualTo("Row menu of the second list"));
	}
}
