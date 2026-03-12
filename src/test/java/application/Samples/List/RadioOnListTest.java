package application.Samples.List;

import application.common.Text;
import application.config.BaseTestForSamples;
import core.config.Constants;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

public class RadioOnListTest extends BaseTestForSamples {


	@Test
	@Severity(CRITICAL)
	@Tag("Negative")
	@DisplayName("Required Message validation test for one field")
	@Description("The test sets the value with the wrong data type in the field. After approval, it checks the text under the field, which informs about the correctness of the type of data entered.")
	void fieldLevelValidationAnnotation() {
		var list = PlatformApp.screen("Radio validation field level annotation")
				.secondLevelView("List")
				.listInline("List title");
		var row = list.rows().clickRow(0);
		row.radio("Custom Field").setValue("Low");
		row.burgerActionWithSleep("Save").click();
		list.rows().row(0)
				.radio("Custom Field")
				.checkRequired(message -> assertThat(message).isEqualTo(Constants.MessageAboutError));
	}
}