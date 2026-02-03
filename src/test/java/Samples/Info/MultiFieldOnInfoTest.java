package Samples.Info;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.multifield.MultifieldContainer;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Info. Checking the basic functions for the MultiField")
@Epic("Samples")
@Tag("Samples")
public class MultiFieldOnInfoTest extends BaseTestForSamples {

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	@Description("Filtering is not available for InfoWidget.")
	void filtration() {
	}

	@Disabled
	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Sorting test")
	@Description("Sorting is not available for InfoWidget.")
	void sorting() {
	}

	@Test
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	void read() {
		List<MultifieldContainer> expectedContainers = List.of(
				new MultifieldContainer("input", "Test data"),
				new MultifieldContainer("hint", "Information data")
		);
		var info = PlatformApp.screen("MultiField basic")
				.secondLevelView("Info")
				.info("Info title");
		info.multiField("Custom multifield hint")
				.checkValue(actualValue -> assertThat(actualValue).isEqualTo(expectedContainers));
	}
}
