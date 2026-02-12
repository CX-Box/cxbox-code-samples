package core.element.widget.list;

import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.list.rows.RowsInline;
import core.element.widget.list.rows.row.RowInline;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;

public abstract class GroupingHierarchyWidgetInline<
		SELF extends GroupingHierarchyWidgetInline<SELF, ROWS, ROW>,
		ROWS extends RowsInline<ROWS, SELF, ROW>,
		ROW extends RowInline<ROW, ROWS, SELF>>
		extends ListWidget<SELF, ROWS, ROW> {

	public GroupingHierarchyWidgetInline(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}


	@Override
	public TypeWidget getType() {
		return PlatformTypeWidgets.GROUPING_HIERARCHY;
	}

	// TODO вложенный группировку
	public SELF expandAll() {
		element().$$("i[aria-label=\"icon: up\"]").forEach(SelenideElement::click);
		return (SELF) this;
	}

	public SELF collapseAll() {
		element().$$("i[aria-label=\"icon: down\"]").forEach(SelenideElement::click);
		return (SELF) this;
	}

	public SELF expandRow() {
		element().$$("i[aria-label=\"icon: up\"]").forEach(e -> e.click());
		return (SELF) this;
	}

	public SELF collapseRow() {
		element().$$("i[aria-label=\"icon: down\"]").forEach(e -> e.click());
		return (SELF) this;
	}

	//TODO
	// dragAndDrop
}
