package core.element.widget.cardlist;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import core.element.widget.PlatformIdentifier;
import core.element.widget.action.BurgerAction;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.filter.header.modal.FileViewerPopup;
import core.element.widget.list.rows.row.RowInlineForm;
import io.qameta.allure.Allure;
import java.time.Duration;
import java.util.function.Consumer;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static core.element.widget.AbstractWidget.logTime;

/**
 * A card of the CardList widget. The card shows the parts set in {@code options.card} of the widget, not the fields,
 * so they are read by {@link #checkTitle}, {@link #checkDescription} and {@link #checkStatus}.
 */
public class CardListRow extends RowInlineForm<CardListRow, CardListRows, CardListWidget, PlatformFormWidget> {

	private static final String FILE_VIEWER_POPUP = "div[class*='FileViewerContainer__popup']";

	public CardListRow(CardListRows parent, int pageIndex, String rowKey) {
		super(parent, pageIndex, rowKey);
	}

	@Override
	public SelenideElement element() {
		return getParent().element().findBy(attribute(ROW_ID_ATTRIBUTE, getRowKey()));
	}

	/** Passes the title of the card to the check: the field from {@code titleFieldKey} or the file name. */
	public CardListRow checkTitle(Consumer<String> checkTitle) {
		checkTitle.accept(text("Getting the title of the card", "div[class*='CardCarouselList__title']"));
		return this;
	}

	/** Passes the description of the card to the check: the field from {@code descriptionFieldKey}. */
	public CardListRow checkDescription(Consumer<String> checkDescription) {
		checkDescription.accept(text("Getting the description of the card", "div[class*='CardCarouselList__description']"));
		return this;
	}

	/** Passes the status of the card to the check: the value of the first dictionary field. */
	public CardListRow checkStatus(Consumer<String> checkStatus) {
		checkStatus.accept(text("Getting the status of the card", "div[class*='CardCarouselList__status']"));
		return this;
	}

	/**
	 * The form from {@code options.edit} in the file popup. After {@code Add} the popup with the form from
	 * {@code options.create} is already open, then the pencil is not clicked.
	 */
	@Override
	public PlatformFormWidget clickPencil() {
		if (!Selenide.$(FILE_VIEWER_POPUP).is(Condition.visible)) {
			clickCardButton("Clicking the pencil of the card", "edit");
		}
		return new PlatformFormWidget(PlatformIdentifier.NONE, null) {
			@Override
			public SelenideElement element() {
				return Selenide.$(FILE_VIEWER_POPUP + " div[data-test='WIDGET'][data-test-widget-type='Form']")
						.shouldBe(Condition.visible, getExpectations().getTimeout());
			}
		};
	}

	/** Opens the file of the card for viewing; the card has the eye when the widget has no {@code options.edit}. */
	public FileViewerPopup clickEye() {
		clickCardButton("Clicking the eye of the card", "eye");
		SelenideElement popup = Selenide.$(FILE_VIEWER_POPUP).shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		return new FileViewerPopup(popup, widget().element());
	}

	/** Clicks the link of the card title and passes the new page address to the check. */
	public CardListRow drilldown(Consumer<String> checkUrl) {
		Allure.step("Click-through when clicking on the title of the card", step -> {
			logTime(step);
			String oldUrl = WebDriverRunner.url();
			element().$("div[class*='CardCarouselList__title'] i[class*='anticon-link']")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
			webdriver().shouldNotHave(url(oldUrl), Duration.ofMillis(widget().getExpectations().getTimeout().toMillis()));
			checkUrl.accept(WebDriverRunner.url());
		});
		return this;
	}

	/** The record action of the card by its name from the service. The card shows it as a button with an icon. */
	@Override
	public BurgerAction<CardListRow, CardListRows, CardListWidget> burgerAction(String label) {
		SelenideElement action = hovered()
				.$("[data-test-widget-list-row-action-item='true'][data-test-action-text='" + label + "']")
				.shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		return new CardAction(this, widget(), label, action);
	}

	private String text(String stepName, String selector) {
		return Allure.step(stepName, step -> {
			logTime(step);
			return element().$(selector).shouldBe(Condition.visible, widget().getExpectations().getTimeout()).getText();
		});
	}

	private void clickCardButton(String stepName, String icon) {
		Allure.step(stepName, step -> {
			logTime(step);
			hovered().$("i[aria-label='icon: " + icon + "']")
					.closest("button")
					.shouldBe(Condition.visible, widget().getExpectations().getTimeout())
					.click();
		});
	}

	/** The card buttons are shown while the mouse is over the card. */
	private SelenideElement hovered() {
		SelenideElement card = element().shouldBe(Condition.visible, widget().getExpectations().getTimeout());
		card.hover();
		return card;
	}

	private static class CardAction extends BurgerAction<CardListRow, CardListRows, CardListWidget> {

		CardAction(CardListRow row, CardListWidget widget, String label, SelenideElement action) {
			super(row, widget, label, action);
		}

	}

}
