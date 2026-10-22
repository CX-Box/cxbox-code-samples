package core.element.widget.field.type.inlinePickList;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.action.PageRequests;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.*;
import core.element.widget.field.attribute.custom.Clear;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class InlinePickList<W extends AbstractWidget<ExpectationPattern, W>, SELF extends InlinePickList<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF> {

	/**
	 * A field with forceActive sends its request in the click on the option, the dependent fields change with the answer;
	 * a field without it costs only this short look for the request
	 */
	private static final Duration FORCE_ACTIVE_REQUEST_START = Duration.ofMillis(200);

	private final String title;

	public InlinePickList(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.INLINE_PICK_LIST;
	}

	@Override
	public String getValue() {
		return StepReport.read(this, () -> element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text());
	}

	@Override
	public SELF setValue(String value) {
		return Allure.step(message("field.choose", getFieldIdentifier()), step -> {
			StepReport.value(value);
			clear();
			// the field is looked up once: each look up waits for the widget
			var field = element();
			field.click();
			field.$(valueTag())
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.setValue(value);
			widget().getExpectations().getWaitAllElements($("body"));
			// the dropdown is found before the choice: a field with forceActive is drawn again after the choice and removes
			// its dropdown from the page, so a dropdown found after the choice never comes
			var dropdown = findDropdownElementByElementAriaControlsId();
			var option = dropdown.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.$$(By.tagName("li"))
					.findBy(Condition.text(value))
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout());
			PageRequests.runAndWaitDelayedRequests(option::click, FORCE_ACTIVE_REQUEST_START, widget().getExpectations().getOverTimeout());
			dropdown.shouldNotBe(Condition.visible, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
	}


	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return parentElement().$$(fieldSelector("title", title))
				.get(0)
				.scrollIntoView("{block: \"center\"}")
				.shouldBe(Condition.interactable, widget().getExpectations().getTimeout());

	}

	protected SelenideElement parentElement() {
		return widget().element();
	}

	protected ElementsCollection getValues() {
		return findDropdownElementByElementAriaControlsId()
				.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
				.$$(By.tagName("li"));

	}

	public List<String> getOptions() {
		return Allure.step(message("field.options", getFieldIdentifier()), step -> {
			element()
					.$("div[class=\"ant-select-selection-selected-value\"]")
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			List<String> strings = getValues().texts();
			return strings;
		});
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step(message("field.placeholder", getFieldIdentifier()), step -> {

			String text = element()
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout()).text();
			expectedPlaceholder.accept(text);
			return (SELF) this;
		});
	}

	public SELF clear() {
		return StepReport.service(message("field.clear", getFieldIdentifier()), () -> {
			boolean iconClear = element()
					.$("span[class=\"ant-select-selection__clear\"]")
					.is(Condition.exist);
			if (iconClear) {
				element()
						.$("span[class=\"ant-select-selection__clear\"]")
						.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
						.click();
			}
			return (SELF) this;
		});
	}

	private SelenideElement findDropdownElementByElementAriaControlsId() {
		var dropdownId = element()
				.$("div.ant-select-selection.ant-select-selection--single")
				.getAttribute("aria-controls");
		return $("div[id='" + dropdownId + "']")
				.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
				.$("ul[role=\"listbox\"]");
	}

}
