package application.Samples.FieldProperty;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.CRITICAL;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.SelenideElement;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.util.DocShots;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Field property snapshotKey: the field shows the previous (snapshot) value and the current value
 */
@DisplayName("Field property snapshotKey")
@Epic("Samples")
@Feature(SnapshotKeyTest.ARTICLE)
@Tag("Samples")
@Tag("FieldProperty")
public class SnapshotKeyTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/fields/property/snapshotkey";

	private static final String SCREEN = "Field property snapshotKey";

	private static final String PREV = "[class*='prevValue']";

	private static final String NEW = "[class*='newValue']";

	/**
	 * Field key of the sample -> folder of the article of the field type
	 */
	private static final List<List<String>> FIELDS = List.of(
			List.of("inputField", "widget/fields/field/input"),
			List.of("textField", "widget/fields/field/text"),
			List.of("hintField", "widget/fields/field/hint"),
			List.of("numberField", "widget/fields/field/number"),
			List.of("moneyField", "widget/fields/field/money"),
			List.of("percentField", "widget/fields/field/percent"),
			List.of("dateField", "widget/fields/field/date"),
			List.of("dateTimeField", "widget/fields/field/dateTime"),
			List.of("dateTimeWithSecondsField", "widget/fields/field/dateTimeWithSeconds"),
			List.of("checkboxField", "widget/fields/field/checkbox"),
			List.of("pickListField", "widget/fields/field/pickList"),
			List.of("inlinePickListField", "widget/fields/field/inlinePickList"),
			List.of("dictionaryField", "widget/fields/field/dictionary"),
			List.of("radioField", "widget/fields/field/radio")
	);

	private static SelenideElement widget(String name) {
		return $("div[data-test='WIDGET'][data-test-widget-name='" + name + "']").shouldBe(visible);
	}

	private static SelenideElement field(SelenideElement scope, String key) {
		return scope.$("[data-test='FIELD'][data-test-field-key='" + key + "']").shouldBe(visible);
	}

	private static SelenideElement row(String scenario) {
		return widget("myexample5900list").$$("tr").findBy(text(scenario)).shouldBe(visible);
	}

	private static void selectScenario(String scenario) {
		widget("myexample5900scenarios").$$("[data-test-field-key='scenario']").findBy(text(scenario)).click();
	}

	private static PlatformView view(String name) {
		return PlatformApp.screen(SCREEN).secondLevelView(name);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("List: previous and current values by scenario")
	@Description("Changed - both values, not changed - usual field, empty snapshot - only current, empty current - only previous; false and 0 are treated as empty")
	void list() {
		view("List");
		DocShots.png(widget("myexample5900list"), ARTICLE, "list.png", 1900, 1000);

		var changed = row("1. Value changed");
		for (var fieldKey : FIELDS) {
			if (fieldKey.get(0).equals("textField")) {
				continue;
			}
			var cell = field(changed, fieldKey.get(0));
			cell.$(PREV).should(exist);
			cell.$(NEW).should(exist);
		}
		field(changed, "inputField").$(PREV).shouldHave(exactText("Old value"));
		field(changed, "inputField").$(NEW).shouldHave(exactText("New value"));
		// text: the difference word by word inside one text
		field(changed, "textField").$("[class*='removedWord']").shouldHave(text("brown"));
		field(changed, "textField").$("[class*='addedWord']").shouldHave(text("red"));

		var notChanged = row("2. Value not changed");
		field(notChanged, "inputField").shouldHave(text("Same value"));
		field(notChanged, "inputField").$(PREV).shouldNot(exist);
		field(notChanged, "inputField").$(NEW).shouldNot(exist);

		var added = row("3. Value added");
		field(added, "inputField").$(PREV).shouldNot(exist);
		field(added, "inputField").$(NEW).shouldHave(exactText("New value"));

		var deleted = row("4. Value deleted");
		field(deleted, "inputField").$(PREV).shouldHave(exactText("Old value"));
		field(deleted, "inputField").$(NEW).shouldNot(exist);

		// false and 0 of the snapshot are not shown
		var falseZero = row("5. Values false and 0");
		field(falseZero, "checkboxField").$(PREV).shouldNot(exist);
		field(falseZero, "checkboxField").$(NEW).should(exist);
		field(falseZero, "numberField").$(PREV).shouldNot(exist);
		field(falseZero, "numberField").$(NEW).should(exist);
		// the current value 0 is not shown either
		field(falseZero, "percentField").$(PREV).should(exist);
		field(falseZero, "percentField").$(NEW).shouldNot(exist);

		var checkboxToFalse = row("6. Checkbox: true -> false");
		field(checkboxToFalse, "checkboxField").$(PREV).should(exist);
		field(checkboxToFalse, "checkboxField").$(NEW).shouldNot(exist);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Info: previous and current values by scenario")
	@Description("The Info widget shows the same as the List widget for every scenario")
	void info() {
		view("Info");
		selectScenario("1. Value changed");
		var info = widget("myexample5900info");
		field(info, "inputField").$(PREV).shouldHave(exactText("Old value"));
		DocShots.png(info, ARTICLE, "info.png", 1660, 1100);
		DocShots.png(info, ARTICLE, "changed.png", 1660, 1100);

		selectScenario("2. Value not changed");
		field(info, "inputField").$(PREV).shouldNot(exist);
		field(info, "inputField").shouldHave(text("Same value"));
		DocShots.png(info, ARTICLE, "notchanged.png", 1660, 1100);

		selectScenario("3. Value added");
		field(info, "inputField").$(PREV).shouldNot(exist);
		field(info, "inputField").$(NEW).shouldHave(exactText("New value"));
		DocShots.png(info, ARTICLE, "added.png", 1660, 1100);

		selectScenario("4. Value deleted");
		field(info, "inputField").$(PREV).shouldHave(exactText("Old value"));
		field(info, "inputField").$(NEW).shouldNot(exist);
		DocShots.png(info, ARTICLE, "deleted.png", 1660, 1100);

		selectScenario("5. Values false and 0");
		field(info, "checkboxField").$(PREV).shouldNot(exist);
		DocShots.png(info, ARTICLE, "falsezero.png", 1660, 1100);
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Form: the field with snapshotKey is read-only and is updated after save")
	@Description("The field with snapshotKey has no input even if it is enabled; a value that is not saved is not shown, after save the difference is updated")
	void form() {
		var view = view("Form");
		selectScenario("1. Value changed");
		var snapshotForm = widget("myexample5900form");
		var editForm = widget("myexample5900edit");

		// the same enabled field: input without snapshotKey, read-only with snapshotKey
		field(editForm, "inputField").$("input").should(exist);
		field(snapshotForm, "inputField").$("input").shouldNot(exist);
		DocShots.png($("main"), ARTICLE, "form.png", 1900, 1300);
		DocShots.png(field(snapshotForm, "textField"), ARTICLE, "text.png", 1660, 1100);
		for (var fieldKey : FIELDS) {
			DocShots.png(field(snapshotForm, fieldKey.get(0)), fieldKey.get(1), "snapshotKey.png", 1660, 1100);
		}

		var edit = view.form("Form without snapshotKey (edit current values)");
		var input = edit.input("Input");
		// the value that is not saved yet is not shown in the field with snapshotKey
		input.setValue("Changed value");
		field(snapshotForm, "inputField").$(NEW).shouldHave(exactText("New value"));
		edit.actions().action("Save").click();
		field(snapshotForm, "inputField").$(NEW).shouldHave(exactText("Changed value"));
		field(snapshotForm, "inputField").$(PREV).shouldHave(exactText("Old value"));

		// the current value equals the snapshot: the usual field
		input.setValue("Old value");
		edit.actions().action("Save").click();
		field(snapshotForm, "inputField").$(PREV).shouldNot(exist);
		field(snapshotForm, "inputField").shouldHave(text("Old value"));

		input.setValue("New value");
		edit.actions().action("Save").click();
		field(snapshotForm, "inputField").$(NEW).shouldHave(exactText("New value"));
	}

}
