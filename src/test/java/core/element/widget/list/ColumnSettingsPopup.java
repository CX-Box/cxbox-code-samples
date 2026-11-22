package core.element.widget.list;

import static com.codeborne.selenide.Selenide.$$;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.action.PageRequests;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import lombok.NonNull;

/**
 * The window of the columns of a table, the item "Change" of the gear menu: {@code list.settings().changeColumns()}.
 * It works as a multipleSelect field: the value is the columns of the table (the list "Main"), the other columns are the
 * list "Additional". A change is saved for the user: the item "Reset" of the gear menu returns the columns of the widget.
 */
public class ColumnSettingsPopup<W extends AbstractWidget<ExpectationPattern, W>> {

	private static final String MODAL = "div.ant-modal:has(.ant-transfer)";

	private static final String COLUMN = "li.ant-transfer-list-content-item";

	/** A column that cannot leave the table, e.g. the column of the grouping of a GroupingHierarchy */
	private static final String DISABLED = "ant-transfer-list-content-item-disabled";

	private final W widget;

	private final ExpectationPattern expectations;

	public ColumnSettingsPopup(W widget, ExpectationPattern expectations) {
		this.widget = widget;
		this.expectations = expectations;
	}

	/** The columns of the table in their order */
	public Set<String> getValue() {
		return Allure.step(message("columns.value"), () -> {
			var columns = main().texts();
			StepReport.list(columns, "columns");
			return new LinkedHashSet<>(columns);
		});
	}

	/** Leaves in the table exactly these columns; a grey column stays in the table */
	public ColumnSettingsPopup<W> setValue(Set<String> value) {
		Allure.step(message("columns.set"), step -> {
			StepReport.value(value);
			move(main(), main().texts().stream().filter(column -> !value.contains(column)).toList(), "right");
			toTable(value);
		});
		return this;
	}

	/** Returns these columns from "Additional" to the table */
	public ColumnSettingsPopup<W> addValue(@NonNull Set<String> values) {
		Allure.step(message("columns.add"), step -> {
			StepReport.value(values);
			toTable(values);
		});
		return this;
	}

	/** Moves all columns to "Additional"; a grey column stays in the table */
	public ColumnSettingsPopup<W> clear() {
		Allure.step(message("columns.clear"), step -> {
			move(main(), main().texts(), "right");
		});
		return this;
	}

	/** All columns of the window: the columns of the table and of "Additional" */
	public ColumnSettingsPopup<W> checkOptions(Consumer<Set<String>> options) {
		Allure.step(message("columns.options"), step -> {
			var columns = new LinkedHashSet<>(main().texts());
			columns.addAll(additional().texts());
			options.accept(columns);
		});
		return this;
	}

	/** Whether the column is in the table */
	public ColumnSettingsPopup<W> checkStatusOption(String name, Consumer<Boolean> isSelected) {
		Allure.step(message("columns.status", name), step -> {
			isSelected.accept(inTable(name));
		});
		return this;
	}

	/** Whether the columns are in the table */
	public ColumnSettingsPopup<W> checkStatusOptions(Map<String, Consumer<Boolean>> options) {
		Allure.step(message("columns.statuses"), step -> {
			options.forEach((name, isSelected) -> isSelected.accept(inTable(name)));
		});
		return this;
	}

	/** Closes the window by its cross */
	public W close() {
		Allure.step(message("columns.close"), step -> {
			element().$("button.ant-modal-close").shouldBe(Condition.visible, expectations.getTimeout()).click();
			$$(MODAL).filterBy(Condition.visible).shouldHave(CollectionCondition.size(0), expectations.getTimeout());
		});
		return widget;
	}

	/** The visible window: closed modal windows stay hidden in the page */
	private SelenideElement element() {
		return $$(MODAL).findBy(Condition.visible).shouldBe(Condition.visible, expectations.getTimeout());
	}

	private ElementsCollection main() {
		return element().$$(".ant-transfer-list").get(0).$$(COLUMN);
	}

	private ElementsCollection additional() {
		return element().$$(".ant-transfer-list").get(1).$$(COLUMN);
	}

	private void toTable(Collection<String> columns) {
		var shown = main().texts();
		move(additional(), columns.stream().filter(column -> !shown.contains(column)).toList(), "left");
	}

	private boolean inTable(String name) {
		// a column that the window does not have is an error of the test, not a column out of the table
		element().$$(COLUMN).findBy(Condition.exactText(name)).shouldBe(Condition.visible, expectations.getTimeout());
		return main().texts().contains(name);
	}

	/** Ticks the columns in the list and moves them to the other list by the arrow, as the user does */
	private void move(ElementsCollection list, Collection<String> columns, String arrow) {
		var movable = columns.stream()
				.map(column -> list.findBy(Condition.exactText(column)).shouldBe(Condition.visible, expectations.getTimeout()))
				.filter(column -> !column.has(Condition.cssClass(DISABLED)))
				.toList();
		if (movable.isEmpty()) {
			return;
		}
		var names = movable.stream().map(SelenideElement::getText).toList();
		movable.forEach(SelenideElement::click);
		PageRequests.track();
		element().$("button:has(i[aria-label='icon: " + arrow + "'])").shouldBe(Condition.enabled, expectations.getTimeout()).click();
		// the table changes at once, the columns of the user are saved by a request
		PageRequests.waitDone(expectations.getOverTimeout());
		Selenide.Wait().withTimeout(expectations.getTimeout()).until(driver -> list.texts().stream().noneMatch(names::contains));
	}

}
