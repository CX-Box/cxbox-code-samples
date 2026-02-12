package core.expectation;

import com.codeborne.selenide.*;
import core.config.ContextUtils;
import io.qameta.allure.Allure;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static core.element.widget.AbstractWidget.logTime;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

@Slf4j
@RequiredArgsConstructor
public class CxBoxExpectations implements ExpectationPattern {

	@Override
	public Duration getTimeout() {
		return Duration.ofSeconds(3);
	}

	@Override
	public Integer getRetryNumber() {
		return 3;
	}


	@Override
	public void getContextMenu() {
		Selenide.Wait().until(visibilityOfAllElements(ContextUtils.MAIN_CONTEXT));
	}


	@Override
	public void getWaitAllElementsWidget(String title) {

		Allure.step("Waiting for all elements to be visible for the widget " + title, step -> {
			logTime(step);

			String widget = "div[data-test=\"WIDGET\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";
			SelenideElement widgetElement = $(widget);
			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					log.debug("Waiting for the widget '{}', trying {} from {}", title, i, getRetryNumber());
					widgetElement.shouldBe(Condition.exist, Duration.ofMillis(getTimeout().toMillis() * getRetryNumber()));
					widgetElement.shouldHave(Condition.visible, getTimeout());
					log.debug("Widget '{}' loaded successfully.\"", title);
					return;
				} catch (TimeoutException e) {
					log.warn("The waiting time for the widget '{}' has been exceeded. An attempt {} from {}.", title, i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for the widget to be visible '" + title + "' after " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});

	}


	@Override
	public void getWaitAllRowsWidget(String title) {
		Allure.step("Waiting for all rows to be visible for the widget " + title, step -> {
			logTime(step);

			String widget = "div[data-test=\"WIDGET\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";
			String rowSelector = "tr[data-test-widget-list-row-id][data-test-widget-list-row-type=\"Row\"]";
			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					SelenideElement widgetElement = $(widget).shouldBe(Condition.visible, getTimeout());
					ElementsCollection rowsElement = widgetElement.$$(rowSelector);
					for (SelenideElement row : rowsElement.shouldHave(CollectionCondition.sizeGreaterThan(0))) {
						row.shouldBe(Condition.exist, getTimeout());
						row.shouldBe(Condition.visible, getTimeout());
						for (SelenideElement s : row.$$("td").shouldHave(CollectionCondition.sizeGreaterThan(0))) {
							s.shouldBe(Condition.exist, getTimeout());
							s.shouldBe(Condition.visible, getTimeout());
						}
					}
					log.debug("All lines of the widget '{}' loaded successfully.", title);
					return;
				} catch (TimeoutException e) {
					log.warn("The waiting time for rows for the widget '{}' has been exceeded. An attempt {} from {}.", title, i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for the widget lines to load '" + title + "' after " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});
	}


	@Override
	public void getWaitAllFields() {
		Allure.step("Waiting for all fields on the page to be visible", step -> {
			logTime(step);

			String fieldsSelector = "div[data-test=\"FIELD\"][data-test-field-type]";
			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					ElementsCollection fields = $$(fieldsSelector);
					for (SelenideElement f : fields.shouldHave(CollectionCondition.sizeGreaterThan(0))) {
						f.shouldBe(Condition.exist, getTimeout());
						f.shouldBe(Condition.visible, getTimeout());
					}
					log.debug("All fields have been uploaded successfully.");
					return;
				} catch (TimeoutException e) {
					log.warn("The waiting time for fields has been exceeded. An attempt {} from {}.", i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for fields to load " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});
	}


	@Override
	public void getWaitElement(String type, String title) {
		Allure.step("Waiting for an element to be visible by type " + type + " and by heading " + title, step -> {
			logTime(step);

			String elementSelector = "div[data-test=\"" + type.toUpperCase().strip() + "\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";
			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					SelenideElement element = $(elementSelector);
					element.shouldBe(Condition.visible, getTimeout());
					element.shouldBe(Condition.exist, getTimeout());
					log.debug("The element with the type '{}' and the name '{}' loaded successfully.", type, title);
					return;
				} catch (TimeoutException e) {
					log.warn("The waiting time for the item type has been exceeded. An attempt {} from {}.", i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for the item to load " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});
	}


	@Override
	public void getWaitAllElements(SelenideElement webElement) {

		Allure.step("Waiting for all Webelement elements to be visible " + webElement, step -> {
			logTime(step);

			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					webElement.shouldBe(Condition.exist, getTimeout());
					webElement.shouldBe(Condition.visible, getTimeout());
					log.debug("WebElement {} \n uploaded successfully", webElement);
				} catch (TimeoutException e) {
					log.warn("The waiting time for WebElement has been exceeded. Attempt {} from {}.", i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for WebElement to load " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});
	}


	@Override
	public void getWaitAllElements(String cssSelector) {
		Allure.step("Waiting for all elements to be visible by Css Selector " + cssSelector, step -> {
			logTime(step);

			for (int i = 1; i <= getRetryNumber(); i++) {
				try {
					SelenideElement element = $(cssSelector);
					element.shouldBe(Condition.exist, getTimeout());
					element.shouldBe(Condition.visible, getTimeout());
					log.debug("элемент по {} загружен успешно", cssSelector);
				} catch (TimeoutException e) {
					log.warn("The waiting time for WebElement has been exceeded. Attempt {} from {}.", i, getRetryNumber());
					if (i < getRetryNumber()) {
						Selenide.sleep(Duration.ofMillis(500L).toMillis());
					} else {
						throw new RuntimeException("Couldn't wait for the item to load " + getRetryNumber() + " attempts.", e);
					}
				}
			}
		});
	}
}
