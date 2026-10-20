package core.element.widget;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.form.PlatformFormPopupWidget;
import core.element.widget.modal.ConfirmPopup;
import core.element.widget.modal.ErrorPopup;
import core.element.widget.modal.ErrorPopupException;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import static core.element.PlatformApp.config;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


// TODO add attribute which show which value tag we must use
// Like  INFO, FORM, LIST(LIST_EDIT? -> must be in list)
@Slf4j
public abstract class PlatformWidget<SELF extends PlatformWidget<SELF>> extends
		AbstractWidget<ExpectationPattern, SELF> {

	@Getter(AccessLevel.PROTECTED)
	private final Identifier identifier;

	private final String textIdentifier;

	public PlatformWidget(Identifier identifier, String textIdentifier) {
		super(new CxBoxExpectations());
		this.identifier = identifier;
		this.textIdentifier = textIdentifier;
	}

	/**
	 * The widget in the technical lines of the report: «список ApplicationDocList (ищется по имени)»
	 */
	@Override
	public String describe() {
		return StepReport.widget(getType().getType(), textIdentifier, getIdentifier().equals(PlatformIdentifier.NAME));
	}

	/**
	 * The widget in the lines of the scenario: its kind and its title as the user sees it («Форма «Заявка»»), its name
	 * when it has no title
	 */
	@Override
	public String label() {
		var title = getIdentifier().equals(PlatformIdentifier.TITLE)
				? textIdentifier
				: widgetByName(getType(), textIdentifier).getAttribute("data-test-widget-title");
		return StepReport.widgetKind(getType().getType()) + " «" + (title == null || title.isBlank() ? textIdentifier : title) + "»";
	}

	/**
	 * The title of the widget as shown, with the values of its fields put into it ({@code ${field}}); empty when the
	 * widget has no title
	 */
	public String title() {
		return Allure.step(message("widget.title", label()), () -> {
			var title = element().$("h2");
			var text = title.exists() ? title.text() : "";
			StepReport.value(text);
			return text;
		});
	}

	@Override
	public SelenideElement element() {
		return StepReport.service(message("widget.get", describe()), () -> {
			if (getIdentifier().equals(PlatformIdentifier.NAME)) {
				return getWidgetElementByName(getType(), textIdentifier).scrollTo();

			} else if (getIdentifier().equals(PlatformIdentifier.TITLE)) {
				return getWidgetElementByTitle(getType(), textIdentifier).scrollTo();
			}
			log.error("Cannot find method for {} with identifier {}", getIdentifier().getName(), getIdentifier().getTypeIdentifier());
			throw new UnsupportedOperationException("Cannot find method for " + getIdentifier().getName());
		});
	}

	/**
	 * The widget is on the page while its element is shown: after a drilldown it is gone, a closed antd popup stays in the
	 * page hidden
	 */
	@Override
	public boolean isOnPage() {
		return (getIdentifier().equals(PlatformIdentifier.NAME)
				? widgetByName(getType(), textIdentifier)
				: widgetByTitle(getType(), textIdentifier)).is(Condition.visible);
	}

	/**
	 * Whether the widget is shown on the page: a widget hidden by its showCondition is not. The check is made when the
	 * widgets of the page have no loading spinner.
	 */
	public boolean isVisible() {
		return Allure.step(message("widget.visible", textIdentifier), step -> {
			Selenide.Wait().withTimeout(getExpectations().getOverTimeout()).until(driver ->
					!Selenide.$("div[data-test='WIDGET'] .ant-spin-spinning, div[data-test='WIDGET'] [data-test-loading]").exists());
			SelenideElement widget = getIdentifier().equals(PlatformIdentifier.NAME)
					? widgetByName(getType(), textIdentifier)
					: widgetByTitle(getType(), textIdentifier);
			return widget.is(Condition.visible);
		});
	}

	/** Passes the visibility of the widget ({@link #isVisible()}) to the check. */
	public SELF checkVisible(Consumer<Boolean> checkVisible) {
		checkVisible.accept(isVisible());
		return widget();
	}


	public ErrorPopup<SELF> errorPopup() {
		return new ErrorPopup<>(widget());
	}

	/**
	 * The action that ends with the error popup of the application, as {@code assertThrows} of JUnit: the popup can come
	 * anywhere inside the action ({@link ErrorPopupException}) or after it. The popup is given to the checks.
	 *
	 * <h5>Usage Example</h5>
	 * <pre>{@code
	 * list.expectErrorPopup(() -> row.dictionary("Custom Field").setValue("Middle"))
	 *         .checkTitleAndMessage(
	 *                 title -> assertThat(title).isEqualTo("Error"),
	 *                 message -> assertThat(message).isEqualTo("System error"))
	 *         .close();
	 * }</pre>
	 *
	 * <h5>Not recommended: try / catch</h5>
	 * The same check without this method. The report has no line that the popup is expected, so the stopped action looks
	 * like a failure, and an action without the popup passes unnoticed.
	 * <pre>{@code
	 * try {
	 *     row.dictionary("Custom Field").setValue("Middle");
	 * } catch (ErrorPopupException e) {
	 *     e.popup()
	 *             .checkTitleAndMessage(
	 *                     title -> assertThat(title).isEqualTo("Error"),
	 *                     message -> assertThat(message).isEqualTo("System error"))
	 *             .close();
	 * }
	 * }</pre>
	 */
	public ErrorPopup<SELF> expectErrorPopup(Runnable action) {
		return Allure.step(message("errorPopup.expect"), () -> {
			ErrorPopupException.expect(action, getExpectations().getTimeout());
			return errorPopup();
		});
	}

	public ConfirmPopup<SELF> confirmPopup() {
		return config().parts.confirmPopup.create(widget());
	}

	/**
	 * The window with a form that the action of this widget opened with {@code PreAction.confirmWithWidget}, as
	 * {@link #confirmPopup()} for {@code PreAction.confirm}. One window is open at a time: it is the widget
	 * {@code FormPopup} with the window inside.
	 */
	public PlatformFormPopupWidget confirmWithWidgetPopup() {
		var name = Selenide.$$("div[data-test-widget-type='FormPopup']")
				.findBy(Condition.match("the open window", popup -> !popup.findElements(By.cssSelector(".ant-modal-content")).isEmpty()))
				.shouldBe(Condition.exist, getExpectations().getTimeout())
				.getAttribute("data-test-widget-name");
		return config().parts.widgets.formPopup.apply(PlatformIdentifier.NAME, name);
	}

	public void checkPositionAtElement (SIDE side, SelenideElement element) {
		switch (side) {
			case BOTTOM -> assertThat(element().getLocation().getY()).isGreaterThan(element.getLocation().getY());
			case TOP -> assertThat(element.getLocation().getY()).isGreaterThan(element().getLocation().getY());
			case LEFT -> assertThat(element.getLocation().getX()).isGreaterThan(element().getLocation().getX());
			case RIGHT -> assertThat(element().getLocation().getX()).isGreaterThan(element.getLocation().getX());
		}
	}

	enum SIDE {
		RIGHT,
		LEFT,
		TOP,
		BOTTOM
	}
}
