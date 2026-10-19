package core.element.widget.field.type.multipleSelect;

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
import core.element.widget.field.attribute.custom.Clear;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Disabled;


public class MultipleSelectRO<W extends AbstractWidget<ExpectationPattern, W>, SELF extends MultipleSelectRO<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF> {
	private final String title;

	public MultipleSelectRO(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIPLE_SELECT;
	}

	@Override
	public String getValue() {
		return StepReport.read(this, () -> {
			return element()
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.getText();
		});
	}

	@Disabled
	@Override
	public SELF setValue(String value) {
		throw new UnsupportedOperationException("MultipleSelect on info widget support read only operation");
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public String valueTag() {
		return "div[class*=\"MultipleSelectField\"]";
	}
}
