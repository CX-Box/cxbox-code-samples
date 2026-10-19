package core.element.widget.field.attribute.checkable;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.list.ListWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;


public interface RequiredCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends RequiredCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	static final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";

	@SuppressWarnings("unchecked")
	default SELF checkRequired(Consumer<V> checkRequired) {
		return Allure.step(message("field.requiredMessage", getFieldIdentifier()), step -> {
			String actualText;
			// move the mouse away to the corner: the center of the body may be over the field itself,
			// then the hover below does not enter the field and its error tooltip does not open
			Selenide.actions()
					.moveToLocation(0, 0)
					.perform();
			if (ListWidget.class.isAssignableFrom(widget().getClass())) {
				element()
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.$("div.ant-row.ant-form-item")
						.hover()
				;
				actualText = element()
						.$(REQUIRED_MESSAGE)
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.text();
			} else {
				element().hover();
				actualText = element()
						.$("div[data-test-error-text=\"true\"]")
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.text();
			}
			StepReport.value(actualText);
			checkRequired.accept((V) actualText);
			return (SELF) this;
		});
	}
}
