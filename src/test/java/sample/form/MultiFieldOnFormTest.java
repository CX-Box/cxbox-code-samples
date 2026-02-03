package sample.form;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.multifield.MultifieldContainer;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Form. Checking the basic functions for the MultiField in the widget Form")
@Epic("Samples")
@Tag("Samples")
@Tag("Form")
public class MultiFieldOnFormTest extends BaseTestForSamples {

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("A test to get a value for a multifield hint")
	void getValues() {
		var form = PlatformApp.screen("Multifield basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multifield("Custom multifield hint")
				.checkValue(val -> assertThat(val).isEqualTo(
						List.of(new MultifieldContainer("input", "Test data"), new MultifieldContainer("hint", "Information data"))));
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("A test to get a value for a multifield")
	void getValues2() {
		var form = PlatformApp.screen("Multifield basic")
				.secondLevelView("Form")
				.form("Form title");
		form.multifield("Custom multifield")
				.checkValue(val -> assertThat(val).isEqualTo(
						List.of(new MultifieldContainer("input", "Additional data multi"), new MultifieldContainer("input", "Data multi"))));
	}
}
