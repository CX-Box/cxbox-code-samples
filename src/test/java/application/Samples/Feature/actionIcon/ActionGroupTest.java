package application.Samples.Feature.actionIcon;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@DisplayName("Form. Checking action group with only text, only icon and mixed")
@Epic("Samples")
@Tag("Samples")
@Tag("Action")
@Tag("Icon")
public class ActionGroupTest extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Check action with text")
	@Description("Verify that all action will be displayed")
	void checkActionGroupOnlyText() {
		var app = PlatformApp.screen("Group action");
		var widget = app.view().listInline("Action with text");
		widget.actions().action("only text").action("text").click();
		widget.actions().action("only text").action("edit").click();
		widget.actions().action("only text").action("delete").click();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Check action with icon")
	@Description("Verify that all action will be displayed")
	void checkActionGroupOnlyIcon() {
		var app = PlatformApp.screen("Group action");
		var widget = app.view().listInline("Action with icon");
		widget.actions().actionWithIcon("bars").actionWithIcon("delete").click();
		widget.actions().actionWithIcon("bars").actionWithIcon("edit").click();
		widget.actions().actionWithIcon("bars").actionWithIcon("file-text").click();


	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Check action with mixed")
	@Description("Verify that all action will be displayed")
	void checkActionGroupMixed() {
		var app = PlatformApp.screen("Group action");
		var widget = app.view().listInline("Action with text and icon(mixed)");
		widget.actions().action("Actions", "bars").action("text","file-text").click();
		widget.actions().action("Actions", "bars").action("edit", "edit").click();
		widget.actions().action("Actions", "bars").action("delete", "delete").click();
	}
}