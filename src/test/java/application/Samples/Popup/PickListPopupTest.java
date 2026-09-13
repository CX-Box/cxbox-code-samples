package application.Samples.Popup;

import application.config.BaseTestForSamples;
import application.config.props.Env;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
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

	private static PlatformView open(String screen, String view) {
		Selenide.open(Env.uri() + "screen/" + screen + "/view/" + view);
		Selenide.sleep(2500);
		return PlatformApp.currentScreen().view();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("A value is picked from the popup into the field of the list")
	@Description("The popup of the pickList field opens from the row; a click on a row of the popup picks the value and closes the popup")
	void basics() {
		var list = open("myexample3067", "myexample3079list").listByName("MyExample3079List");
		var row = list.rows().clickRow(0);
		var field = row.pickList("Custom Field Pick List");
		DocShots.gif(ARTICLE, "pickListPopupBasic.gif", 1660, 760, DocShots.Frame.WITH_SIDEBAR);
		field.setValue("Custom Field", "test data");
		field.checkValue(v -> assertThat(v).isEqualTo("test data"));
		Selenide.sleep(1000);
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Constant title of the popup")
	void constantTitle() {
		var form = open("myexample3068", "myexample3068form").formByName("MyExample3068Form");
		var popup = form.pickList(FIELD).openListPopup();
		assertThat(popup.title()).isEqualTo("Constant Title");
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupWithTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Popup without a title")
	void withoutTitle() {
		var form = open("myexample3068", "myexample3069form").formByName("MyExample3069Form");
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
		var form = open("myexample3068", "myexample3071form").formByName("MyExample3071Form");
		var popup = form.pickList(FIELD).openListPopup();
		assertThat(popup.title()).startsWith("customFieldPick:");
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupCalculatedTitle.png", 1600, 1000);
		popup.close();
	}

	@Test
	@Tag("Positive")
	@DisplayName("Colored rows of the popup")
	void color() {
		var form = open("myexample3060", "myexample3060form").formByName("MyExample3060Form");
		var popup = form.pickList("Custom Field Picklist").openListPopup();
		assertThat(popup.list().rows().element().size()).isGreaterThan(0);
		DocShots.png(popup.dialog(), ARTICLE, "pickListPopupColor.png", 1600, 1000);
		popup.close();
	}

}
