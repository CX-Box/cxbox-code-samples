package core.element.widget.cardlist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.rows.RowsInlineForm;

/** The cards of the current page, in the order on the screen. */
public class CardListRows extends RowsInlineForm<CardListRows, CardListWidget, CardListRow, PlatformFormWidget> {

	public CardListRows(CardListWidget widget) {
		super(widget);
	}

	@Override
	public ElementsCollection element() {
		widget().getExpectations().getWaitAllElements(widget().element());
		return widget().element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$$("div[" + ROW_ID_ATTRIBUTE + "]");
	}

	@Override
	public CardListRow row(int number) {
		String cursor = element().get(number).getAttribute(ROW_ID_ATTRIBUTE);
		return new CardListRow(this, number, cursor);
	}

}
