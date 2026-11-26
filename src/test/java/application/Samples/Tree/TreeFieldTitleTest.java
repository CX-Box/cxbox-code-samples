package application.Samples.Tree;

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

/** The Tree widget with a calculated title of a field: the title takes a value of the record. */
@DisplayName("Tree. Calculated field title")
@Epic("Samples")
@Feature(TreeFieldTitleTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreeFieldTitleTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/tree";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Calculated field title in the header and in the window of the columns")
	@Description("The title ${customFieldTitle} of the column shows the value of the record in the header of the table and in the window of the columns")
	void calculatedFieldTitle() {
		var widget = PlatformApp.screen("Tree widget calculated field title").view().tree("Tree");
		var header = widget.headers().names();
		assertThat(header).singleElement().asString().startsWith("Custom Field, ");
		DocShots.png(widget.element(), ARTICLE, "fieldtitle.png", 1600, 1000);
		var columns = widget.settings().changeColumns();
		assertThat(columns.getValue()).containsExactlyElementsOf(header);
		columns.close();
	}
}
