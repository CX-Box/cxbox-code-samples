package application.Samples.CardList;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.cardlist.CardListWidget;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.io.File;
import lombok.SneakyThrows;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The CardList widget: the card, the arrows of the strip and the actions. */
@DisplayName("CardList. Basic")
@Epic("Samples")
@Feature(CardListBasicTest.ARTICLE)
@Tag("Samples")
@Tag("CardList")
public class CardListBasicTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/cardlist";

	private static CardListWidget cards() {
		return PlatformApp.screen("CardList basic").view().cardListByName("MyExample5300CardList");
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
		DocShots.png(cards.element(), ARTICLE, "cardlist.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Pages of the cards")
	@Description("The widget shows 5 cards on a page, the next page shows the rest")
	void pagination() {
		var cards = cards();
		AtomicInteger pages = new AtomicInteger();
		cards.pagination().checkPageCount(pages::set);
		assertThat(pages.get()).isEqualTo(2);
		DocShots.gif(ARTICLE, "pagination.gif", 1660, 1100, DocShots.Frame.WITHOUT_SIDEBAR);
		cards.pagination().nextPage();
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Contract"));
		cards.pagination().firstPage();
		DocShots.stop();
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));
	}

	@SneakyThrows
	private static File resourceFile(String name) {
		return new File(CardListBasicTest.class.getClassLoader().getResource(name).toURI());
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
		form.fileUpload("Document").setValue(resourceFile("Hope_of_Humanity.jpg"));
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
