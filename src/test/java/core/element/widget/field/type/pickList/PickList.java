package core.element.widget.field.type.pickList;

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

	/**
	 * @deprecated Do not use.
	 * Use {@link #setValue(String, String)} instead.
	 */
	@Deprecated
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
			openPopupIcon();

			pickInModal(title, value);
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
			openPopupIcon();

			pickInModal(columnName, value);
			return (SELF) this;
		});
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	protected String popupIconSelector() {
		return "i[data-test-field-picklist-popup=\"true\"]";
	}

	protected String clearIconSelector() {
		return "i[data-test-field-picklist-clear=\"true\"]";
	}

	/** Clicks the popup icon; the first click may only focus the field, so the click is repeated until a popup is shown. */
	public void openPopupIcon() {
		SelenideElement icon = element()
				.$(popupIconSelector())
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		SelenideElement modal = Selenide.$("div[data-test-widget-type$=\"Popup\"] .ant-modal");
		for (int attempt = 0; attempt < 3 && !modal.is(Condition.visible); attempt++) {
			icon.click();
			modal.is(Condition.visible, widget().getExpectations().getTimeout());
		}
	}

	protected void pickInModal(String columnName, String value) {
		new PickListModal<>(widget()).setValue(columnName, value);
	}

	/** Opens the PickListPopup of the field and returns it for step-by-step checks (a pickTree field opens its tree popup with {@code openPopup()}). */
	public PickListModal<W> openListPopup() {
		widget().getExpectations().getWaitAllFields();
		openPopupIcon();
		return new PickListModal<>(widget());
	}

	@Override
	public SELF clear() {
		Allure.step("Clearing the field", step -> {
			logTime(step);

			element()
					.$(clearIconSelector())
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
