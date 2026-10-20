package core.element.widget.field.type.suggestionPickList;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

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

import java.util.List;

import static com.codeborne.selenide.Selenide.$;


public class SuggestionPickList<W extends AbstractWidget<ExpectationPattern, W>, SELF extends SuggestionPickList<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SuggestionPickList<W, SELF>> implements
		Clear<W, String, SuggestionPickList<W, SELF>>,
		ColorCheckable<W, String, String, SuggestionPickList<W, SELF>>,
		PlaceholderCheckable<W, String, String, SuggestionPickList<W, SELF>>,
		ReadOnlyCheckable<W, String, Boolean, SuggestionPickList<W, SELF>>,
		ValueCheckable<W, String, SuggestionPickList<W, SELF>>,
		DrillDownSupportCheckable<W, String, Boolean, SuggestionPickList<W, SELF>>,
		RequiredCheckable<W, String, String, SuggestionPickList<W, SELF>>,
		MaxInputCheckable<W, String, Integer, SuggestionPickList<W, SELF>> {

	private final String title;

	public SuggestionPickList(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.SUGGESTION_PICK_LIST;
	}

	@Override
	public String getValue() {
		return StepReport.read(this, () -> {
			return getUniversalText(element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout()));
		});
	}

	@Override
	public SuggestionPickList<W, SELF> setValue(String value) {
		Allure.step(message("field.choose", getFieldIdentifier()), step -> {
			StepReport.value(value);
			SelenideElement field = element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
			clear();
			field
					.setValue(value);
			getItems()
					.findBy(Condition.text(value))
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
		});
		return this;
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	/**
	 * Getting a list of matching options
	 *
	 * @param value Symbols, which will be searched for
	 * @return List(String)
	 */
	public List<String> getOptions(String value) {
		return Allure.step(message("field.suggestions", getFieldIdentifier(), value), step -> {
			step.parameter(message("parameter.symbols"), value);

			element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.setValue(value);
			return getItems().texts();
		});
	}


	private ElementsCollection getItems() {
		return $("div[class*=\"rc-select-dropdown SuggestionPickList\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("div[class=\"rc-virtual-list\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$("div[class*=\"rc-select-item rc-select-item-option\"]");
	}

	public SuggestionPickList<W, SELF> clear() {
		StepReport.service(message("field.clear", getFieldIdentifier()), () -> {

			// the field is looked up once: each look up waits for the widget
			var field = element();
			field.click();
			field.hover();
			if (field
					.$("i[class=\"anticon anticon-close-circle\"]")
					.is(Condition.visible)) {
				field
						.$("i[class=\"anticon anticon-close-circle\"]")
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.click();
			}
		});
		return this;
	}


}
