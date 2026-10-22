package application.Samples.Feature.massOperations;

import static core.element.widget.list.MassOperation.Result.SUCCESS;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("List. Mass operation: ticking the rows, the confirm form, the results")
@Epic("Samples")
@Tag("Samples")
@Tag("MassOperations")
@Feature(MassOperationsTest.ARTICLE)
public class MassOperationsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/massoperations";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Mass edit of the ticked rows with the confirm form")
	@Description("Two rows on two pages are ticked, the step Review rows shows only them, the form of the step Confirm operation sets the fields, the results show both rows done.")
	void massEdit() {
		var app = PlatformApp.screen("Bulk (Mass) operations");
		app.secondLevelView("with Confirm operation");
		var list = app.thirdLevelView("Basic List widget").listInlineByName("myexample6101list");
		// the operation changes the fields of the rows: the data of the sample is loaded again at the start of the backend
		list.actions().click("Mass Edit");
		var mass = list.massOperation();
		assertThat(mass.step()).isEqualTo("Select rows");
		// five rows on a page: the rows are on the first and on the second page
		mass.select("test data 2");
		list.pagination().nextPage();
		mass.select("test data 7").click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		assertThat(mass.rows()).as("rows of the step Review rows").containsExactlyInAnyOrder("test data 7", "test data 2");
		mass.click("Next");
		assertThat(mass.step()).isEqualTo("Confirm operation");
		mass.confirmDictionary("customFieldDictionary", "High")
				.confirmCheckbox("customFieldCheckbox", true)
				.confirmClick("Save");
		assertThat(mass.results()).isEqualTo(Map.of("test data 7", SUCCESS, "test data 2", SUCCESS));
		mass.click("Close");
		assertThat(mass.isActive()).isFalse();
	}

}
