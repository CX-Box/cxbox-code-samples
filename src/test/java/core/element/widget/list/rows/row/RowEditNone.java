package core.element.widget.list.rows.row;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import org.openqa.selenium.StaleElementReferenceException;

//TODO >> cxbox front >> need add test attribute which show this field can be edited

/**
 * this class needed for get row in ro state ( if options.style.edit: none)
 *
 * @param <SELF>
 * @param <W>
 */
public class RowEditNone<
		SELF extends RowEditNone<SELF, ROWS, W>,
		ROWS extends PlatformRows<ROWS, W, SELF>,
		W extends ListWidget<W, ROWS, SELF>>
		extends PlatformRow<SELF, ROWS, W> {


	public RowEditNone(ROWS parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return null;
	}
}
