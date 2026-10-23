package application.Samples.CardCarouselList;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

/** The CardCarouselList widget with a show condition by the parent entity. */
@DisplayName("CardCarouselList. Show condition")
@Epic("Samples")
@Feature(CardCarouselListShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("CardCarouselList")
public class CardCarouselListShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = CardCarouselListBasicTest.ARTICLE;

	private static final BigDecimal CONDITION_MET = BigDecimal.valueOf(8);

	private static final BigDecimal CONDITION_NOT_MET = BigDecimal.valueOf(3);

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by parent entity")
	@Description("The cards are shown while Custom Field Number of the parent form is greater than 5; the condition is recalculated on save")
	void showConditionByParentEntity() {
		var view = PlatformApp.screen("CardCarouselList show condition").view();
		var parent = view.formByName("MyExample5063Parent");
		var cards = view.cardCarouselListByName("MyExample5064CardCarouselList");
		var customFieldNumber = parent.number("Custom Field Number");
		BigDecimal initialValue = customFieldNumber.getValue();

		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		cards.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond.gif", 1660, 760, DocShots.Frame.WITHOUT_SIDEBAR);
		customFieldNumber.setValue(CONDITION_NOT_MET);
		parent.actions().action("Save").click();
		cards.checkVisible(visible -> assertThat(visible).isFalse());
		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		cards.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
		cards.rows().row(0).checkTitle(title -> assertThat(title).isEqualTo("Certificate"));

		customFieldNumber.setValue(initialValue);
		parent.actions().action("Save").click();
	}

}
