package application.Samples.List;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The window of the columns of the List widget: the columns of the table go to "Additional" and back. */
@DisplayName("List. Customization of displayed columns")
@Epic("Samples")
@Feature(ListCustomizationColumnsTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class ListCustomizationColumnsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/list";

	private static final String INPUT = "Custom Field Input";

	private static final String PERCENT = "Custom Field Percent";

	private static final String RADIO = "Custom Field Radio";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A column goes to Additional and back")
	@Description("The window of the columns removes a column from the table and returns it; Reset returns the columns of the widget")
	void columnToAdditionalAndBack() {
		var list = PlatformApp.screen("List widget customization columns").secondLevelView("List widget")
				.listInline("List widget customization columns");
		var columns = list.settings().changeColumns()
				.checkOptions(all -> assertThat(all).containsExactlyInAnyOrder(INPUT, PERCENT, RADIO))
				.setValue(Set.of(INPUT, RADIO))
				.checkStatusOption(PERCENT, inTable -> assertThat(inTable).isFalse());
		assertThat(list.headers().names()).containsExactly(INPUT, RADIO);
		columns.addValue(Set.of(PERCENT))
				.checkStatusOptions(Map.of(INPUT, inTable -> assertThat(inTable).isTrue(), PERCENT, inTable -> assertThat(inTable).isTrue()));
		assertThat(columns.getValue()).containsExactly(INPUT, PERCENT, RADIO);
		columns.close();
		list.settings().select("Reset");
		assertThat(list.headers().names()).containsExactly(INPUT, PERCENT, RADIO);
	}
}
