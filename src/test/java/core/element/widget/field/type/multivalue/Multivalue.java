package core.element.widget.field.type.multivalue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.exist;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class Multivalue<W extends AbstractWidget<ExpectationPattern, W>> extends AbstractFieldImpl<ExpectationPattern, W, List<String>, Multivalue<W>> implements
		PlaceholderCheckable<W, List<String>, String, Multivalue<W>>,
		ColorCheckable<W, List<String>, String, Multivalue<W>>,
		ReadOnlyCheckable<W, List<String>, String, Multivalue<W>>,
		ValueCheckable<W, List<String>, Multivalue<W>>,
		RequiredCheckable<W, List<String>, String, Multivalue<W>> {

	private final String name;

	public Multivalue(W widget, String name) {
		super(widget, name, PlatformIdentifier.TITLE);
		this.name = name;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE;
	}

	@Override
	public List<String> getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			List<String> strings = element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.$$(By.tagName("span"))
					.texts();
			Collections.reverse(strings);
			return strings;
		});
	}

	@Override
	public Multivalue<W> setValue(List<String> value) {
		return Allure.step("Set value on field", step -> {
			logTime(step);
			ElementsCollection icons = element()
					.shouldBe(exist, widget().getExpectations().getTimeout())
					.$$("i[class=\"anticon anticon-close\"]");
			for (SelenideElement i : icons) {
				i.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
				widget().getExpectations().getWaitAllElements(i);
				i.click();
				i.shouldBe(Condition.disappear, widget().getExpectations().getTimeout());
			}
			element()
					.$("div[data-test-field-multivalue-icon=\"true\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();

			MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
			multivalueModal.setValues(name, value);
			return this;
		});

	}


	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public Multivalue<W> checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			String placeholder = element()
					.$("span[class=\"ant-form-item-children\"] div div")
					.getAttribute("data-text");
			expectedPlaceholder.accept(placeholder);
			return this;
		});
	}

	public Multivalue<W> clear() {
		clear(false);
		return this;
	}

	public Multivalue<W> clear(boolean close) {
		element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
		multivalueModal.clear(close);
		return this;
	}

	public Multivalue<W> clearValue(String value, boolean close) {
		element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
		multivalueModal.clearWithValue(value, close);
		return this;
	}

	public Multivalue<W> setAll(boolean close) {
		element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
		multivalueModal.setValueAll(close);

		widget().getExpectations().getWaitAllFields();
		return this;
	}


	@Override
	public Multivalue<W> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		boolean isReadOnly = !element().$$x(".//*[contains(@class, 'disabled')]").isEmpty();
		expectedReadOnly.accept(isReadOnly);
		return this;
	}
}
