package core.element.widget.field.type.pickTree;

import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Preconditions;
import core.element.widget.AbstractWidget;
import core.element.widget.list.WidgetSettings;
import core.element.widget.tree.TreeNavigation;
import core.element.widget.tree.TreePopupRows;
import core.exception.InvalidStateException;
import core.expectation.ExpectationPattern;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Optional;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

/**
 * PickTreePopup: a value is picked by clicking the row; nodes are expanded until the value is found.
 */
public class PickTreeModal<W extends AbstractWidget<ExpectationPattern, W>> {

	private final W widget;

	private final SelenideElement modal;

	public PickTreeModal(W widget) {
		this.widget = widget;
		this.modal = $("div[data-test-widget-type=\"PickTreePopup\"]")
				.shouldBe(visible, widget.getExpectations().getTimeout())
				.shouldBe(exist, widget.getExpectations().getTimeout());
	}

	public SelenideElement element() {
		return modal;
	}

	/** The visible dialog box of the popup, e.g. for screenshots. */
	public SelenideElement dialog() {
		return modal.$(".ant-modal");
	}

	/** Widget actions and row actions inside the popup. */
	public TreePopupRows rowActions() {
		return new TreePopupRows(modal, widget.getExpectations());
	}

	/** Full text search of the popup (options.fullTextSearch). */
	public PickTreeModal<W> fullTextSearch(String text) {
		TreeNavigation.fullTextSearch(modal, text, widget.getExpectations());
		return this;
	}

	/** Gear menu of the popup: search mode, restore path, page size. */
	public WidgetSettings<W> settings() {
		return new WidgetSettings<>(widget, modal, widget.getExpectations());
	}

	/** Expands the first collapsed node or loads the first "More" page. */
	public boolean loadNext() {
		return TreeNavigation.loadNext(modal, widget.getExpectations());
	}

	public void close() {
		modal.$("button[data-test-widget-list-cancel], button[data-test-widget-list-close], button.ant-modal-close").click();
		modal.shouldNotBe(visible, widget.getExpectations().getTimeout());
	}

	public void setValue(String columnName, String value) {
		while (!clickRow(columnName, value)) {
			if (!TreeNavigation.loadNext(modal, widget.getExpectations())) {
				throw new InvalidStateException("No value " + value + " found for the field " + columnName);
			}
		}
		modal.shouldNotBe(visible, widget.getExpectations().getTimeout());
	}

	private boolean clickRow(String columnName, String value) {
		widget.getExpectations().getWaitAllElements(modal);
		List<String> columns = TreeNavigation.columnNames(modal, widget.getExpectations());
		int number = columns.indexOf(columnName);
		Preconditions.checkArgument(number >= 0, "No column with name '%s' found", columnName);
		Optional<SelenideElement> row = TreeNavigation.rows(modal).stream()
				.filter(r -> r.$$(By.tagName("td")).get(number).getText().equals(value))
				.findFirst();
		row.ifPresent(SelenideElement::click);
		return row.isPresent();
	}

}
