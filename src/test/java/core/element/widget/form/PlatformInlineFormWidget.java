package core.element.widget.form;

import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Actions;
import core.element.widget.field.type.checkbox.CheckBox;
import core.element.widget.field.type.date.Date;
import core.element.widget.field.type.dateTime.DateTime;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSeconds;
import core.element.widget.field.type.dictionary.Dictionary;
import core.element.widget.field.type.hint.Hint;
import core.element.widget.field.type.inlinePickList.InlinePickList;
import core.element.widget.field.type.input.Input;
import core.element.widget.field.type.money.Money;
import core.element.widget.field.type.multifield.Multifield;
import core.element.widget.field.type.multipleSelect.MultipleSelect;
import core.element.widget.field.type.multivalueHover.MultivalueHover;
import core.element.widget.field.type.number.Number;
import core.element.widget.field.type.pickList.PickList;
import core.element.widget.list.rows.row.RowInlineForm;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlatformInlineFormWidget extends PlatformWidget<PlatformInlineFormWidget> {

	private final RowInlineForm<?, ?, ?, ?> row;

	private final String rowKey;

	public PlatformInlineFormWidget(Identifier identifier, String title, RowInlineForm<?, ?, ?, ?> row, String rowKey) {
		super(identifier, title);
		this.row = row;
		this.rowKey = rowKey;
	}

	@Override
	public SelenideElement element() {
		return row.element().$("div[data-test-widget-list-row-id='" + rowKey + "'][data-test-widget-list-row-type='InlineForm']");
	}

	public Input<PlatformInlineFormWidget, ?> input(String title) {
		return new Input<>(this, title);
	}

	public CheckBox<PlatformInlineFormWidget, ?> checkbox(String title) {
		return new CheckBox<>(title, this);
	}

	public DateTimeWithSeconds<PlatformInlineFormWidget, ?> dateTimeWithSecond(String title) {
		return new DateTimeWithSeconds<>(title, this);
	}

	public Date<PlatformInlineFormWidget, ?> date(String title) {
		return new Date<>(title, this);
	}

	public DateTime<PlatformInlineFormWidget, ?> dateTime(String title) {
		return new DateTime<>(this, title);
	}

	public Dictionary<PlatformInlineFormWidget, ?> dictionary(String title) {
		return new Dictionary<>(this, title);
	}

	public Hint<PlatformInlineFormWidget, ?> hint(String title) {
		return new Hint<>(this, title);
	}

	public InlinePickList<PlatformInlineFormWidget, ?> inlinePickList(String title) {
		return new InlinePickList<>(this, title);
	}

	public Money<PlatformInlineFormWidget, ?> money(String title) {
		return new Money<>(this, title);
	}

	public Multifield<PlatformInlineFormWidget, ?> multifield(String title) {
		return new Multifield<>(this, title);
	}

	public MultipleSelect<PlatformInlineFormWidget, ?> multipleSelect(String title) {
		return new MultipleSelect<>(this, title);
	}

	public MultivalueHover<PlatformInlineFormWidget, ?> multivalueHover(String title) {
		return new MultivalueHover<>(this, title);
	}

	public Number<PlatformInlineFormWidget, ?> number(String title) {
		return new Number<>(this, title);
	}

	public PickList<PlatformInlineFormWidget, ?> pickList(String title) {
		return new PickList<>(this, title);
	}


	public Actions<PlatformInlineFormWidget> actions() {
		return new Actions<>(this);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.FORM;
	}

	public RowInlineForm<?, ?, ?, ?> row() {
		return row;
	}
}
