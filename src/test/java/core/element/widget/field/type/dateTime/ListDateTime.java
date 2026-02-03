package core.element.widget.field.type.dateTime;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.field.type.ParentRow;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.list.rows.row.RowInline;
import io.qameta.allure.Allure;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static core.element.widget.AbstractWidget.logTime;

public class ListDateTime<
		W extends ListWidget<W, RR, R>,
		RR extends PlatformRows<RR, W, R>,
		R extends PlatformRow<R, RR, W>
		>

		extends DateTime<W, ListDateTime<W, RR, R>> implements ParentRow<R> {

	@Getter
	private final R row;

	public ListDateTime(String title, W widget, R row) {
		super(widget, title);
		this.row = row;
	}

	@Override
	public String valueTag() {
		if (row instanceof RowInline<?, ?, ?> rowInline) {
			if (!rowInline.getIsEdit()) {
				return "span[class*='ReadOnlyField'";
			}
		}
		return super.valueTag();
	}

	@Override
	public LocalDateTime getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			String date;
			if (row instanceof RowInline<?, ?, ?> rowInline && !rowInline.getIsEdit()) {
				date = element().shouldBe(Condition.exist).$(valueTag()).getText();
			} else {
				date = element().shouldBe(Condition.exist).$(valueTag()).getValue();
			}
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
			return LocalDateTime.parse(Objects.requireNonNull(date), formatter);
		});
	}

	@Override
	public R row() {
		return row;
	}

	@Override
	protected SelenideElement parentElement() {
		return row().element();
	}
}
