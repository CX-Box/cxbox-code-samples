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

import static org.assertj.core.api.Assertions.assertThat;

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

	@Test
	@DisplayName("Child list shown by forceActive radio of the parent has data")
	@Description("The child lists are hidden by showCondition on the first open. The forceActive radio of the parent form changes the showCondition field, the child lists are shown and have data without Save of the parent")
	public void childListShownByForceActiveHasData() {
		//CXBOX-1432
		var view = PlatformApp.screen("ForceActive radio and child showCondition").view();
		var form = view.formByName("MyExample1432Form");
		var child = view.listByName("MyExample1433List");
		var grandchild = view.listByName("MyExample1435List");
		var accountableCrs = form.radio("Accountable CRS");

		accountableCrs.setValue("Not accountable");
		child.checkVisible(visible -> assertThat(visible).isFalse());
		grandchild.checkVisible(visible -> assertThat(visible).isFalse());

		accountableCrs.setValue("Accountable");
		child.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Cyprus");
		grandchild.checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(grandchild.rows().streamCurrentPage().map(row -> row.input("Country").getValue()))
				.containsExactly("Latvia");

		accountableCrs.setValue("Not accountable");
		form.actions().action("Save").click();
		child.checkVisible(visible -> assertThat(visible).isFalse());
	}
}
