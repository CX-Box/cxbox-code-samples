package application.Samples.Tree;

import application.config.BaseTestForSamples;
import core.config.selenide.BrowserDevTools;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Widgets that share a business component with a Tree on one view. Widgets that load the business component as a list
 * (List and others) conflict with the tree; widgets of one record (Form, Info, AdditionalInfo) do not.
 */
@DisplayName("Tree. Widgets of the same business component")
@Epic("Samples")
@Feature(TreeCompatibleWidgetsTest.ARTICLE)
@Tag("Samples")
@Tag("Tree")
public class TreeCompatibleWidgetsTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/tree";

	private static final String CONFLICT_ERROR = "Tree widget cannot be used simultaneously";

	@Test
	@Severity(NORMAL)
	@Tag("Positive")
	@DisplayName("Info next to a Tree of the same business component: no conflict error")
	@Description("The view has a Tree and an Info of one business component; the tree loads and the console has no conflict error")
	void infoNextToTree() {
		BrowserDevTools.clearConsoleLog();
		var view = PlatformApp.screen("Tree widget show condition").secondLevelView("Show condition by parent entity");
		view.treeByName("myexample3276parent").waitLoaded();
		view.infoByName("myexample3276infotext2").checkVisible(visible -> assertThat(visible).isTrue());
		assertThat(BrowserDevTools.consoleLog()).noneMatch(message -> message.contains(CONFLICT_ERROR));
	}

}
