package application.Samples.Feature.massOperations;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

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
	@Description("Two rows on two pages are ticked by their values, the step Review rows shows only them, the form of the step Confirm operation sets the fields, the results show both rows done.")
	void massEdit() {
		var app = PlatformApp.screen("Bulk upload");
		app.secondLevelView("with Confirm operation");
		var list = app.thirdLevelView("Basic List widget").listByName("myexample6101List");
		// the operation changes the fields of the rows: the data of the sample is loaded again at the start of the backend
		var mass = list.massOperation("Mass Edit");
		// five rows on a page: the rows are on the first and on the second page
		mass.setValues("customField", List.of("test data 7", "test data 2"));
		mass.next();
		assertThat(list.rows().streamCurrentPage().map(row -> row.input("customField").getValue()))
				.as("rows of the step Review rows").containsExactlyInAnyOrder("test data 7", "test data 2");
		mass.next();
		mass.confirm(form -> {
			form.dictionary("Custom Field Dictionary").setValue("High");
			form.checkbox("customField Checkbox").setValue(true);
		});
		mass.checkResults("customField", results -> assertThat(results).containsOnly(entry("test data 7", true), entry("test data 2", true)));
		mass.close();
	}

}
