package core.element.widget.tree;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.expectation.ExpectationPattern;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Row actions inside a tree popup (PickTreePopup, AssocTreePopup): the widget actions of the popup,
 * the row menu ("..."), inline editing of a row and the inline form of a row (antd extra row).
 */
public class TreePopupRows {

	private static final String ROW_ACTION_BUTTON = "button[data-test-widget-list-row-action]";

	private static final String ROW_ACTION_ITEM = "li[data-test-widget-list-row-action-item=\"true\"]";

	private static final String EXTRA_ROW = "-extra-row";

	private final SelenideElement modal;

	private final ExpectationPattern expectations;

	public TreePopupRows(SelenideElement modal, ExpectationPattern expectations) {
		this.modal = modal;
		this.expectations = expectations;
	}

	/** Clicks a widget action of the popup (e.g. "Add") by its text. */
	public TreePopupRows action(String text) {
		modal.$("div[class*='Operations__operations']").$$("button")
				.shouldHave(CollectionCondition.sizeGreaterThan(0), expectations.getTimeout())
				.findBy(Condition.text(text)).click();
		TreeNavigation.waitLoaded(modal, expectations);
		return this;
	}

	/** Visible tree rows of the popup (root rows and the expanded child rows). */
	public List<SelenideElement> rows() {
		return TreeNavigation.rows(modal).asFixedIterable().stream().toList();
	}

	public List<String> rowTexts() {
		return rows().stream().map(r -> r.getText().replace("\n", " | ")).toList();
	}

	public SelenideElement row(int index) {
		return TreeNavigation.rows(modal).shouldHave(CollectionCondition.sizeGreaterThan(index), expectations.getTimeout()).get(index);
	}

	/** Index of the first row whose text contains the value, -1 when there is no such row. */
	public int rowIndex(String text) {
		List<String> texts = rowTexts();
		for (int i = 0; i < texts.size(); i++) {
			if (texts.get(i).contains(text)) {
				return i;
			}
		}
		return -1;
	}

	/** Waits until a row whose text contains the value is shown; -1 after the widget timeout. */
	public int waitRow(String text) {
		long until = System.currentTimeMillis() + expectations.getTimeout().toMillis();
		int index = rowIndex(text);
		while (index < 0 && System.currentTimeMillis() < until) {
			Selenide.sleep(300);
			index = rowIndex(text);
		}
		return index;
	}

	/** The first input of the row in the edit mode. */
	public SelenideElement rowInput(int index) {
		return row(index).$("input:not([type=checkbox])").shouldBe(Condition.visible, expectations.getTimeout());
	}

	/** "Clear N filter(s)" of the popup filter panel, when a filter is applied (an AssocTreePopup opens filtered by the selected records). */
	public TreePopupRows clearFilters() {
		SelenideElement clear = modal.$$("a").findBy(Condition.text("filter"));
		if (clear.exists()) {
			clear.click();
			TreeNavigation.waitLoaded(modal, expectations);
		}
		return this;
	}

	/** Clicks the cell of the column (1-based, the first column is the tree column) to switch the row into the edit mode. */
	public TreePopupRows clickCell(int index, int column) {
		row(index).$$("td").get(column - 1).click();
		return this;
	}

	/** Items of the row menu "..." of the row; the menu is closed afterwards. */
	public List<String> rowMenuItems(int index) {
		openRowMenu(index);
		List<String> items = $$(ROW_ACTION_ITEM).filter(Condition.visible).texts();
		Selenide.executeJavaScript("document.body.click()");
		return items;
	}

	/** Chooses the item of the row menu "..." of the row. */
	public TreePopupRows rowMenu(int index, String item) {
		openRowMenu(index);
		$$(ROW_ACTION_ITEM).filter(Condition.visible).findBy(Condition.text(item)).click();
		TreeNavigation.waitLoaded(modal, expectations);
		return this;
	}

	/** The row menu "..." exists for the row (it is rendered on hover). */
	public boolean hasRowMenu(int index) {
		SelenideElement row = row(index);
		row.scrollIntoView("{block: \"center\"}");
		row.$$("td").last().hover();
		return modal.$(ROW_ACTION_BUTTON).is(Condition.visible, expectations.getTimeout());
	}

	private void openRowMenu(int index) {
		SelenideElement row = row(index);
		row.scrollIntoView("{block: \"center\"}");
		row.$$("td").last().hover();
		SelenideElement button = modal.$(ROW_ACTION_BUTTON);
		if (!button.is(Condition.visible)) {
			row.$$("td").first().hover();
		}
		button.shouldBe(Condition.visible, expectations.getTimeout()).click();
		$$(ROW_ACTION_ITEM).filter(Condition.visible).shouldHave(CollectionCondition.sizeGreaterThan(0), expectations.getTimeout());
	}

	/** The pencil of the row opens its inline form. */
	public TreePopupRows clickPencil(int index) {
		SelenideElement row = row(index);
		row.hover();
		row.$("i[aria-label='icon: edit']").shouldBe(Condition.visible, expectations.getTimeout()).click();
		extraRow(index).shouldBe(Condition.visible, expectations.getTimeout());
		return this;
	}

	/** The inline form (antd extra row) of the row, when it is open. */
	public SelenideElement extraRow(int index) {
		String key = row(index).getAttribute("data-row-key");
		return modal.$("tr[data-row-key=\"" + key + EXTRA_ROW + "\"]");
	}

	/** Input of the inline form of the row by the field title. */
	public SelenideElement extraRowInput(int index, String title) {
		return extraRow(index).$("div[data-test-field-title=\"" + title + "\"] input").shouldBe(Condition.visible, expectations.getTimeout());
	}

	/** Clicks a button of the inline form of the row (e.g. "Save", "Cancel"). */
	public TreePopupRows extraRowAction(int index, String text) {
		extraRow(index).$$("button").findBy(Condition.text(text)).click();
		TreeNavigation.waitLoaded(modal, expectations);
		return this;
	}

	/** Texts of the widget actions of the popup (e.g. "Add", "Save"). */
	public List<String> actionTexts() {
		return modal.$$("div[class*='Operations__operations'] button").asFixedIterable().stream().map(b -> b.getText().trim()).toList();
	}

	public boolean errorShown() {
		return Selenide.$("div[data-test-error-popup]").is(Condition.visible);
	}

}
