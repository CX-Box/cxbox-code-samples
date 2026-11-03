package core.element.widget.list;

import static core.util.i18n.CoreMessageSource.message;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.common.Identifier;
import core.element.widget.PlatformWidget;
import core.element.widget.action.Action;
import core.element.widget.action.PageRequests;
import core.element.widget.list.rows.PlatformRows;
import core.element.widget.list.rows.row.PlatformRow;
import core.element.widget.tree.TreeNavigation;
import core.util.report.StepReport;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;
import static core.element.PlatformApp.config;

public abstract class ListWidget<SELF extends ListWidget<SELF, ROWS, ROW>, ROWS extends PlatformRows<ROWS, SELF, ROW>, ROW extends PlatformRow<ROW, ROWS, SELF>> extends PlatformWidget<SELF> {

	/** The hint "Enter three or more characters" of the full text search; the popover is outside the widget. */
	private static final String FULL_TEXT_SEARCH_HINT = "[data-test-widget-full-text-search-hint]";

	/** The full text search starts from this length; shorter text shows the hint. */
	private static final int FULL_TEXT_SEARCH_MIN_LENGTH = 3;

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

	/** data-test attribute that holds the column title in the table header. */
	public String headerTitleAttribute() {
		return "data-test-widget-list-header-column-title";
	}

	/** The mass-operation mode of the widget, started by the button of a mass action. */
	public MassOperation<SELF> massOperation() {
		return new MassOperation<>(self());
	}

	/** The gear menu of the widget. */
	public WidgetSettings<SELF> settings() {
		return new WidgetSettings<>(self());
	}

	/**
	 * Types into the full text search field of the widget (options.fullTextSearch) and waits for the result.
	 * Empty or {@code null} text clears the field.
	 * <p>
	 * The search starts after a pause in typing and only from three characters. So the method waits for:
	 * <ul>
	 * <li>shorter text: the hint "Enter three or more characters";</li>
	 * <li>the field is cleared while the hint is shown: the hint is gone, then the requests and the loading spinner;</li>
	 * <li>other text: the search is applied ({@link #waitFullTextSearchApplied}), then the requests and the loading spinner.</li>
	 * </ul>
	 */
	public SELF fullTextSearch(String text) {
		String value = text == null ? "" : text;
		return Allure.step(message("list.search", value, label()), step -> {
			Duration timeout = getExpectations().getOverTimeout();
			SelenideElement input = element().$(TreeNavigation.FULL_TEXT_SEARCH).shouldBe(Condition.visible, getExpectations().getTimeout());
			if (value.equals(input.getValue())) {
				return self();
			}
			boolean hintShown = fullTextSearchHintShown();
			PageRequests.track();
			long sent = PageRequests.sent();
			// select all and delete: clear() does not trigger the change handler of the field
			input.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
			if (!value.isEmpty()) {
				input.sendKeys(value);
			}
			int length = value.trim().length();
			if (length > 0 && length < FULL_TEXT_SEARCH_MIN_LENGTH) {
				Selenide.Wait().withTimeout(timeout).until(driver -> fullTextSearchHintShown());
				return self();
			}
			if (length == 0 && hintShown) {
				// the hint and the search share the pause: the hint is gone after the search has started
				Selenide.Wait().withTimeout(timeout).until(driver -> !fullTextSearchHintShown());
			} else {
				waitFullTextSearchApplied(length == 0, sent, timeout);
			}
			PageRequests.waitDone(timeout);
			element().$(".ant-spin-spinning").shouldNot(Condition.exist, timeout);
			StepReport.count(element().$$("tbody tr[data-test-widget-list-row-type='Row']").size(), "found");
			return self();
		});
	}

	/** Text of the full text search field of the widget ({@code options.fullTextSearch}): empty when nothing is searched. */
	public String fullTextSearchValue() {
		return element().$(TreeNavigation.FULL_TEXT_SEARCH)
				.shouldBe(Condition.visible, getExpectations().getTimeout())
				.getValue();
	}

	/** A list sends a request for the search and for the clearing of the search. */
	protected void waitFullTextSearchApplied(boolean cleared, long sentBefore, Duration timeout) {
		PageRequests.waitSent(sentBefore, timeout);
	}

	private static boolean fullTextSearchHintShown() {
		return !$$(FULL_TEXT_SEARCH_HINT).filter(Condition.visible).isEmpty();
	}

}