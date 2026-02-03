package core.element.widget.field;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Condition.attribute;


public abstract class AbstractFieldImpl<T extends ExpectationPattern, S extends AbstractWidget<T, S>, V, SELF extends AbstractFieldImpl<T, S, V, SELF>> implements AbstractField<T, S, V, SELF> {

	private final S widget;

	@Getter(value = AccessLevel.PROTECTED)
	private final String fieldIdentifier;

	@Getter(value = AccessLevel.PROTECTED)
	private final Identifier identifier;

	public AbstractFieldImpl(final S widget, String fieldIdentifier, Identifier identifier) {
		this.widget = widget;
		this.fieldIdentifier = fieldIdentifier;
		this.identifier = identifier;
	}

	@Override
	public S widget() {
		return widget;
	}


	public String valueTag() {
		return fieldType().getValueTag();
	}

	protected abstract SelenideElement parentElement();

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		SelenideElement selenideElement = parentElement().$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-" + identifier.getTypeIdentifier() + "=\"" + fieldIdentifier + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());

		return selenideElement;
	}

	protected String getUniversalText(SelenideElement element) {
		if (element.getAttribute("value") != null ||
				element.has(attribute("value"))) {
			return element.getValue();
		}

		return element.getText();
	}

}
