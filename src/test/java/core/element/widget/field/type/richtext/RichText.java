package core.element.widget.field.type.richtext;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static core.element.widget.AbstractWidget.logTime;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.element.widget.AbstractWidget;
import core.element.widget.PlatformIdentifier;
import core.element.widget.field.AbstractFieldImpl;
import core.element.widget.field.FieldType;
import core.element.widget.field.PlatformFieldType;
import core.element.widget.field.attribute.checkable.ValueCheckable;
import core.expectation.ExpectationPattern;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

/**
 * Page-object for the RichText field (Tiptap WYSIWYG + Markdown source editor).
 *
 * <p>The "value" of the field is its stored <b>markdown</b>; {@link #getValue()}/{@link #setValue}
 * operate on it through the source editor (locale- and layout-independent, so it is the stable choice
 * for round-trip assertions).
 *
 * <p>Toolbar actions are addressed by their <b>stable, non-localized key</b> via the
 * {@code data-test-rich-text-action} attribute (e.g. {@code "Bold"}, {@code "Heading 1"}, {@code "Red"},
 * {@code "Settings"}). Never by the translated title. Whether a button is shown directly, hidden behind
 * the "⋯" overflow menu, or is an item inside a dropdown depends on the viewport width — so
 * {@link #clickAction} / {@link #pick} discover that at runtime and click in the right place.
 */
public class RichText<W extends AbstractWidget<ExpectationPattern, W>, SELF extends RichText<W, SELF>>
		extends AbstractFieldImpl<ExpectationPattern, W, String, SELF>
		implements ValueCheckable<W, String, SELF> {

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

	// region ---- toolbar addressing (overflow-aware) ----

	/** All currently VISIBLE elements carrying this action key (toolbar button and/or open menu item). */
	private ElementsCollection actions(String key) {
		element().shouldBe(exist); // ensure the editor is mounted
		return $$("[data-test-rich-text-action=\"" + key + "\"]").filter(visible);
	}

	/**
	 * Clicks a toolbar action, resolving where it actually lives: a directly-visible button, or — when
	 * the toolbar is too narrow — an item revealed by opening the "⋯" overflow (More) menu.
	 */
	private void clickAction(String key) {
		if (actions(key).size() > 0) {
			actions(key).first().shouldBe(enabled).click();
			return;
		}
		actions("More").first().shouldBe(visible).click();
		actions(key).first().shouldBe(visible).click();
	}

	/**
	 * Opens a dropdown ({@code parentKey}: Heading / List / Code / Text color / Settings) and clicks a
	 * child item ({@code itemKey}). Works whether the parent sits in the toolbar or under the "⋯" menu.
	 */
	private void pick(String parentKey, String itemKey) {
		clickAction(parentKey);
		if (actions(itemKey).size() == 0) {
			actions(parentKey).first().hover(); // parent came from the overflow menu → expand its submenu
		}
		actions(itemKey).first().shouldBe(visible).click();
	}

	// endregion

	// region ---- mode switching (⚙ Settings) ----

	public SELF openMarkdownSource() {
		return Allure.step("Switch RichText to Markdown source", step -> {
			logTime(step);
			if (!isSourceMode()) {
				pick("Settings", "Markdown markup");
				element().$(".cm-content").shouldBe(visible);
			}
			return (SELF) this;
		});
	}

	public SELF openVisualEditor() {
		return Allure.step("Switch RichText to Visual editor", step -> {
			logTime(step);
			if (isSourceMode()) {
				pick("Settings", "Visual Editor");
				editable();
			}
			return (SELF) this;
		});
	}

	private boolean isSourceMode() {
		return element().$(".cm-content").is(exist);
	}

	private SelenideElement editable() {
		return element().shouldBe(exist).$(".ProseMirror").shouldBe(visible);
	}

	// endregion

	// region ---- value = markdown (via source editor) ----

	@Override
	public String getValue() {
		return Allure.step("Read markdown from RichText", step -> {
			logTime(step);
			openMarkdownSource();
			return readCodeMirror();
		});
	}

	@Override
	public SELF setValue(String markdown) {
		return Allure.step("Set markdown into RichText", step -> {
			logTime(step);
			openMarkdownSource();
			SelenideElement cm = element().$(".cm-content").shouldBe(visible);
			cm.click();
			cm.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
			cm.sendKeys(markdown);
			return (SELF) this;
		});
	}

	/** Round-trip helper: markdown → parse (visual) → serialize (source) → markdown. */
	public String roundTrip(String markdown) {
		setValue(markdown);
		openVisualEditor();
		return getValue();
	}

	private String readCodeMirror() {
		String text = executeJavaScript("return arguments[0].innerText;", element().$(".cm-content"));
		// CodeMirror's innerText appends blank trailing lines for the empty editor rows; strip trailing
		// whitespace so markdown assertions are exact. Mid-content whitespace (incl. U+200B) is kept.
		return text == null ? "" : text.replaceAll("\\s+$", "");
	}

	// endregion

	// region ---- visual editing ----

	public SELF type(String text) {
		return Allure.step("Type into RichText", step -> {
			logTime(step);
			openVisualEditor();
			editable().click();
			editable().sendKeys(text);
			return (SELF) this;
		});
	}

	public SELF selectAll() {
		editable().click();
		editable().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		return (SELF) this;
	}

	public SELF clearContent() {
		selectAll();
		editable().sendKeys(Keys.BACK_SPACE);
		return (SELF) this;
	}

	/** Selects {@code length} characters starting at character {@code from} (0-based) on the first line. */
	public SELF selectRange(int from, int length) {
		editable().click();
		editable().sendKeys(Keys.HOME);
		for (int i = 0; i < from; i++) {
			editable().sendKeys(Keys.ARROW_RIGHT);
		}
		for (int i = 0; i < length; i++) {
			editable().sendKeys(Keys.chord(Keys.SHIFT, Keys.ARROW_RIGHT));
		}
		return (SELF) this;
	}

	// endregion

	// region ---- toolbar actions (mouse) ----

	public SELF bold() {
		openVisualEditor();
		clickAction("Bold");
		return (SELF) this;
	}

	public SELF italic() {
		openVisualEditor();
		clickAction("Italic");
		return (SELF) this;
	}

	public SELF underline() {
		openVisualEditor();
		clickAction("Underline");
		return (SELF) this;
	}

	public SELF strike() {
		openVisualEditor();
		clickAction("Strikethrough");
		return (SELF) this;
	}

	public SELF inlineCode() {
		openVisualEditor();
		pick("Code", "Inline code");
		return (SELF) this;
	}

	public SELF codeBlock() {
		openVisualEditor();
		pick("Code", "Code block");
		return (SELF) this;
	}

	public SELF heading(int level) {
		openVisualEditor();
		pick("Heading", "Heading " + level);
		return (SELF) this;
	}

	public SELF paragraph() {
		openVisualEditor();
		pick("Heading", "Text");
		return (SELF) this;
	}

	public SELF bulletList() {
		openVisualEditor();
		pick("List", "Bullet List");
		return (SELF) this;
	}

	public SELF orderedList() {
		openVisualEditor();
		pick("List", "Ordered List");
		return (SELF) this;
	}

	/** {@code menuLabel} is the colour's stable key, e.g. "Red", "Yellow", "Green". */
	public SELF color(String menuLabel) {
		openVisualEditor();
		pick("Text color", menuLabel);
		return (SELF) this;
	}

	public SELF quote() {
		openVisualEditor();
		clickAction("Quote");
		return (SELF) this;
	}

	public SELF clearFormat() {
		openVisualEditor();
		clickAction("Clear Format");
		return (SELF) this;
	}

	/** Whether a toolbar action is enabled (used to assert the flanking guard greys out formatting). */
	public boolean isToolbarEnabled(String key) {
		openVisualEditor();
		SelenideElement item;
		if (actions(key).size() > 0) {
			item = actions(key).first();
		} else {
			actions("More").first().shouldBe(visible).click();
			item = actions(key).first().shouldBe(visible);
		}
		return !(item.has(attribute("disabled"))
				|| item.has(cssClass("ant-dropdown-menu-item-disabled"))
				|| "true".equals(item.getAttribute("aria-disabled")));
	}

	/** Raw HTML the visual editor renders — for asserting how markup is displayed. */
	public String visualHtml() {
		openVisualEditor();
		return editable().innerHtml();
	}

	// endregion
}
