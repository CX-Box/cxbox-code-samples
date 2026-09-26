package core.element.widget.list;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
import core.element.widget.action.PageRequests;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static core.element.widget.AbstractWidget.logTime;

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
		return new Action<>(self());
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
		return Allure.step("Full text search: " + text, step -> {
			logTime(step);
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
			return self();
		});
	}

}