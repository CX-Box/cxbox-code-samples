package core.element.screen.view;

import com.codeborne.selenide.ElementsCollection;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.chart.Column2DWidget;
import core.element.widget.chart.Line2DWidget;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.form.PlatformFormPopupWidget;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.info.PlatformAdditionalInfoWidget;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.realization.form.gh.PlatformGHWidgetInlineForm;
import core.element.widget.list.realization.form.list.PlatformListWidgetInlineForm;
import core.element.widget.list.realization.inline.gh.PlatformGHWidgetInline;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.element.widget.list.realization.form.tree.PlatformTreeWidgetInlineForm;
import core.element.widget.cardlist.CardCarouselListWidget;
import core.element.widget.cardlist.CardListWidget;
import core.element.widget.filepreview.FilePreviewWidget;
import core.element.widget.group.WidgetGroup;
import core.element.widget.statblock.StatsBlockWidget;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;
import java.util.function.Supplier;

import static core.element.PlatformApp.config;


public class PlatformView extends AbstractView<PlatformView> {

	/** Passes the address of the current page ({@link PlatformApp#getUrl()}) to the check. */
	public PlatformView checkUrl(Consumer<String> checkUrl) {
		checkUrl.accept(PlatformApp.getUrl());
		return this;
	}

	public PlatformFormWidget form(String title) {
		return config().parts.widgets.form.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformFormWidget formByName(String name) {
		return config().parts.widgets.form.apply(PlatformIdentifier.NAME, name);
	}

	/** The form in a window ({@link PlatformFormPopupWidget}) by the title of the widget */
	public PlatformFormPopupWidget formPopup(String title) {
		return config().parts.widgets.formPopup.apply(PlatformIdentifier.TITLE, title);
	}

	/** The form in a window ({@link PlatformFormPopupWidget}) by the name of the widget */
	public PlatformFormPopupWidget formPopupByName(String name) {
		return config().parts.widgets.formPopup.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformInfoWidget info(String title) {
		return config().parts.widgets.info.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformInfoWidget infoByName(String name) {
		return config().parts.widgets.info.apply(PlatformIdentifier.NAME, name);
	}


	public PlatformListWidgetInline listByName(String name) {
		return config().parts.widgets.list.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformListWidgetInline listInline(String title) {
		return config().parts.widgets.list.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformListWidgetInline listInlineByName(String name) {
		return config().parts.widgets.list.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformListWidgetInlineForm listInlineForm(String title) {
		return config().parts.widgets.listInlineForm.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformListWidgetInlineForm listInlineFormByName(String name) {
		return config().parts.widgets.listInlineForm.apply(PlatformIdentifier.NAME, name);
	}

	/** AdditionalList widget: a List of its own type with the same API. */
	public PlatformListWidgetInline additionalList(String title) {
		return config().parts.widgets.additionalList.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformListWidgetInline additionalListByName(String name) {
		return config().parts.widgets.additionalList.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformAdditionalInfoWidget additionalInfo(String title) {
		return config().parts.widgets.additionalInfo.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformAdditionalInfoWidget additionalInfoByName(String name) {
		return config().parts.widgets.additionalInfo.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformGHWidgetInline groupingHierarchyInline(String title) {
		return config().parts.widgets.groupingHierarchy.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformGHWidgetInline groupingHierarchyInlineByName(String name) {
		return config().parts.widgets.groupingHierarchy.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformGHWidgetInlineForm groupingHierarchyInlineWidget(String title) {
		return config().parts.widgets.groupingHierarchyInlineForm.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformGHWidgetInlineForm groupingHierarchyInlineWidgetByName(String name) {
		return config().parts.widgets.groupingHierarchyInlineForm.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformTreeWidgetInline tree(String title) {
		return config().parts.widgets.tree.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformTreeWidgetInline treeByName(String name) {
		return config().parts.widgets.tree.apply(PlatformIdentifier.NAME, name);
	}

	public PlatformTreeWidgetInlineForm treeInlineForm(String title) {
		return config().parts.widgets.treeInlineForm.apply(PlatformIdentifier.TITLE, title);
	}

	public PlatformTreeWidgetInlineForm treeInlineFormByName(String name) {
		return config().parts.widgets.treeInlineForm.apply(PlatformIdentifier.NAME, name);
	}

	public StatsBlockWidget statBlock(String title) {
		return config().parts.widgets.statBlock.apply(PlatformIdentifier.TITLE, title);
	}

	public StatsBlockWidget statBlockByName(String name) {
		return config().parts.widgets.statBlock.apply(PlatformIdentifier.NAME, name);
	}

	public Pie1DWidget pie1D(String title) {
		return config().parts.widgets.pie1D.apply(PlatformIdentifier.TITLE, title);
	}

	public Pie1DWidget pie1DByName(String name) {
		return config().parts.widgets.pie1D.apply(PlatformIdentifier.NAME, name);
	}

	public Column2DWidget column2D(String title) {
		return config().parts.widgets.column2D.apply(PlatformIdentifier.TITLE, title);
	}

	public Column2DWidget column2DByName(String name) {
		return config().parts.widgets.column2D.apply(PlatformIdentifier.NAME, name);
	}

	public Line2DWidget line2D(String title) {
		return config().parts.widgets.line2D.apply(PlatformIdentifier.TITLE, title);
	}

	public Line2DWidget line2DByName(String name) {
		return config().parts.widgets.line2D.apply(PlatformIdentifier.NAME, name);
	}
	public CardListWidget cardList(String title) {
		return config().parts.widgets.cardList.apply(PlatformIdentifier.TITLE, title);
	}

	public CardListWidget cardListByName(String name) {
		return config().parts.widgets.cardList.apply(PlatformIdentifier.NAME, name);
	}

	public CardCarouselListWidget cardCarouselList(String title) {
		return config().parts.widgets.cardCarouselList.apply(PlatformIdentifier.TITLE, title);
	}

	public CardCarouselListWidget cardCarouselListByName(String name) {
		return config().parts.widgets.cardCarouselList.apply(PlatformIdentifier.NAME, name);
	}

	public FilePreviewWidget filePreview(String title) {
		return new FilePreviewWidget(PlatformIdentifier.TITLE, title);
	}

	public FilePreviewWidget filePreviewByName(String name) {
		return new FilePreviewWidget(PlatformIdentifier.NAME, name);
	}

	/** The group of widgets of the view ({@code view.json -> groups}) by the name of its main (first) widget */
	public WidgetGroup widgetGroup(String mainWidgetName) {
		return new WidgetGroup(mainWidgetName);
	}

	public <T extends AbstractWidget<ExpectationPattern, T>> T widget(Supplier<T> supplier) {
		return supplier.get();
	}

	PlatformScreen screen(String name) {
		return config().parts.screen.apply(name);
	}

	public PlatformScreen currentScreen() {
		return config().parts.currentScreen.get();
	}

	@Override
	public ElementsCollection element() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
