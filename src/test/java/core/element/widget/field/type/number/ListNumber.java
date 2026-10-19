package core.element.widget.field.type.number;

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

import java.math.BigDecimal;


public class ListNumber
		<
				W extends ListWidget<W, RR, R>,
				RR extends PlatformRows<RR, W, R>,
				R extends PlatformRow<R, RR, W>
				>
		extends Number<W, ListNumber<W, RR, R>> implements ParentRow<R> {

	private final R row;

	public ListNumber(W widget, String title, R row) {
		super(widget, title);
		this.row = row;
	}

	protected SelenideElement parentElement() {
		return row.element();
	}

	public R row() {
		return row;
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> pri && !pri.getIsEdit()) {
			return "span[class*='ReadOnlyField__readOnlyField']";
		}
		return super.valueTag();
	}

	@Override
	public BigDecimal getValue() {
		if (row instanceof RowInline<?, ?, ?> pri && pri.getIsEdit()) {
			return super.getValue();
		}
		return StepReport.read(this, () -> {
			String str = element()
					.shouldBe(Condition.exist)
					.$(valueTag())
					.getText();
			str = str.replaceAll("\\s+", "")
					.replace(",", ".")
					.replaceAll("[^\\d.]+", "");
			return new BigDecimal(str);
		});

	}
}
