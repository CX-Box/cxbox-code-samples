package core.element.widget.field.type.inlinePickList;

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
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

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
		return element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text();
	}

	@Override
	public SELF setValue(String value) {
		return Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("PickList", value);
			clear();
			element().click();
			element()
					.$(valueTag())
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.setValue(value);
			widget().getExpectations().getWaitAllElements(element());
			getValues()
					.findBy(Condition.text(value))
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();

			$("div[class=\"ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft \"]")
					.$("ul[role=\"listbox\"]")
					.shouldNotBe(Condition.visible, widget().getExpectations().getTimeout());
			return (SELF) this;
		});
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

	protected ElementsCollection getValues() {
		return $("div[class=\"ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft \"]")
				.$("ul[role=\"listbox\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$(By.tagName("li"));
	}


	//TODO >> remake
//	public List<String> getOptions(String value) {
//		return Allure.step("Getting a list of options", step -> {
//			logTime(step);
//			element()
//					.$("div[class=\"ant-select-selection-selected-value\"]")
//					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
//					.click();
//			var strings = new ArrayList<String>(getValues().filter(Condition.matchText(value)).texts());
//			$("body").click();
//			$("div[class=\"ant-select-dropdown ant-select-dropdown--single ant-select-dropdown-placement-bottomLeft \"]")
//					.$("ul[role=\"listbox\"]")
//					.shouldNotBe(Condition.visible, widget().getExpectations().getTimeout());
//			log.info("value in list: " + strings);
//			return strings;
//		});
//	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting the Placeholder value", step -> {
			logTime(step);

			String text = element()
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout()).text();
			expectedPlaceholder.accept(text);
			return (SELF) this;
		});
	}

	public SELF clear() {
		return Allure.step("Clearing the field", step -> {
			logTime(step);
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
}
