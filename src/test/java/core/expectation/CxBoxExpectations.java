package core.expectation;

import application.config.props.Env;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.config.ContextUtils;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static core.element.widget.AbstractWidget.logTime;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

@Slf4j
public class CxBoxExpectations implements ExpectationPattern {

	private final Duration timeout;
	private final Duration overTimeout;
	private final Integer poolingRate;


	public CxBoxExpectations() {
		this.timeout = Env.timeout();
		this.overTimeout = Env.overTimeout();
		this.poolingRate = Env.poolingRate();
	}

	@Override
	public Duration getTimeout() {
		return timeout;
	}

	@Override
	public Duration getOverTimeout() {
		return overTimeout;
	}

	@Override
	public Integer getPoolingRate() {
		return poolingRate;
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
			Selenide.Wait()
					.withTimeout(getTimeout().multipliedBy(getRetryNumber()))
					.pollingEvery(getTimeout().multipliedBy(getRetryNumber()).dividedBy(getPoolingRate()))
					.withMessage("Widget '" + title + "' loaded failure")
					.until(driver -> {
						SelenideElement el = $(widget);
						return el.exists() && el.isDisplayed();
					});

			log.debug("Widget '{}' loaded successfully.", title);
		});

	}


	@Override
	public void getWaitAllRowsWidget(String title) {
		Allure.step("Waiting for all rows to be visible for the widget " + title, step -> {
			logTime(step);

			String widgetSelector = "div[data-test=\"WIDGET\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";
			String rowSelector = "tr[data-test-widget-list-row-id][data-test-widget-list-row-type=\"Row\"]";
			Selenide.Wait()
					.withTimeout(getTimeout())
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.until(driver -> {
						SelenideElement widget = $(widgetSelector);
						if (!widget.isDisplayed()) return false;

						ElementsCollection rows = widget.$$(rowSelector);
						if (rows.isEmpty()) return false;

						SelenideElement firstRow = rows.first();
						ElementsCollection cells = firstRow.$$("td");

						return cells.size() > 0 && cells.first().isDisplayed();
					});

			log.debug("All rows and cells for widget '{}' are verified and visible.", title);
		});
	}


	@Override
	public void getWaitAllFields() {
		Allure.step("Waiting for all fields on the page to be visible", step -> {
			logTime(step);

			String fieldsSelector = "div[data-test=\"FIELD\"][data-test-field-type]";
			Selenide.Wait()
					.withTimeout(getTimeout().multipliedBy(getRetryNumber()))
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.until(driver -> {
						ElementsCollection fields = $$(fieldsSelector);

						if (fields.isEmpty()) return false;

						return fields.asFixedIterable().stream()
								.allMatch(f -> f.isDisplayed() && f.getSize().getHeight() > 0);
					});

			log.debug("All fields have been uploaded successfully.");
		});
	}


	@Override
	public void getWaitElement(String type, String title) {
		Allure.step("Waiting for an element to be visible by type " + type + " and by heading " + title, step -> {
			logTime(step);

			String elementSelector = "div[data-test=\"" + type.toUpperCase().strip() + "\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";

			Selenide.Wait()
					.withTimeout(getTimeout())
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.withMessage("The element with the type '" + type + "' and the name '" + title + "' loaded failure")
					.until(driver -> {
						SelenideElement el = $(elementSelector);
						if (!el.isDisplayed()) return false;
						boolean hasContent = el.$$("*").size() > 0;
						boolean isNotCollapsed = el.getSize().getHeight() > 0;
						return hasContent && isNotCollapsed;
					});

			log.debug("The element with the type '{}' and the name '{}' loaded successfully.", type, title);
		});
	}


	public void getWaitElementWithText(String type, String title) {
		Allure.step("Waiting for an element to be visible by type " + type + " and by heading " + title, step -> {
			logTime(step);

			String elementSelector = "div[data-test=\"" + type.toUpperCase().strip() + "\"][data-test-widget-type][data-test-widget-title=\"" + title + "\"]";

			Selenide.Wait()
					.withTimeout(getTimeout())
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.withMessage("The element with the type '" + type + "' and the name '" + title + "' loaded failure")
					.until(driver -> {
						SelenideElement el = $(elementSelector);

						if (!el.isDisplayed()) return false;

						return el.isEnabled() && !el.getOwnText().isEmpty();
					});

			log.debug("The element '{}' with title '{}' is fully loaded with data.", type, title);
		});
	}


	@Override
	public void getWaitAllElements(SelenideElement webElement) {

		Allure.step("Waiting for all WebElement elements to be visible " + webElement, step -> {
			logTime(step);

			Selenide.Wait()
					.withTimeout(getTimeout().multipliedBy(getRetryNumber()))
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.withMessage("Element " + webElement.getSearchCriteria() + " loaded failure")
					.until(driver -> {
						return webElement.exists() && webElement.isDisplayed();
					});

			log.debug("WebElement '{}' uploaded successfully", webElement.getSearchCriteria());
		});
	}


	@Override
	public void getWaitAllElements(String cssSelector) {
		Allure.step("Waiting for all elements to be visible by Css Selector " + cssSelector, step -> {
			logTime(step);

			Selenide.Wait()
					.withTimeout(getTimeout().multipliedBy(getRetryNumber()))
					.pollingEvery(getTimeout().dividedBy(getPoolingRate()))
					.withMessage("Element by Selector '" + cssSelector + "' loaded failure")
					.until(driver -> {
						SelenideElement el = $(cssSelector);
						return el.exists() && el.isDisplayed();
					});

			log.debug("WebElement by selector '{}' uploaded successfully", cssSelector);
		});
	}
}
