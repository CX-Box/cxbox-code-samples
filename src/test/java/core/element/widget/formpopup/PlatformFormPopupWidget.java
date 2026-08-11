package core.element.widget.formpopup;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformIdentifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
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
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlatformFormPopupWidget extends PlatformWidget<PlatformFormPopupWidget> {

	public PlatformFormPopupWidget(Identifier identifier, String title) {
		super(identifier, title);
	}

	public Input<PlatformFormPopupWidget, ?> input(String title) {
		return new Input<>(this, title);
	}

	public CheckBox<PlatformFormPopupWidget, ?> checkbox(String title) {
		return new CheckBox<>(title, this);
	}

	public DateTimeWithSeconds<PlatformFormPopupWidget, ?> dateTimeWithSecond(String title) {
		return new DateTimeWithSeconds<>(title, this);
	}

	public Date<PlatformFormPopupWidget, ?> date(String title) {
		return new Date<>(title, this);
	}

	public DateTime<PlatformFormPopupWidget, ?> dateTime(String title) {
		return new DateTime<>(this, title);
	}

	public Dictionary<PlatformFormPopupWidget, ?> dictionary(String title) {
		return new Dictionary<>(this, title);
	}

	public Hint<PlatformFormPopupWidget, ?> hint(String title) {
		return new Hint<>(this, title);
	}

	public InlinePickList<PlatformFormPopupWidget, ?> inlinePickList(String title) {
		return new InlinePickList<>(this, title);
	}

	public Money<PlatformFormPopupWidget, ?> money(String title) {
		return new Money<>(this, title);
	}

	public Multifield<PlatformFormPopupWidget, ?> multifield(String title) {
		return new Multifield<>(this, title);
	}

	public MultipleSelect<PlatformFormPopupWidget, ?> multipleSelect(String title) {
		return new MultipleSelect<>(this, title);
	}

	public MultivalueHover<PlatformFormPopupWidget, ?> multivalueHover(String title) {
		return new MultivalueHover<>(this, title);
	}

	public Number<PlatformFormPopupWidget, ?> number(String title) {
		return new Number<>(this, title);
	}

	public PickList<PlatformFormPopupWidget, ?> pickList(String title) {
		return new PickList<>(this, title);
	}

	public Percent<PlatformFormPopupWidget, ?> percent(String title) {
		return new Percent<>(this, title);
	}

	public Radio<PlatformFormPopupWidget, ?> radio(String title) {
		return new Radio<>(this, title);
	}

	public SuggestionPickList<PlatformFormPopupWidget, ?> suggestionPickList(String title) {
		return new SuggestionPickList<>(this, title);
	}

	public Text<PlatformFormPopupWidget, ?> text(String title) {
		return new Text<>(this, title);
	}

	public Time<PlatformFormPopupWidget, ?> time(String title, String format) {
		return new Time<>(this, title, format);
	}

	public FileUpload<PlatformFormPopupWidget, ?> fileUpload(String title) {
		return new FileUpload<>(this, title);
	}

	public Action<PlatformFormPopupWidget> actions() {
		return new Action<>(this);
	}

	@Override
	public SelenideElement element() {
		return Allure.step("Getting FormPopup Modal content for: " + getTextIdentifier(), step -> {
			logTime(step);

			if (getIdentifier().equals(PlatformIdentifier.TITLE)) {
				return $$(".ant-modal-content")
						.filter(Condition.visible)
						.findBy(Condition.text(getTextIdentifier()))
						.shouldBe(Condition.visible, expectations.getOverTimeout());

			} else if (getIdentifier().equals(PlatformIdentifier.NAME)) {
				return $(".ant-modal-content")
						.shouldBe(Condition.visible, expectations.getOverTimeout());
			}

			throw new UnsupportedOperationException("Cannot find method for " + getIdentifier().getName());
		});
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.FORM_POPUP;
	}

}