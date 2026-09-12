package core.element.widget.field.type.richtext;

import java.util.Arrays;

/**
 * Every button and menu item on the RichText toolbar, by its key.
 *
 * <p>The key is the {@code data-test-rich-text-action} attribute the UI puts on the control, not the
 * translated title, so a test does not break when the interface language changes. {@link #menu} is
 * the key of the menu the item is in, or null for a button on the toolbar itself.
 */
public enum RichTextAction {

	UNDO("Undo"),
	REDO("Redo"),

	BOLD("Bold"),
	ITALIC("Italic"),
	UNDERLINE("Underline"),
	STRIKETHROUGH("Strikethrough"),

	QUOTE("Quote"),
	CLEAR_FORMAT("Clear Format"),

	PARAGRAPH("Text", "Heading"),
	HEADING_1("Heading 1", "Heading"),
	HEADING_2("Heading 2", "Heading"),
	HEADING_3("Heading 3", "Heading"),
	HEADING_4("Heading 4", "Heading"),
	HEADING_5("Heading 5", "Heading"),
	HEADING_6("Heading 6", "Heading"),

	BULLET_LIST("Bullet List", "List"),
	ORDERED_LIST("Ordered List", "List"),
	SINK_ITEM("Sink Item", "List"),
	LIFT_ITEM("Lift Item", "List"),

	INLINE_CODE("Inline code", "Code"),
	CODE_BLOCK("Code block", "Code"),

	COLOR_DEFAULT("Default", "Text color"),
	COLOR_GRAY("Gray", "Text color"),
	COLOR_YELLOW("Yellow", "Text color"),
	COLOR_ORANGE("Orange", "Text color"),
	COLOR_RED("Red", "Text color"),
	COLOR_GREEN("Green", "Text color"),
	COLOR_BLUE("Blue", "Text color"),
	COLOR_VIOLET("Violet", "Text color"),

	MARKDOWN_SOURCE("Markdown markup", "Settings"),
	VISUAL_EDITOR("Visual Editor", "Settings"),

	/** The "⋯" button the toolbar shows when it is too narrow for all its buttons. */
	MORE("More");

	private final String key;

	private final String menu;

	RichTextAction(String key) {
		this(key, null);
	}

	RichTextAction(String key, String menu) {
		this.key = key;
		this.menu = menu;
	}

	public String key() {
		return key;
	}

	public String menu() {
		return menu;
	}

	/** {@code heading(2)} is {@link #HEADING_2}. */
	public static RichTextAction heading(int level) {
		return Arrays.stream(values())
				.filter(action -> action.key.equals("Heading " + level))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("There is no Heading " + level + ", only 1 to 6"));
	}

	/** {@code color("red")} is {@link #COLOR_RED}: the name as markdown writes it, {@code default} removes the colour. */
	public static RichTextAction color(String name) {
		String key = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		return Arrays.stream(values())
				.filter(action -> "Text color".equals(action.menu) && action.key.equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("There is no colour \"" + name + "\" on the toolbar"));
	}

	/** "Bold", or "Text color > Red" for a menu item. */
	@Override
	public String toString() {
		return menu == null ? key : menu + " > " + key;
	}

}
