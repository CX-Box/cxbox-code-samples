package core.element.widget.field.type.inlinePickList;

import core.util.report.StepReport;
import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;
import io.qameta.allure.Allure;

import java.util.function.Consumer;


public class ListInlinePickList<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		> extends InlinePickList<W, ListInlinePickList<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListInlinePickList(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row.element();
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> platformRowsInline && !platformRowsInline.getIsEdit()) {
			return "span[class*='ReadOnlyField']";
		}
		return "div[class=\"ant-select-selection-selected-value\"]";
	}

	@Override
	public ListInlinePickList<W, RR, R> setValue(String value) {
		return Allure.step(message("field.choose", getFieldIdentifier()), step -> {
			StepReport.value(value);
			clear();
			element()
					.$("div[class*=\"ant-select-selection\"]")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			element()
					.$("input[class=\"ant-select-search__field\"]")
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.setValue(value);
			widget().getExpectations().getWaitAllElements(element());
			getValues()
					.findBy(Condition.text(value))
					.shouldBe(Condition.interactable, widget().getExpectations().getTimeout())
					.click();
			return this;
		});
	}

	@Override
	public ListInlinePickList<W, RR, R> checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		return Allure.step(message("field.readOnly", getFieldIdentifier()), step -> {
			Boolean disabled = element().shouldBe(Condition.exist)
					.$("input[class=\"ant-select-search__field\"]")
					.has(Condition.attribute("disabled"));
			expectedReadOnly.accept(disabled);
			return this;
		});
	}

	@Override
	public R row() {
		return row;
	}
}
