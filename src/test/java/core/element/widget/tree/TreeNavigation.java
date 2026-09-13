package core.element.widget.tree;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.expectation.ExpectationPattern;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Selectors of Tree-like widgets (Tree, PickTreePopup, AssocTreePopup). Rows belong to an owner:
 * a row key or {@link #ROOT_KEY}; pages of an owner are loaded by its "More" pseudo row.
 */
public final class TreeNavigation {

	public static final String ROOT_KEY = "null";

	/** owner key of the rows found by a filter whose path to the root is not restored yet */
	public static final String UNALLOCATED_KEY = "unallocated";

	/** Owner key of every visible row regardless of its parent: the rows of a popup, which may be shown filtered (unallocated). */
	public static final String ALL_KEY = "*";

	public static final String ROW_ID_ATTRIBUTE = "data-test-widget-tree-row-id";

	public static final String PARENT_ID_ATTRIBUTE = "data-test-widget-tree-row-parent-id";

	public static final String ROWS_SELECTOR = "tr[data-test-widget-tree-row-type=\"Row\"]";

	public static final String HEADER_TITLE_ATTRIBUTE = "data-test-widget-tree-header-column-title";

	public static final String ROW_SELECT_SELECTOR = "input[data-test-widget-tree-row-select]";

	public static final String SHOW_MORE_SELECT_SELECTOR = "input[data-test-widget-tree-show-more-select]";

	public static final String COLLAPSED_ROW_ICON = "i[data-test-widget-tree-row-expand][aria-label=\"icon: right\"]";

	public static final String EXPANDED_ROW_ICON = "i[data-test-widget-tree-row-expand][aria-label=\"icon: down\"]";

	/** the dot shown instead of the arrow in the "hide" search mode */
	public static final String EXPAND_DISABLED_ICON = "i[data-test-widget-tree-row-expand-disabled]";

	public static final String COLLAPSED_HEADER_ICON = "i[data-test-widget-tree-header-expand][aria-label=\"icon: right\"]";

	/** the ">..." button of a row whose path to the root is not restored yet */
	public static final String RESTORE_PATH_BUTTON = "button[data-test-widget-tree-row-restore-path]";

	public static final String RESTORE_PATH_ALL_BUTTON = "button[data-test-widget-tree-restore-path-all]";

	public static final String FILTER_SHOWN = "[data-test-widget-tree-filter-shown]";

	public static final String FILTER_MORE = "[data-test-widget-tree-filter-shown] ~ a";

	public static final String FULL_TEXT_SEARCH = "input[data-test-widget-full-text-search]";

	/** Types into the full text search field of the container and waits for the result. */
	public static void fullTextSearch(SelenideElement container, String text, ExpectationPattern expectations) {
		SelenideElement input = container.$(FULL_TEXT_SEARCH).shouldBe(Condition.visible, expectations.getTimeout());
		input.clear();
		input.setValue(text);
		container.$(FILTER_SHOWN).should(Condition.exist, expectations.getTimeout());
		waitLoaded(container, expectations);
	}

	private static final String SHOW_MORE_BUTTON = "button[data-test-widget-tree-show-more]";

	private TreeNavigation() {
	}

	/** All visible data rows of the container regardless of the owner; rows of a collapsed node stay in the DOM hidden. */
	public static ElementsCollection rows(SelenideElement container) {
		return container.$$(ROWS_SELECTOR).filter(Condition.visible);
	}

	public static ElementsCollection childRows(SelenideElement container, String parentKey) {
		if (UNALLOCATED_KEY.equals(parentKey)) {
			return unallocatedRows(container);
		}
		if (ALL_KEY.equals(parentKey)) {
			return rows(container);
		}
		return container.$$(ROWS_SELECTOR + "[" + PARENT_ID_ATTRIBUTE + "=\"" + parentKey + "\"]").filter(Condition.visible);
	}

	/** Rows found by a filter whose parents are not loaded: they are shown apart, with the ">..." button. */
	public static ElementsCollection unallocatedRows(SelenideElement container) {
		return container.$$(ROWS_SELECTOR + ":has(" + RESTORE_PATH_BUTTON + ")").filter(Condition.visible);
	}

	public static SelenideElement row(SelenideElement container, String key) {
		return container.$(ROWS_SELECTOR + "[" + ROW_ID_ATTRIBUTE + "=\"" + key + "\"]");
	}

	/** The row placed in the tree, i.e. not in the unallocated block. */
	public static SelenideElement allocatedRow(SelenideElement container, String key) {
		return container.$(ROWS_SELECTOR + "[" + ROW_ID_ATTRIBUTE + "=\"" + key + "\"]:not(:has(" + RESTORE_PATH_BUTTON + "))");
	}

	public static SelenideElement moreButton(SelenideElement container, String parentKey) {
		return container.$(pseudoRow("show-more", parentKey)).$(SHOW_MORE_BUTTON);
	}

	public static SelenideElement moreSelect(SelenideElement container, String parentKey) {
		return container.$(pseudoRow("show-more", parentKey)).$(SHOW_MORE_SELECT_SELECTOR);
	}

	public static SelenideElement loadingRow(SelenideElement container, String parentKey) {
		return container.$(pseudoRow("loading", parentKey));
	}

	/**
	 * Waits until no page of any owner is loading: no loading pseudo row, no "More" in the loading state
	 * and at least one row, the "empty" row or the "More" row is shown.
	 */
	public static void waitLoaded(SelenideElement container, ExpectationPattern expectations) {
		expectations.getWaitAllElements(container);
		container.$("tr[data-record-type=\"loading\"]").shouldNot(Condition.exist, expectations.getTimeout());
		container.$(".ant-btn-loading").shouldNot(Condition.exist, expectations.getTimeout());
		try {
			container.$$("tr[data-record-type=\"node\"], tr[data-record-type=\"empty\"], tr[data-record-type=\"show-more\"]")
					.filter(Condition.visible)
					.shouldHave(CollectionCondition.sizeGreaterThan(0), expectations.getTimeout());
		} catch (AssertionError e) {
			// a popup without data renders no row at all; the caller decides what an empty tree means
		}
	}

	private static String pseudoRow(String type, String parentKey) {
		return "tr[data-record-type=\"" + type + "\"][" + PARENT_ID_ATTRIBUTE + "=\"" + parentKey + "\"]";
	}

	/**
	 * Expands the first collapsed row or loads the first enabled "More" page; used by the popups,
	 * where the path to a value is unknown.
	 *
	 * @return false when the whole tree is loaded
	 */
	public static boolean loadNext(SelenideElement container, ExpectationPattern expectations) {
		waitLoaded(container, expectations);
		SelenideElement icon = container.$(COLLAPSED_ROW_ICON);
		if (icon.exists()) {
			icon.shouldBe(Condition.visible, expectations.getTimeout()).click();
			waitLoaded(container, expectations);
			return true;
		}
		SelenideElement more = container.$(SHOW_MORE_BUTTON);
		if (more.exists()) {
			more.shouldBe(Condition.visible, expectations.getTimeout()).click();
			// the "More" button is replaced by the loading row a moment later
			Selenide.sleep(300);
			waitLoaded(container, expectations);
			return true;
		}
		return false;
	}

	public static void loadWholeTree(SelenideElement container, ExpectationPattern expectations) {
		while (true) {
			if (loadNext(container, expectations)) {
				continue;
			}
			// a page may still be rendering: check once more after a pause
			Selenide.sleep(500);
			waitLoaded(container, expectations);
			if (!loadNext(container, expectations)) {
				return;
			}
		}
	}

	public static List<String> columnNames(SelenideElement container, ExpectationPattern expectations) {
		return container
				.$(By.tagName("table"))
				.$(By.tagName("thead"))
				.shouldBe(Condition.visible, expectations.getTimeout())
				.$$(By.tagName("th"))
				.stream()
				.map(th -> th.getAttribute(HEADER_TITLE_ATTRIBUTE))
				.collect(Collectors.toList());
	}

	/** Number in a "More N" / "shown N" label, 0 when there is none. */
	public static int number(SelenideElement element) {
		String digits = element.exists() ? element.getText().replaceAll("\\D", "") : "";
		return digits.isEmpty() ? 0 : Integer.parseInt(digits);
	}

}
