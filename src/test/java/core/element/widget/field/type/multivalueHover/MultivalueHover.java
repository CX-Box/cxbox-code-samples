package core.element.widget.field.type.multivalueHover;

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

import static com.codeborne.selenide.Selenide.$;

public class MultivalueHover<W extends AbstractWidget<ExpectationPattern, W>, SELF extends MultivalueHover<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, MultivalueHover<W, SELF>> implements
		Clear<W, String, MultivalueHover<W, SELF>>,
		ColorCheckable<W, String, String, MultivalueHover<W, SELF>>,
		PlaceholderCheckable<W, String, String, MultivalueHover<W, SELF>>,
		ReadOnlyCheckable<W, String, Boolean, MultivalueHover<W, SELF>>,
		ValueCheckable<W, String, MultivalueHover<W, SELF>>,
		DrillDownSupportCheckable<W, String, Boolean, MultivalueHover<W, SELF>>,
		RequiredCheckable<W, String, String, MultivalueHover<W, SELF>>,
		MaxInputCheckable<W, String, Integer, MultivalueHover<W, SELF>> {

	private final String title;

	public MultivalueHover(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_HOVER;
	}

	@Override
	public String getValue() {
		return StepReport.read(this, () -> {
			element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.hover();
			return $("div[class=\"ant-popover-inner\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.text();
		});
	}

	@Deprecated
	@Override
	public MultivalueHover<W, SELF> setValue(String value) {
		throw new UnsupportedOperationException("setValue not supported for MultiValueHover");
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}
}
