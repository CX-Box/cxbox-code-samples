package application.Samples.CardCarouselList;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.cardlist.CardCarouselListWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The CardCarouselList widget: the card, the arrows of the strip and the actions. */
@DisplayName("CardCarouselList. Basic")
@Epic("Samples")
@Feature(CardCarouselListBasicTest.ARTICLE)
@Tag("Samples")
@Tag("CardCarouselList")
public class CardCarouselListBasicTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/cardcarousellist";

	private static CardCarouselListWidget cards() {
		return PlatformApp.screen("CardCarouselList basic").view().cardCarouselListByName("MyExample5060CardCarouselList");
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The card shows the title and the description")
	@Description("titleFieldKey and descriptionFieldKey of options.card are shown under the preview")
	void cardParts() {
		var cards = cards();
		cards.rows().row(0)
				.checkTitle(title -> assertThat(title).isEqualTo("Certificate"))
				.checkDescription(description -> assertThat(description).isEqualTo("Issued to the Main office"));
		DocShots.png(cards.element(), ARTICLE, "cardcarousellist.png", 1660, 760);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Arrows scroll the strip")
	@Description("The right arrow shows the next cards, the left arrow returns to the first ones")
	void arrows() {
		var pagination = cards().pagination();
		AtomicInteger pages = new AtomicInteger();
		pagination.checkPageCount(pages::set);
		assertThat(pages.get()).isGreaterThan(1);
		assertThat(pagination.isLastPage()).isFalse();

		pagination.pages(pages.get() - 1);
		assertThat(pagination.isLastPage()).isTrue();

		pagination.previousPage();
		assertThat(pagination.isLastPage()).isFalse();
		pagination.firstPage();
		cards().rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Edit in the form of the card")
	@Description("The pencil opens the file popup with the form under the file, Save changes the description of the card")
	void edit() {
		var cards = cards();
		DocShots.gif(ARTICLE, "edit.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		var form = cards.rows().row(0).clickPencil();
		form.input("Custom Field Description").setValue("Issued to the Branch office");
		form.actions().action("Save").click();
		cards.rows().row(0).checkDescription(description -> assertThat(description).isEqualTo("Issued to the Branch office"));
		DocShots.stop();

		form = cards.rows().row(0).clickPencil();
		form.input("Custom Field Description").setValue("Issued to the Main office");
		form.actions().action("Save").click();
		cards.rows().row(0).checkDescription(description -> assertThat(description).isEqualTo("Issued to the Main office"));
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Create and delete a card")
	@Description("Add opens the file popup with the form, Save adds the card, Delete of the card removes it")
	void createAndDelete() {
		var cards = cards();
		DocShots.gif(ARTICLE, "create.gif", 1200, 900, DocShots.Frame.WITH_SIDEBAR);
		cards.actions().click("Add");
		var form = cards.rows().row(0).clickPencil();
		form.input("Custom Field").setValue("New document");
		form.actions().action("Save").click();
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("New document"));
		DocShots.stop();

		DocShots.gif(ARTICLE, "delete.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		cards.rows().row(0).burgerAction("Delete").click();
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
		DocShots.stop();
	}

}
