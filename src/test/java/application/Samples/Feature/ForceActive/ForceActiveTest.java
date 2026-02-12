package application.Samples.Feature.ForceActive;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the PickList in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("ForceActive")
public class ForceActiveTest extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Set Force Active")
	@Description("Verify that when the value of a field with forceActive is changed, the fields associated with it are populated.")
	void setForceActive() {

		var app = PlatformApp.screen("Meta. buildRowDependentMeta. Force Active + isFieldChangedNow");
		app.secondLevelView("Inner");
		app.thirdLevelView("Business example");
		var form = app.fourthLevelView("Fields With Force Active").form("Form. Example for Inner Source");
		form.dictionary("Country FA").setValue("Russia");

		form.dictionary("Region FA").checkValue(v -> assertThat(v).isEqualTo("Moscowskaya region"));

	}
}