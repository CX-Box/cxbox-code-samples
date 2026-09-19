package application.Samples.List;

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

/** The List widget with a show condition by the current entity and by the parent entity. */
@DisplayName("List. Show condition")
@Epic("Samples")
@Feature(ListShowConditionTest.ARTICLE)
@Tag("Samples")
@Tag("List")
public class ListShowConditionTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/list";

	private static final BigDecimal CONDITION_MET = BigDecimal.valueOf(8);

	private static final BigDecimal CONDITION_NOT_MET = BigDecimal.valueOf(3);

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by current entity")
	@Description("The list is shown while Custom Field of the current record is greater than 5; the condition is recalculated on save")
	void showConditionByCurrentEntity() {
		var view = PlatformApp.screen("List widget show condition")
				.secondLevelView("Show condition by current entity")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3101"));
		var form = view.formByName("MyExample3101");
		var list = view.listByName("MyExample31012");
		var customField = form.number("Custom Field");
		BigDecimal initialValue = customField.getValue();

		// the picture of the article starts with the list shown
		customField.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		list.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond_current.gif", 1280, 1000, DocShots.Frame.WITHOUT_SIDEBAR);
		customField.setValue(CONDITION_NOT_MET);
		form.actions().action("Save").click();
		list.checkVisible(visible -> assertThat(visible).isFalse());
		customField.setValue(CONDITION_MET);
		form.actions().action("Save").click();
		list.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();

		customField.setValue(initialValue);
		form.actions().action("Save").click();
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Show condition by parent entity")
	@Description("The child list is shown while Custom Field Number of the parent form is greater than 5; the condition is recalculated on save")
	void showConditionByParentEntity() {
		var view = PlatformApp.screen("List widget show condition")
				.secondLevelView("Show condition by parent entity")
				.checkUrl(url -> assertThat(url).contains("#/screen/myexample3101/view/myexample3106showcond"));
		var parent = view.formByName("MyExample3100parent");
		var child = view.listByName("MyExample3106child");
		var customFieldNumber = parent.number("Custom Field Number");
		BigDecimal initialValue = customFieldNumber.getValue();

		// the picture of the article starts with the child list shown
		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		child.checkVisible(visible -> assertThat(visible).isTrue());

		DocShots.gif(ARTICLE, "show_cond.gif", 1280, 1100, DocShots.Frame.WITHOUT_SIDEBAR);
		customFieldNumber.setValue(CONDITION_NOT_MET);
		parent.actions().action("Save").click();
		child.checkVisible(visible -> assertThat(visible).isFalse());
		customFieldNumber.setValue(CONDITION_MET);
		parent.actions().action("Save").click();
		child.checkVisible(visible -> assertThat(visible).isTrue());
		DocShots.stop();
		assertThat(child.rows().streamCurrentPage().map(row -> row.input("Custom Field, bc - myExampleBc3106").getValue()))
				.containsExactlyInAnyOrder("Test data", "Test data2");

		customFieldNumber.setValue(initialValue);
		parent.actions().action("Save").click();
	}

}
