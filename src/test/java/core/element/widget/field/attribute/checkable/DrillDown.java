package core.element.widget.field.attribute.checkable;

import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.AbstractWidget;
import core.element.widget.field.AbstractField;
import core.element.widget.field.PlatformFieldType;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;

import java.time.Duration;
import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static core.element.widget.AbstractWidget.logTime;


public interface DrillDown<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends DrillDown<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	default void drilldown(Consumer<V> consumer) {
		Allure.step("Click-through when clicking on a hyperlink or a special element in a field", step -> {
			logTime(step);
			String drilldownHolder = "i[class=\"anticon anticon-link\"]";
			if (
					this.fieldType().equals(PlatformFieldType.DATE_TIME_WITH_SECONDS_LIST)
							|| this.fieldType().equals(PlatformFieldType.DATE)
							|| this.fieldType().equals(PlatformFieldType.DATE_TIME)
							|| this.fieldType().equals(PlatformFieldType.MONEY)
							|| this.fieldType().equals(PlatformFieldType.TEXT)) {
				drilldownHolder = "span a";
			}
			String oldUrl = WebDriverRunner.url();
			element().find(drilldownHolder).click();
			webdriver().shouldNotHave(url(oldUrl),
					Duration.ofMillis(widget().getExpectations().getTimeout().toMillis()));
			$x("//body").exists();
			String newUrl = WebDriverRunner.url();
			consumer.accept((V) newUrl);

			return (SELF) this;
		});

	}
}
