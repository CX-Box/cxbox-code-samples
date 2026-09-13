package core.element.widget.tree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.realization.form.tree.PlatformTreePopupWidgetInlineForm;
import core.element.widget.list.realization.inline.tree.PlatformTreePopupWidgetInline;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

/**
 * Row actions inside a tree popup. Kept for the tests written against it; every method delegates
 * to the standard Tree API of the popup widget.
 *
 * @deprecated use {@code popup.tree()} / {@code popup.treeInlineForm()} and the same calls as for a Tree widget:
 * {@code tree.actions().click("Add")}, {@code tree.rows().row(0).input("Custom Field").setValue(v)},
 * {@code row.burgerAction("Save").click()}, {@code tree.rows().row(0).clickPencil()}, {@code tree.headers().clearFilters()}.
 */
@Deprecated(since = "CXBOX-1341", forRemoval = true)
public class TreePopupRows {

	private static final String ROW_ACTION_BUTTON = "button[data-test-widget-list-row-action]";

	private static final String ROW_ACTION_ITEM = "li[data-test-widget-list-row-action-item=\"true\"]";

	private final SelenideElement modal;

	private final ExpectationPattern expectations;

	private final PlatformTreePopupWidgetInline tree;

	private final PlatformTreePopupWidgetInlineForm treeInlineForm;

	public TreePopupRows(SelenideElement modal, ExpectationPattern expectations, TypeWidget type) {
		this.modal = modal;
		this.expectations = expectations;
		String name = modal.getAttribute("data-test-widget-name");
		this.tree = new PlatformTreePopupWidgetInline(type, name);
		this.treeInlineForm = new PlatformTreePopupWidgetInlineForm(type, name);
	}

	/** @deprecated use {@code tree.actions().click(text)} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows action(String text) {
		tree.actions().click(text);
		return this;
	}

	/** @deprecated use {@code tree.rows().streamCurrentPage()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public List<SelenideElement> rows() {
		return tree.rows().streamCurrentPage().map(r -> r.element()).toList();
	}

	/** @deprecated use {@code tree.rows().streamCurrentPage().map(r -> r.element().getText())} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public List<String> rowTexts() {
		return rows().stream().map(r -> r.getText().replace("\n", " | ")).toList();
	}

	/** @deprecated use {@code tree.rows().row(index).element()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public SelenideElement row(int index) {
		return tree.rows().row(index).element();
	}

	/** @deprecated search the row with {@code tree.rows().streamCurrentPage()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public int rowIndex(String text) {
		List<String> texts = rowTexts();
		for (int i = 0; i < texts.size(); i++) {
			if (texts.get(i).contains(text)) {
				return i;
			}
		}
		return -1;
	}

	/** @deprecated wait with {@code tree.waitLoaded()} and search the row with {@code tree.rows().streamCurrentPage()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public int waitRow(String text) {
		long until = System.currentTimeMillis() + expectations.getTimeout().toMillis();
		int index = rowIndex(text);
		while (index < 0 && System.currentTimeMillis() < until) {
			Selenide.sleep(300);
			index = rowIndex(text);
		}
		return index;
	}

	/** @deprecated use {@code tree.rows().row(index).input(title)} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public SelenideElement rowInput(int index) {
		return row(index).$("input:not([type=checkbox])").shouldBe(Condition.visible, expectations.getTimeout());
	}

	/** @deprecated use {@code tree.headers().clearFilters()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows clearFilters() {
		tree.headers().clearFilters();
		return this;
	}

	/** @deprecated use {@code tree.rows().clickRow(index)} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows clickCell(int index, int column) {
		row(index).$$("td").get(column - 1).click();
		return this;
	}

	/** @deprecated use {@code tree.rows().row(index).burgerAction(item)} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public List<String> rowMenuItems(int index) {
		openRowMenu(index);
		List<String> items = $$(ROW_ACTION_ITEM).filter(Condition.visible).texts();
		Selenide.executeJavaScript("document.body.click()");
		return items;
	}

	/** @deprecated use {@code tree.rows().row(index).burgerAction(item).click()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows rowMenu(int index, String item) {
		tree.rows().row(index).burgerAction(item).click();
		tree.waitLoaded();
		return this;
	}

	/** @deprecated use {@code tree.rows().row(index).burgerAction(item)} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
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
		modal.$(ROW_ACTION_BUTTON).shouldBe(Condition.visible, expectations.getTimeout()).click();
	}

	/** @deprecated use {@code treeInlineForm.rows().row(index).clickPencil()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows clickPencil(int index) {
		treeInlineForm.rows().row(index).clickPencil();
		return this;
	}

	/** @deprecated use the form returned by {@code treeInlineForm.rows().row(index).clickPencil()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public SelenideElement extraRow(int index) {
		return treeInlineForm.rows().row(index).clickPencil().element();
	}

	/** @deprecated use {@code form.input(title)} of the form returned by {@code clickPencil()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public SelenideElement extraRowInput(int index, String title) {
		return treeInlineForm.rows().row(index).clickPencil().input(title).element();
	}

	/** @deprecated use {@code form.actions().action(text).click()} of the form returned by {@code clickPencil()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows extraRowAction(int index, String text) {
		treeInlineForm.rows().row(index).clickPencil().actions().action(text).click();
		tree.waitLoaded();
		return this;
	}

	/** @deprecated use {@code tree.actions()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public List<String> actionTexts() {
		return modal.$$("div[class*='Operations__operations'] button").asFixedIterable().stream().map(b -> b.getText().trim()).toList();
	}

	/** @deprecated use {@code tree.errorPopup()} */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public boolean errorShown() {
		return Selenide.$("div[data-test-error-popup]").is(Condition.visible);
	}

}
