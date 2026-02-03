package core.element.widget.form;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Actions;
import core.element.widget.field.type.checkbox.CheckBox;
import core.element.widget.field.type.date.Date;
import core.element.widget.field.type.dateTime.DateTime;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSeconds;
import core.element.widget.field.type.dictionary.Dictionary;
import core.element.widget.field.type.fileUpload.FileUpload;
import core.element.widget.field.type.hint.Hint;
import core.element.widget.field.type.inlinePickList.InlinePickList;
import core.element.widget.field.type.input.Input;
import core.element.widget.field.type.money.Money;
import core.element.widget.field.type.multifield.Multifield;
import core.element.widget.field.type.multipleSelect.MultipleSelect;
import core.element.widget.field.type.multivalueHover.MultivalueHover;
import core.element.widget.field.type.number.Number;
import core.element.widget.field.type.percent.Percent;
import core.element.widget.field.type.pickList.PickList;
import core.element.widget.field.type.radio.Radio;
import core.element.widget.field.type.suggestionPickList.SuggestionPickList;
import core.element.widget.field.type.text.Text;
import core.element.widget.field.type.time.Time;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlatformFormWidget extends PlatformWidget<PlatformFormWidget> {

	public PlatformFormWidget(Identifier identifier, String title) {
		super(identifier, title);
	}

	public Input<PlatformFormWidget, ?> input(String title) {
		return new Input<>(this, title);
	}

	public CheckBox<PlatformFormWidget, ?> checkbox(String title) {
		return new CheckBox<>(title, this);
	}

	public DateTimeWithSeconds<PlatformFormWidget, ?> dateTimeWithSecond(String title) {
		return new DateTimeWithSeconds<>(title, this);
	}

	public Date<PlatformFormWidget, ?> date(String title) {
		return new Date<>(title, this);
	}

	public DateTime<PlatformFormWidget, ?> dateTime(String title) {
		return new DateTime<>(this, title);
	}

	public Dictionary<PlatformFormWidget, ?> dictionary(String title) {
		return new Dictionary<>(this, title);
	}

	public Hint<PlatformFormWidget, ?> hint(String title) {
		return new Hint<>(this, title);
	}

	public InlinePickList<PlatformFormWidget, ?> inlinePickList(String title) {
		return new InlinePickList<>(this, title);
	}

	public Money<PlatformFormWidget, ?> money(String title) {
		return new Money<>(this, title);
	}

	public Multifield<PlatformFormWidget, ?> multifield(String title) {
		return new Multifield<>(this, title);
	}

	public MultipleSelect<PlatformFormWidget, ?> multipleSelect(String title) {
		return new MultipleSelect<>(this, title);
	}

	public MultivalueHover<PlatformFormWidget, ?> multivalueHover(String title) {
		return new MultivalueHover<>(this, title);
	}

	public Number<PlatformFormWidget, ?> number(String title) {
		return new Number<>(this, title);
	}

	public PickList<PlatformFormWidget, ?> pickList(String title) {
		return new PickList<>(this, title);
	}

	public Percent<PlatformFormWidget, ?> percent(String title) {
		return new Percent<>(this, title);
	}

	public Radio<PlatformFormWidget, ?> radio(String title) {
		return new Radio<>(this, title);
	}

	public SuggestionPickList<PlatformFormWidget, ?> suggestionPickList(String title) {
		return new SuggestionPickList<>(this, title);
	}

	public Text<PlatformFormWidget, ?> text(String title) {
		return new Text<>(this, title);
	}

	public Time<PlatformFormWidget, ?> time(String title, String format) {
		return new Time<>(this, title, format);
	}

	public FileUpload<PlatformFormWidget, ?> fileUpload(String title) {
		return new FileUpload<>(this, title);
	}

	public Actions<PlatformFormWidget> actions() {
		return new Actions<>(this);
	}


	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.FORM;
	}

}
