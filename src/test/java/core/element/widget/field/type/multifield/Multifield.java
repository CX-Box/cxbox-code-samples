package core.element.widget.field.type.multifield;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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
import org.openqa.selenium.StaleElementReferenceException;

import java.util.ArrayList;
import java.util.List;

import static core.element.widget.AbstractWidget.logTime;

public class Multifield<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Multifield<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, List<MultifieldContainer>, SELF> implements
		Clear<W, List<MultifieldContainer>, SELF>,
		ColorCheckable<W, List<MultifieldContainer>, String, SELF>,
		PlaceholderCheckable<W, List<MultifieldContainer>, String, SELF>,
		ReadOnlyCheckable<W, List<MultifieldContainer>, Boolean, SELF>,
		ValueCheckable<W, List<MultifieldContainer>, SELF>,
		DrillDownSupportCheckable<W, List<MultifieldContainer>, Boolean, SELF>,
		RequiredCheckable<W, List<MultifieldContainer>, String, SELF>,
		MaxInputCheckable<W, List<MultifieldContainer>, Integer, SELF> {

	private final String title;

	public Multifield(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIFIELD;
	}

	@Override
	public List<MultifieldContainer> getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			ElementsCollection elements = elements();
			List<MultifieldContainer> result = new ArrayList<>(elements.size());
			for (SelenideElement i : elements) {
				result.add(new MultifieldContainer(i.getAttribute("data-test-field-type"), i.text()));
			}
			return result;
		});
	}

	@Deprecated
	@Override
	public SELF setValue(List<MultifieldContainer> value) {
		throw new UnsupportedOperationException("Set value is not supported for Multifield");
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return parentElement().$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-title=\"" + title + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());
	}

	protected SelenideElement parentElement() {
		return widget().element();
	}

	protected ElementsCollection elements() {
		return element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())

				.$$("div[class*='MultiField'][data-test='FIELD']");
	}


}
