package core.element.widget.field.type.pickList;

import static core.util.i18n.CoreMessageSource.message;
import static core.element.PlatformApp.config;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Preconditions;
import core.element.widget.AbstractWidget;
import core.element.widget.list.realization.form.list.PlatformListPopupWidgetInlineForm;
import core.element.widget.list.realization.inline.list.PlatformListPopupWidgetInline;
import core.element.widget.type.PlatformTypeWidgets;
import core.exception.InvalidStateException;
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

@Slf4j
public class PickListModal<W extends AbstractWidget<ExpectationPattern, W>> {

	/** The next arrow of the pagination without page numbers (ArrowPagination) */
	private static final String ARROW_NEXT = "[data-test-widget-list-pagination-next=\"true\"]";

	private final W widget;

	private final SelenideElement modal;

	private String name;

	public PickListModal(W widget) {
		this.widget = widget;
		this.modal = $("div" + config().selectors.widgetTypeAttribute(PlatformTypeWidgets.PICK_LIST_POPUP.getType()))
				.shouldBe(visible, widget.getExpectations().getTimeout())
				.shouldBe(exist, widget.getExpectations().getTimeout());
		name();
	}

	public SelenideElement element() {
		return modal;
	}

	/** The visible dialog box of the popup, e.g. for screenshots. */
	public SelenideElement dialog() {
		return modal.$(".ant-modal-content");
	}

	/** Title of the popup; empty when the widget has no title. */
	public String title() {
		SelenideElement title = dialog().$(".ant-modal-title");
		return title.exists() ? title.getText() : "";
	}

	/** The list of the popup with the standard List API: actions, rows, headers, settings. */
	public PlatformListPopupWidgetInline list() {
		return new PlatformListPopupWidgetInline(PlatformTypeWidgets.PICK_LIST_POPUP, name());
	}

	/** The list of the popup whose rows open the inline form (options.create.widget / options.edit.widget). */
	public PlatformListPopupWidgetInlineForm listInlineForm() {
		return new PlatformListPopupWidgetInlineForm(PlatformTypeWidgets.PICK_LIST_POPUP, name());
	}

	/** The widget name is read once: the popup may be closed by the time the widget of the popup is asked for. */
	private String name() {
		if (name == null) {
			name = modal.getAttribute("data-test-widget-name");
		}
		return name;
	}

	public void setValue(String name, String value) {
		while (true) {
			boolean isFounded = setValuesOnCurrentPage(name, value);
			if (isFounded) {
				break;
			}
			if (isLastPage()) {
				throw new InvalidStateException("No value " + value + " found for the field" + name);
			}
			pressRight(1);
		}
		$("div" + config().selectors.widgetTypeAttribute(PlatformTypeWidgets.PICK_LIST_POPUP.getType())).shouldNotBe(visible, widget.getExpectations().getTimeout());
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
		var arrow = this.modal.$(ARROW_NEXT);
		if (arrow.exists()) {
			return !arrow.isEnabled();
		}
		return this.modal
				.$("li.ant-pagination-next[aria-disabled=\"true\"]")
				.is(Condition.anyOf(Condition.visible, Condition.interactable));
	}

	private void pressRight(int number) {
		Allure.step(message("modal.nextPage"), step -> {
			step.parameter(message("parameter.clicks"), number);

			for (int i = 0; i < number; i++) {
				var arrow = this.modal.$(ARROW_NEXT);
				if (arrow.exists()) {
					// no page number to wait for: the next page is open when its first row is another one
					var rows = this.modal.$$(By.cssSelector("table > tbody > tr"));
					var firstRow = rows.first().getAttribute("data-row-key");
					arrow.shouldBe(Condition.enabled, widget.getExpectations().getTimeout()).click();
					rows.first().shouldNotHave(Condition.attribute("data-row-key", firstRow), widget.getExpectations().getTimeout());
				} else if (getPages() > 1) {
					var page = Integer.parseInt(this.modal.$("li.ant-pagination-item-active").getAttribute("title"));
					this.modal.$("i[class=\"anticon anticon-right\"]")
							.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
							.click();
					// the next page is open when its number is active, as the table waits for its page
					this.modal.$("li.ant-pagination-item-active[title=\"" + (page + 1) + "\"]")
							.should(Condition.exist, widget.getExpectations().getTimeout());
				}

			}
		});

	}

	private int getPages() {
		return Allure.step(message("modal.pages"), step -> {

			return modal.$("div[data-test-widget-list-pagination=\"true\"]")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.$$("li[tabindex=\"0\"]").size();
		});
	}

	/** Closes the popup: the Close button when the widget has one, otherwise the cross of the dialog. */
	public void close() {
		Allure.step(message("modal.close"), step -> {
			modal.$("button[data-test-widget-list-close=\"true\"], button.ant-modal-close")
					.shouldBe(visible, widget.getExpectations().getTimeout())
					.click();
		});
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
				.shouldBe(Condition.interactable);
	}
}
