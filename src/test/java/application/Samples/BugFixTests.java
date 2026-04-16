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
}
