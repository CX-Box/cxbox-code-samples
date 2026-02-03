package core.element.widget.field.type.input;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static core.element.widget.AbstractWidget.logTime;

public class Input<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Input<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		DrillDown<W, String, String, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF> {

	private final String fieldType = "input";

	private final String title;


	public Input(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}


	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}


	public String getValueTag() {
		return fieldType;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.INPUT;
	}

	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return getUniversalText(element()
					.shouldBe(Condition.exist)
					.$(valueTag()));
		});
	}


	@Override
	public SELF setValue(String value) {
		element().shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		element().click();
		element()
				.$(valueTag())
				.shouldBe(Condition.enabled)
				.clear();
		element()
				.$(valueTag())
				.shouldBe(Condition.enabled)
				.setValue(value);
		element()
				.$(valueTag())
				.shouldNot(Condition.empty);
		element()
				.$(valueTag())
				.sendKeys(Keys.TAB);
		return (SELF) this;
	}

}
