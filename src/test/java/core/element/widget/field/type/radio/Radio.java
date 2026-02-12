package core.element.widget.field.type.radio;

import com.codeborne.selenide.CollectionCondition;
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
import core.element.widget.info.PlatformInfoWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class Radio<W extends AbstractWidget<ExpectationPattern, W>, SELF extends Radio<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, Radio<W, SELF>> implements
		Clear<W, String, Radio<W, SELF>>,
		ColorCheckable<W, String, String, Radio<W, SELF>>,
		PlaceholderCheckable<W, String, String, Radio<W, SELF>>,
		ReadOnlyCheckable<W, String, Boolean, Radio<W, SELF>>,
		ValueCheckable<W, String, Radio<W, SELF>>,
		DrillDownSupportCheckable<W, String, Boolean, Radio<W, SELF>>,
		RequiredCheckable<W, String, String, Radio<W, SELF>>,
		MaxInputCheckable<W, String, Integer, Radio<W, SELF>> {

	private final String title;

	public Radio(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.RADIO;
	}

	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);

			if (valueTag().contains("span")) {
				return getUniversalText(element().$(valueTag()));
			}
			log.info(valueTag());
			int size = getContainersActions().size();
			for (int i = 0; i < size; i++) {
				if (getContainersActions().get(i).$(valueTag()).isSelected()) {
					return getContainersActions().get(i).text();
				}
			}
			return null;
		});
	}

	@Override
	public Radio<W, SELF> setValue(String value) {

		Allure.step("Setting the " + value + " in the field", step -> {
			logTime(step);
			step.parameter("Radio name", value);

			getRadio(value)
					.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
					.click();
			getRadio(value)
					.isSelected();
		});
		return this;
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}


	/**
	 * Getting a value from a field
	 *
	 * @return HashMap(String, Boolean)
	 */

	public Map<String, Boolean> getValues() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);

			HashMap<String, Boolean> values = new HashMap<>();
			List<String> list = getContainersActions().texts();
			for (int i = 0; i < list.size(); i++) {
				String text = getContainersActions().get(i).text();
				boolean isSelected = getContainersActions().get(i).$(valueTag()).isSelected();
				values.put(text, isSelected);
			}
			return values;
		});
	}

	public SELF checkOption(Consumer<Map<String, Boolean>> options) {
		Allure.step("Check radio options", step -> {
			logTime(step);
			options.accept(getValues());

		});
		return (SELF) this;
	}

	private ElementsCollection getContainersActions() {
		return element()
				.$$(By.tagName("label"))
				.shouldHave(CollectionCondition.sizeGreaterThan(0));
	}

	private SelenideElement getRadio(String nameRadio) {
		return getContainersActions().find(Condition.match("check action name: " + nameRadio, b -> b.getText().equals(nameRadio)));
	}

	@Override
	public String valueTag() {
		if (widget() instanceof PlatformInfoWidget) {
			return "span[class*='ReadOnlyField__readOnlyField']";
		}
		return super.valueTag();
	}
}
