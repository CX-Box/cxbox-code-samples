package core.element.widget.list.filter.header.filtration;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import io.qameta.allure.Allure;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.filtration.filter.AbstractFilter;
import core.element.widget.list.filter.header.filtration.filter.DictionaryFilter;
import core.element.widget.list.filter.header.filtration.filter.MultipleSelectFilter;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * FC - Filter Configuration
 *
 * @param <W>
 */
@SuppressWarnings("unchecked")
@Slf4j
public class FC<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>> {

	private final W widget;

	@Getter
	private List<AbstractFilter> container;

	public FC(W widget) {
		container = new ArrayList<>();
		this.widget = widget;
	}

	public void executeFilters() {
		// a value chosen from a list is chosen, as the field of the same type: «Фильтр колонки «Вид»: выбирает»
		container.forEach(fc -> Allure.step(message(fc instanceof DictionaryFilter || fc instanceof MultipleSelectFilter ? "filter.columnChoose" : "filter.column",
				fc.getParent().getName()), step -> {
			StepReport.value(fc.getValue());
			fc
					.filter(fc.getValue())
					.apply();
		}));
	}
}
