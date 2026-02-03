package core.element.widget.field.type.suggestionPickList;

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
import static core.element.widget.AbstractWidget.logTime;


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
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return getUniversalText(element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout()));
		});
	}

	@Override
	public SuggestionPickList<W, SELF> setValue(String value) {
		Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("Suggestion Pick List", value);
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
		return Allure.step("Getting a list of matching options by symbols " + value, step -> {
			logTime(step);
			step.parameter("Symbols", value);

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
		Allure.step("Clearing the field", step -> {
			logTime(step);

			element().click();
			element().hover();
			if (element()
					.$("i[class=\"anticon anticon-close-circle\"]")
					.is(Condition.visible)) {
				element()
						.$("i[class=\"anticon anticon-close-circle\"]")
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.click();
			}
		});
		return this;
	}


}
