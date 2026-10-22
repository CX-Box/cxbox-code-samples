package core.config;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import core.common.Identifier;
import core.element.screen.PlatformScreen;
import core.element.screen.view.PlatformView;
import core.element.widget.AbstractWidget;
import core.element.widget.action.Action;
import core.element.widget.cardlist.CardListWidget;
import core.element.widget.chart.Column2DWidget;
import core.element.widget.chart.Line2DWidget;
import core.element.widget.chart.Pie1DWidget;
import core.element.widget.field.type.checkbox.CheckBox;
import core.element.widget.field.type.date.Date;
import core.element.widget.field.type.dateTime.DateTime;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSeconds;
import core.element.widget.field.type.dateTimeWithSec.DateTimeWithSecondsRO;
import core.element.widget.field.type.dictionary.Dictionary;
import core.element.widget.field.type.fileUpload.FileUpload;
import core.element.widget.field.type.fileUpload.FileUploadRO;
import core.element.widget.field.type.hint.Hint;
import core.element.widget.field.type.inlinePickList.InlinePickList;
import core.element.widget.field.type.input.Input;
import core.element.widget.field.type.input.InputRO;
import core.element.widget.field.type.money.Money;
import core.element.widget.field.type.multifield.Multifield;
import core.element.widget.field.type.multipleSelect.MultipleSelect;
import core.element.widget.field.type.multipleSelect.MultipleSelectRO;
import core.element.widget.field.type.multivalue.Multivalue;
import core.element.widget.field.type.multivalue.MultivalueModal;
import core.element.widget.field.type.multivalue.MultivalueRO;
import core.element.widget.field.type.multivalueHover.MultivalueHover;
import core.element.widget.field.type.multivalueTree.MultivalueTree;
import core.element.widget.field.type.multivalueTree.MultivalueTreeRO;
import core.element.widget.field.type.number.Number;
import core.element.widget.field.type.percent.Percent;
import core.element.widget.field.type.pickList.PickList;
import core.element.widget.field.type.pickList.PickListModal;
import core.element.widget.field.type.pickTree.PickTree;
import core.element.widget.field.type.radio.Radio;
import core.element.widget.field.type.richtext.RichText;
import core.element.widget.field.type.suggestionPickList.SuggestionPickList;
import core.element.widget.field.type.text.Text;
import core.element.widget.form.PlatformFormPopupWidget;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.info.PlatformAdditionalInfoWidget;
import core.element.widget.info.PlatformInfoWidget;
import core.element.widget.list.ListHeaders;
import core.element.widget.list.ListPagination;
import core.element.widget.list.realization.form.gh.PlatformGHWidgetInlineForm;
import core.element.widget.list.realization.form.list.PlatformListWidgetInlineForm;
import core.element.widget.list.realization.form.tree.PlatformTreeWidgetInlineForm;
import core.element.widget.list.realization.inline.gh.PlatformGHWidgetInline;
import core.element.widget.list.realization.inline.list.PlatformListRowInline;
import core.element.widget.list.realization.inline.list.PlatformListRowsInline;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.list.realization.inline.tree.PlatformTreeWidgetInline;
import core.element.widget.modal.ConfirmPopup;
import core.element.widget.statblock.StatsBlockWidget;
import core.element.widget.type.PlatformTypeWidgets;
import core.element.widget.type.TypeWidget;
import core.expectation.ExpectationPattern;
import core.page.UserMenu;

/**
 * The settings of the test core for a project whose UI differs from the box: the selectors and the classes of the parts.
 * The values here are the box. A project changes what differs, once, in its base test
 * ({@link core.element.PlatformApp#configure}); the tests keep the DSL of the core.
 * <ul>
 * <li>{@link #selectors}: an element of the project is found by another selector. One line, no class.</li>
 * <li>{@link #parts}: a part of the project acts otherwise. Its class extends the class of the core, so the DSL returns
 * the type of the core and the test needs no cast.</li>
 * </ul>
 *
 * <h5>Usage Example</h5>
 * <pre>{@code
 * PlatformApp.configure(cfg -> {
 *     cfg.selectors.listFieldTag = "td";
 *     cfg.parts.form.dictionary = MyDictionary::new;
 *     cfg.parts.list.row = MyListRow::new;
 * });
 * }</pre>
 */
public class PlatformConfig {

	public final Selectors selectors = new Selectors();

	public final Parts parts = new Parts();

	/** A value is CSS unless its comment says XPath; CSS can hold alternatives: {@code "a, button"} */
	public static class Selectors {

		/** The type of a widget in the page ({@code data-test-widget-type}) by the type of the box */
		public Function<String, String> widgetType = type -> type;

		/** The condition on the type of a widget for a CSS selector, with the type of the project */
		public String widgetTypeAttribute(String type) {
			return "[data-test-widget-type='" + widgetType.apply(type) + "']";
		}

		/** The layout of the application and its content, waited for after a drilldown */
		public String appLayout = "section[class*='appLayout']";
		public String appContent = "main[class*='ant-layout-content']";

		/** XPath inside an item of the main menu: the name of the screen, compared ignoring case */
		public String menuItemName = "@title";

		/** The tabs of the views of the second level: the container (empty: the page), the tab in it */
		public String secondLevelMenu = "div[data-test-widget-type='SecondLevelMenu']";
		public String secondLevelMenuTab = "span[data-test-navigation-tabs-item='true']";

		/** The panel of the actions of a widget (empty: the widget itself), a button in it */
		public String actions = "div[class*='Operations__operations']";
		public String actionsButton = "button";

		/** The tag of a field with its test attributes: on a widget, in a row of a table */
		public String fieldTag = "div";
		public String listFieldTag = "div";

		/** The drilldown link inside a field; for date, dateTime, money and text fields the second one */
		public String drilldown = "i[class=\"anticon anticon-link\"]";
		public String drilldownText = "span a";

		/** The drilldown link inside the value of an input field (read-only on a form, in a row) */
		public String link = "span:has(a)";

		/** The value of a dictionary field: on a form, on an info widget, in a row, in a row in edit */
		public String dictionaryValue = "[data-test-field-dictionary-item=\"true\"]";
		public String infoDictionaryValue = "div[data-test-field-value=\"true\"]";
		public String listDictionaryValue = "div[class*='Dictionary']";
		public String listDictionaryEditValue = "span";

		/** The value of a date field and of a number field on an info widget, of a number field in a row */
		public String infoDateValue = "span[class*='ReadOnlyField'";
		public String infoNumberValue = "span[class*='ReadOnlyField__readOnlyField']";
		public String listNumberValue = "span[class*='ReadOnlyField__readOnlyField']";

		/** The file of a file field (download, check that there is none): on a form, in a row */
		public String fileUploadFile = "button";
		public String listFileUploadFile = "button";

		/** The icon that opens the popup of a multivalue field, the button that saves the choice of the popup */
		public String multivalueIcon = "div[data-test-field-multivalue-icon=\"true\"]";
		public String multivalueSave = "button[data-test-widget-list-close=\"true\"]";

		/** The value of a pick list field (text, or value of an input), its icons, the open popup of the field */
		public String pickListValue = "div[class=\"ant-select-selection-selected-value\"]";
		public String pickListPopupIcon = "i[data-test-field-picklist-popup=\"true\"]";
		public String pickListClearIcon = "i[data-test-field-picklist-clear=\"true\"]";
		public String pickListPopup = "div[data-test-widget-type$=\"Popup\"] .ant-modal";

		/** The message and the buttons of the confirm popup */
		public String confirmMessage = "p";
		public String confirmOk = "[data-test-confirm-popup-button-ok=\"true\"]";
		public String confirmCancel = "[data-test-confirm-popup-button-cancel=\"true\"]";

		/** The pagination of a list and a page button in it */
		public String pagination = "div[data-test-widget-list-pagination=\"true\"]";
		public String paginationPage = "li[tabindex=\"0\"].ant-pagination-item";

		/**
		 * A button of the steps of a mass operation by its text in the box: Next, Back, Cancel, Close. A project whose UI
		 * translates them gives its text: {@code text -> Map.of("Next", "Далее").getOrDefault(text, text)}
		 */
		public Function<String, String> massOperationButton = text -> text;

		/** The steps of a mass operation, the passed ones, the check box of a row in the step Select rows */
		public String massOperationStep = "div.ant-steps-item";
		public String massOperationDoneStep = "div.ant-steps-item-finish";
		public String massOperationRowCheckbox = "td.ant-table-selection-column input";

		/** The confirm button of the form in the step Confirm operation: the first one, its text is the yesText */
		public String massOperationConfirm = "div[class*='ConfirmWithForm__actions'] button";

		/** The result of a row in the step View results: done or failed; a row without them was not done */
		public String massOperationRowDone = "i[aria-label='icon: check-circle']";
		public String massOperationRowFailed = "i[aria-label='icon: close-square']";

		/** The active role in the user menu */
		public String userMenuActiveRole = "[class*='checked'] [data-test-menu-user-role]";

	}

	/**
	 * The parts that the DSL creates. The fields of the rows of a list come with the row ({@link ListParts#row}): a
	 * field of a row has the types of its list, its row and their rows.
	 */
	public static class Parts {

		/** A screen by its name, the screen that is open now, a view, the user menu */
		public Function<String, PlatformScreen> screen = PlatformScreen::new;
		public Supplier<PlatformScreen> currentScreen = PlatformScreen::new;
		public Supplier<PlatformView> view = PlatformView::new;
		public Supplier<UserMenu> userMenu = UserMenu::new;

		public final Widgets widgets = new Widgets();

		public final FormFields form = new FormFields();
		public final InfoFields info = new InfoFields();
		public final ListParts list = new ListParts();

		/** The actions and the confirm popup of any widget, the popups of a pick list field and of a multivalue field */
		public ActionPart actions = Action::new;
		public ConfirmPopupPart confirmPopup = ConfirmPopup::new;
		public PickListPopupPart pickListPopup = PickListModal::new;
		public MultivalueModalPart multivalueModal = MultivalueModal::new;

	}

	/** The widgets of a view */
	public static class Widgets {

		public WidgetPart<PlatformFormWidget> form = PlatformFormWidget::new;
		public WidgetPart<PlatformFormPopupWidget> formPopup = PlatformFormPopupWidget::new;
		public WidgetPart<PlatformInfoWidget> info = PlatformInfoWidget::new;
		public WidgetPart<PlatformAdditionalInfoWidget> additionalInfo = PlatformAdditionalInfoWidget::new;
		public WidgetPart<PlatformListWidgetInline> list = PlatformListWidgetInline::new;

		/** AdditionalList widget: a List of its own type */
		public WidgetPart<PlatformListWidgetInline> additionalList = (identifier, text) ->
				new PlatformListWidgetInline(identifier, text) {
					@Override
					public TypeWidget getType() {
						return PlatformTypeWidgets.ADDITIONAL_LIST;
					}
				};

		public WidgetPart<PlatformListWidgetInlineForm> listInlineForm = PlatformListWidgetInlineForm::new;
		public WidgetPart<PlatformGHWidgetInline> groupingHierarchy = PlatformGHWidgetInline::new;
		public WidgetPart<PlatformGHWidgetInlineForm> groupingHierarchyInlineForm = PlatformGHWidgetInlineForm::new;
		public WidgetPart<PlatformTreeWidgetInline> tree = PlatformTreeWidgetInline::new;
		public WidgetPart<PlatformTreeWidgetInlineForm> treeInlineForm = PlatformTreeWidgetInlineForm::new;
		public WidgetPart<StatsBlockWidget> statBlock = StatsBlockWidget::new;
		public WidgetPart<Pie1DWidget> pie1D = Pie1DWidget::new;
		public WidgetPart<Column2DWidget> column2D = Column2DWidget::new;
		public WidgetPart<Line2DWidget> line2D = Line2DWidget::new;
		public WidgetPart<CardListWidget> cardList = CardListWidget::new;

	}

	/** The fields of a form; {@code time(title, format)} is not here: it has three arguments */
	public static class FormFields {

		public FormField<Input<PlatformFormWidget, ?>> input = Input::new;
		public FormField<CheckBox<PlatformFormWidget, ?>> checkbox = (form, title) -> new CheckBox<>(title, form);
		public FormField<DateTimeWithSeconds<PlatformFormWidget, ?>> dateTimeWithSecond = (form, title) -> new DateTimeWithSeconds<>(title, form);
		public FormField<Date<PlatformFormWidget, ?>> date = (form, title) -> new Date<>(title, form);
		public FormField<DateTime<PlatformFormWidget, ?>> dateTime = DateTime::new;
		public FormField<Dictionary<PlatformFormWidget, ?>> dictionary = Dictionary::new;
		public FormField<Hint<PlatformFormWidget, ?>> hint = Hint::new;
		public FormField<InlinePickList<PlatformFormWidget, ?>> inlinePickList = InlinePickList::new;
		public FormField<Money<PlatformFormWidget, ?>> money = Money::new;
		public FormField<Multifield<PlatformFormWidget, ?>> multifield = Multifield::new;
		public FormField<MultipleSelect<PlatformFormWidget, ?>> multipleSelect = MultipleSelect::new;
		public FormField<Multivalue<PlatformFormWidget>> multivalue = Multivalue::new;
		public FormField<MultivalueHover<PlatformFormWidget, ?>> multivalueHover = MultivalueHover::new;
		public FormField<Number<PlatformFormWidget, ?>> number = Number::new;
		public FormField<PickList<PlatformFormWidget, ?>> pickList = PickList::new;
		public FormField<PickTree<PlatformFormWidget, ?>> pickTree = PickTree::new;
		public FormField<MultivalueTree<PlatformFormWidget>> multivalueTree = MultivalueTree::new;
		public FormField<Percent<PlatformFormWidget, ?>> percent = Percent::new;
		public FormField<Radio<PlatformFormWidget, ?>> radio = Radio::new;
		public FormField<SuggestionPickList<PlatformFormWidget, ?>> suggestionPickList = SuggestionPickList::new;
		public FormField<Text<PlatformFormWidget, ?>> text = Text::new;
		public FormField<RichText<PlatformFormWidget, ?>> richText = RichText::new;
		public FormField<FileUpload<PlatformFormWidget, ?>> fileUpload = FileUpload::new;

	}

	/** The fields of an info widget; {@code time(title, format)} is not here: it has three arguments */
	public static class InfoFields {

		public InfoField<InputRO<PlatformInfoWidget>> input = (info, title) -> new InputRO<>(title, info);
		public InfoField<CheckBox<PlatformInfoWidget, ?>> checkbox = (info, title) -> new CheckBox<>(title, info);
		public InfoField<DateTimeWithSecondsRO<PlatformInfoWidget, ?>> dateTimeWithSeconds = (info, title) -> new DateTimeWithSecondsRO<>(title, info);
		public InfoField<Date<PlatformInfoWidget, ?>> date = (info, title) -> new Date<>(title, info);
		public InfoField<DateTime<PlatformInfoWidget, ?>> dateTime = DateTime::new;
		public InfoField<Dictionary<PlatformInfoWidget, ?>> dictionary = Dictionary::new;
		public InfoField<FileUploadRO<PlatformInfoWidget>> fileUpload = FileUploadRO::new;
		public InfoField<Percent<PlatformInfoWidget, ?>> percent = Percent::new;
		public InfoField<Hint<PlatformInfoWidget, ?>> hint = Hint::new;
		public InfoField<Money<PlatformInfoWidget, ?>> money = Money::new;
		public InfoField<Multifield<PlatformInfoWidget, ?>> multiField = Multifield::new;
		public InfoField<MultipleSelectRO<PlatformInfoWidget, ?>> multipleSelect = MultipleSelectRO::new;
		public InfoField<MultivalueHover<PlatformInfoWidget, ?>> multivalueHover = MultivalueHover::new;
		public InfoField<MultivalueRO<PlatformInfoWidget>> multivalue = MultivalueRO::new;
		public InfoField<Radio<PlatformInfoWidget, ?>> radio = Radio::new;
		public InfoField<Number<PlatformInfoWidget, ?>> number = Number::new;
		public InfoField<Text<PlatformInfoWidget, ?>> text = Text::new;
		public InfoField<RichText<PlatformInfoWidget, ?>> richText = RichText::new;
		public InfoField<PickList<PlatformInfoWidget, ?>> pickList = PickList::new;
		public InfoField<PickTree<PlatformInfoWidget, ?>> pickTree = PickTree::new;
		public InfoField<MultivalueTreeRO<PlatformInfoWidget>> multivalueTree = MultivalueTreeRO::new;

	}

	/** The rows, the headers and the pages of the List widget; the other lists (tree, grouping hierarchy) keep theirs */
	public static class ListParts {

		public Function<PlatformListWidgetInline, PlatformListRowsInline> rows = PlatformListRowsInline::new;
		public ListRowPart row = PlatformListRowInline::new;
		public Function<PlatformListWidgetInline, ListHeaders<PlatformListWidgetInline, PlatformListRowsInline, PlatformListRowInline>> headers = ListHeaders::new;
		public Function<PlatformListWidgetInline, ListPagination<PlatformListWidgetInline>> pagination = ListPagination::new;

	}

	/*
	 * A part of any widget has the type of its widget: a lambda cannot be generic, so these parts take a constructor
	 * reference, MyAction::new of a class MyAction<W> extends Action<W>.
	 */

	public interface ActionPart {
		<W extends AbstractWidget<ExpectationPattern, W>> Action<W> create(W widget);
	}

	public interface ConfirmPopupPart {
		<W extends AbstractWidget<ExpectationPattern, W>> ConfirmPopup<W> create(W widget);
	}

	public interface PickListPopupPart {
		<W extends AbstractWidget<ExpectationPattern, W>> PickListModal<W> create(W widget);
	}

	public interface MultivalueModalPart {
		<W extends AbstractWidget<ExpectationPattern, W>> MultivalueModal<W> create(W widget);
	}

	/** {@code edit}: the row is open for a change ({@code editRow()}) */
	public interface ListRowPart {
		PlatformListRowInline create(PlatformListRowsInline rows, int pageIndex, String rowKey, boolean edit);
	}

	/** A widget by the title or the name */
	public interface WidgetPart<W> extends BiFunction<Identifier, String, W> {
	}

	/** A field by its title */
	public interface FormField<F> extends BiFunction<PlatformFormWidget, String, F> {
	}

	public interface InfoField<F> extends BiFunction<PlatformInfoWidget, String, F> {
	}

}
