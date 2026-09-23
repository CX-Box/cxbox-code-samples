package core.element.widget.field.type.richtext;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static core.element.widget.AbstractWidget.logTime;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.PlaceholderCheckable;
import core.element.widget.field.attribute.checkable.ReadOnlyCheckable;
import core.element.widget.field.attribute.checkable.RequiredCheckable;
import core.element.widget.field.attribute.checkable.ValueCheckable;
import core.element.widget.field.attribute.custom.Clear;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import java.util.function.Consumer;
import java.util.function.Function;
import org.openqa.selenium.StaleElementReferenceException;

/**
 * The RichText field: a visual editor whose value is markdown.
 *
 * <p>Like every field: {@link #setValue} puts a value in (the way the application does when a value
 * comes from the database), {@link #getValue} reads the markdown the field stores, {@link #checkValue},
 * {@link #clear}, {@link #checkReadOnly}, {@link #checkPlaceholder}, {@link #checkRequired}, and
 * {@link #checkTruncated} for a value cut to the field height in view mode.
 *
 * <p>Special for RichText - what the user does: {@link #userInput} types text and formats it with the
 * field's own methods, {@code field.userInput("abc", f -> f.bold(0, 3)).getValue()} is {@code **abc**}.
 * Its parts are public too: {@link #type}, {@link #select}, {@link #selectAll}, and one method per
 * toolbar button - {@link #bold()}, {@link #heading(int)}, {@link #color(String)} and so on. Every
 * button method has a second form with positions, {@code bold(from, to)}: select characters
 * {@code from}-{@code to}, then click. Positions count characters: one per character, one per line
 * break, one per paragraph break. A button the toolbar has greyed out throws {@link Refused}.
 *
 * <p>The field is driven through the editor's own JavaScript object and one in-page script for the
 * toolbar, not through Selenide selectors: {@link RichTextCanvas} and {@link RichTextToolbar} say why.
 */
public class RichText<W extends AbstractWidget<ExpectationPattern, W>, SELF extends RichText<W, SELF>>
		extends AbstractFieldImpl<ExpectationPattern, W, String, SELF>
		implements ValueCheckable<W, String, SELF>, Clear<W, String, SELF>, ReadOnlyCheckable<W, String, Boolean, SELF>,
		PlaceholderCheckable<W, String, String, SELF>, RequiredCheckable<W, String, String, SELF> {

	private SelenideElement resolved;

	public RichText(W widget, String title) {
		super(widget, title, PlatformIdentifier.TITLE);
	}

	@Override
	protected SelenideElement parentElement() {
		return widget().element();
	}

	@Override
	public FieldType fieldType() {
		return PlatformFieldType.RICH_TEXT;
	}

	/**
	 * The field element, found once and reused: the base locator is lazy and re-finds the widget and
	 * the field on every use. If the page changes, the browser reports a stale element and
	 * {@link #onField} finds it again.
	 */
	@Override
	public SelenideElement element() {
		if (resolved == null) {
			SelenideElement field = super.element().shouldBe(exist);
			field.$(".ProseMirror").shouldBe(visible);   // the editor is on the page
			resolved = Selenide.$(field.toWebElement());
		}
		return resolved;
	}

	private <T> T onField(Function<SelenideElement, T> operation) {
		try {
			return operation.apply(element());
		} catch (StaleElementReferenceException stale) {
			resolved = null;
			return operation.apply(element());
		}
	}

	// ---- like every field -----------------------------------------------------------------------

	/** The markdown the field stores for what is in the editor now. */
	@Override
	public String getValue() {
		return Allure.step("Getting a value from a field", step -> {
			logTime(step);
			return onField(RichTextCanvas::markdown);
		});
	}

	/** Opens {@code markdown} the way the application opens a value from the database. */
	@Override
	public SELF setValue(String markdown) {
		Allure.step("Setting a value in a field: " + printable(markdown), step -> {
			logTime(step);
			onField(field -> {
				RichTextCanvas.load(field, markdown);
				return field;
			});
		});
		return asSelf();
	}

	/**
	 * Empties the field the way the user does (select all, delete) and waits until the application has the
	 * empty value, so a Save right after it sends the empty value.
	 */
	@Override
	public SELF clear() {
		Allure.step("Clearing the field", () -> onField(field -> {
			RichTextCanvas.clearAsUser(field);
			Selenide.Wait().until(driver -> RichTextCanvas.applied(field));
			return field;
		}));
		return asSelf();
	}

	@Override
	public SELF checkReadOnly(Consumer<Boolean> expectedReadOnly) {
		return Allure.step("Checking the field for \"ReadOnly\"", step -> {
			logTime(step);
			expectedReadOnly.accept(element().$(".ProseMirror").has(attribute("contenteditable", "false")));
			return asSelf();
		});
	}

	/**
	 * The placeholder the user sees in the empty visual editor, or null. The editor has no input with a
	 * placeholder attribute: it draws the text before its empty first paragraph, so the check reads what is
	 * drawn there.
	 */
	@Override
	public SELF checkPlaceholder(Consumer<String> expectedPlaceholder) {
		return Allure.step("Getting the Placeholder value", step -> {
			logTime(step);
			expectedPlaceholder.accept(onField(field -> {
				SelenideElement empty = field.$(".ProseMirror p.is-editor-empty");
				if (!empty.exists()) {
					return null;
				}
				String drawn = Selenide.executeJavaScript("return getComputedStyle(arguments[0], '::before').content", empty);
				String text = drawn == null || "none".equals(drawn) ? "" : drawn.replaceAll("^\"|\"$", "");
				return text.isEmpty() ? null : text;
			}));
			return asSelf();
		});
	}

	/**
	 * Whether the value in view mode is cut to the field height ({@code maxRows}): the field then shows
	 * "..." that opens the full value.
	 */
	public SELF checkTruncated(Consumer<Boolean> expectedTruncated) {
		return Allure.step("Checking that the value is cut to the field height", step -> {
			logTime(step);
			expectedTruncated.accept(onField(field -> field.$("[class*='moreButton']").exists()));
			return asSelf();
		});
	}

	// ---- what the user does ---------------------------------------------------------------------

	/**
	 * Clears the field, types {@code text}, selects all of it and runs {@code actions} on the field.
	 * In the actions {@code f.bold()} is Bold over the whole text, {@code f.bold(0, 6)} over characters
	 * 0-6. Read the result with {@link #getValue}.
	 */
	public SELF userInput(String text, Consumer<? super SELF> actions) {
		// the empty editor is not passed to the application: the typed text follows at once
		onField(field -> {
			RichTextCanvas.load(field, "");
			return field;
		});
		type(text);
		actions.accept(selectAll());
		return asSelf();
	}

	/**
	 * Types {@code text} at the end as plain text: markdown characters in it stay characters. A line
	 * break in the text is Shift+Enter, an empty line is Enter.
	 */
	public SELF type(String text) {
		Allure.step("Typing: " + printable(text), () -> onField(field -> {
			RichTextCanvas.type(field, text);
			return field;
		}));
		return asSelf();
	}

	public SELF selectAll() {
		onField(field -> {
			RichTextCanvas.selectAll(field);
			return field;
		});
		return asSelf();
	}

	/** Selects characters {@code from} (inclusive) to {@code to} (exclusive). */
	public SELF select(int from, int to) {
		Allure.step("Selecting [" + from + ", " + to + ")", () -> onField(field -> {
			RichTextCanvas.select(field, from, to);
			return field;
		}));
		return asSelf();
	}

	/** Clicks a toolbar button, opening its menu first if it is in one. Throws {@link Refused} if it is greyed out. */
	public SELF click(RichTextAction action) {
		try {
			RichTextToolbar.click(action);
		} catch (Refused greyedOut) {
			Allure.step("Clicking " + action + " → the button is greyed out");
			throw greyedOut;
		}
		Allure.step("Clicking " + action);
		return asSelf();
	}

	/** Whether a toolbar button can be clicked for the current selection. */
	public boolean isEnabled(RichTextAction action) {
		element();
		return RichTextToolbar.isEnabled(action);
	}

	public SELF bold() {
		return click(RichTextAction.BOLD);
	}

	public SELF bold(int from, int to) {
		return select(from, to).bold();
	}

	public SELF italic() {
		return click(RichTextAction.ITALIC);
	}

	public SELF italic(int from, int to) {
		return select(from, to).italic();
	}

	public SELF underline() {
		return click(RichTextAction.UNDERLINE);
	}

	public SELF underline(int from, int to) {
		return select(from, to).underline();
	}

	public SELF strike() {
		return click(RichTextAction.STRIKETHROUGH);
	}

	public SELF strike(int from, int to) {
		return select(from, to).strike();
	}

	public SELF inlineCode() {
		return click(RichTextAction.INLINE_CODE);
	}

	public SELF inlineCode(int from, int to) {
		return select(from, to).inlineCode();
	}

	public SELF codeBlock() {
		return click(RichTextAction.CODE_BLOCK);
	}

	public SELF codeBlock(int from, int to) {
		return select(from, to).codeBlock();
	}

	public SELF paragraph() {
		return click(RichTextAction.PARAGRAPH);
	}

	public SELF paragraph(int from, int to) {
		return select(from, to).paragraph();
	}

	public SELF bulletList() {
		return click(RichTextAction.BULLET_LIST);
	}

	public SELF bulletList(int from, int to) {
		return select(from, to).bulletList();
	}

	public SELF orderedList() {
		return click(RichTextAction.ORDERED_LIST);
	}

	public SELF orderedList(int from, int to) {
		return select(from, to).orderedList();
	}

	public SELF quote() {
		return click(RichTextAction.QUOTE);
	}

	public SELF quote(int from, int to) {
		return select(from, to).quote();
	}

	public SELF clearFormat() {
		return click(RichTextAction.CLEAR_FORMAT);
	}

	public SELF clearFormat(int from, int to) {
		return select(from, to).clearFormat();
	}

	public SELF heading(int level) {
		return click(RichTextAction.heading(level));
	}

	public SELF heading(int level, int from, int to) {
		return select(from, to).heading(level);
	}

	/** {@code name} is the colour as markdown writes it: {@code red}, {@code green}, ... {@code default} removes the colour. */
	public SELF color(String name) {
		return click(RichTextAction.color(name));
	}

	public SELF color(String name, int from, int to) {
		return select(from, to).color(name);
	}

	// ---------------------------------------------------------------------------------------------

	/** Thrown by a click on a toolbar button that is greyed out for the current selection. */
	public static final class Refused extends IllegalStateException {

		public Refused(String message) {
			super(message);
		}

	}

	/** Makes invisible characters visible, for step names and failure messages. */
	public static String printable(String text) {
		if (text == null) {
			return "null";
		}
		return text.replace("\u200B", "<ZWSP>").replace("\u00A0", "<NBSP>").replace("\n", "\\n").replace("\t", "\\t");
	}

	@SuppressWarnings("unchecked")
	private SELF asSelf() {
		return (SELF) this;
	}

}
