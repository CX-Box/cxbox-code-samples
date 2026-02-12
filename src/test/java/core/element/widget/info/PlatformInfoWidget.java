package core.element.widget.info;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.field.type.checkbox.CheckBox;
import core.element.widget.field.type.date.Date;
import core.element.widget.field.type.dateTime.DateTime;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSecondsRO;
import core.element.widget.field.type.dictionary.Dictionary;
import core.element.widget.field.type.fileUpload.FileUploadRO;
import core.element.widget.field.type.hint.Hint;
import core.element.widget.field.type.input.InputRO;
import core.element.widget.field.type.money.Money;
import core.element.widget.field.type.multifield.Multifield;
import core.element.widget.field.type.multipleSelect.MultipleSelectRO;
import core.element.widget.field.type.multivalue.MultivalueRO;
import core.element.widget.field.type.multivalueHover.MultivalueHover;
import core.element.widget.field.type.number.Number;
import core.element.widget.field.type.percent.Percent;
import core.element.widget.field.type.pickList.PickList;
import core.element.widget.field.type.radio.Radio;
import core.element.widget.field.type.text.Text;
import core.element.widget.field.type.time.Time;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

public class PlatformInfoWidget extends PlatformWidget<PlatformInfoWidget> {

	public PlatformInfoWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public InputRO<? extends PlatformInfoWidget> input(String title) {
		return new InputRO<>(title, this);
	}

	public CheckBox<? extends PlatformInfoWidget, ?> checkbox(String title) {
		return new CheckBox<>(title, this);
	}

	public DateTimeWithSecondsRO<PlatformInfoWidget, ?> dateTimeWithSeconds(String title) {
		return new DateTimeWithSecondsRO<>(title, this);
	}

	public Date<PlatformInfoWidget, ?> date(String title) {
		return new Date<>(title, this);
	}

	public DateTime<PlatformInfoWidget, ?> dateTime(String title) {
		return new DateTime<>(this, title);
	}

	public Dictionary<PlatformInfoWidget, ?> dictionary(String title) {
		return new Dictionary<>(this, title);
	}

	public FileUploadRO<? extends PlatformInfoWidget> fileUpload(String title) {
		return new FileUploadRO<>(this, title);
	}

	public Percent<PlatformInfoWidget, ?> percent(String title) {
		return new Percent<>(this, title);
	}

	public Hint<PlatformInfoWidget, ?> hint(String title) {
		return new Hint<>(this, title);
	}

	public Money<PlatformInfoWidget, ?> money(String title) {
		return new Money<>(this, title);
	}

	public Multifield<PlatformInfoWidget, ?> multiField(String title) {
		return new Multifield<>(this, title);
	}

	public MultipleSelectRO<PlatformInfoWidget, ?> multipleSelect(String title) {
		return new MultipleSelectRO<>(this, title);
	}

	public MultivalueHover<PlatformInfoWidget, ?> multivalueHover(String title) {
		return new MultivalueHover<>(this, title);
	}

	public MultivalueRO<PlatformInfoWidget> multivalue(String title) {
		return new MultivalueRO<>(this, title);
	}

	public Radio<PlatformInfoWidget, ?> radio(String title) {
		return new Radio<>(this, title);
	}

	public Number<PlatformInfoWidget, ?> number(String title) {
		return new Number<>(this, title);
	}

	public Text<PlatformInfoWidget, ?> text(String title) {
		return new Text<>(this, title);
	}

	public Time<PlatformInfoWidget, ?> time(String title, String format) {
		return new Time<>(this, title, format);
	}

	public PickList<PlatformInfoWidget, ?> pickList(String title) {
		return new PickList<>(this, title);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.INFO;
	}
}
