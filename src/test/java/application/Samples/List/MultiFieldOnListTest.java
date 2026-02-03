package application.Samples.List;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.multifield.MultifieldContainer;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.qameta.allure.SeverityLevel.MINOR;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("List. Checking the basic functions for the MultiField in the widget List")
@Epic("Samples")
@Tag("Samples")
@Tag("List")
public class MultiFieldOnListTest extends BaseTestForSamples {

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("A test to get a value for a multifield hint")
	void getValues() {
		var list = PlatformApp.screen("Multifield basic")
				.secondLevelView("List")
				.listInline("List title");
		var actualData = list.rows().streamAllPages()
				.map(r -> r.multivalueField("Custom multifield hint").getValue())
				.collect(Collectors.toList());

		List<List<MultifieldContainer>> expectedData = new ArrayList<>();
		expectedData.add(List.of(new MultifieldContainer("input", "Test data"), new MultifieldContainer("hint", "Information data")));
		expectedData.add(List.of(new MultifieldContainer("input", "Test data 2"), new MultifieldContainer("hint", "Information data 2")));
		assertThat(actualData).isEqualTo(expectedData);
	}

	@Test
	@Severity(MINOR)
	@Tag("Negative")
	@DisplayName("Filtering test")
	void filtration() {
		var list = PlatformApp.screen("Multifield filtration")
				.secondLevelView("List")
				.listInline("List title");
		list.headers().filter(fb -> fb.multifield("Custom Field Additional", "2"));
		var actualData = list.rows().streamAllPages()
				.map(r -> r.multivalueField("Custom multifield hint").getValue())
				.collect(Collectors.toList());

		List<List<MultifieldContainer>> expectedData = new ArrayList<>();
		expectedData.add(List.of(new MultifieldContainer("input", "Test data 2"), new MultifieldContainer("hint", "Information data 2")));
		assertThat(actualData).isEqualTo(expectedData);
	}
}
