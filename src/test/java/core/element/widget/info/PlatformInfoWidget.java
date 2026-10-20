package core.element.widget.info;

import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
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
import core.element.widget.field.type.pickTree.PickTree;
import core.element.widget.field.type.multivalueTree.MultivalueTreeRO;
import core.element.widget.field.type.radio.Radio;
import core.element.widget.field.type.richtext.RichText;
import core.element.widget.field.type.text.Text;
import core.element.widget.field.type.time.Time;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

import static core.element.PlatformApp.config;

public class PlatformInfoWidget extends PlatformWidget<PlatformInfoWidget> {

	public PlatformInfoWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public InputRO<? extends PlatformInfoWidget> input(String title) {
		return config().parts.info.input.apply(this, title);
	}

	public CheckBox<? extends PlatformInfoWidget, ?> checkbox(String title) {
		return config().parts.info.checkbox.apply(this, title);
	}

	public DateTimeWithSecondsRO<PlatformInfoWidget, ?> dateTimeWithSeconds(String title) {
		return config().parts.info.dateTimeWithSeconds.apply(this, title);
	}

	public Date<PlatformInfoWidget, ?> date(String title) {
		return config().parts.info.date.apply(this, title);
	}

	public DateTime<PlatformInfoWidget, ?> dateTime(String title) {
		return config().parts.info.dateTime.apply(this, title);
	}

	public Dictionary<PlatformInfoWidget, ?> dictionary(String title) {
		return config().parts.info.dictionary.apply(this, title);
	}

	public FileUploadRO<? extends PlatformInfoWidget> fileUpload(String title) {
		return config().parts.info.fileUpload.apply(this, title);
	}

	public Percent<PlatformInfoWidget, ?> percent(String title) {
		return config().parts.info.percent.apply(this, title);
	}

	public Hint<PlatformInfoWidget, ?> hint(String title) {
		return config().parts.info.hint.apply(this, title);
	}

	public Money<PlatformInfoWidget, ?> money(String title) {
		return config().parts.info.money.apply(this, title);
	}

	public Multifield<PlatformInfoWidget, ?> multiField(String title) {
		return config().parts.info.multiField.apply(this, title);
	}

	public MultipleSelectRO<PlatformInfoWidget, ?> multipleSelect(String title) {
		return config().parts.info.multipleSelect.apply(this, title);
	}

	public MultivalueHover<PlatformInfoWidget, ?> multivalueHover(String title) {
		return config().parts.info.multivalueHover.apply(this, title);
	}

	public MultivalueRO<PlatformInfoWidget> multivalue(String title) {
		return config().parts.info.multivalue.apply(this, title);
	}

	public Radio<PlatformInfoWidget, ?> radio(String title) {
		return config().parts.info.radio.apply(this, title);
	}

	public Number<PlatformInfoWidget, ?> number(String title) {
		return config().parts.info.number.apply(this, title);
	}

	public Text<PlatformInfoWidget, ?> text(String title) {
		return config().parts.info.text.apply(this, title);
	}

	public RichText<PlatformInfoWidget, ?> richText(String title) {
		return config().parts.info.richText.apply(this, title);
	}

	public Time<PlatformInfoWidget, ?> time(String title, String format) {
		return new Time<>(this, title, format);
	}

	public PickList<PlatformInfoWidget, ?> pickList(String title) {
		return config().parts.info.pickList.apply(this, title);
	}

	public PickTree<PlatformInfoWidget, ?> pickTree(String title) {
		return config().parts.info.pickTree.apply(this, title);
	}

	/** The buttons of the info widget */
	public Action<PlatformInfoWidget> actions() {
		return config().parts.actions.create(this);
	}

	public MultivalueTreeRO<PlatformInfoWidget> multivalueTree(String title) {
		return config().parts.info.multivalueTree.apply(this, title);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.INFO;
	}
}
