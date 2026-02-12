package core.element.widget.field.type.dictionary;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.element.widget.info.PlatformInfoWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

public class Dictionary<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Dictionary<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF> {

	protected final String MENU_OPTIONS = "div[class=\"ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft \"]";

	@Getter(value = AccessLevel.PROTECTED)
	private final String title;

	public Dictionary(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.DICTIONARY;
	}

	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text();
		});
	}

	@Override
	public String valueTag() {
		if (widget().getClass().isAssignableFrom(PlatformInfoWidget.class)) {
			return "div[data-test-field-value=\"true\"]";
		}
		return "[data-test-field-dictionary-item=\"true\"]";
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SELF setValue(String value) {
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("value", value);
			clear();
			if (Selenide.$(By.cssSelector("div[data-test-error-popup=\"true\"]"))
					.is(Condition.exist, widget().getExpectations().getTimeout())) {
				return (SELF) this;
			}
			element().click();
			getOptionDictionary(value)
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			return (SELF) this;
		});
	}

	public List<String> getOptions() {
		return Allure.step("Getting a list of options from a drop-down list", step -> {
			logTime(step);
			element().click();
			return getOptionsDictionary().texts();
		});
	}

	public SELF checkOptions(Consumer<List<String>> checkOptions) {
		checkOptions.accept(getOptions());
		return (SELF) this;
	}

	private SelenideElement getOptionDictionary(String value) {
		return getOptionsDictionary()
				.find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getOptionsDictionary() {
		return $(MENU_OPTIONS)
				.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
				.$$(By.tagName("li"));
	}

	@Override
	public SELF clear() {
		return Allure.step("Clearing the field through the cross icon", step -> {
			logTime(step);
			if (!element().$("i[aria-label=\"icon: close-circle\"]").exists()) {
				return (SELF) this;
			}
			element()
					.$("i[aria-label=\"icon: close-circle\"]")
					.hover()
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			return (SELF) this;
		});
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting placeholder", step -> {
			logTime(step);
			String text = element()
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.text();
			expectedPlaceholder.accept(text);
			return (SELF) this;
		});
	}
}
