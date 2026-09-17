package core.element.widget.field.attribute.checkable;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.BiConsumer;

import static core.element.widget.AbstractWidget.logTime;

/**
 * Field with a drop-down list that is allowed to be wider than the field itself.
 */
public interface DropDownWidthCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, SELF extends DropDownWidthCheckable<W, VF, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	/**
	 * First option of the opened drop-down list, its locator differs from field to field
	 */
	SelenideElement dropDownOption();

	/**
	 * Opens the drop-down list and gives the field width and the option width, both in pixels
	 */
	@SuppressWarnings("unchecked")
	default SELF checkDropDownWidth(BiConsumer<Integer, Integer> checkWidth) {
		Allure.step("Getting the width of the field and of a drop-down list option", step -> {
			logTime(step);
			SelenideElement field = element().shouldBe(Condition.visible, widget().getExpectations().getTimeout());
			int fieldWidth = field.getSize().getWidth();
			field.click();
			int optionWidth = dropDownOption()
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.getSize()
					.getWidth();
			step.parameter("field width", fieldWidth);
			step.parameter("option width", optionWidth);
			checkWidth.accept(fieldWidth, optionWidth);
		});
		return (SELF) this;
	}

}
