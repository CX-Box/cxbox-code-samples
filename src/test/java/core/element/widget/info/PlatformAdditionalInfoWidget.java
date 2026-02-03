package core.element.widget.info;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.field.type.checkbox.CheckBox;
import core.element.widget.field.type.date.Date;
import core.element.widget.field.type.dateTime.DateTime;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSecondsRO;
import core.element.widget.field.type.dictionary.Dictionary;
import core.element.widget.field.type.hint.Hint;
import core.element.widget.field.type.input.InputRO;
import core.element.widget.field.type.money.Money;
import core.element.widget.field.type.multifield.Multifield;
import core.element.widget.field.type.multipleSelect.MultipleSelectRO;
import core.element.widget.field.type.multivalueHover.MultivalueHover;
import core.element.widget.field.type.number.Number;
import core.element.widget.field.type.pickList.PickList;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

public class PlatformAdditionalInfoWidget extends PlatformWidget<PlatformAdditionalInfoWidget> {

	public PlatformAdditionalInfoWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public InputRO<? extends PlatformAdditionalInfoWidget> input(String title) {
		return new InputRO<>(title, this);
	}

	public CheckBox<? extends PlatformAdditionalInfoWidget, ?> checkbox(String title) {
		return new CheckBox<>(title, this);
	}

	public DateTimeWithSecondsRO<PlatformAdditionalInfoWidget, ?> dateTimeWithSeconds(String title) {
		return new DateTimeWithSecondsRO<>(title, this);
	}

	public Date<PlatformAdditionalInfoWidget, ?> date(String title) {
		return new Date<>(title, this);
	}

	public DateTime<PlatformAdditionalInfoWidget, ?> dateTime(String title) {
		return new DateTime<>(this, title);
	}

	public Dictionary<PlatformAdditionalInfoWidget, ?> dictionary(String title) {
		return new Dictionary<>(this, title);
	}

	public Hint<PlatformAdditionalInfoWidget, ?> hint(String title) {
		return new Hint<>(this, title);
	}

	public Money<PlatformAdditionalInfoWidget, ?> money(String title) {
		return new Money<>(this, title);
	}

	public Multifield<PlatformAdditionalInfoWidget, ?> multiField(String title) {
		return new Multifield<>(this, title);
	}

	public MultipleSelectRO<PlatformAdditionalInfoWidget, ?> multipleSelect(String title) {
		return new MultipleSelectRO<>(this, title);
	}

	public MultivalueHover<PlatformAdditionalInfoWidget, ?> multivalueHover(String title) {
		return new MultivalueHover<>(this, title);
	}

	public Number<PlatformAdditionalInfoWidget, ?> number(String title) {
		return new Number<>(this, title);
	}

	public PickList<PlatformAdditionalInfoWidget, ?> pickList(String title) {
		return new PickList<>(this, title);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.ADDITIONAL_INFO;
	}
}
