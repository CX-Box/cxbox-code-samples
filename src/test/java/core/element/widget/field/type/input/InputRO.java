package core.element.widget.field.type.input;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.AbstractWidget;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import java.util.function.Consumer;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.Wait;
import static core.element.widget.AbstractWidget.logTime;

@Slf4j
@Getter
public class InputRO<W extends AbstractWidget<ExpectationPattern, W>> extends Input<W, InputRO<W>> {

	private final String title;


	public InputRO(String name, W widget) {
		super(widget, name);
		this.title = name;
	}


	public String title() {
		return title;
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.INPUT_RO;
	}

	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			if (element()
					.shouldBe(Condition.exist, widget().getExpectations().getTimeout())
					.$(valueTag()).is(Condition.visible)) {
				return element().$(valueTag()).getText();
			} else {
				return null;
			}
		});
	}

	@Override
	public InputRO<W> setValue(String value) {
		log.warn("Is not use for this");
		return this;
	}

	@Override
	public void drilldown(Consumer<String> consumer) {
		Allure.step("Clicking on a hyperlink in the text or by clicking on a special element", step -> {
			logTime(step);
			String oldUrl = WebDriverRunner.url();
			element().$(valueTag()).getWrappedElement().findElement(By.cssSelector("span:has(a)")).click();
			Wait().until(webDriver -> !webDriver.getCurrentUrl().contains(oldUrl));
			widget().getExpectations().getContextMenu();
			$x("//body").exists();
			consumer.accept(WebDriverRunner.url());
		});
	}
}
