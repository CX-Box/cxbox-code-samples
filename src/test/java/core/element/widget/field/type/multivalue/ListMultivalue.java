package core.element.widget.field.type.multivalue;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.config.Constants;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.exist;
import static core.element.widget.AbstractWidget.logTime;

public class ListMultivalue<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends AbstractFieldImpl<ExpectationPattern, W, List<String>, ListMultivalue<W, RR, R>> implements
		PlaceholderCheckable<W, List<String>, String, ListMultivalue<W, RR, R>>,
		ColorCheckable<W, List<String>, String, ListMultivalue<W, RR, R>>,
		ReadOnlyCheckable<W, List<String>, Boolean, ListMultivalue<W, RR, R>>,
		ValueCheckable<W, List<String>, ListMultivalue<W, RR, R>>,
		RequiredCheckable<W, List<String>, String, ListMultivalue<W, RR, R>>, ParentRow<R> {

	final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";
	final R row;
	private final String identifier;

	public ListMultivalue(W widget, String identifier, R parent) {
		super(widget, identifier, PlatformIdentifier.TITLE);
		this.identifier = identifier;
		this.row = parent;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.MULTIVALUE_LIST;
	}

	@Override
	public List<String> getValue() {
		return element()
				.$$(By.tagName("span"))
				.texts();
	}

	@Override
	public ListMultivalue<W, RR, R> setValue(List<String> value) {
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
			if (value.isEmpty()) {
				return this;
			}
			element()
					.$("div[data-test-field-multivalue-icon=\"true\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();

			MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
			multivalueModal.setValues(identifier, value);
			return this;
		});
	}


	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}


	@Override
	public ListMultivalue<W, RR, R> checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			String placeholder = element()
					.$("div[data-text]")
					.getAttribute("data-text");
			expectedPlaceholder.accept(placeholder);
			return this;
		});
	}

	@Override
	public ListMultivalue<W, RR, R> checkColor(Consumer<String> checkColor) {
		return Allure.step("Getting color for field", step -> {
			String color = element().$(" p")
					.getAttribute("style");
			Pattern pattern = Pattern.compile("rgb\\((\\d{1,3}, \\d{1,3}, \\d{1,3})\\)");
			Matcher matcher = pattern.matcher(color);

			if (matcher.find()) {
				String rgb = matcher.group(1);
				String NewRGB = rgb.replaceAll(" ", "");
				String[] strings = NewRGB.split("[,\\\\s]+");
				int[] numbers = new int[strings.length];
				for (int i = 0; i < strings.length; i++) {
					numbers[i] = Integer.parseInt(strings[i]);
				}
				checkColor.accept(String.format(Constants.FormatForRgb, numbers[0], numbers[1], numbers[2]));
			}
			return this;
		});
	}

	@Override
	public ListMultivalue<W, RR, R> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		element();
		boolean isCheckReadOnly = !element().$$x(".//*[contains(@class, 'disabled')]").isEmpty();
		expectedReadOnly.accept(isCheckReadOnly);
		return this;
	}

	@Override
	public ListMultivalue<W, RR, R> checkRequired(Consumer<String> checkRequired) {
		element().$("div.ant-row.ant-form-item")
				.hover();
		String text = element().$(REQUIRED_MESSAGE)
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text();
		checkRequired.accept(text);
		return this;
	}

	public ListMultivalue<W, RR, R> checkValueList(Consumer<String> expectedValue) {
		expectedValue.accept(element().$("p").text());
		return this;
	}

	public ListMultivalue<W, RR, R> clearWithModal() {
		clearWithModal(false);
		return this;
	}

	public R row() {
		return row;
	}

	public ListMultivalue<W, RR, R> clearWithModal(boolean close) {
		element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
		multivalueModal.clear(close);
		return this;
	}

	public ListMultivalue<W, RR, R> clear() {
		setValue(List.of());
		return this;
	}

	public ListMultivalue<W, RR, R> setAllModal(boolean close) {
		element()
				.$("div[data-test-field-multivalue-icon=\"true\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		MultivalueModal<W> multivalueModal = new MultivalueModal<>(widget());
		multivalueModal.setValueAll(close);
		widget().getExpectations().getWaitAllFields();
		return this;
	}

	public ListMultivalue<W, RR, R> deleteValueFromField() {
		ElementsCollection selenideElements = element().$$x(".//*[contains(@class, 'anticon-close')]");
		selenideElements.get(selenideElements.size() - 1).click();
		return this;
	}
}
