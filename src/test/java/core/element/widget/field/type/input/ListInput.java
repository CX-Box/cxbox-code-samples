package core.element.widget.field.type.input;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowInline;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import java.util.Arrays;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$x;
import static core.element.widget.AbstractWidget.logTime;

public class ListInput<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		>
		extends Input<W, ListInput<W, RR, R>> implements

		ParentRow<R> {

	final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";
	final R row;
	final String name;


	public ListInput(String name, W widget, R row) {
		super(widget, name);
		this.row = row;
		this.name = name;
	}

	public R row() {
		return row;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.INPUT_LIST;
	}

	@Override
	public String getValue() {
		return getUniversalText(element().$(valueTag())
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout()));
	}

	@Override
	public ListInput<W, RR, R> setValue(String value) {
		element().$(fieldType().getValueTagFocused())
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
				.clear();
		element().$(fieldType().getValueTagFocused())
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
				.setValue(value)
				.shouldNot(Condition.empty)
				.sendKeys(Keys.TAB);
		return this;
	}

	@Override
	public SelenideElement element() {
		return row.element()
				.$$("div[data-test-field-type='" + fieldType().getType() + "'][data-test-field-title=\"" + name + "\"]")
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout());
	}

	@Override
	public ListInput<W, RR, R> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		return Allure.step("Checking the field for \"ReadOnly\"", step -> {
			logTime(step);
			Boolean disabled = element().shouldBe(Condition.exist)
					.$(fieldType().getValueTagFocused())
					.has(Condition.attribute("disabled"));
			expectedReadOnly.accept(disabled);
			return this;
		});
	}

	@Override
	public void drilldown(Consumer<String> consumer) {
		String url = WebDriverRunner.url();
		element().$(valueTag()).shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("span:has(a)")
				.click();
		Selenide.Wait().until(webDriver -> !webDriver.getCurrentUrl().contains(url));
		widget().getExpectations().getContextMenu();
		$x("//body").exists();
		consumer.accept(WebDriverRunner.url());
	}

	@Override
	public ListInput<W, RR, R> checkRequired(Consumer<String> consumer) {
		element().$("div.ant-row.ant-form-item")
				.hover();
		String text = element().$(REQUIRED_MESSAGE)
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text();
		consumer.accept(text);
		return this;
	}

	@Override
	public ListInput<W, RR, R> clear() {
		return Allure.step("Clearing the field", step -> {
			logTime(step);
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			// It needs for work on different OS
			int sizeText = ((String) getValue()).length() + 1;
			CharSequence[] sequence = new CharSequence[sizeText];
			Arrays.fill(sequence, 0, sizeText, Keys.BACK_SPACE);
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.sendKeys(sequence);
			return this;
		});
	}

	@Override
	public ListInput<W, RR, R> checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting placeholder the field", step -> {
			logTime(step);
			String actualPlaceholder = element()

					.shouldBe(Condition.exist)
					.$(valueTag())

					.getAttribute("placeholder");
			expectedPlaceholder.accept(actualPlaceholder);

			return this;
		});
	}

	public String valueTag() {
		if (row instanceof PlatformListRowInline ri) {
			if (ri.getIsEdit()) {
				return "input";
			}
		}
		return super.valueTag();
	}

	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}

}

