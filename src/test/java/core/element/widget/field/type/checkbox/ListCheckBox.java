package core.element.widget.field.type.checkbox;

import com.codeborne.selenide.Condition;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;

import java.util.function.Consumer;

public class ListCheckBox<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends CheckBox<W, ListCheckBox<W, RR, R>> implements ParentRow<R> {


	final String REQUIRED_MESSAGE = "div[class=\"ant-tooltip-inner\"]";
	final R row;

	public ListCheckBox(String name, W widget, R parent) {
		super(name, widget);
		row = parent;
	}

	@Override
	public ListCheckBox<W, RR, R> checkRequired(Consumer<String> checkRequired) {
		element()
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.$("div.ant-row.ant-form-item")
				.hover();
		String actualText = element()
				.$(REQUIRED_MESSAGE)
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.text();
		checkRequired.accept(actualText);
		return this;
	}


	public R row() {
		return row;
	}
}
