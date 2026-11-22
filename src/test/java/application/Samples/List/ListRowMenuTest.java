package application.Samples.List;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The menu of the row actions of the List widget. */
@DisplayName("List. Row menu")
@Epic("Samples")
@Feature(ListRowMenuTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class ListRowMenuTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/list";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Menu button after the menu is closed by a click in the row")
	@Description("The menu of the row is closed by a click in the same row: the menu button is shown again while the mouse moves in the row")
	void menuButtonAfterClickInRow() {
		var rows = PlatformApp.screen("List widget action edit with view").view().listInline("List").rows();
		rows.row(0).openBurger();
		rows.clickRow(0).checkBurgerVisible(visible -> assertThat(visible).isTrue());
	}
}
