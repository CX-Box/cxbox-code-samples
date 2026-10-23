package core.element.widget.list;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.PlatformIdentifier;
import core.element.widget.form.PlatformFormWidget;

/**
 * The form of the step Confirm operation of a mass operation: the list shows the fields of the confirm widget in its
 * place, so the fields are looked for in the list
 */
public class MassOperationForm extends PlatformFormWidget {

	private final ListWidget<?, ?, ?> list;

	MassOperationForm(ListWidget<?, ?, ?> list) {
		super(PlatformIdentifier.NONE, null);
		this.list = list;
	}

	@Override
	public SelenideElement element() {
		return list.element();
	}

	/** The form has neither a name nor a title of its own: the scenario lines name it by its place */
	@Override
	public String label() {
		var label = message("report.widget.massForm");
		return label.substring(0, 1).toUpperCase() + label.substring(1);
	}

	@Override
	public boolean isOnPage() {
		try {
			return element().is(Condition.visible);
		} catch (RuntimeException e) {
			return false;
		}
	}

}
