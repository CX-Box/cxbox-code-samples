package core.element.widget.field.type.checkbox;

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

import static core.element.widget.AbstractWidget.logTime;

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
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.isSelected();
		});
	}

	@Override
	public SELF setValue(Boolean value) {
		if (value.equals(getValue())) {
			return (SELF) this;
		}
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("value", value);
			element().shouldBe(Condition.editable, widget().getExpectations().getTimeout());
			element().$(valueTag()).click();
			return (SELF) this;
		});

	}


}
