package core.element.widget;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.modal.ConfirmPopup;
import core.element.widget.modal.ErrorPopup;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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

	@Override
	public SelenideElement element() {
		return Allure.step("Getting  Widget by heading (Title) " + textIdentifier, step -> {
			logTime(step);
			step.parameter("Widget title", textIdentifier);
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
	 * Whether the widget is shown on the page: a widget hidden by its showCondition is not. The check is made when the
	 * widgets of the page have no loading spinner.
	 */
	public boolean isVisible() {
		return Allure.step("Getting the visibility of the widget " + textIdentifier, step -> {
			logTime(step);
			step.parameter("Widget title", textIdentifier);
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
		return Allure.step("Validation of the modal window", step -> {
			logTime(step);
			return new ErrorPopup<>(widget());
		});
	}

	public ConfirmPopup<SELF> confirmPopup() {
		return Allure.step("Confirm popup", step -> {
			logTime(step);
			return new ConfirmPopup<>(widget());
		});
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
