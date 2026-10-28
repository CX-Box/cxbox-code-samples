package core.element.widget.list;

import static com.codeborne.selenide.Selenide.$$;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The mass-operation mode of a List or a GroupingHierarchy widget ({@code ActionScope.MASS}): the steps on the left,
 * the buttons of the step above the table. The mode is started by the button of the mass action
 * ({@code widget.actions().click("Mass Edit")}).
 * <p>
 * A row is found by the text of a field ({@code customField} by default), as the user sees it.
 */
public class MassOperation<W extends AbstractWidget<ExpectationPattern, W>> {

	/** The result of a row on the step "View results": the icon of the result column. */
	public enum Result {
		SUCCESS("check-circle"),
		FAIL("close-square"),
		NOT_PROCESSED("minus-circle");

		private final String icon;

		Result(String icon) {
			this.icon = icon;
		}

		static Result byIcon(String ariaLabel) {
			return Arrays.stream(values()).filter(r -> ("icon: " + r.icon).equals(ariaLabel)).findFirst().orElse(null);
		}
	}

	private static final String ROWS = "tbody tr[data-test-widget-list-row-type='Row']";

	private final W widget;

	private final String rowKey;

	public MassOperation(W widget) {
		this(widget, "customField");
	}

	/**
	 * @param rowKey key of the field whose text identifies a row
	 */
	public MassOperation(W widget, String rowKey) {
		this.widget = widget;
		this.rowKey = rowKey;
	}

	/** The title of the active step, e.g. "Select rows". */
	public String step() {
		return activeStep().shouldBe(Condition.visible, widget.getExpectations().getTimeout()).getText();
	}

	/** Checks the checkboxes of the rows with these texts on the step "Select rows". */
	public MassOperation<W> select(String... rows) {
		Allure.step(message("mass.select", String.join(", ", rows), widget.label()), step -> {
			for (String text : rows) {
				row(text).$("input[data-test-widget-list-column-select]").closest("label")
						.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
						.click();
			}
		});
		return this;
	}

	/** Checks the checkboxes of the first rows of the table that can be checked. */
	public MassOperation<W> selectFirst(int count) {
		Allure.step(message("mass.select", count, widget.label()), step -> {
			widget.element().$$(ROWS + " input[data-test-widget-list-column-select]:not([disabled])")
					.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(count), widget.getExpectations().getTimeout())
					.asFixedIterable().stream().limit(count)
					.forEach(checkbox -> checkbox.closest("label").click());
		});
		return this;
	}

	/** The buttons of the current step above the table. */
	public List<String> buttons() {
		return widget.element().$$("header.ant-layout-header button").filter(Condition.visible).texts();
	}

	/** Whether the checkbox of the row can be checked: a group row without its own record has a disabled one. */
	public boolean selectable(String rowText) {
		return row(rowText).$("input[data-test-widget-list-column-select]").is(Condition.enabled);
	}

	/** The chips of the selected rows above the table on the step "Select rows". */
	public List<String> chips() {
		return widget.element().$$("header .ant-tag").texts();
	}

	/** The texts of the rows of the table (the field {@code rowKey}). */
	public List<String> rows() {
		return rowsElements().texts();
	}

	/** Clicks the button of the step ("Next", "Back", "Apply", "Cancel", "Close", "Export") and waits for the step it opens. */
	public MassOperation<W> click(String button) {
		Allure.step(message("mass.click", button, widget.label()), step -> {
			widget.element().$$("header.ant-layout-header button").findBy(Condition.exactText(button))
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.click();
			waitLoaded();
		});
		return this;
	}

	/** The confirmation form of the step "Confirm operation": chooses the value of a dictionary field. */
	public MassOperation<W> confirmDictionary(String key, String value) {
		Allure.step(message("mass.confirmField", key, value), step -> {
			confirm().$("[data-test-field-key='" + key + "'] .ant-select-selection")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.click();
			$$(".ant-select-dropdown:not(.ant-select-dropdown-hidden) li.ant-select-dropdown-menu-item")
					.findBy(Condition.exactText(value))
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.click();
		});
		return this;
	}

	/**
	 * The step "Certificate selection" of the mass signing and encrypting: waits for the certificates of the CryptoPro
	 * plugin and chooses the certificate with this text in every certificate field (for signing, for encryption).
	 */
	public MassOperation<W> certificate(String certificate, Duration timeout) {
		Allure.step(message("mass.certificate", certificate, widget.label()), step -> {
			var fields = widget.element().$$("[class*='CryptoGeneratorContent'] .ant-select-selection")
					.shouldHave(CollectionCondition.sizeGreaterThan(0), timeout);
			for (SelenideElement field : fields.asFixedIterable()) {
				field.click();
				$$(".ant-select-dropdown:not(.ant-select-dropdown-hidden) li.ant-select-dropdown-menu-item")
						.findBy(Condition.text(certificate))
						.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
						.click();
			}
		});
		return this;
	}

	/** Waits for the step, e.g. "View results" after the files are processed by the CryptoPro plugin. */
	public MassOperation<W> waitStep(String title, Duration timeout) {
		activeStep().shouldHave(Condition.exactText(title), timeout);
		return this;
	}

	/** The confirmation form of the step "Confirm operation": checks or unchecks a checkbox field. */
	public MassOperation<W> confirmCheckbox(String key, boolean value) {
		Allure.step(message("mass.confirmField", key, value), step -> {
			var checkbox = confirm().$("[data-test-field-key='" + key + "'] label.ant-checkbox-wrapper")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout());
			if (checkbox.has(Condition.cssClass("ant-checkbox-wrapper-checked")) != value) {
				checkbox.click();
			}
		});
		return this;
	}

	/** The title of the confirmation on the step "Confirm operation". */
	public String confirmTitle() {
		return confirm().$("h2").getText();
	}

	/** Clicks a button of the confirmation ("Save", "Cancel" or the custom texts) and waits for the step it opens. */
	public MassOperation<W> confirmClick(String button) {
		Allure.step(message("mass.click", button, widget.label()), step -> {
			confirm().$$("button").findBy(Condition.exactText(button))
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.click();
			waitLoaded();
		});
		return this;
	}

	/** The results of the rows on the step "View results", by the text of the row. */
	public Map<String, Result> results() {
		return Allure.step(message("mass.results", widget.label()), step -> {
			activeStep().shouldHave(Condition.exactText("View results"), widget.getExpectations().getTimeout());
			Map<String, Result> results = new LinkedHashMap<>();
			for (SelenideElement row : widget.element().$$(ROWS).asFixedIterable()) {
				var icon = row.$("td i[aria-label^='icon: ']").getAttribute("aria-label");
				results.put(row.$("[data-test-field-key='" + rowKey + "']").getText(), Result.byIcon(icon));
			}
			StepReport.value(results);
			return results;
		});
	}

	/** The counter of the step "View results": "Processed: 2 (1 Success, 1 Fail)". */
	public String processed() {
		return widget.element().$$("*").findBy(Condition.matchText("^Processed: \\d+ \\(.*\\)$"))
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout()).getText();
	}

	/** Whether the widget is in the mass-operation mode (the steps are shown). */
	public boolean isActive() {
		return activeStep().exists();
	}

	public W widget() {
		return widget;
	}

	private SelenideElement row(String text) {
		return rowsElements().findBy(Condition.exactText(text)).closest("tr")
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout());
	}

	private ElementsCollection rowsElements() {
		return widget.element().$$(ROWS + " [data-test-field-key='" + rowKey + "']");
	}

	private SelenideElement activeStep() {
		return widget.element().$(".ant-steps-item-active .ant-steps-item-title");
	}

	private SelenideElement confirm() {
		return widget.element().$("main.ant-layout-content");
	}

	private void waitLoaded() {
		widget.element().$$(".ant-spin-spinning").shouldHave(CollectionCondition.size(0), widget.getExpectations().getOverTimeout());
		widget.element().$("[data-test-loading='true']").shouldNot(Condition.exist, widget.getExpectations().getOverTimeout());
	}

}
