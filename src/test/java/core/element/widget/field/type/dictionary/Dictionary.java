package core.element.widget.field.type.dictionary;

import static core.element.PlatformApp.config;
import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.action.PageRequests;
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

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Dictionary<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Dictionary<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		DrillDown<W, String, String, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF>,
		DropDownWidthCheckable<W, String, SELF> {

	/**
	 * A field with forceActive sends its request at once after the change, the dependent fields change with the answer;
	 * a field without it costs this wait
	 */
	private static final Duration FORCE_ACTIVE_REQUEST_START = Duration.ofSeconds(1);

	protected final String MENU_OPTIONS ="div.ant-select-dropdown.ant-select-dropdown--single" +
			"[class*='ant-select-dropdown-placement-']";

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
		return StepReport.read(this, () -> {
			return element()
					.$(valueTag())
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.text();
		});
	}

	@Override
	public SELF setValue(String value) {
		return Allure.step(message("field.choose", getFieldIdentifier()), step -> {
			StepReport.value(value);
			// no clear: the chosen option replaces the value, and a clear sends an empty value first (one more forceActive
			// request, an error on a required field)
			open();
			var option = getOptionDictionary(value).shouldBe(Condition.visible, widget().getExpectations().getTimeout());
			PageRequests.runAndWaitDelayedRequests(option::click, FORCE_ACTIVE_REQUEST_START, widget().getExpectations().getOverTimeout());
			return (SELF) this;
		});
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
			return config().selectors.infoDictionaryValue;
		}
		return config().selectors.dictionaryValue;
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	public List<String> getOptions() {
		return Allure.step(message("field.options", getFieldIdentifier()), step -> {
			open();
			var options = getOptionsDictionary().texts();
			StepReport.list(options, "options");
			return options;
		});
	}

	public SELF checkOptions(Consumer<List<String>> checkOptions) {
		checkOptions.accept(getOptions());
		return (SELF) this;
	}

	@Override
	public SelenideElement dropDownOption() {
		return openList().$(By.tagName("li"));
	}

	private SelenideElement getOptionDictionary(String value) {
		return getOptionsDictionary()
				.find(Condition.match("check action name: " + value, b -> b.getText().equals(value)))
				.scrollIntoView("{block: \"center\"}");
	}

	private ElementsCollection getOptionsDictionary() {
		return openList()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$(By.tagName("li"));
	}

	/**
	 * The drop-down list that is open now: antd keeps the closed list of a field in the page hidden, so the first list of
	 * the page can be the list of a field filled before (a form with several dictionaries)
	 */
	private SelenideElement openList() {
		return $$(MENU_OPTIONS).findBy(Condition.visible);
	}

	/** A click on the select itself: the middle of the field is empty when the label is above the select in a tall row */
	private void open() {
		element().$(".ant-select-selection").click();
	}

	@Override
	public SELF clear() {
		if (!element().$("i[aria-label=\"icon: close-circle\"]").exists()) {
			return (SELF) this;
		}
		return StepReport.service(message("field.clearOld", getFieldIdentifier()), () -> {
			element()
					.$("i[aria-label=\"icon: close-circle\"]")
					.hover()
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.click();
			return (SELF) this;
		});
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step(message("field.placeholder", getFieldIdentifier()), step -> {
			String text = element()
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.text();
			expectedPlaceholder.accept(text);
			return (SELF) this;
		});
	}
}
