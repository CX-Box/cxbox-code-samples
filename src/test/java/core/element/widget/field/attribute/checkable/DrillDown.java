package core.element.widget.field.attribute.checkable;

import static core.util.i18n.CoreMessageSource.message;

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


public interface DrillDown<W extends AbstractWidget<ExpectationPattern, W>, VF, V, SELF extends DrillDown<W, VF, V, SELF>> extends AbstractField<ExpectationPattern, W, VF, SELF> {

	@SuppressWarnings("unchecked")
	// TODO >> !! >> drilldown with filter ( on self !!!)
	default void drilldown(Consumer<V> consumer) {
		Allure.step(message("field.drilldown", getFieldIdentifier()), step -> {
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
			webdriver().shouldNotHave(url(oldUrl), Duration.ofMillis(widget().getExpectations().getTimeout().toMillis()));
			$x("//body").exists();
			String newUrl = WebDriverRunner.url();
			consumer.accept((V) newUrl);

			return (SELF) this;
		});

	}
}
