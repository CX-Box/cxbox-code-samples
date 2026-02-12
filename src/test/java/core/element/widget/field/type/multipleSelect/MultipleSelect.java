package core.element.widget.field.type.multipleSelect;

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
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class MultipleSelect<W extends AbstractWidget<ExpectationPattern, W>, SELF extends MultipleSelect<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, Set<String>, SELF> implements
		Clear<W, Set<String>, SELF>,
		ColorCheckable<W, Set<String>, String, SELF>,
		PlaceholderCheckable<W, Set<String>, String, SELF>,
		ReadOnlyCheckable<W, Set<String>, Boolean, SELF>,
		ValueCheckable<W, Set<String>, SELF>,
		DrillDownSupportCheckable<W, Set<String>, Boolean, SELF>,
		RequiredCheckable<W, Set<String>, String, SELF>,
		MaxInputCheckable<W, Set<String>, Integer, SELF> {

	private final String title;

	public MultipleSelect(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIPLE_SELECT;
	}

	@Override
	public Set<String> getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			List<String> list = element()
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.$$("div[data-test-field-multipleselect-current-item=\"true\"]").texts();
			return new HashSet<>(list);
		});
	}


	@Override
	public SELF setValue(Set<String> value) {
		Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("values", value);
			clear();
			addValue(value);
		});
		return (SELF) this;
	}

	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			String actualPlaceholder = element()
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.text();
			expectedPlaceholder.accept(actualPlaceholder);
		});
		return (SELF) this;
	}

	public SELF addValue(@NonNull Set<String> values) {
		Allure.step("Setting the " + values + " in the field", step -> {
			logTime(step);
			step.parameter("values", values);

			values.forEach(value -> {
				boolean doesNotExist = !$("div[class^='ant-select-dropdown MultipleSelectField__dropDownMenu']")
						.is(Condition.visible, widget().getExpectations().getTimeout());
				if (doesNotExist) {
					element().click();
				}
				if (!isOptionSelected(value)) {
					getOption(value)
							.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
							.click();
				}
				$("body").sendKeys(Keys.ESCAPE);
				$("div[class^='ant-select-dropdown MultipleSelectField__dropDownMenu']")
						.is(Condition.hidden, widget().getExpectations().getTimeout());
			});
		});
		return (SELF) this;
	}

	protected Boolean isOptionSelected(String option) {
		return Boolean.parseBoolean(getOption(option).getAttribute("aria-selected"));
	}

	protected Set<String> getOptions() {
		return Allure.step("Getting a list of options", step -> {
			logTime(step);
			element().click();
			return new HashSet<>(getOptionsMultipleSelect().texts());
		});
	}

	public SELF checkOptions(Consumer<Set<String>> options) {
		Allure.step("Checking the options", step -> {
			logTime(step);
			options.accept(getOptions());
		});
		return (SELF) this;
	}

	public SELF checkStatusOption(String name, Consumer<Boolean> isSelected) {
		Allure.step("Checking the options", step -> {
			logTime(step);
			element().click();
			isSelected.accept(isOptionSelected(name));
			$("body").sendKeys(Keys.ESCAPE);
		});
		return (SELF) this;
	}

	public SELF checkStatusOptions(Map<String, Consumer<Boolean>> options) {
		Allure.step("Checking the options", step -> {
			logTime(step);
			options.forEach((key, value) -> {
				element().click();
				value.accept(isOptionSelected(key));
				$("body").sendKeys(Keys.ESCAPE);
			});
		});
		return (SELF) this;
	}

	protected SelenideElement getOption(String nameRadio) {
		return getOptionsMultipleSelect().find(Condition.match("check action name: " + nameRadio, b -> b.getText().equals(nameRadio)));
	}

	protected ElementsCollection getOptionsMultipleSelect() {
		return $("div[class^=\"ant-select-dropdown MultipleSelectField__dropDownMenu\"]")
				.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$(By.tagName("li"));
	}

	public SELF clear() {
		if (false) {
			return Clear.super.clear();
		}
		Allure.step("Clearing the field", step -> {
			logTime(step);
			ElementsCollection closeX = element()
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.$$("i[aria-label=\"icon: close\"]");
			for (int i = 0; i <= closeX.size(); i++) {
				if (closeX.get(i).is(Condition.exist)) {
					closeX.get(i).click();
				}
			}
			$("body").sendKeys(Keys.ESCAPE);
		});
		return (SELF) this;
	}
}
