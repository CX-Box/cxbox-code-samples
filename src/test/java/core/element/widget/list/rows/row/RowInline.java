package core.element.widget.list.rows.row;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.RowsInline;
import io.qameta.allure.Allure;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Condition.attribute;
import static core.util.i18n.CoreMessageSource.message;


public abstract class RowInline<
		SELF extends RowInline<SELF, ROWS, W>,
		ROWS extends RowsInline<ROWS, W, SELF>,
		W extends ListWidget<W, ROWS, SELF>> extends PlatformRow<SELF, ROWS, W> {

	//TODO remake ( maybe create State ??? (READ, EDIT ... ) )
	@Getter
	@Setter
	protected Boolean isEdit;

	public RowInline(ROWS parent, int pageIndex, String rowKey, boolean isEdit) {
		super(parent, pageIndex, rowKey);
		this.isEdit = isEdit;
	}

	public RowInline(ROWS parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
		this.isEdit = false;
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return getParent().element().findBy(attribute("data-test-widget-list-row-id", getRowKey()));
	}

	public abstract SELF editRow();

	/** Selects the row with a click: it becomes the active record of the widget, the widgets below show its data */
	public SELF select() {
		return Allure.step(message("row.select"), () -> {
			element().click();
			return self();
		});
	}

}
