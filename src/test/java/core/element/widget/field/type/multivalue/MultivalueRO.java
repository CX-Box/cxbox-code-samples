package core.element.widget.field.type.multivalue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.ColorCheckable;
import core.element.widget.field.attribute.checkable.PlaceholderSupportedCheckable;
import core.element.widget.field.attribute.checkable.ReadOnlyCheckable;
import core.element.widget.field.attribute.checkable.ValueCheckable;
import core.expectation.ExpectationPattern;
import core.util.report.StepReport;

import java.util.List;
import java.util.function.Consumer;

public class MultivalueRO<W extends AbstractWidget<ExpectationPattern, W>> extends AbstractFieldImpl<ExpectationPattern, W, List<String>, MultivalueRO<W>> implements
		PlaceholderSupportedCheckable<W, List<String>, MultivalueRO<W>>,
		ColorCheckable<W, List<String>, String, MultivalueRO<W>>,
		ReadOnlyCheckable<W, List<String>, String, MultivalueRO<W>>,
		ValueCheckable<W, List<String>, MultivalueRO<W>> {

	private final String identifier;

	public MultivalueRO(W widget, String identifier) {
		super(widget, identifier, PlatformIdentifier.TITLE);
		this.identifier = identifier;
	}


	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_RO;
	}

	@Override
	public List<String> getValue() {
		return StepReport.read(this, () -> element()
//				.$("div[class*=\"InfoCell__fieldData\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$(valueTag())
				.texts());
	}

	@Override
	public MultivalueRO<W> setValue(List<String> value) {
		throw new UnsupportedOperationException();
	}


	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SelenideElement element() {
		return widget().element().
				$$(fieldSelector("title", identifier))
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.$("div[class*=\"InfoCell__fieldData\"]")
				.shouldBe(Condition.interactable, widget().getExpectations().getTimeout());
	}


	@Override
	public MultivalueRO<W> checkPlaceholderSupported(Consumer<Boolean> consumer) {
		boolean isPlaceholderSupported = element()
				.$("span[class*=\"MultivalueField\"]")
				.getAttribute("placeholder") != null;
		consumer.accept(isPlaceholderSupported);
		return this;
	}
}
