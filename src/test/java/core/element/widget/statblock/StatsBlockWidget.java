package core.element.widget.statblock;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Getter(AccessLevel.PROTECTED)
@Slf4j
public class StatsBlockWidget extends AbstractWidget<ExpectationPattern, StatsBlockWidget> {

	private final String textIdentifier;

	private final Identifier identifier;

	public StatsBlockWidget(ExpectationPattern expectations, String textIdentifier, Identifier identifier) {
		super(expectations);
		this.textIdentifier = textIdentifier;
		this.identifier = identifier;
	}

	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.STATS_BLOCK;
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return Allure.step("Getting  Widget by heading (Title) " + textIdentifier, step -> {
			logTime(step);
			step.parameter("Widget title", textIdentifier);
			if (getIdentifier().equals(PlatformIdentifier.NAME)) {
				return getWidgetElementByName(getType(), textIdentifier);

			} else if (getIdentifier().equals(PlatformIdentifier.TITLE)) {
				return getWidgetElementByTitle(getType(), textIdentifier);
			}
			log.error("Cannot find method for {} with identifier {}", getIdentifier().getName(), getIdentifier().getTypeIdentifier());
			throw new UnsupportedOperationException("Cannot find method for " + getIdentifier().getName());
		});
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
		return new StatsBlock(
				blockValues.get(0).text(),
				blockValues.get(1).text(),
				e.$("i[class*='StatsBlock__itemIcon']").getAttribute("aria-label"),
				e);

	}
}
