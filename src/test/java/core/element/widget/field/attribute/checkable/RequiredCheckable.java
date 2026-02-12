package core.element.widget.field.attribute.checkable;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.list.ListWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;


public interface RequiredCheckable<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends RequiredCheckable<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	static final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";

	@SuppressWarnings("unchecked")
	default SELF checkRequired(Consumer<V> checkRequired) {
		return Allure.step("Getting a value from a field RequiredMessage", step -> {
			logTime(step);
			String actualText;
			Selenide.actions()
					.moveToElement($("body"))
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
			checkRequired.accept((V) actualText);
			return (SELF) this;
		});
	}
}
