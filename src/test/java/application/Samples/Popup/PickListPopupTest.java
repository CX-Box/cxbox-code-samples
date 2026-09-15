package application.Samples.Popup;

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

/** PickListPopup: the basics and the title of the popup; the pictures of the article. */
@DisplayName("PickListPopup. Basics and title")
@Epic("Samples")
@Feature(PickListPopupTest.ARTICLE)
@Tag("Samples")
public class PickListPopupTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/picklistpopup";

	private static final String FIELD = "Custom Field";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A value is picked from the popup into the field of the list")
	@Description("The popup of the pickList field opens from the row; a click on a row of the popup picks the value and closes the popup")
	void basics() {
		var list = PlatformApp
				.screen("PickListPopup widget basic")
				.secondLevelView("PickListPopup List Widget")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3067/view/myexample3079list"))
				.listByName("MyExample3079List");
		var row = list.rows().clickRow(0);
		var field = row.pickList("Custom Field Pick List");
		DocShots.gif(ARTICLE, "pickListPopupBasic.gif", 1660, 760, DocShots.Frame.WITH_SIDEBAR);
		field.setValue("Custom Field", "test data");
		field.checkValue(v -> assertThat(v).isEqualTo("test data"));
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Constant title of the popup")
	void constantTitle() {
		var screen = PlatformApp.screen("PickListPopup widget with title");
		screen.secondLevelView("PickListPopup widget with title");
		var form = screen.thirdLevelView("Form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3068/view/myexample3068form"))
				.formByName("MyExample3068Form");
		var popup = form.pickList(FIELD).openListPopup();
		assertThat(popup.title()).isEqualTo("Constant Title");
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupWithTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Popup without a title")
	void withoutTitle() {
		var screen = PlatformApp.screen("PickListPopup widget with title");
		screen.secondLevelView("PickListPopup widget without title");
		var form = screen.thirdLevelView("Form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3068/view/myexample3069form"))
				.formByName("MyExample3069Form");
		var popup = form.pickList(FIELD).openListPopup();
		assertThat(popup.title()).isEmpty();
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupWithoutTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Calculated title of the popup")
	@Description("The title is built from the field of the parent record: customFieldPick: ${customFieldPick}")
	void calculatedTitle() {
		var screen = PlatformApp.screen("PickListPopup widget with title");
		screen.secondLevelView("PickListPopup widget calculated title");
		var form = screen.thirdLevelView("Form")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3068/view/myexample3071form"))
				.formByName("MyExample3071Form");
		var popup = form.pickList(FIELD).openListPopup();
		assertThat(popup.title()).startsWith("customFieldPick:");
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupCalculatedTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Colored rows of the popup")
	void color() {
		var form = PlatformApp
				.screen("PickListPopup widget color title")
				.secondLevelView("Color")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3060/view/myexample3060form"))
				.formByName("MyExample3060Form");
		var popup = form.pickList("Custom Field Picklist").openListPopup();
		assertThat(popup.list().rows().element().size()).isGreaterThan(0);
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupColor.png", 1600, 1000);
		popup.close();
	}

}
