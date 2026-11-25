package core.element.widget.statblock;

import com.codeborne.selenide.SelenideElement;

/**
 * A card of the StatsBlock widget.
 *
 * @param count the value of the card, without the tag
 * @param tag the text of the tag next to the value ({@code options.stats.tagFieldKey}), {@code null} without a tag
 */
public record StatsBlock(String count, String description, String icon, String tag, SelenideElement e) {

	public StatsBlock(String count, String description, String icon) {
		this(count, description, icon, null, null);
	}

	/**
	 * @deprecated the card has a tag now, use {@link #StatsBlock(String, String, String, String, SelenideElement)}
	 */
	@Deprecated
	public StatsBlock(String count, String description, String icon, SelenideElement e) {
		this(count, description, icon, null, e);
	}

	//	String getIcon();
	public StatsBlock click() {
		e.click();
		return this;
	}
}
