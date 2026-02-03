package core.element.widget.field.type.pickList;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Preconditions;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
public class PickListModal<W extends AbstractWidget<ExpectationPattern, W>> {
	private final W widget;

	private final SelenideElement modal;

	public PickListModal(W widget) {
		this.widget = widget;
		this.modal = $("div[data-test-widget-type=\"PickListPopup\"]")
				.shouldBe(visible, widget.getExpectations().getTimeout())
				.shouldBe(exist, widget.getExpectations().getTimeout());
		;
	}

	public void setValue(String name, String value) {
		while (true) {
			boolean isFounded = setValuesOnCurrentPage(name, value);
			if (isFounded) {
				break;
			}
			if (isLastPage()) {
				close();
				break;
			}
			pressRight(1);
		}
		$("div[data-test-widget-type=\"PickListPopup\"]").shouldNotBe(visible, widget.getExpectations().getTimeout());
	}

	private boolean setValuesOnCurrentPage(String columnName, String value) {
		widget.getExpectations().getWaitAllElements(this.modal);
		Optional<SelenideElement> first = modal.shouldBe(visible, widget.getExpectations().getTimeout())
				.$$(By.cssSelector("table > tbody > tr"))
				.shouldBe(CollectionCondition.sizeGreaterThan(0))
				.stream()
				.filter(r -> getColumnByName(columnName, r).getText().equals(value))
				.findFirst();
		if (first.isPresent()) {
			first.ifPresent(SelenideElement::click);
			return true;
		}
		return false;
	}

	private boolean isLastPage() {
		return this.modal
				.$("li[title=\"Next Page\"][aria-disabled=\"true\"]")
				.is(Condition.anyOf(Condition.visible, Condition.enabled));
	}

	private void pressRight(int number) {
		Allure.step("Clicking on the button \"Right\"", step -> {
			logTime(step);
			step.parameter("Number of clicks", number);

			for (int i = 0; i < number; i++) {
				if (getPages() > 1) {
					this.modal.$("i[class=\"anticon anticon-right\"]")
							.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
							.click();
				}

			}
		});

	}

	private int getPages() {
		return Allure.step("Getting the number of pages in a pagination", step -> {
			logTime(step);

			return modal.$("div[data-test-widget-list-pagination=\"true\"]")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.$$("li[tabindex=\"0\"]").size();
		});
	}

	private void close() {
		Allure.step("Clicking on the button Close", step -> {
			logTime(step);

			getSubmitButton()
					.click();
		});
	}

	private SelenideElement getSubmitButton() {
		return this.modal
				.$("button[data-test-widget-list-close=\"true\"]")
				.shouldBe(Condition.visible, widget.getExpectations().getTimeout());
	}

	private SelenideElement getColumnByName(String columnName, SelenideElement row) {
		for (var i = 1; i <= widget.getExpectations().getRetryNumber(); i++) {
			try {
				SelenideElement column = row.$$(By.tagName("td"))
						.shouldBe(CollectionCondition.sizeGreaterThan(0))
						.get(getColumnNumber(columnName, getColumnNames()))
						.shouldBe(Condition.visible, widget.getExpectations().getTimeout());
				if (column.exists()) {
					return column;
				}
			} catch (StaleElementReferenceException ex) {
				log.error("The element is outdated. Attempt number: {}", i, ex);
			}
		}
		throw new RuntimeException("Time is over...");
	}

	private int getColumnNumber(String columnName, List<String> columnNames) {
		widget.getExpectations().getWaitAllElements(modal);
		Preconditions.checkNotNull(columnNames, "columnNames must not be null");
		int number = columnNames.indexOf(columnName);
		Preconditions.checkArgument(number >= 0, "No column with name '%s' found", columnName);
		return number;
	}

	private List<String> getColumnNames() {
		for (int i = 1; i < widget.getExpectations().getRetryNumber(); i++) {
			try {
				return this.modal
						.$(By.tagName("table"))
						.$(By.tagName("thead"))
						.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
						.$$(By.tagName("th"))
						.stream()
						.map(th -> th.getAttribute("data-test-widget-list-header-column-title"))
						.collect(Collectors.toList());
			} catch (StaleElementReferenceException ex) {
				log.error("Stale element reference exception occurred while getting column names. Retrying...{}", i, ex);
			}
		}
		throw new RuntimeException("Time is over...");
	}

	private SelenideElement getSelectionRow(SelenideElement row) {
		return row.$(By.cssSelector("td[class='ant-table-selection-column']"))
				.$(By.tagName("input"))
				.shouldBe(Condition.enabled);
	}
}
