package core.element.widget.field.type.checkbox;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;


public class CheckBox<W extends AbstractWidget<ExpectationPattern, W>, SELF extends CheckBox<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, Boolean, CheckBox<W, SELF>> implements
		ColorCheckable<W, Boolean, String, CheckBox<W, SELF>>,
		PlaceholderCheckable<W, Boolean, String, CheckBox<W, SELF>>,
		ReadOnlyCheckable<W, Boolean, Boolean, CheckBox<W, SELF>>,
		ValueCheckable<W, Boolean, CheckBox<W, SELF>>,
		RequiredCheckable<W, Boolean, String, CheckBox<W, SELF>>,
		DrillDownSupportCheckable<W, Boolean, Boolean, CheckBox<W, SELF>> {


	public CheckBox(String name, W widget) {
		super(widget, name, PlatformIdentifier.TITLE);
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.CHECKBOX;
	}

	@Override
	public Boolean getValue() {
		return StepReport.read(this, () -> {
			return element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.isSelected();
		});
	}

	@Override
	public SELF setValue(Boolean value) {
		return Allure.step(message("field.tick", getFieldIdentifier()), step -> {
			StepReport.value(value);
			if (value.equals(getValue())) {
				StepReport.note(message("field.alreadySet"));
			} else {
				StepReport.service(message("field.click"), () -> {
					element().shouldBe(Condition.editable, widget().getExpectations().getTimeout());
					element().$(valueTag()).click();
				});
			}
			return (SELF) this;
		});

	}


}
