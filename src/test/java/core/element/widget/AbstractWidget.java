package core.element.widget;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.screen.view.PlatformView;
import core.element.widget.field.AbstractField;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import static com.codeborne.selenide.Selenide.$;

@Getter
public abstract class AbstractWidget<EP extends ExpectationPattern, SELF extends AbstractWidget<EP, SELF>> implements SingleElement {

	protected final EP expectations;

	public AbstractWidget(EP expectations) {
		this.expectations = expectations;
	}

	public static void logTime(Allure.StepContext step) {
		step.parameter("startTime", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")));
	}

	public abstract TypeWidget getType();

	protected SelenideElement getWidgetElementByTitle(TypeWidget type, String title) {
		return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getType() + "'][data-test-widget-title='" + title
				+ "']")
				.shouldBe(Condition.enabled, expectations.getTimeout());
	}

	protected SelenideElement getWidgetElementByName(TypeWidget type, String name) {
		return $("div[data-test='WIDGET'][data-test-widget-type='" + type.getType() + "'][data-test-widget-name='" + name
				+ "']")
				.shouldBe(Condition.enabled, expectations.getTimeout());
	}


	public SELF widget() {
		return (SELF) this;
	}

	public PlatformView view() {
		return new PlatformView();
	}

	public <FT, F extends AbstractField<EP, SELF, FT, F>> F field(Function<SELF, F> field) {
		return field.apply(widget());
	}

}
