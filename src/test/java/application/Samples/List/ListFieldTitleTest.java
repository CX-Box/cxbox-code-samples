package application.Samples.List;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The List widget with a calculated title of a field: the title takes a value of the record. */
@DisplayName("List. Calculated field title")
@Epic("Samples")
@Feature(ListFieldTitleTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class ListFieldTitleTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/list";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Calculated field title in the header and in the window of the columns")
	@Description("The title ${customFieldTitle} of the column shows the value of the record in the header of the table and in the window of the columns")
	void calculatedFieldTitle() {
		var widget = PlatformApp.screen("List widget calculated field title").view().listInline("List");
		var header = widget.headers().names();
		assertThat(header).singleElement().asString().startsWith("Custom Field, ");
		DocShots.png(widget.element(), ARTICLE, "fieldtitle.png", 1600, 1000);
		var columns = widget.settings().changeColumns();
		assertThat(columns.getValue()).containsExactlyElementsOf(header);
		columns.close();
	}
}
