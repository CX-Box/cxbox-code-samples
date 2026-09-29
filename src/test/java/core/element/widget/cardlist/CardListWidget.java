package core.element.widget.cardlist;

import core.common.Identifier;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.ListWidgetInlineForm;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

/**
 * CardList widget: the records are cards, the edit form opens from the card. It is used like a List with an inline
 * form: {@code rows().row(0)}, {@code clickPencil()}, {@code burgerAction(label)}, {@code actions()},
 * {@code pagination()}. The widget has no table header, so {@code headers()} and {@code settings()} are not used.
 */
public class CardListWidget extends ListWidgetInlineForm<CardListWidget, CardListRows, CardListRow, PlatformFormWidget> {

	public CardListWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.CARD_LIST;
	}

	@Override
	public CardListRows rows() {
		return new CardListRows(this);
	}

}
