package core.element.widget.cardlist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.list.Pagination;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import static core.element.widget.AbstractWidget.logTime;

/**
 * The arrows of the CardCarouselList strip. The strip shows the cards that are already loaded, so a page change does
 * not call the backend: the arrow makes the first card of the next group current and scrolls the strip to it.
 */
public class CarouselPagination<W extends AbstractWidget<ExpectationPattern, W>> implements Pagination<CarouselPagination<W>, W> {

	private static final String STRIP = "div[class*='CardCarouselList__previewGroup']";

	private static final String CARD = "[data-carousel-item]";

	private static final String ACTIVE_CARD = CARD + "[class*='CardCarouselList__active']";

	private static final String ARROW = "div[class*='ArrowPagination__carouselList'] i.anticon-";

	/**
	 * Cards shown in the strip. Like the widget, which counts the cards of a group by rounding, a card counts when more
	 * than half of it is inside the strip.
	 */
	private static final String VISIBLE_CARDS_SCRIPT = "const s = arguments[0].getBoundingClientRect();"
			+ "return [...arguments[0].querySelectorAll('[data-carousel-item]')].map(e => e.getBoundingClientRect())"
			+ ".map((r, i) => Math.min(r.right, s.right) - Math.max(r.left, s.left) > r.width / 2 ? i : -1)"
			+ ".filter(i => i >= 0);";

	private final W widget;

	public CarouselPagination(W widget) {
		this.widget = widget;
	}

	@Override
	public CarouselPagination<W> checkPageCount(Consumer<Integer> pageCountChecker) {
		int cards = cards().size();
		int visible = Math.max(visibleCards().size(), 1);
		pageCountChecker.accept((cards + visible - 1) / visible);
		return this;
	}

	@Override
	public CarouselPagination<W> pages(int number) {
		firstPage();
		for (int i = 0; i < number; i++) {
			nextPage();
		}
		return this;
	}

	@Override
	public CarouselPagination<W> firstPage() {
		int attempts = cards().size();
		while (!visibleCards().contains(0) && attempts-- > 0) {
			previousPage();
		}
		return this;
	}

	@Override
	public CarouselPagination<W> nextPage() {
		return scroll("Scrolling the strip to the next cards", "right");
	}

	@Override
	public CarouselPagination<W> previousPage() {
		return scroll("Scrolling the strip to the previous cards", "left");
	}

	/** Whether the strip has cards to the right of the visible ones; after the last card the arrow goes to the first. */
	@Override
	public boolean checkNextPage() {
		return !isLastPage();
	}

	@Override
	public boolean isLastPage() {
		return visibleCards().contains(cards().size() - 1);
	}

	@Override
	public W widget() {
		return widget;
	}

	private CarouselPagination<W> scroll(String stepName, String direction) {
		Allure.step(stepName, step -> {
			logTime(step);
			String before = activeIndex();
			// the icon is under its button, a click on the icon itself is intercepted by the button
			widget.element().$(ARROW + direction).closest("button")
					.shouldBe(Condition.visible, widget.getExpectations().getTimeout())
					.click();
			// the current card changes first, then the strip scrolls smoothly; the page is shown when the new current
			// card is fully visible and the scroll position stays the same between two checks
			AtomicReference<Object> lastScroll = new AtomicReference<>();
			Selenide.Wait().withTimeout(widget.getExpectations().getTimeout()).until(driver -> {
				String after = activeIndex();
				Object scroll = Selenide.executeJavaScript("return arguments[0].scrollLeft;", strip());
				boolean stopped = scroll != null && scroll.equals(lastScroll.getAndSet(scroll));
				return after != null && !after.equals(before) && stopped
						&& visibleCards().contains(Integer.parseInt(after));
			});
		});
		return this;
	}

	private String activeIndex() {
		SelenideElement active = strip().$(ACTIVE_CARD);
		return active.exists() ? active.getAttribute("data-index") : null;
	}

	private List<Integer> visibleCards() {
		List<?> indexes = Selenide.executeJavaScript(VISIBLE_CARDS_SCRIPT, strip());
		return indexes == null ? List.of() : indexes.stream().map(i -> ((Number) i).intValue()).toList();
	}

	private ElementsCollection cards() {
		return strip().$$(CARD);
	}

	private SelenideElement strip() {
		return widget.element().$(STRIP).shouldBe(Condition.visible, widget.getExpectations().getTimeout());
	}

}
