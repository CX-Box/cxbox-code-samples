package core.element.widget.list;

import static core.element.PlatformApp.config;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * A mass operation of a list ({@code options.massOp}) step by step: the rows are ticked by the values of a column, as in
 * the AssocListPopup, the next step, the form of the step Confirm operation, the results.
 *
 * <h5>Usage Example</h5>
 * <pre>{@code
 * var mass = list.massOperation("Mass Edit");
 * mass.setValues("customField", List.of("test data 6", "test data 7"));
 * mass.next();
 * mass.next();
 * mass.confirm(form -> form.dictionary("Custom Field Dictionary").setValue("High"));
 * mass.checkResults("customField", results -> assertThat(results).containsEntry("test data 6", true));
 * mass.close();
 * }</pre>
 */
public class MassOperation<W extends ListWidget<W, ?, ?>> {

	private final W list;

	MassOperation(W list) {
		this.list = list;
	}

	/**
	 * Ticks the rows whose column shows one of the values; the values are looked for page by page. A value that no row
	 * shows fails the step.
	 */
	public MassOperation<W> setValues(String column, List<String> values) {
		return Allure.step(message("mass.select", column, String.join(", ", values)), step -> {
			var missing = new ArrayList<>(values);
			while (true) {
				// a row is taken by its index: the table is drawn again after each tick
				var rows = list.rows().element();
				for (int i = 0; i < rows.size(); i++) {
					var row = rows.get(i);
					var value = cell(row, column);
					if (missing.remove(value)) {
						StepReport.service(message("modal.check", value), () -> {
							if (!row.$(config().selectors.massOperationRowCheckbox).isSelected()) {
								row.$(config().selectors.massOperationRowCheckbox).click();
							}
							row.$(config().selectors.massOperationRowCheckbox).shouldBe(Condition.selected, list.getExpectations().getTimeout());
							return null;
						});
					}
				}
				if (missing.isEmpty() || list.pagination().isLastPage()) {
					break;
				}
				list.pagination().nextPage();
			}
			if (!missing.isEmpty()) {
				throw new AssertionError(message("mass.notFound", column, String.join(", ", missing)));
			}
			return this;
		});
	}

	/** Goes to the next step by its button: from Select rows to Review rows, from Review rows to Confirm operation */
	public MassOperation<W> next() {
		return Allure.step(message("mass.next"), step -> {
			var done = doneSteps();
			button("Next").click();
			Selenide.Wait().withTimeout(list.getExpectations().getOverTimeout()).withMessage(message("mass.stepNotChanged", done + 1))
					.until(driver -> doneSteps() > done);
			return this;
		});
	}

	/**
	 * Fills the form of the step Confirm operation and confirms it by its first button, whatever its text: the operation
	 * runs, the step View results shows its rows
	 */
	public MassOperation<W> confirm(Consumer<MassOperationForm> fill) {
		return Allure.step(message("mass.confirm"), step -> {
			var done = doneSteps();
			fill.accept(new MassOperationForm(list));
			list.element().$$(config().selectors.massOperationConfirm).first()
					.shouldBe(Condition.interactable, list.getExpectations().getTimeout())
					.click();
			Selenide.Wait().withTimeout(list.getExpectations().getOverTimeout()).withMessage(message("mass.stepNotChanged", done + 1))
					.until(driver -> doneSteps() > done);
			// the list is looked up once more: the look up waits until the rows of the results are loaded
			list.element();
			return this;
		});
	}

	/** The list in the step View results: its rows are the rows of the operation */
	public W results() {
		return list;
	}

	/** Passes the results of the rows of the page to the check: the value of the column and whether the row is done */
	public MassOperation<W> checkResults(String column, Consumer<Map<String, Boolean>> check) {
		var results = Allure.step(message("mass.results", column), step -> {
			var done = new LinkedHashMap<String, Boolean>();
			var rows = list.rows().element();
			for (int i = 0; i < rows.size(); i++) {
				var row = rows.get(i);
				if (row.$(config().selectors.massOperationRowDone).exists()) {
					done.put(cell(row, column), true);
				} else if (row.$(config().selectors.massOperationRowFailed).exists()) {
					done.put(cell(row, column), false);
				}
			}
			StepReport.value(done.toString());
			return done;
		});
		check.accept(results);
		return this;
	}

	/** Closes the results: the list shows its records without the steps */
	public W close() {
		return Allure.step(message("mass.close"), step -> {
			button("Close").click();
			list.element().$(config().selectors.massOperationStep).shouldNot(Condition.exist, list.getExpectations().getOverTimeout());
			return list;
		});
	}

	private SelenideElement button(String text) {
		return list.element().$$("button").findBy(Condition.exactText(config().selectors.massOperationButton.apply(text)))
				.shouldBe(Condition.interactable, list.getExpectations().getTimeout());
	}

	private int doneSteps() {
		return list.element().$$(config().selectors.massOperationDoneStep).size();
	}

	private String cell(SelenideElement row, String column) {
		return row.$(config().selectors.listFieldTag + "[data-test-field-title=\"" + column + "\"]").getText();
	}

}
