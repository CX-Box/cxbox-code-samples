package core.element.widget.field.type.hint;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.ListWidget;
import core.expectation.ExpectationPattern;
import org.openqa.selenium.StaleElementReferenceException;

public class Hint<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Hint<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, Hint<W, SELF>> implements
		Clear<W, String, Hint<W, SELF>>,
		ColorCheckable<W, String, String, Hint<W, SELF>>,
		PlaceholderCheckable<W, String, String, Hint<W, SELF>>,
		ReadOnlyCheckable<W, String, Boolean, Hint<W, SELF>>,
		ValueCheckable<W, String, Hint<W, SELF>>,
		DrillDownSupportCheckable<W, String, Boolean, Hint<W, SELF>>,
		RequiredCheckable<W, String, String, Hint<W, SELF>>,
		MaxInputCheckable<W, String, Integer, Hint<W, SELF>> {

	private final String title;

	public Hint(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.HINT;
	}

	@Override
	public String getValue() {
		return element().$(valueTag()).getText();
	}

	@Deprecated
	@Override
	public Hint<W, SELF> setValue(String value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return parentElement().$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-title=\"" + title + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass()) || ListWidget.class.isAssignableFrom(widget().getClass())) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}

	protected SelenideElement parentElement() {
		return widget().element();
	}
}
