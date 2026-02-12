package core.element.widget.list.filter.header.filtration;


import core.element.widget.list.HeaderColumn;
import core.element.widget.list.ListHeaders;
import core.element.widget.list.ListWidget;
import core.element.widget.list.filter.header.filtration.filter.*;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@SuppressWarnings("unchecked")
public class FB<W extends ListWidget<W, ROWS, ROW>, ROWS extends PlatformRows<ROWS, W, ROW>, ROW extends PlatformRow<ROW, ROWS, W>, S extends FB<W, ROWS, ROW, S>> {

	private final W widget;

	private final ListHeaders<W, ROWS, ROW> headers;

	@Getter(AccessLevel.PROTECTED)
	private List<AbstractFilter> container;

	public FB(List<AbstractFilter> container, W widget, ListHeaders<W, ROWS, ROW> headers) {
		this.container = container;
		this.widget = widget;
		this.headers = headers;
	}


	public S date(String name, LocalDate date) {
		container.add(new DateFilter<>(widget, column(name), date));
		return self();
	}

	public S checkbox(String name, boolean date) {
		container.add(new CheckBoxFilter<>(widget, column(name), date));
		return self();
	}

	public S dateFromTo(String name, LocalDate from, LocalDate to) {
		container.add(new DateFromToFilter<>(widget, column(name), List.of(from, to)));
		return self();
	}


	public S dateTime(String name, LocalDateTime dateTime) {
		container.add(new DateTimeFilter<>(widget, column(name), dateTime));
		return self();
	}

	public S dateTimeFromTo(String name, LocalDateTime from, LocalDateTime to) {
		List<LocalDateTime> dates = new ArrayList<>();
		dates.add(from);
		dates.add(to);
		container.add(new DateTimeFromToFilter<>(widget, column(name), dates));
		return self();
	}


	public S dictionary(String name, String value) {
		container.add(new DictionaryFilter<>(widget, column(name), value));
		return self();
	}


	public S hint(String name, String value) {
		container.add(new HintFilter<>(widget, column(name), value));
		return self();
	}

	public S inlinePickList(String name, String value) {
		container.add(new InlinePickListFilter<>(widget, column(name), value));
		return self();
	}

	public S money(String name, BigDecimal value) {
		container.add(new MoneyFilter<>(widget, column(name), value));
		return self();
	}

	public S moneyFromTo(String name, BigDecimal from, BigDecimal to) {
		container.add(new MoneyFromToFilter<>(widget, column(name), List.of(from, to)));
		return self();
	}

	public S multifield(String name, String value) {
		container.add(new MultifieldFilter<>(widget, column(name), value));
		return self();
	}

	public S multipleSelect(String name, Set<String> values) {
		container.add(new MultipleSelectFilter<>(widget, column(name), values));
		return self();
	}

	public <T extends Number> S number(String name, T value) {
		container.add(new NumberFilter<>(widget, column(name), value));
		return self();
	}

	public <T extends Number> S numberFromTo(String name, T from, T to) {
		container.add(new NumberFromToFilter<>(widget, column(name), List.of(from, to)));
		return self();
	}


	public S input(String name, String value) {
		container.add(new InputFilter<>(widget, column(name), value));
		return self();
	}

	public S dateWithSecond(String name, LocalDateTime value) {
		container.add(new DateTimeWithSecondsFilter<>(widget, column(name), value));
		return self();
	}

	public S dateWithSecondFromTo(String name, LocalDateTime from, LocalDateTime to) {
		List<LocalDateTime> dates = new ArrayList<>();
		dates.add(from);
		dates.add(to);
		container.add(new DateTimeWithSecondsFromToFilter<>(widget, column(name), dates));
		return self();
	}


	public S fileUpload(String name, String value) {
		container.add(new FileUploadFilter<>(widget, column(name), value));
		return self();
	}

	public S radio(String name, String value) {
		container.add(new RadioFilter<>(widget, column(name), value));
		return self();
	}

	public S text(String name, String value) {
		container.add(new InputFilter<>(widget, column(name), value));
		return self();
	}

	public S time(String name, LocalDateTime value, String pattern) {
		container.add(new TimeFilter<>(widget, column(name), value, pattern));
		return self();
	}

	public S timeFromTo(String name, LocalDateTime from, LocalDateTime to, String pattern) {
		container.add(new TimeFilterFromTo<>(widget, column(name), List.of(from, to), pattern));
		return self();
	}
	/*







	public <T extends Number> S percent(String name, T value) {
		container.add(new NotSupportedFilter<>(widget, column(name), value));
		return self();
	}

	public <T extends Number> S percentFromTo(String name, T from, T to) {
		container.add(new NotSupportedFilter<>(widget, column(name), from));
		return self();
	}

	public S pickList(String name, Collection<String> value) {
		container.add(new NotSupportedFilter<>(widget, column(name), value));
		return self();
	}



	public S suggestionPickList(String name, String value) {
		container.add(new NotSupportedFilter<>(widget, column(name), value));
		return self();
	}

	public S text(String name, String value) {
		container.add(new NotSupportedFilter<>(widget, column(name), value));
		return self();
	}


	 */

	protected S self() {
		return (S) this;
	}

	protected HeaderColumn<W, ROWS, ROW> column(String name) {
		return headers.headerColumn(name);
	}
}
