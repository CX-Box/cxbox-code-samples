package core.element.widget.statblock;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Slf4j
public class StatsBlockWidget extends PlatformWidget<StatsBlockWidget> {

	public StatsBlockWidget(Identifier identifier, String textIdentifier) {
		super(identifier, textIdentifier);
	}

	/**
	 * @deprecated the widget uses the same expectations as the other widgets, use
	 * {@link #StatsBlockWidget(Identifier, String)}
	 */
	@Deprecated
	public StatsBlockWidget(ExpectationPattern expectations, String textIdentifier, Identifier identifier) {
		this(identifier, textIdentifier);
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.STATS_BLOCK;
	}


	public StatsBlockWidget checkValues(Consumer<StatsBlock> checkValues) {
		element().$$("div[class*='ant-list-item StatsBlock__itemContainer']").stream()
				.map(this::getStatsBlock)
				.forEach(checkValues);
		return this;
	}


	public StatsBlock block(String description) {
		return element().$$("div[class*='ant-list-item StatsBlock__itemContainer']").stream()
				.map(this::getStatsBlock)
				.filter(e -> description.equals(e.description()))
				.findFirst().orElseThrow(() -> new IllegalArgumentException("Cannot find stats block with description " + description));
	}

	public StatsBlock blockById(int index) {
		return element().$$("div[class*='ant-list-item StatsBlock__itemContainer']").stream()
				.skip(index)
				.limit(1)
				.map(this::getStatsBlock)
				.findFirst().orElseThrow(() -> new IllegalArgumentException("Cannot find stats block with index " + index));
	}

	public List<StatsBlock> allBlocks() {
		return element().$$("div[class*='ant-list-item StatsBlock__itemContainer']").stream()
				.map(this::getStatsBlock)
				.collect(Collectors.toList());
	}


	private StatsBlock getStatsBlock(SelenideElement e) {
		e.scrollTo();
		ElementsCollection blockValues = e.$$("div[class*='StatsBlock__itemContent'] > div ");
		log.info("Found {} stats block values", blockValues.size());
		// the icon is optional: a block without it has no icon element
		SelenideElement icon = e.$("i[class*='StatsBlock__itemIcon']");
		return new StatsBlock(
				blockValues.get(0).text(),
				blockValues.get(1).text(),
				icon.exists() ? icon.getAttribute("aria-label") : null,
				e);
	}
}
