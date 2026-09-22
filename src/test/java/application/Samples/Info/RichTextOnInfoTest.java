package application.Samples.Info;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

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

@DisplayName("Info. Checking the basic functions for the RichText in the widget Info")
@Epic("Samples")
@Feature(RichTextOnInfoTest.ARTICLE)
@Tag("Samples")
@Tag("Info")
public class RichTextOnInfoTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/field/richtext";

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("The test for getting the value from the field")
	@Description("The field opens the stored markdown and shows it formatted.")
	void read() {
		var info = PlatformApp.screen("RichText basic")
				.secondLevelView("Info")
				.info("Info title");
		info.richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Rich text").contains("A **bold** word"));
		DocShots.png(info.element(), ARTICLE, "img_info.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("A test to check the field for \"Read-only\"")
	@Description("The field on Info cannot be edited.")
	void readonly() {
		var info = PlatformApp.screen("RichText readonly")
				.secondLevelView("Info")
				.info("Info title");
		info.richText("Custom Field")
				.checkReadOnly(ro -> assertThat(ro).isTrue());
		DocShots.png(info.element(), ARTICLE, "img_ro_info.png", 1200, 800);
	}

	@Test
	@Tag("Positive")
	@DisplayName("The height of the field")
	@Description("Two Info widgets of the same record: with the default height and with minRows 2, maxRows 4, where the value is cut and shows \"...\".")
	void height() {
		var view = PlatformApp.screen("RichText height")
				.secondLevelView("Info");
		var byDefault = view.info("Default: minRows 1, maxRows 10");
		byDefault.richText("Custom Field")
				.checkValue(value -> assertThat(value).startsWith("# Meeting notes"));
		DocShots.png(byDefault.element(), ARTICLE, "img_height_info_default.png", 1200, 800);
		var widget = view.info("minRows 2, maxRows 4");
		widget.richText("Custom Field")
				.checkTruncated(truncated -> assertThat(truncated).isTrue());
		DocShots.png(widget.element(), ARTICLE, "img_height_info.png", 1200, 800);
	}

}
