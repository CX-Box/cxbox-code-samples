package core.element.widget.list.rows.row;

import static core.util.i18n.CoreMessageSource.message;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.HoverOptions;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.action.BurgerAction;
import core.element.widget.field.type.checkbox.ListCheckBox;
import core.element.widget.field.type.date.ListDate;
import core.element.widget.field.type.dateTime.ListDateTime;
import core.element.widget.field.type.dateTimeWithSec.ListDateTimeWithSeconds;
import core.element.widget.field.type.dictionary.ListDictionary;
import core.element.widget.field.type.fileUpload.ListFileUpload;
import core.element.widget.field.type.hint.ListHint;
import core.element.widget.field.type.inlinePickList.ListInlinePickList;
import core.element.widget.field.type.input.ListInput;
import core.element.widget.field.type.money.ListMoney;
import core.element.widget.field.type.multifield.ListMultifield;
import core.element.widget.field.type.multipleSelect.ListMultipleSelect;
import core.element.widget.field.type.multivalue.ListMultivalue;
import core.element.widget.field.type.multivalueHover.ListMultivalueHover;
import core.element.widget.field.type.number.ListNumber;
import core.element.widget.field.type.percent.ListPercent;
import core.element.widget.field.type.pickList.ListPickList;
import core.element.widget.field.type.pickTree.ListPickTree;
import core.element.widget.field.type.multivalueTree.ListMultivalueTree;
import core.element.widget.field.type.radio.ListRadio;
import core.element.widget.field.type.richtext.ListRichText;
import core.element.widget.field.type.suggestionPickList.ListSuggestionPickList;
import core.element.widget.field.type.text.ListText;
import core.element.widget.field.type.time.ListTime;
import core.element.widget.list.ListWidget;
import core.element.widget.list.Row;
import core.element.widget.list.rows.PlatformRows;
import io.qameta.allure.Allure;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter(AccessLevel.PROTECTED)
public abstract class PlatformRow<SELF extends PlatformRow<SELF, ROWS, WIDGET>, ROWS extends PlatformRows<ROWS, WIDGET, SELF>, WIDGET extends ListWidget<WIDGET, ROWS, SELF>> extends Row<SELF, PlatformRows<ROWS, WIDGET, SELF>, WIDGET> {

	protected static final String ROW_ID_ATTRIBUTE = "data-test-widget-list-row-id";

	protected static final String DATA_ROW_KEY = "data-row-key";

	private static final String BURGER_BUTTON = "button[data-test-widget-list-row-action=\"true\"]";

	private final ROWS parent;

	private final int pageIndex;

	private final String rowKey;

	public PlatformRow(ROWS parent, int pageIndex, String rowKey) {
		this.parent = parent;
		this.pageIndex = pageIndex;
		this.rowKey = rowKey;
	}

	/**
	 * The row in the technical lines of the report: «строка id 1121762»
	 */
	public String describe() {
		return message("report.row", rowKey);
	}

	public BurgerAction<SELF, ROWS, WIDGET> burgerAction(String label) {
		return new BurgerAction<>(self(), parent.widget(), label);
	}

	public ROWS burgerActionClick(String label) {
		burgerAction(label).click();
		return parent;
	}

	/** Opens the menu of the row and leaves it open; its items come when the meta of the row is loaded */
	public SELF openBurger() {
		Allure.step(message("row.openBurger"), () -> {
			element().shouldBe(Condition.visible, widget().getExpectations().getTimeout()).hover();
			// the mouse stays on the row: a notice of the application can cover the button and stays open while hovered
			burgerButton().shouldBe(Condition.visible, widget().getExpectations().getTimeout()).click();
			burgerButton().shouldHave(Condition.cssClass("ant-dropdown-open"), widget().getExpectations().getTimeout());
		});
		return self();
	}

	/** Moves the mouse in the row and passes to the check whether the button of the row menu is visible */
	public SELF checkBurgerVisible(Consumer<Boolean> checkVisible) {
		checkVisible.accept(Allure.step(message("row.burgerVisible"), () -> {
			// a move inside the row, not only an entry into it: the mouse can already be in the row
			element().hover(HoverOptions.withOffset(-10, 0)).hover(HoverOptions.withOffset(10, 0));
			return burgerButton().is(Condition.visible, widget().getExpectations().getTimeout());
		}));
		return self();
	}

	/** The button of the row, or the one button of the list shown on the hover of a row */
	private SelenideElement burgerButton() {
		var inRow = element().$(BURGER_BUTTON);
		return inRow.exists() ? inRow : widget().element().$(BURGER_BUTTON);
	}


	public ROWS rows() {
		return parent;
	}

	public WIDGET widget() {
		return parent.widget();
	}

	@SuppressWarnings("unchecked")
	public SELF self() {
		return (SELF) this;
	}

	public ListCheckBox<WIDGET, ROWS, SELF> checkBox(String title) {
		return new ListCheckBox<>(title, widget(), self());
	}

	public ListCheckBox<WIDGET, ROWS, SELF> checkBoxByName(String name) {
		return new ListCheckBox<>(name, widget(), self());
	}

	public ListDate<WIDGET, ROWS, SELF> date(String title) {
		return new ListDate<>(title, widget(), self());
	}

	public ListDate<WIDGET, ROWS, SELF> dateByName(String name) {
		return new ListDate<>(name, widget(), self());
	}

	public ListDateTime<WIDGET, ROWS, SELF> dateTime(String title) {
		return new ListDateTime<>(title, widget(), self());
	}

	public ListDateTime<WIDGET, ROWS, SELF> dateTimeByName(String name) {
		return new ListDateTime<>(name, widget(), self());
	}

	public ListDateTimeWithSeconds<WIDGET, ROWS, SELF> dateTimeWithSec(String title) {
		return new ListDateTimeWithSeconds<>(title, widget(), self());
	}

	public ListDateTimeWithSeconds<WIDGET, ROWS, SELF> dateTimeWithSecByName(String name) {
		return new ListDateTimeWithSeconds<>(name, widget(), self());
	}

	public ListDictionary<WIDGET, ROWS, SELF> dictionary(String title) {
		return new ListDictionary<>(widget(), title, self());
	}

	public ListDictionary<WIDGET, ROWS, SELF> dictionaryByName(String name) {
		return new ListDictionary<>(widget(), name, self());
	}

	public ListFileUpload<WIDGET, ROWS, SELF> fileUpload(String title) {
		return new ListFileUpload<>(widget(), self(), title);
	}

	public ListFileUpload<WIDGET, ROWS, SELF> fileUploadByName(String name) {
		return new ListFileUpload<>(widget(), self(), name);
	}

	public ListHint<WIDGET, ROWS, SELF> hint(String title) {
		return new ListHint<>(widget(), title, self());
	}

	public ListHint<WIDGET, ROWS, SELF> hintByName(String name) {
		return new ListHint<>(widget(), name, self());
	}

	public ListInlinePickList<WIDGET, ROWS, SELF> inlinePickList(String title) {
		return new ListInlinePickList<>(widget(), title, self());
	}

	public ListInlinePickList<WIDGET, ROWS, SELF> inlinePickListByName(String name) {
		return new ListInlinePickList<>(widget(), name, self());
	}

	public ListInput<WIDGET, ROWS, SELF> input(String title) {
		return new ListInput<>(title, widget(), self());
	}

	public ListInput<WIDGET, ROWS, SELF> inputByName(String name) {
		return new ListInput<>(name, widget(), self());
	}

	public ListMoney<WIDGET, ROWS, SELF> money(String title) {
		return new ListMoney<>(widget(), title, self());
	}

	public ListMoney<WIDGET, ROWS, SELF> moneyByName(String name) {
		return new ListMoney<>(widget(), name, self());
	}

	public ListMultifield<WIDGET, ROWS, SELF> multivalueField(String title) {
		return new ListMultifield<>(widget(), title, self());
	}

	public ListMultifield<WIDGET, ROWS, SELF> multivalueFieldByName(String name) {
		return new ListMultifield<>(widget(), name, self());
	}

	public ListMultipleSelect<WIDGET, ROWS, SELF> multipleSelect(String title) {
		return new ListMultipleSelect<>(widget(), title, self());
	}

	public ListMultipleSelect<WIDGET, ROWS, SELF> multipleSelectByName(String name) {
		return new ListMultipleSelect<>(widget(), name, self());
	}

	public ListMultivalue<WIDGET, ROWS, SELF> multivalue(String title) {
		return new ListMultivalue<>(widget(), title, self());
	}

	public ListMultivalue<WIDGET, ROWS, SELF> multivalueByName(String name) {
		return new ListMultivalue<>(widget(), name, self());
	}

	public ListMultivalueHover<WIDGET, ROWS, SELF> multivalueHover(String title) {
		return new ListMultivalueHover<>(widget(), title, self());
	}

	public ListMultivalueHover<WIDGET, ROWS, SELF> multivalueHoverByName(String name) {
		return new ListMultivalueHover<>(widget(), name, self());
	}

	public ListNumber<WIDGET, ROWS, SELF> number(String title) {
		return new ListNumber<>(widget(), title, self());
	}

	public ListNumber<WIDGET, ROWS, SELF> numberByName(String name) {
		return new ListNumber<>(widget(), name, self());
	}

	public ListPercent<WIDGET, ROWS, SELF> percent(String title) {
		return new ListPercent<>(widget(), title, self());
	}

	public ListPercent<WIDGET, ROWS, SELF> percentByName(String name) {
		return new ListPercent<>(widget(), name, self());
	}

	public ListPickList<WIDGET, ROWS, SELF> pickList(String title) {
		return new ListPickList<>(widget(), title, self());
	}

	public ListPickList<WIDGET, ROWS, SELF> pickListByName(String name) {
		return new ListPickList<>(widget(), name, self());
	}

	public ListPickTree<WIDGET, ROWS, SELF> pickTree(String title) {
		return new ListPickTree<>(widget(), title, self());
	}

	public ListPickTree<WIDGET, ROWS, SELF> pickTreeByName(String name) {
		return new ListPickTree<>(widget(), name, self());
	}



	public ListMultivalueTree<WIDGET, ROWS, SELF> multivalueTree(String title) {
		return new ListMultivalueTree<>(widget(), title, self());
	}

	public ListMultivalueTree<WIDGET, ROWS, SELF> multivalueTreeByName(String name) {
		return new ListMultivalueTree<>(widget(), name, self());
	}

	public ListRadio<WIDGET, ROWS, SELF> radio(String title) {
		return new ListRadio<>(widget(), title, self());
	}

	public ListRadio<WIDGET, ROWS, SELF> radioByName(String name) {
		return new ListRadio<>(widget(), name, self());
	}

	public ListSuggestionPickList<WIDGET, ROWS, SELF> suggestionPickList(String title) {
		return new ListSuggestionPickList<>(widget(), title, self());
	}

	public ListSuggestionPickList<WIDGET, ROWS, SELF> suggestionPickListByName(String name) {
		return new ListSuggestionPickList<>(widget(), name, self());
	}

	public ListRichText<WIDGET, ROWS, SELF> richText(String title) {
		return new ListRichText<>(widget(), title, self());
	}

	public ListText<WIDGET, ROWS, SELF> text(String title) {
		return new ListText<>(widget(), title, self());
	}

	public ListText<WIDGET, ROWS, SELF> textByName(String name) {
		return new ListText<>(widget(), name, self());
	}

	public ListTime<WIDGET, ROWS, SELF> time(String title, String format) {
		return new ListTime<>(widget(), title, format, self());
	}

	public ListTime<WIDGET, ROWS, SELF> timeByName(String name, String format) {
		return new ListTime<>(widget(), name, format, self());
	}


	//	public <FT, F extends AbstractField<ExpectationPattern, W, FT, F>> F field(BiFunction<W, SELF, F> field) {
//		return field.apply(parent.widget(), self());
//	}

}
