package core.element.widget.calendar;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.field.type.input.ListInput;

import java.util.function.Consumer;

/** The title field of a calendar event: its value and its drilldown; the value is edited in the form of the event. */
public class CalendarInput<W extends CalendarWidget<W>> extends ListInput<W, CalendarRows<W>, CalendarRow<W>> {

	private final String title;

	public CalendarInput(String title, W widget, CalendarRow<W> row) {
		super(title, widget, row);
		this.title = title;
	}

	@Override
	public SelenideElement element() {
		return row().element()
				.$("[data-test=\"FIELD\"][data-test-field-type=\"" + fieldType().getType() + "\"][data-test-field-title=\"" + title + "\"]")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
	}

	@Override
	public String getValue() {
		return element().getText();
	}

	/** Clicks the title link of the event (the field has a drilldown). */
	@Override
	public void drilldown(Consumer<String> consumer) {
		String url = WebDriverRunner.url();
		element().$("[class*='actionLink']")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
				.click();
		Selenide.Wait().until(webDriver -> !webDriver.getCurrentUrl().equals(url));
		widget().getExpectations().getContextMenu();
		consumer.accept(WebDriverRunner.url());
	}

	/** Not applicable: the event shows the value only, it is edited in the form of {@link CalendarRow#clickPencil()}. */
	@Override
	public CalendarInput<W> setValue(String value) {
		throw new UnsupportedOperationException("The event shows the value only: edit it in the form of row.clickPencil()");
	}

}
