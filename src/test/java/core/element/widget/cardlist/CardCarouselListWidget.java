package core.element.widget.cardlist;

import core.common.Identifier;
import core.element.widget.list.Pagination;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

/**
 * CardCarouselList widget: the cards of CardList in one horizontal strip. It is used like {@link CardListWidget};
 * {@link #pagination()} scrolls the strip with its arrows instead of loading pages.
 */
public class CardCarouselListWidget extends CardListWidget {

	public CardCarouselListWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.CARD_CAROUSEL_LIST;
	}

	/** A page is the group of cards that fits into the strip; the next page after the last one is the first one. */
	@Override
	public Pagination<?, CardListWidget> pagination() {
		return new CarouselPagination<>(this);
	}

}
