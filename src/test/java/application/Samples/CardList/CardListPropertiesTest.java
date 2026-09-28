package application.Samples.CardList;

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

/** The CardList widget: title, status, drilldown and the read widget. */
@DisplayName("CardList. Properties")
@Epic("Samples")
@Feature(CardListPropertiesTest.ARTICLE)
@Tag("Samples")
@Tag("CardList")
public class CardListPropertiesTest extends BaseTestForSamples {

	static final String ARTICLE = CardListBasicTest.ARTICLE;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Constant title and empty title")
	@Description("The widget shows the constant title; without title the widget has no heading")
	void title() {
		var screen = PlatformApp.screen("CardList title");
		var constant = screen.secondLevelView("Constant title").cardList("Constant Title");
		constant.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
		DocShots.png(constant.element(), ARTICLE, "consttitle.png", 1660, 1100);

		var empty = screen.secondLevelView("Empty title").cardListByName("MyExample5301EmptyTitle");
		empty.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
		DocShots.png(empty.element(), ARTICLE, "emptytitle.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Title color")
	@Description("The title shows the field of the selected card with the calculated color")
	void titleColor() {
		var cards = PlatformApp.screen("CardList color title").secondLevelView("Calculated color")
				.cardListByName("MyExample5302CardList");
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
		DocShots.png(cards.element(), ARTICLE, "colorwidget.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Status of the card")
	@Description("The first dictionary field is shown in the middle of the card")
	void status() {
		var cards = PlatformApp.screen("CardList status").view()
				.cardListByName("MyExample5305CardList");
		cards.rows().row(0).checkStatus(status -> assertThat(status).isEqualTo("Rejected"));
		cards.rows().row(1).checkStatus(status -> assertThat(status).isEqualTo("Approved"));
		cards.rows().row(2).checkStatus(status -> assertThat(status).isEqualTo("New"));
		DocShots.png(cards.element(), ARTICLE, "status.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("DrillDown from the title of the card")
	@Description("A click on the title with the link opens the form of the record of the card")
	void drilldown() {
		var cards = PlatformApp.screen("CardList drilldown").view()
				.cardListByName("MyExample5306CardList");
		DocShots.gif(ARTICLE, "drilldown.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		cards.rows().row(2).drilldown(url -> assertThat(url).contains("/view/myexample5306form/"));
		PlatformApp.currentScreen().view().formByName("MyExample5306DrillDownForm")
				.input("Custom Field").checkValue(value -> assertThat(value).isEqualTo("Price list"));
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Read widget")
	@Description("The read widget above the strip shows the file of the selected card")
	void read() {
		var cards = PlatformApp.screen("CardList read").view()
				.cardListByName("MyExample5307CardList");
		DocShots.gif(ARTICLE, "read.gif", 1900, 1250, DocShots.Frame.WITHOUT_SIDEBAR);
		cards.rows().row(2).click();
		cards.rows().row(2).checkTitle(title -> assertThat(title).isEqualTo("Price list"));
		cards.rows().row(3).click();
		cards.rows().row(3).checkTitle(title -> assertThat(title).isEqualTo("Invoice"));
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The eye opens the file")
	@Description("Without options.edit the card has the eye, it opens the file in a popup")
	void view() {
		var cards = PlatformApp.screen("CardList read").view().cardListByName("MyExample5307CardList");
		DocShots.gif(ARTICLE, "view.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		var viewer = cards.rows().row(0).clickEye();
		assertThat(viewer.getTitle()).isEqualTo("Certificate.png");
		viewer.closePopup();
		DocShots.stop();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Main visual parts of the card")
	@Description("The card shows the preview, the status, the title, the description and the actions")
	void parts() {
		var cards = PlatformApp.screen("CardList status").view().cardListByName("MyExample5305CardList");
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
		DocShots.png(cards.element(), ARTICLE, "parts.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Full text search")
	@Description("The search box of the widget leaves the cards with the text in the title")
	void fullTextSearch() {
		var cards = PlatformApp.screen("CardList full text search").view().cardListByName("MyExample5308CardList");
		DocShots.gif(ARTICLE, "fulltextsearch.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		cards.fullTextSearch("Invoice");
		assertThat(cards.rows().streamCurrentPage()).hasSize(1);
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Invoice"));
		DocShots.stop();
		cards.fullTextSearch("");
		assertThat(cards.rows().streamCurrentPage()).hasSize(5);
	}

}
