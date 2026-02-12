package core.element.widget.field.type.multipleSelect;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;
import lombok.NonNull;
import org.openqa.selenium.Keys;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;

public class ListMultipleSelect
		<
				W extends ListWidget<W, RR, R>,
				RR extends PlatformRows<RR, W, R>,
				R extends PlatformRow<R, RR, W>
				>
		extends MultipleSelect<W, ListMultipleSelect<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListMultipleSelect(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	public R row() {
		return row;
	}

	@Override
	public Set<String> getValue() {
		if (row instanceof RowInline ri && ri.getIsEdit()) {
			return super.getValue();
		}
		return Set.of(element().$(valueTag()).text());
	}

	@Override
	protected SelenideElement parentElement() {
		return row.element();
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> ri && !ri.getIsEdit()) {
			return "div[class*='MultipleSelectField__readOnly']";
		}
		return super.valueTag();
	}

	@Override
	public ListMultipleSelect<W, RR, R> addValue(@NonNull Set<String> values) {
		values.forEach(value -> {
			boolean doesNotExist = !$("div[class^='ant-select-dropdown MultipleSelectField__dropDownMenu']")
					.is(Condition.visible, widget().getExpectations().getTimeout());
			if (doesNotExist) {
				element().click();
			}
			if (!isOptionSelected(value)) {
				getOption(value)
						.shouldBe(Condition.enabled, widget().getExpectations().getTimeout())
						.click();
			}
			$("body").sendKeys(Keys.ESCAPE);
			$("div[class^='ant-select-dropdown MultipleSelectField__dropDownMenu']")
					.is(Condition.hidden, widget().getExpectations().getTimeout());
		});

		return this;
	}
}
