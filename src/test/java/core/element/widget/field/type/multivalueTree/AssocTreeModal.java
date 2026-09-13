package core.element.widget.field.type.multivalueTree;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ListSizeMismatch;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.StaleElementReferenceException;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.list.realization.form.tree.PlatformTreePopupWidgetInlineForm;
import core.element.widget.list.realization.inline.tree.PlatformTreePopupWidgetInline;
import core.element.widget.tree.TreePopupRows;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.field.type.multivalue.MultivalueModal;
import core.element.widget.list.WidgetSettings;
import core.element.widget.tree.TreeNavigation;
import core.expectation.ExpectationPattern;

import java.util.List;

/**
 * AssocTreePopup: the same modal as AssocListPopup, but rows are loaded by expanding nodes instead of paging.
 */
public class AssocTreeModal<W extends AbstractWidget<ExpectationPattern, W>> extends MultivalueModal<W> {

	public AssocTreeModal(W widget) {
		super(widget, POPUP_TYPE);
		name();
	}

	private static final String POPUP_TYPE = "AssocTreePopup";

	private String name;

	/** The popup container, whether it is opened or not. */
	public static SelenideElement modalElement() {
		return Selenide.$("div[data-test-widget-type=\"" + POPUP_TYPE + "\"]");
	}

	@Override
	public void setValues(String name, List<String> values) {
		widget.getExpectations().getWaitAllElements(modal);
		clearFilters();
		TreeNavigation.loadWholeTree(modal, widget.getExpectations());
		setValuesOnCurrentPage(name, values, true);
		close();
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

	/** Expands the first collapsed node or loads the first "More" page. */
	public boolean loadNext() {
		return TreeNavigation.loadNext(modal, widget.getExpectations());
	}

	/** The tree of the popup with the standard Tree API: actions, rows, headers, settings. */
	public PlatformTreePopupWidgetInline tree() {
		return new PlatformTreePopupWidgetInline(PlatformTypeWidgets.ASSOC_TREE_POPUP, name());
	}

	/** The tree of the popup whose rows open the inline form (options.create.widget / options.edit.widget). */
	public PlatformTreePopupWidgetInlineForm treeInlineForm() {
		return new PlatformTreePopupWidgetInlineForm(PlatformTypeWidgets.ASSOC_TREE_POPUP, name());
	}

	/** @deprecated use {@link #tree()} / {@link #treeInlineForm()} with the standard Tree API */
	@Deprecated(since = "CXBOX-1341", forRemoval = true)
	public TreePopupRows rowActions() {
		return new TreePopupRows(modal, widget.getExpectations(), PlatformTypeWidgets.ASSOC_TREE_POPUP);
	}

	/** The widget name is read once: the popup may be closed by the time the widget of the popup is asked for. */
	private String name() {
		if (name == null) {
			name = modal.getAttribute("data-test-widget-name");
		}
		return name;
	}

	/** Row of the popup by the value of the column. */
	public SelenideElement row(String columnName, String value) {
		TreeNavigation.loadWholeTree(modal, widget.getExpectations());
		return getRowByValue(columnName, value);
	}

	private SelenideElement getRowByValue(String columnName, String value) {
		TreeNavigation.waitLoaded(modal, widget.getExpectations());
		for (int i = 1; ; i++) {
			try {
				return rows().stream()
						.filter(r -> getColumnByName(columnName, r).getText().equals(value))
						.findFirst()
						.orElseThrow(() -> new IllegalStateException("No row with " + columnName + " = " + value + " among "
								+ rows().stream().map(r -> getColumnByName(columnName, r).getText()).collect(java.util.stream.Collectors.toList())));
			} catch (RuntimeException | UIAssertionError e) {
				// the tree re-rendered while the rows were read (e.g. after a search): read once more
				if (!(isStale(e) || e instanceof ListSizeMismatch) || i >= widget.getExpectations().getRetryNumber()) {
					throw e;
				}
				Selenide.sleep(300);
			}
		}
	}

	/** Selenide wraps the stale element error of the driver: the cause chain is checked. A row without cells is a row being re-rendered. */
	private static boolean isStale(Throwable e) {
		for (Throwable t = e; t != null; t = t.getCause()) {
			if (t instanceof StaleElementReferenceException) {
				return true;
			}
		}
		return false;
	}

	/** Toggles the checkbox of the row; the row must be loaded already. */
	public AssocTreeModal<W> toggle(String columnName, String value) {
		getSelectionRow(getRowByValue(columnName, value)).click();
		widget.getExpectations().getWaitAllElements(modal);
		return this;
	}

	public boolean isChecked(String columnName, String value) {
		return getRowByValue(columnName, value).$(TreeNavigation.ROW_SELECT_SELECTOR).isSelected();
	}

	/** Dimmed checkbox: the row is covered by the selection of its parent. */
	public boolean isImplicitlyChecked(String columnName, String value) {
		String cls = getRowByValue(columnName, value).$(TreeNavigation.ROW_SELECT_SELECTOR).parent().parent().getAttribute("class");
		return cls != null && cls.contains("implicitCheckboxMuted");
	}

	public boolean isIndeterminate(String columnName, String value) {
		String cls = getRowByValue(columnName, value).$(TreeNavigation.ROW_SELECT_SELECTOR).parent().getAttribute("class");
		return cls != null && cls.contains("ant-checkbox-indeterminate");
	}

	public boolean isSelectDisabled(String columnName, String value) {
		return getRowByValue(columnName, value).$(TreeNavigation.ROW_SELECT_SELECTOR).has(Condition.attribute("disabled"));
	}

	/** Expands the node row of the popup. */
	public AssocTreeModal<W> expand(String columnName, String value) {
		getRowByValue(columnName, value).$(TreeNavigation.COLLAPSED_ROW_ICON).click();
		widget.getExpectations().getWaitAllElements(modal);
		return this;
	}

	/** Values of the column of the loaded child rows of the node. */
	public List<String> children(String columnName, String value) {
		String key = getRowByValue(columnName, value).getAttribute(TreeNavigation.ROW_ID_ATTRIBUTE);
		return TreeNavigation.childRows(modal, key).stream()
				.map(r -> getColumnByName(columnName, r).getText())
				.collect(java.util.stream.Collectors.toList());
	}

	public boolean hasMore(String columnName, String value) {
		String key = getRowByValue(columnName, value).getAttribute(TreeNavigation.ROW_ID_ATTRIBUTE);
		return TreeNavigation.moreButton(modal, key).exists();
	}

	/** Full text search of the popup (options.fullTextSearch). */
	public AssocTreeModal<W> fullTextSearch(String text) {
		TreeNavigation.fullTextSearch(modal, text, widget.getExpectations());
		return this;
	}

	/** Gear menu of the popup: search mode, restore path, page size. */
	public WidgetSettings<W> settings() {
		return new WidgetSettings<>(widget, modal, widget.getExpectations());
	}

	/** Clicks "Clear N filter(s)" of the popup (the popup opens filtered by the selected ids). */
	public AssocTreeModal<W> clearFilters() {
		SelenideElement clear = modal.$$("a").findBy(Condition.text("Clear"));
		if (clear.exists()) {
			clear.click();
			Selenide.sleep(300);
			TreeNavigation.waitLoaded(modal, widget.getExpectations());
		}
		return this;
	}

	/** The confirmation dialog shown by options.tree.confirms. */
	public TreeConfirm confirm() {
		return new TreeConfirm(widget.getExpectations());
	}

	public AssocTreeModal<W> closeModal() {
		close();
		return this;
	}

	/** Cancel of a popup opened by a widget action (such a popup has Cancel and Save instead of Close). */
	public AssocTreeModal<W> cancel() {
		modal.$("button[data-test-widget-list-cancel=\"true\"]").shouldBe(Condition.visible, widget.getExpectations().getTimeout()).click();
		modal.shouldNotBe(Condition.visible, widget.getExpectations().getTimeout());
		return this;
	}

	@Override
	protected ElementsCollection rows() {
		return TreeNavigation.rows(modal);
	}

	@Override
	protected boolean isLastPage() {
		return true;
	}

	@Override
	protected SelenideElement getSelectionRow(SelenideElement row) {
		return row.$(TreeNavigation.ROW_SELECT_SELECTOR).shouldBe(Condition.enabled);
	}

	@Override
	protected String headerTitleAttribute() {
		return TreeNavigation.HEADER_TITLE_ATTRIBUTE;
	}

	/** A tree has no "select all" checkbox in the header: the whole tree is never loaded. */
	@Override
	protected SelenideElement getCheckBoxAll() {
		throw new UnsupportedOperationException("AssocTreePopup has no select all; select a node instead");
	}

	@Override
	public void setValueAll(boolean close) {
		throw new UnsupportedOperationException("AssocTreePopup has no select all; select a node instead");
	}

}
