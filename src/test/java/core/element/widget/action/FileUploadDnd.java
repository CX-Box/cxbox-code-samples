package core.element.widget.action;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.SingleElement;
import core.element.widget.AbstractWidget;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.function.Consumer;

/**
 * The drag-and-drop zone of the multi-upload: {@code "mode": "file-upload-dnd"} or {@code "default-and-file-upload-dnd"}
 * in {@code options.buttons} of the widget.
 * <p>
 * The zone is always shown. It is disabled until its row meta is loaded and while its action is unavailable.
 */
public class FileUploadDnd<W extends AbstractWidget<ExpectationPattern, W>> implements SingleElement {

	private static final String ZONE = "data-test-file-upload-dnd";

	private final W widget;

	public FileUploadDnd(W widget) {
		this.widget = widget;
	}

	/** The zone after its row meta is loaded: before that the zone is disabled whatever the action is. */
	@Override
	public SelenideElement element() {
		return widget.element()
				.$("[" + ZONE + "]")
				.shouldHave(Condition.attribute(ZONE, "ready"), widget.getExpectations().getTimeout());
	}

	/** Checks whether the zone is disabled, i.e. does not accept files. */
	public W checkDisabled(Consumer<Boolean> disabled) {
		return Allure.step("Checking the drag-and-drop zone for \"Disabled\"", step -> {
			AbstractWidget.logTime(step);
			disabled.accept(element().$(".ant-upload-disabled").exists());
			return widget;
		});
	}

}
