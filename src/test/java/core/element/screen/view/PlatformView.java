package core.element.screen.view;

import com.codeborne.selenide.ElementsCollection;
import core.element.PlatformApp;
import core.element.screen.PlatformScreen;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.chart.Column2DWidget;
import core.element.widget.chart.Line2DWidget;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.info.PlatformAdditionalInfoWidget;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.realization.form.gh.PlatformGHWidgetInlineForm;
import core.element.widget.list.realization.form.list.PlatformListWidgetInlineForm;
import core.element.widget.list.realization.inline.gh.PlatformGHWidgetInline;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.element.widget.list.realization.form.tree.PlatformTreeWidgetInlineForm;
import core.element.widget.statblock.StatsBlockWidget;
import core.expectation.ExpectationPattern;

import java.util.function.Consumer;
import java.util.function.Supplier;


public class PlatformView extends AbstractView<PlatformView> {

	/** Passes the address of the current page ({@link PlatformApp#getUrl()}) to the check. */
	public PlatformView checkUrl(Consumer<String> checkUrl) {
		checkUrl.accept(PlatformApp.getUrl());
		return this;
	}

	public PlatformFormWidget form(String title) {
		return new PlatformFormWidget(PlatformIdentifier.TITLE, title);
	}

	public PlatformFormWidget formByName(String name) {
		return new PlatformFormWidget(PlatformIdentifier.NAME, name);
	}

	public PlatformInfoWidget info(String title) {
		return new PlatformInfoWidget(PlatformIdentifier.TITLE, title);
	}

	public PlatformInfoWidget infoByName(String name) {
		return new PlatformInfoWidget(PlatformIdentifier.NAME, name);
	}


	public PlatformListWidgetInline listByName(String name) {
		return new PlatformListWidgetInline(PlatformIdentifier.NAME, name);
	}

	public PlatformListWidgetInline listInline(String title) {
		return new PlatformListWidgetInline(PlatformIdentifier.TITLE, title);
	}

	public PlatformListWidgetInline listInlineByName(String name) {
		return new PlatformListWidgetInline(PlatformIdentifier.NAME, name);
	}

	public PlatformListWidgetInlineForm listInlineForm(String title) {
		return new PlatformListWidgetInlineForm(PlatformIdentifier.TITLE, title);
	}

	public PlatformListWidgetInlineForm listInlineFormByName(String name) {
		return new PlatformListWidgetInlineForm(PlatformIdentifier.NAME, name);
	}

	public PlatformAdditionalInfoWidget additionalInfo(String title) {
		return new PlatformAdditionalInfoWidget(PlatformIdentifier.TITLE, title);
	}

	public PlatformAdditionalInfoWidget additionalInfoByName(String name) {
		return new PlatformAdditionalInfoWidget(PlatformIdentifier.NAME, name);
	}

	public PlatformGHWidgetInline groupingHierarchyInline(String title) {
		return new PlatformGHWidgetInline(PlatformIdentifier.TITLE, title);
	}

	public PlatformGHWidgetInline groupingHierarchyInlineByName(String name) {
		return new PlatformGHWidgetInline(PlatformIdentifier.NAME, name);
	}

	public PlatformGHWidgetInlineForm groupingHierarchyInlineWidget(String title) {
		return new PlatformGHWidgetInlineForm(PlatformIdentifier.TITLE, title);
	}

	public PlatformGHWidgetInlineForm groupingHierarchyInlineWidgetByName(String name) {
		return new PlatformGHWidgetInlineForm(PlatformIdentifier.NAME, name);
	}

	public PlatformTreeWidgetInline tree(String title) {
		return new PlatformTreeWidgetInline(PlatformIdentifier.TITLE, title);
	}

	public PlatformTreeWidgetInline treeByName(String name) {
		return new PlatformTreeWidgetInline(PlatformIdentifier.NAME, name);
	}

	public PlatformTreeWidgetInlineForm treeInlineForm(String title) {
		return new PlatformTreeWidgetInlineForm(PlatformIdentifier.TITLE, title);
	}

	public PlatformTreeWidgetInlineForm treeInlineFormByName(String name) {
		return new PlatformTreeWidgetInlineForm(PlatformIdentifier.NAME, name);
	}

	public StatsBlockWidget statBlock(String title) {
		return new StatsBlockWidget(PlatformIdentifier.TITLE, title);
	}

	public StatsBlockWidget statBlockByName(String name) {
		return new StatsBlockWidget(PlatformIdentifier.NAME, name);
	}

	public Pie1DWidget pie1D(String title) {
		return new Pie1DWidget(PlatformIdentifier.TITLE, title);
	}

	public Pie1DWidget pie1DByName(String name) {
		return new Pie1DWidget(PlatformIdentifier.NAME, name);
	}

	public Column2DWidget column2D(String title) {
		return new Column2DWidget(PlatformIdentifier.TITLE, title);
	}

	public Column2DWidget column2DByName(String name) {
		return new Column2DWidget(PlatformIdentifier.NAME, name);
	}

	public Line2DWidget line2D(String title) {
		return new Line2DWidget(PlatformIdentifier.TITLE, title);
	}

	public Line2DWidget line2DByName(String name) {
		return new Line2DWidget(PlatformIdentifier.NAME, name);
	}

	public <T extends AbstractWidget<ExpectationPattern, T>> T widget(Supplier<T> supplier) {
		return supplier.get();
	}

	PlatformScreen screen(String name) {
		return new PlatformScreen(name);
	}

	public PlatformScreen currentScreen() {
		return new PlatformScreen();
	}

	@Override
	public ElementsCollection element() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
