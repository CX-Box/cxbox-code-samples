package application.Samples.Form.richtext;

import static core.element.widget.field.type.richtext.RichText.printable;
import static org.assertj.core.api.Assertions.assertThat;

import core.element.widget.field.type.richtext.RichText;
import io.qameta.allure.Allure;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.experimental.UtilityClass;

/**
 * One line of a RichText test: what goes in, what the editor must store.
 *
 * <p>Two kinds of input. <b>User input</b>: the user types text and clicks toolbar buttons
 * ({@link #userInput}). <b>DB input</b>: markdown that is already in the database - the user types
 * nothing, the editor opens the value ({@link #dbInput}, {@link #dbOldSpellingInput}). Every line
 * runs at once and becomes one Allure step with its checks inside.
 */
@UtilityClass
public final class RichTextUtil {

	/** Put in place of the markdown when the toolbar greys the button out for that selection. */
	public static final String REFUSED = "<the button is greyed out>";

	/** Same as below, with no actions: the user only types the text. */
	public static void userInput(RichText<?, ?> field, String text, String markdown) {
		userInput(field, text, markdown, f -> { });
	}

	/**
	 * User input: types {@code text} into the empty field, runs {@code actions} on it (clicks, with the
	 * field's own methods) and checks that the editor stores {@code markdown}. Then the same markdown as
	 * DB input: opens it and checks it is stored again unchanged, and once more after that. With
	 * {@link #REFUSED} as the markdown, checks instead that the toolbar button is greyed out.
	 */
	public static void userInput(RichText<?, ?> field, String text, String markdown, Consumer<RichText<?, ?>> actions) {
		Allure.step("user input " + quote(text) + " → " + outcome(markdown), () -> {
			check("user input: type the text and format it → " + outcome(markdown), markdown, () -> build(field, text, actions));
			if (!REFUSED.equals(markdown)) {
				survives(field, markdown);
			}
		});
	}

	/**
	 * DB input only: {@code markdown} is already in the database and cannot be made by user input
	 * ({@code whyNotUserInput} says why, and goes into the report). Opens it and checks it is stored
	 * again unchanged, and once more.
	 */
	public static void dbInput(RichText<?, ?> field, String markdown, String whyNotUserInput) {
		Allure.step("DB input " + printable(markdown) + " (not user input: " + whyNotUserInput + ")", () -> survives(field, markdown));
	}

	/**
	 * DB input with an old spelling: {@code oldSpelling} is the same value written another way - by
	 * hand, by an older editor, by another system. Opens it and checks that the editor stores it as
	 * {@code markdown}, our spelling. {@link #userInput} cannot cover this: {@code a\#b} as user input
	 * is stored as {@code a\\\#b}, but {@code a\#b} as DB input opens as {@code a#b}.
	 */
	public static void dbOldSpellingInput(RichText<?, ?> field, String oldSpelling, String markdown) {
		check("DB input " + printable(oldSpelling) + " → the editor stores it as " + printable(markdown), markdown, () -> field.setValue(oldSpelling).getValue());
	}

	/** Same as below, with no actions. */
	public static void userInputButReopenBreaks(RichText<?, ?> field, String text, String markdown) {
		userInputButReopenBreaks(field, text, markdown, f -> { });
	}

	/**
	 * For a known bug: user input like {@link #userInput} - types {@code text}, runs {@code actions},
	 * checks that the editor stores {@code markdown} - but the DB input part is skipped, because
	 * opening this value again is what is broken. Put such lines in a step named
	 * "KNOWN BUG, accepted for now: ...".
	 */
	public static void userInputButReopenBreaks(RichText<?, ?> field, String text, String markdown, Consumer<RichText<?, ?>> actions) {
		Allure.step("user input " + quote(text) + " → " + printable(markdown) + " (known bug: as DB input it breaks, not checked)",
				() -> check("user input: type the text and format it → " + printable(markdown), markdown, () -> build(field, text, actions)));
	}

	private static void survives(RichText<?, ?> field, String markdown) {
		check("DB input: open the same markdown → it is stored again unchanged", markdown, () -> field.setValue(markdown).getValue());
		check("DB input: open it once more → still unchanged", markdown, () -> field.setValue(field.setValue(markdown).getValue()).getValue());
	}

	private static String build(RichText<?, ?> field, String text, Consumer<RichText<?, ?>> actions) {
		try {
			return field.userInput(text, actions).getValue();
		} catch (RichText.Refused greyedOut) {
			return REFUSED;
		}
	}

	private static void check(String name, String expected, Supplier<String> actual) {
		Allure.step(name, () -> assertThat(printable(actual.get())).as(name).isEqualTo(printable(expected)));
	}

	private static String outcome(String markdown) {
		return REFUSED.equals(markdown) ? "the button is greyed out" : printable(markdown);
	}

	private static String quote(String text) {
		return "\"" + printable(text) + "\"";
	}

}
