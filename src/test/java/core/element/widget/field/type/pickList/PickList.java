package core.element.widget.field.type.pickList;

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

import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.exist;
import static core.element.widget.AbstractWidget.logTime;

public class PickList<W extends AbstractWidget<ExpectationPattern, W>, SELF extends PickList<W, SELF>> extends AbstractFieldImpl<ExpectationPattern, W, String, SELF> implements
		Clear<W, String, SELF>,
		ColorCheckable<W, String, String, SELF>,
		PlaceholderCheckable<W, String, String, SELF>,
		ReadOnlyCheckable<W, String, Boolean, SELF>,
		ValueCheckable<W, String, SELF>,
		DrillDownSupportCheckable<W, String, Boolean, SELF>,
		RequiredCheckable<W, String, String, SELF>,
		MaxInputCheckable<W, String, Integer, SELF> {

	private final String title;

	public PickList(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
		this.title = title;
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.PICKLIST;
	}

	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return element()
					.$(valueTag())
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.getText();
		});

	}

	@Override
	public SELF setValue(String value) {
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
					.$("i[data-test-field-picklist-popup=\"true\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();

			PickListModal<W> multivalueModal = new PickListModal<>(widget());
			multivalueModal.setValue(title, value);
			return (SELF) this;
		});
	}

	public SELF setValue(String columnName, String value) {
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
					.$("i[data-test-field-picklist-popup=\"true\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();

			PickListModal<W> multivalueModal = new PickListModal<>(widget());
			multivalueModal.setValue(columnName, value);
			return (SELF) this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public SELF clear() {
		Allure.step("Clearing the field", step -> {
			logTime(step);

			element()
					.$("i[data-test-field-picklist-clear=\"true\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout()).click();
		});
		return (SELF) this;
	}

	@Override
	public String valueTag() {
		if (PlatformInfoWidget.class.isAssignableFrom(widget().getClass())) {
			return "span[class*=\"ReadOnlyField\"]";
		}
		return super.valueTag();
	}

	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			System.out.println("Checking placeholder " + valueTag());
			String actualPlaceholder = element()
					.shouldBe(Condition.exist)
					.$("div[class=\"ant-select-selection__placeholder\"]")
					.text();
			expectedPlaceholder.accept(actualPlaceholder);
		});
		return (SELF) this;
	}

	@Override
	public SELF checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		expectedReadOnly.accept(element().find(("div[class*='ant-select-disabled']")).exists());
		return (SELF) this;
	}
}
