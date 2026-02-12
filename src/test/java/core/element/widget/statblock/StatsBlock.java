package core.element.widget.statblock;

import com.codeborne.selenide.SelenideElement;

public record StatsBlock(String count, String description, String icon, SelenideElement e) {

	public StatsBlock(String count, String description, String icon) {
		this(count, description, icon, null);
	}

	//	String getIcon();
	public StatsBlock click() {
		e.click();
		return this;
	}
}
