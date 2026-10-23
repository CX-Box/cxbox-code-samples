package core.element.widget.list;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
import core.element.widget.action.PageRequests;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static core.element.PlatformApp.config;


public abstract class ListWidget<SELF extends ListWidget<SELF, ROWS, ROW>, ROWS extends PlatformRows<ROWS, SELF, ROW>, ROW extends PlatformRow<ROW, ROWS, SELF>> extends PlatformWidget<SELF> {

	public ListWidget(Identifier identifier, String textIdenfier) {
		super(identifier, textIdenfier);
	}

	public abstract ROWS rows();

	public ListHeaders<SELF, ROWS, ROW> headers() {
		return new ListHeaders<>(self());
	}

	public Pagination<?, SELF> pagination() {
		return new ListPagination<>(self());
	}

	@SuppressWarnings("unchecked")
	public SELF self() {
		return (SELF) this;
	}

	public Action<SELF> actions() {
		return config().parts.actions.create(self());
	}

	/**
	 * Starts the mass operation of the list by its button ({@code options.massOp}): the list shows the steps of the
	 * operation, the first one is Select rows
	 */
	public MassOperation<SELF> massOperation(String action) {
		return Allure.step(message("mass.start", action, label()), step -> {
			actions().action(action).click();
			element().$(config().selectors.massOperationStep).shouldBe(Condition.visible, getExpectations().getOverTimeout());
			return new MassOperation<>(self());
		});
	}

	/** data-test attribute that holds the column title in the table header. */
	public String headerTitleAttribute() {
		return "data-test-widget-list-header-column-title";
	}

	/** The gear menu of the widget. */
	public WidgetSettings<SELF> settings() {
		return new WidgetSettings<>(self());
	}

	/**
	 * Types into the full text search field of the widget ({@code options.fullTextSearch}) and waits until the widget
	 * shows the found records. The widget searches from three characters; an empty text shows all records again.
	 */
	public SELF fullTextSearch(String text) {
		return Allure.step(message("list.search", text, label()), step -> {
			SelenideElement input = element().$("input[data-test-widget-full-text-search]")
					.shouldBe(Condition.visible, getExpectations().getTimeout());
			// clear() does not reach the React handler, so the text is removed as by the user;
			// the widget sends the search with a delay after the last key
			PageRequests.runAndWaitDelayedRequests(() -> {
				input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
				if (!text.isEmpty()) {
					input.sendKeys(text);
				}
			}, getExpectations().getTimeout(), getExpectations().getOverTimeout());
			element().$(".ant-spin-spinning").shouldNot(Condition.exist, getExpectations().getOverTimeout());
			StepReport.count(element().$$("tbody tr[data-test-widget-list-row-type='Row']").size(), "found");
			return self();
		});
	}

}