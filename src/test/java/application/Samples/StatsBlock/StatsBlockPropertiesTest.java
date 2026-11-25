package application.Samples.StatsBlock;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.statblock.StatsBlock;
import core.element.widget.statblock.StatsBlockWidget;
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

/** The additional properties of the StatsBlock widget. */
@DisplayName("StatsBlock. Additional properties")
@Epic("Samples")
@Feature(StatsBlockPropertiesTest.ARTICLE)
@Tag("Samples")
@Tag("StatsBlock")
public class StatsBlockPropertiesTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/statblocks";

	private static final String RELEASE = "new/v3.0.2";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Tag: a field of the record as a colored tag next to the value")
	@Description("tagFieldKey shows the field right after the value of each card, colored by bgColorKey or bgColor of the field; a card without the value of the field has no tag")
	void tag() {
		var screen = PlatformApp.screen("StatsBlock widget tag");
		StatsBlockWidget calculated = screen.secondLevelView("StatsBlock widget tag").statBlockByName("myexample4234tag");
		StatsBlock newClaims = calculated.block("New claims");
		assertThat(newClaims.count()).isEqualTo("42007");
		assertThat(newClaims.tag()).isEqualTo("+35 %");
		assertThat(calculated.block("Open portfolio").tag()).isEqualTo("-0.7 %");
		StatsBlock closedClaims = calculated.block("Closed claims");
		assertThat(closedClaims.count()).isEqualTo("1518");
		assertThat(closedClaims.tag()).isNull();
		DocShots.png(calculated.element(), ARTICLE, "tag.png", WIDTH, HEIGHT);
		DocShots.png(calculated.element(), RELEASE, "CXBOX-1467-tag.png", WIDTH, HEIGHT);

		StatsBlockWidget constant = screen.secondLevelView("StatsBlock widget tagConst").statBlockByName("myexample4234tagconst");
		assertThat(constant.block("New claims").tag()).isEqualTo("+35 %");
		assertThat(constant.block("Closed claims").tag()).isNull();
		DocShots.png(constant.element(), ARTICLE, "tag_const.png", WIDTH, HEIGHT);
	}

}
