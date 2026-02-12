package core.element.widget;

import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.modal.ConfirmPopup;
import core.element.widget.modal.ErrorPopup;
import core.expectation.CxBoxExpectations;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;


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


}
