package core.element.widget.list.rows.row;

import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.list.ListWidget;
import core.element.widget.list.rows.PlatformRows;
import core.expectation.ExpectationPattern;
import org.openqa.selenium.StaleElementReferenceException;

import static com.codeborne.selenide.Condition.attribute;

public abstract class RowInlineForm<
		SELF extends RowInlineForm<SELF, ROWS, WIDGET, FORMWIDGET>,
		ROWS extends PlatformRows<ROWS, WIDGET, SELF>,
		WIDGET extends ListWidget<WIDGET, ROWS, SELF>,
		FORMWIDGET extends AbstractWidget<ExpectationPattern, FORMWIDGET>> extends PlatformRow<SELF, ROWS, WIDGET> {

	public RowInlineForm(ROWS parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public SelenideElement element() throws StaleElementReferenceException {
		return getParent().element().findBy(attribute("data-row-key", getRowKey()));
	}

	public SELF click() {
		SelenideElement element = element();
		element.click();
		return self();
	}

	public abstract FORMWIDGET clickPencil();

//	public PlatformInlineFormWidget clickPencil() {
//		getParent().element().findBy(attribute("data-row-key", getRowKey() + "-extra-row"));
//		boolean exists = getParent().element()
//				.findBy(attribute("data-row-key", getRowKey() + "-extra-row"))
//				.is(Condition.visible, widget().getExpectations().getTimeout());
//		if (!exists) {
//		}
//		return new PlatformInlineFormWidget(PlatformIdentifier.NONE, null, this, this.getRowKey());
//	}

//	public SELF callActionInInlineEdit(String name) {
//		element().findAll(by("type", "button"))
//				.shouldHave(CollectionCondition.sizeGreaterThan(0)).find(Condition.match("check action name: " + name, b -> b.getText().equals(name))).click();
//		return self();
//	}
}