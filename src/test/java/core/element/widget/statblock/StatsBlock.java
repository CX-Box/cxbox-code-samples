package core.element.widget.statblock;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.action.PageRequests;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.function.Consumer;

/**
 * A card of the StatsBlock widget.
 *
 * @param count the value of the card, without the tag
 * @param tag the text of the tag next to the value ({@code options.stats.tagFieldKey}), {@code null} without a tag
 */
public record StatsBlock(String count, String description, String icon, String tag, SelenideElement e, StatsBlockWidget widget) {

	/** The click sends its requests at once; the same wait as for the filters of a list. */
	private static final Duration REQUEST_START = Duration.ofMillis(500);

	public StatsBlock(String count, String description, String icon) {
		this(count, description, icon, null, null, null);
	}

	/**
	 * @deprecated the card has a tag now, use {@link #StatsBlock(String, String, String, String, SelenideElement)}
	 */
	@Deprecated
	public StatsBlock(String count, String description, String icon, SelenideElement e) {
		this(count, description, icon, null, e, null);
	}

	public StatsBlock(String count, String description, String icon, String tag, SelenideElement e) {
		this(count, description, icon, tag, e, null);
	}

	//	String getIcon();
	public StatsBlock click() {
		e.click();
		return this;
	}

	/**
	 * Clicks the block and passes the address after its drilldown to the check. A drilldown to the view of the block keeps
	 * the address and only filters the widgets of the view, so the method waits for the requests of the click.
	 */
	public StatsBlock drilldown(Consumer<String> checkUrl) {
		Allure.step(message("statsBlock.drilldown", description), step -> {
			PageRequests.runAndWaitDelayedRequests(e::click, REQUEST_START, widget.getExpectations().getOverTimeout());
			checkUrl.accept(WebDriverRunner.url());
		});
		return this;
	}
}
