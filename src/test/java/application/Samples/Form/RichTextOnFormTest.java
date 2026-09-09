package application.Samples.Form;

import static application.Samples.Form.richtext.RichTextUtil.REFUSED;
import static application.Samples.Form.richtext.RichTextUtil.userInputButReopenBreaks;
import static application.Samples.Form.richtext.RichTextUtil.dbOldSpellingInput;
import static application.Samples.Form.richtext.RichTextUtil.dbInput;
import static application.Samples.Form.richtext.RichTextUtil.userInput;
import static io.qameta.allure.SeverityLevel.CRITICAL;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.richtext.RichText;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * RichText: what the editor stores for what goes in.
 *
 * <p>Every line of a test is one case. Two kinds of input. <b>User input</b>: the user types text and
 * clicks toolbar buttons - the line reads left to right: the text, the markdown the editor must store,
 * and the clicks, written with the field's own methods:
 *
 * <pre>{@code
 *   userInput(fld, LATIN, "**abc*defghijk*lmn**", f -> f.bold(0, 14).italic(3, 11));
 *
 *   a b c d e f g h i j  k  l  m  n      LATIN, and the positions the numbers point to
 *   0 1 2 3 4 5 6 7 8 9 10 11 12 13
 * }</pre>
 *
 * {@code f.bold(0, 14)} is Bold on characters 0-14, {@code f.bold()} is Bold on the whole text. In the
 * text, {@code \n} is a line break (Shift+Enter) and an empty line starts a new paragraph. Each such
 * line is checked three ways: user input - the markdown after the clicks; DB input - the same markdown
 * opens and is stored again unchanged; and a second open changes nothing. {@code REFUSED} in place of
 * the markdown means the toolbar greys the button out for that selection.
 *
 * <p><b>DB input</b>: markdown that is already in the database, the user types nothing.
 * {@code dbInput(...)} is a value that cannot be user input, checked to open and be stored again
 * unchanged; {@code dbOldSpellingInput(...)} is another spelling of a value and what the editor
 * turns it into.
 *
 * <p>The lines are grouped into steps, and every step says why its lines are there. Steps named
 * "KNOWN BUG, accepted for now" hold wrong behaviour that we keep as it is today.
 *
 * <p>Every case gets an empty editor: the same markdown is stored differently depending on what else
 * is in the document, so sharing one document would make the expected values depend on their
 * neighbours.
 */
@DisplayName("Form. RichText regression suite for the RichText in the widget Form")
@Epic("application/Samples")
@Story("Form")
@Tag("application/Samples")
@Tag("Form")
@Tag("RichText")
public class RichTextOnFormTest extends BaseTestForSamples {

	private static RichText<?, ?> fld;

	private static void open() {
		fld = PlatformApp.screen("RichText basic").secondLevelView("Form").form("Form title").richText("Custom Field");
	}

	@Test
	@Tag("Positive")
	@Severity(CRITICAL)
	@DisplayName("Two and three marks on one text: every combination, every position")
	@Description("We type one text and put marks on it: one mark, two marks, three marks, in every order and in every position they can have (one inside the other, same end, same start, crossing). Each line checks three things: user input - the markdown the editor stores after the clicks; DB input - the same markdown opens and is stored again unchanged; and a second open changes nothing.")
	void markCombinations() {
		open();
		final String LATIN = "abcdefghijklmn";
		Allure.step("One mark over the whole text", () -> {
			userInput(fld, LATIN, "**abcdefghijklmn**", f -> f.bold());
			userInput(fld, LATIN, "*abcdefghijklmn*", f -> f.italic());
			userInput(fld, LATIN, "++abcdefghijklmn++", f -> f.underline());
			userInput(fld, LATIN, "~~abcdefghijklmn~~", f -> f.strike());
			userInput(fld, LATIN, "{red}(abcdefghijklmn)", f -> f.color("red"));
		});
		Allure.step("Colour together with one other mark, and three marks on the same selection", () -> {
			userInput(fld, LATIN, "{red}(*abcdefghijklmn*)", f -> f.color("red").italic());
			userInput(fld, LATIN, "{red}(++abcdefghijklmn++)", f -> f.color("red").underline());
			userInput(fld, LATIN, "{red}(~~abcdefghijklmn~~)", f -> f.color("red").strike());
			userInput(fld, LATIN, "**~~++abcdefghijklmn++~~**", f -> f.bold().strike().underline());
		});
		Allure.step("Two marks at other sizes: overlap by one character, overlap by all but one, touching, running to the end of the text", () -> {
			userInput(fld, LATIN, "++abcdef**g**++**hijklmn**", f -> f.underline(0, 7).bold(6, 14));
			userInput(fld, LATIN, "++a**bcdefghijklm**++**n**", f -> f.underline(0, 13).bold(1, 14));
			userInput(fld, LATIN, "**abcdef++gh++**++ijklmn++", f -> f.bold(0, 8).underline(6, 14));
			userInput(fld, LATIN, "++abcdefg++**hijklmn**", f -> f.underline(0, 7).bold(7, 14));
			userInput(fld, LATIN, "**abcdefg**++hijklmn++", f -> f.bold(0, 7).underline(7, 14));
			userInput(fld, LATIN, "**abcdefg**hijklmn", f -> f.bold(0, 7));
			userInput(fld, LATIN, "abcdefg**hijklmn**", f -> f.bold(7, 14));
			userInput(fld, LATIN, "abcd{blue}(efghij)klmn", f -> f.color("blue", 4, 10));
			userInput(fld, LATIN, "{green}(abcdef**g**hijklmn)", f -> f.color("green", 0, 14).bold(6, 7));
			userInput(fld, LATIN, "**abcdef{red}(gh)**{red}(ijklmn)", f -> f.bold(0, 8).color("red", 6, 14));
		});
		Allure.step("Three marks with the same start and the same end: there is no outer mark, so the order is the choice of the editor", () -> {
			userInput(fld, LATIN, "**{red}(++abcdef++)ghijklmn**", f -> f.bold(0, 14).underline(0, 6).color("red", 0, 6));
		});
		Allure.step("Four marks starting from the same character (a sample)", () -> {
			userInput(fld, LATIN, "++**~~{red}(abc)def~~ghi**jklmn++", f -> f.underline(0, 14).bold(0, 9).strike(0, 6).color("red", 0, 3));
			userInput(fld, LATIN, "**++~~{red}(abc)def~~ghi++jklmn**", f -> f.bold(0, 14).underline(0, 9).strike(0, 6).color("red", 0, 3));
			userInput(fld, LATIN, "{red}(++~~**abc**def~~ghi++jklmn)", f -> f.color("red", 0, 14).underline(0, 9).strike(0, 6).bold(0, 3));
			userInput(fld, LATIN, "~~{red}(++**abc**def++ghi)jklmn~~", f -> f.strike(0, 14).color("red", 0, 9).underline(0, 6).bold(0, 3));
			userInput(fld, LATIN, "++{red}(**~~abc~~def**ghi)jklmn++", f -> f.underline(0, 14).color("red", 0, 9).bold(0, 6).strike(0, 3));
			userInput(fld, LATIN, "++**~~abcdef~~ghi**jklmn++", f -> f.underline(0, 14).bold(0, 9).strike(0, 6));
		});
		Allure.step("Four marks on the whole text (a sample)", () -> {
			userInput(fld, LATIN, "{green}(***++abcdefghijklmn++***)", f -> f.color("green").bold().italic().underline());
			userInput(fld, LATIN, "***~~++abcdefghijklmn++~~***", f -> f.bold().italic().underline().strike());
		});
		Allure.step("Two and three marks in every order and every position: one inside the other, same end, same start, crossing", () -> {
			userInput(fld, LATIN, "***abcdefghijklmn***", f -> f.bold().italic());
			userInput(fld, LATIN, "**abc*defghijk*lmn**", f -> f.bold(0, 14).italic(3, 11));
			userInput(fld, LATIN, "**abcde*fghijklmn***", f -> f.bold(0, 14).italic(5, 14));
			userInput(fld, LATIN, "***abcdefghi*jklmn**", f -> f.bold(0, 14).italic(0, 9));
			userInput(fld, LATIN, "**abcd*ef***\u200B*ghij*klmn", f -> f.bold(0, 6).italic(4, 10));
			userInput(fld, LATIN, "***++abc++defghi*jklmn**", f -> f.bold(0, 14).italic(0, 9).underline(0, 3));
			userInput(fld, LATIN, "**abcd*ef***\u200B*gh++ij++*++klmn++", f -> f.bold(0, 6).italic(4, 10).underline(8, 14));
			userInput(fld, LATIN, "***~~abc~~defghi*jklmn**", f -> f.bold(0, 14).italic(0, 9).strike(0, 3));
			userInput(fld, LATIN, "**abcd*ef***\u200B*gh~~ij~~*~~klmn~~", f -> f.bold(0, 6).italic(4, 10).strike(8, 14));
			userInput(fld, LATIN, "***{red}(abc)defghi*jklmn**", f -> f.bold(0, 14).italic(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "**abcd*ef***\u200B*gh{red}(ij)*{red}(klmn)", f -> f.bold(0, 6).italic(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "**++abcdefghijklmn++**", f -> f.bold().underline());
			userInput(fld, LATIN, "**abc++defghijk++lmn**", f -> f.bold(0, 14).underline(3, 11));
			userInput(fld, LATIN, "**abcde++fghijklmn++**", f -> f.bold(0, 14).underline(5, 14));
			userInput(fld, LATIN, "**++abcdefghi++jklmn**", f -> f.bold(0, 14).underline(0, 9));
			userInput(fld, LATIN, "**abcd++ef++**++ghij++klmn", f -> f.bold(0, 6).underline(4, 10));
			userInput(fld, LATIN, "**abcd++ef++**++gh*ij*++*klmn*", f -> f.bold(0, 6).underline(4, 10).italic(8, 14));
			userInput(fld, LATIN, "**++~~abc~~defghi++jklmn**", f -> f.bold(0, 14).underline(0, 9).strike(0, 3));
			userInput(fld, LATIN, "**abcd++ef++**++gh~~ij~~++~~klmn~~", f -> f.bold(0, 6).underline(4, 10).strike(8, 14));
			userInput(fld, LATIN, "**++{red}(abc)defghi++jklmn**", f -> f.bold(0, 14).underline(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "**abcd++ef++**++gh{red}(ij)++{red}(klmn)", f -> f.bold(0, 6).underline(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "**abc~~defghijk~~lmn**", f -> f.bold(0, 14).strike(3, 11));
			userInput(fld, LATIN, "**abcde~~fghijklmn~~**", f -> f.bold(0, 14).strike(5, 14));
			userInput(fld, LATIN, "**~~abcdefghi~~jklmn**", f -> f.bold(0, 14).strike(0, 9));
			userInput(fld, LATIN, "**abcd~~ef~~**~~ghij~~klmn", f -> f.bold(0, 6).strike(4, 10));
			userInput(fld, LATIN, "**abcd~~ef~~**~~gh*ij*~~*klmn*", f -> f.bold(0, 6).strike(4, 10).italic(8, 14));
			userInput(fld, LATIN, "**~~++abc++defghi~~jklmn**", f -> f.bold(0, 14).strike(0, 9).underline(0, 3));
			userInput(fld, LATIN, "**abcd~~ef~~**~~gh++ij++~~++klmn++", f -> f.bold(0, 6).strike(4, 10).underline(8, 14));
			userInput(fld, LATIN, "**~~{red}(abc)defghi~~jklmn**", f -> f.bold(0, 14).strike(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "**abcd~~ef~~**~~gh{red}(ij)~~{red}(klmn)", f -> f.bold(0, 6).strike(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "**abc{red}(defghijk)lmn**", f -> f.bold(0, 14).color("red", 3, 11));
			userInput(fld, LATIN, "**abcde{red}(fghijklmn)**", f -> f.bold(0, 14).color("red", 5, 14));
			userInput(fld, LATIN, "**{red}(abcdefghi)jklmn**", f -> f.bold(0, 14).color("red", 0, 9));
			userInput(fld, LATIN, "**abcd{red}(ef)**{red}(ghij)klmn", f -> f.bold(0, 6).color("red", 4, 10));
			userInput(fld, LATIN, "**abcd{red}(ef)**{red}(gh*ij*)*klmn*", f -> f.bold(0, 6).color("red", 4, 10).italic(8, 14));
			userInput(fld, LATIN, "**{red}(++abc++defghi)jklmn**", f -> f.bold(0, 14).color("red", 0, 9).underline(0, 3));
			userInput(fld, LATIN, "**abcd{red}(ef)**{red}(gh++ij++)++klmn++", f -> f.bold(0, 6).color("red", 4, 10).underline(8, 14));
			userInput(fld, LATIN, "**{red}(~~abc~~defghi)jklmn**", f -> f.bold(0, 14).color("red", 0, 9).strike(0, 3));
			userInput(fld, LATIN, "**abcd{red}(ef)**{red}(gh~~ij~~)~~klmn~~", f -> f.bold(0, 6).color("red", 4, 10).strike(8, 14));
			userInput(fld, LATIN, "*abc**defghijk**lmn*", f -> f.italic(0, 14).bold(3, 11));
			userInput(fld, LATIN, "*abcde**fghijklmn***", f -> f.italic(0, 14).bold(5, 14));
			userInput(fld, LATIN, "***abcdefghi**jklmn*", f -> f.italic(0, 14).bold(0, 9));
			userInput(fld, LATIN, "*abcd**ef***\u200B**ghij**klmn", f -> f.italic(0, 6).bold(4, 10));
			userInput(fld, LATIN, "***++abc++defghi**jklmn*", f -> f.italic(0, 14).bold(0, 9).underline(0, 3));
			userInput(fld, LATIN, "*abcd**ef***\u200B**gh++ij++**++klmn++", f -> f.italic(0, 6).bold(4, 10).underline(8, 14));
			userInput(fld, LATIN, "***~~abc~~defghi**jklmn*", f -> f.italic(0, 14).bold(0, 9).strike(0, 3));
			userInput(fld, LATIN, "*abcd**ef***\u200B**gh~~ij~~**~~klmn~~", f -> f.italic(0, 6).bold(4, 10).strike(8, 14));
			userInput(fld, LATIN, "***{red}(abc)defghi**jklmn*", f -> f.italic(0, 14).bold(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "*abcd**ef***\u200B**gh{red}(ij)**{red}(klmn)", f -> f.italic(0, 6).bold(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "*abc++defghijk++lmn*", f -> f.italic(0, 14).underline(3, 11));
			userInput(fld, LATIN, "*abcde++fghijklmn++*", f -> f.italic(0, 14).underline(5, 14));
			userInput(fld, LATIN, "*++abcdefghi++jklmn*", f -> f.italic(0, 14).underline(0, 9));
			userInput(fld, LATIN, "*abcd++ef++*++ghij++klmn", f -> f.italic(0, 6).underline(4, 10));
			userInput(fld, LATIN, "*abcd++ef++*++gh**ij**++**klmn**", f -> f.italic(0, 6).underline(4, 10).bold(8, 14));
			userInput(fld, LATIN, "*++~~abc~~defghi++jklmn*", f -> f.italic(0, 14).underline(0, 9).strike(0, 3));
			userInput(fld, LATIN, "*abcd++ef++*++gh~~ij~~++~~klmn~~", f -> f.italic(0, 6).underline(4, 10).strike(8, 14));
			userInput(fld, LATIN, "*++{red}(abc)defghi++jklmn*", f -> f.italic(0, 14).underline(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "*abcd++ef++*++gh{red}(ij)++{red}(klmn)", f -> f.italic(0, 6).underline(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "*abc~~defghijk~~lmn*", f -> f.italic(0, 14).strike(3, 11));
			userInput(fld, LATIN, "*abcde~~fghijklmn~~*", f -> f.italic(0, 14).strike(5, 14));
			userInput(fld, LATIN, "*~~abcdefghi~~jklmn*", f -> f.italic(0, 14).strike(0, 9));
			userInput(fld, LATIN, "*abcd~~ef~~*~~ghij~~klmn", f -> f.italic(0, 6).strike(4, 10));
			userInput(fld, LATIN, "*abcd~~ef~~*~~gh**ij**~~**klmn**", f -> f.italic(0, 6).strike(4, 10).bold(8, 14));
			userInput(fld, LATIN, "*~~++abc++defghi~~jklmn*", f -> f.italic(0, 14).strike(0, 9).underline(0, 3));
			userInput(fld, LATIN, "*abcd~~ef~~*~~gh++ij++~~++klmn++", f -> f.italic(0, 6).strike(4, 10).underline(8, 14));
			userInput(fld, LATIN, "*~~{red}(abc)defghi~~jklmn*", f -> f.italic(0, 14).strike(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "*abcd~~ef~~*~~gh{red}(ij)~~{red}(klmn)", f -> f.italic(0, 6).strike(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "*abc{red}(defghijk)lmn*", f -> f.italic(0, 14).color("red", 3, 11));
			userInput(fld, LATIN, "*abcde{red}(fghijklmn)*", f -> f.italic(0, 14).color("red", 5, 14));
			userInput(fld, LATIN, "*{red}(abcdefghi)jklmn*", f -> f.italic(0, 14).color("red", 0, 9));
			userInput(fld, LATIN, "*abcd{red}(ef)*{red}(ghij)klmn", f -> f.italic(0, 6).color("red", 4, 10));
			userInput(fld, LATIN, "*abcd{red}(ef)*{red}(gh**ij**)**klmn**", f -> f.italic(0, 6).color("red", 4, 10).bold(8, 14));
			userInput(fld, LATIN, "*{red}(++abc++defghi)jklmn*", f -> f.italic(0, 14).color("red", 0, 9).underline(0, 3));
			userInput(fld, LATIN, "*abcd{red}(ef)*{red}(gh++ij++)++klmn++", f -> f.italic(0, 6).color("red", 4, 10).underline(8, 14));
			userInput(fld, LATIN, "*{red}(~~abc~~defghi)jklmn*", f -> f.italic(0, 14).color("red", 0, 9).strike(0, 3));
			userInput(fld, LATIN, "*abcd{red}(ef)*{red}(gh~~ij~~)~~klmn~~", f -> f.italic(0, 6).color("red", 4, 10).strike(8, 14));
			userInput(fld, LATIN, "++abc**defghijk**lmn++", f -> f.underline(0, 14).bold(3, 11));
			userInput(fld, LATIN, "++abcde**fghijklmn**++", f -> f.underline(0, 14).bold(5, 14));
			userInput(fld, LATIN, "++**abcdefghi**jklmn++", f -> f.underline(0, 14).bold(0, 9));
			userInput(fld, LATIN, "++abcd**ef**++**ghij**klmn", f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, LATIN, "++***abc*defghi**jklmn++", f -> f.underline(0, 14).bold(0, 9).italic(0, 3));
			userInput(fld, LATIN, "++abcd**ef**++**gh*ij***\u200B*klmn*", f -> f.underline(0, 6).bold(4, 10).italic(8, 14));
			userInput(fld, LATIN, "++**~~abc~~defghi**jklmn++", f -> f.underline(0, 14).bold(0, 9).strike(0, 3));
			userInput(fld, LATIN, "++abcd**ef**++**gh~~ij~~**~~klmn~~", f -> f.underline(0, 6).bold(4, 10).strike(8, 14));
			userInput(fld, LATIN, "++**{red}(abc)defghi**jklmn++", f -> f.underline(0, 14).bold(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "++abcd**ef**++**gh{red}(ij)**{red}(klmn)", f -> f.underline(0, 6).bold(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "++abc*defghijk*lmn++", f -> f.underline(0, 14).italic(3, 11));
			userInput(fld, LATIN, "++abcde*fghijklmn*++", f -> f.underline(0, 14).italic(5, 14));
			userInput(fld, LATIN, "++*abcdefghi*jklmn++", f -> f.underline(0, 14).italic(0, 9));
			userInput(fld, LATIN, "++abcd*ef*++*ghij*klmn", f -> f.underline(0, 6).italic(4, 10));
			userInput(fld, LATIN, "++***abc**defghi*jklmn++", f -> f.underline(0, 14).italic(0, 9).bold(0, 3));
			userInput(fld, LATIN, "++abcd*ef*++*gh**ij***\u200B**klmn**", f -> f.underline(0, 6).italic(4, 10).bold(8, 14));
			userInput(fld, LATIN, "++*~~abc~~defghi*jklmn++", f -> f.underline(0, 14).italic(0, 9).strike(0, 3));
			userInput(fld, LATIN, "++abcd*ef*++*gh~~ij~~*~~klmn~~", f -> f.underline(0, 6).italic(4, 10).strike(8, 14));
			userInput(fld, LATIN, "++*{red}(abc)defghi*jklmn++", f -> f.underline(0, 14).italic(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "++abcd*ef*++*gh{red}(ij)*{red}(klmn)", f -> f.underline(0, 6).italic(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "++abc~~defghijk~~lmn++", f -> f.underline(0, 14).strike(3, 11));
			userInput(fld, LATIN, "++abcde~~fghijklmn~~++", f -> f.underline(0, 14).strike(5, 14));
			userInput(fld, LATIN, "++~~abcdefghi~~jklmn++", f -> f.underline(0, 14).strike(0, 9));
			userInput(fld, LATIN, "++abcd~~ef~~++~~ghij~~klmn", f -> f.underline(0, 6).strike(4, 10));
			userInput(fld, LATIN, "++~~**abc**defghi~~jklmn++", f -> f.underline(0, 14).strike(0, 9).bold(0, 3));
			userInput(fld, LATIN, "++abcd~~ef~~++~~gh**ij**~~**klmn**", f -> f.underline(0, 6).strike(4, 10).bold(8, 14));
			userInput(fld, LATIN, "++~~*abc*defghi~~jklmn++", f -> f.underline(0, 14).strike(0, 9).italic(0, 3));
			userInput(fld, LATIN, "++abcd~~ef~~++~~gh*ij*~~*klmn*", f -> f.underline(0, 6).strike(4, 10).italic(8, 14));
			userInput(fld, LATIN, "++~~{red}(abc)defghi~~jklmn++", f -> f.underline(0, 14).strike(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "++abcd~~ef~~++~~gh{red}(ij)~~{red}(klmn)", f -> f.underline(0, 6).strike(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "++abc{red}(defghijk)lmn++", f -> f.underline(0, 14).color("red", 3, 11));
			userInput(fld, LATIN, "++abcde{red}(fghijklmn)++", f -> f.underline(0, 14).color("red", 5, 14));
			userInput(fld, LATIN, "++{red}(abcdefghi)jklmn++", f -> f.underline(0, 14).color("red", 0, 9));
			userInput(fld, LATIN, "++abcd{red}(ef)++{red}(ghij)klmn", f -> f.underline(0, 6).color("red", 4, 10));
			userInput(fld, LATIN, "++{red}(**abc**defghi)jklmn++", f -> f.underline(0, 14).color("red", 0, 9).bold(0, 3));
			userInput(fld, LATIN, "++abcd{red}(ef)++{red}(gh**ij**)**klmn**", f -> f.underline(0, 6).color("red", 4, 10).bold(8, 14));
			userInput(fld, LATIN, "++{red}(*abc*defghi)jklmn++", f -> f.underline(0, 14).color("red", 0, 9).italic(0, 3));
			userInput(fld, LATIN, "++abcd{red}(ef)++{red}(gh*ij*)*klmn*", f -> f.underline(0, 6).color("red", 4, 10).italic(8, 14));
			userInput(fld, LATIN, "++{red}(~~abc~~defghi)jklmn++", f -> f.underline(0, 14).color("red", 0, 9).strike(0, 3));
			userInput(fld, LATIN, "++abcd{red}(ef)++{red}(gh~~ij~~)~~klmn~~", f -> f.underline(0, 6).color("red", 4, 10).strike(8, 14));
			userInput(fld, LATIN, "~~abc**defghijk**lmn~~", f -> f.strike(0, 14).bold(3, 11));
			userInput(fld, LATIN, "~~abcde**fghijklmn**~~", f -> f.strike(0, 14).bold(5, 14));
			userInput(fld, LATIN, "~~**abcdefghi**jklmn~~", f -> f.strike(0, 14).bold(0, 9));
			userInput(fld, LATIN, "~~abcd**ef**~~**ghij**klmn", f -> f.strike(0, 6).bold(4, 10));
			userInput(fld, LATIN, "~~***abc*defghi**jklmn~~", f -> f.strike(0, 14).bold(0, 9).italic(0, 3));
			userInput(fld, LATIN, "~~abcd**ef**~~**gh*ij***\u200B*klmn*", f -> f.strike(0, 6).bold(4, 10).italic(8, 14));
			userInput(fld, LATIN, "~~**++abc++defghi**jklmn~~", f -> f.strike(0, 14).bold(0, 9).underline(0, 3));
			userInput(fld, LATIN, "~~abcd**ef**~~**gh++ij++**++klmn++", f -> f.strike(0, 6).bold(4, 10).underline(8, 14));
			userInput(fld, LATIN, "~~**{red}(abc)defghi**jklmn~~", f -> f.strike(0, 14).bold(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "~~abcd**ef**~~**gh{red}(ij)**{red}(klmn)", f -> f.strike(0, 6).bold(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "~~abc*defghijk*lmn~~", f -> f.strike(0, 14).italic(3, 11));
			userInput(fld, LATIN, "~~abcde*fghijklmn*~~", f -> f.strike(0, 14).italic(5, 14));
			userInput(fld, LATIN, "~~*abcdefghi*jklmn~~", f -> f.strike(0, 14).italic(0, 9));
			userInput(fld, LATIN, "~~abcd*ef*~~*ghij*klmn", f -> f.strike(0, 6).italic(4, 10));
			userInput(fld, LATIN, "~~***abc**defghi*jklmn~~", f -> f.strike(0, 14).italic(0, 9).bold(0, 3));
			userInput(fld, LATIN, "~~abcd*ef*~~*gh**ij***\u200B**klmn**", f -> f.strike(0, 6).italic(4, 10).bold(8, 14));
			userInput(fld, LATIN, "~~*++abc++defghi*jklmn~~", f -> f.strike(0, 14).italic(0, 9).underline(0, 3));
			userInput(fld, LATIN, "~~abcd*ef*~~*gh++ij++*++klmn++", f -> f.strike(0, 6).italic(4, 10).underline(8, 14));
			userInput(fld, LATIN, "~~*{red}(abc)defghi*jklmn~~", f -> f.strike(0, 14).italic(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "~~abcd*ef*~~*gh{red}(ij)*{red}(klmn)", f -> f.strike(0, 6).italic(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "~~abc++defghijk++lmn~~", f -> f.strike(0, 14).underline(3, 11));
			userInput(fld, LATIN, "~~abcde++fghijklmn++~~", f -> f.strike(0, 14).underline(5, 14));
			userInput(fld, LATIN, "~~++abcdefghi++jklmn~~", f -> f.strike(0, 14).underline(0, 9));
			userInput(fld, LATIN, "~~abcd++ef++~~++ghij++klmn", f -> f.strike(0, 6).underline(4, 10));
			userInput(fld, LATIN, "~~++**abc**defghi++jklmn~~", f -> f.strike(0, 14).underline(0, 9).bold(0, 3));
			userInput(fld, LATIN, "~~abcd++ef++~~++gh**ij**++**klmn**", f -> f.strike(0, 6).underline(4, 10).bold(8, 14));
			userInput(fld, LATIN, "~~++*abc*defghi++jklmn~~", f -> f.strike(0, 14).underline(0, 9).italic(0, 3));
			userInput(fld, LATIN, "~~abcd++ef++~~++gh*ij*++*klmn*", f -> f.strike(0, 6).underline(4, 10).italic(8, 14));
			userInput(fld, LATIN, "~~++{red}(abc)defghi++jklmn~~", f -> f.strike(0, 14).underline(0, 9).color("red", 0, 3));
			userInput(fld, LATIN, "~~abcd++ef++~~++gh{red}(ij)++{red}(klmn)", f -> f.strike(0, 6).underline(4, 10).color("red", 8, 14));
			userInput(fld, LATIN, "~~abc{red}(defghijk)lmn~~", f -> f.strike(0, 14).color("red", 3, 11));
			userInput(fld, LATIN, "~~abcde{red}(fghijklmn)~~", f -> f.strike(0, 14).color("red", 5, 14));
			userInput(fld, LATIN, "~~{red}(abcdefghi)jklmn~~", f -> f.strike(0, 14).color("red", 0, 9));
			userInput(fld, LATIN, "~~abcd{red}(ef)~~{red}(ghij)klmn", f -> f.strike(0, 6).color("red", 4, 10));
			userInput(fld, LATIN, "~~{red}(**abc**defghi)jklmn~~", f -> f.strike(0, 14).color("red", 0, 9).bold(0, 3));
			userInput(fld, LATIN, "~~abcd{red}(ef)~~{red}(gh**ij**)**klmn**", f -> f.strike(0, 6).color("red", 4, 10).bold(8, 14));
			userInput(fld, LATIN, "~~{red}(*abc*defghi)jklmn~~", f -> f.strike(0, 14).color("red", 0, 9).italic(0, 3));
			userInput(fld, LATIN, "~~abcd{red}(ef)~~{red}(gh*ij*)*klmn*", f -> f.strike(0, 6).color("red", 4, 10).italic(8, 14));
			userInput(fld, LATIN, "~~{red}(++abc++defghi)jklmn~~", f -> f.strike(0, 14).color("red", 0, 9).underline(0, 3));
			userInput(fld, LATIN, "~~abcd{red}(ef)~~{red}(gh++ij++)++klmn++", f -> f.strike(0, 6).color("red", 4, 10).underline(8, 14));
			userInput(fld, LATIN, "{red}(**abcdefghijklmn**)", f -> f.color("red").bold());
			userInput(fld, LATIN, "{red}(abc**defghijk**lmn)", f -> f.color("red", 0, 14).bold(3, 11));
			userInput(fld, LATIN, "{red}(abcde**fghijklmn**)", f -> f.color("red", 0, 14).bold(5, 14));
			userInput(fld, LATIN, "{red}(**abcdefghi**jklmn)", f -> f.color("red", 0, 14).bold(0, 9));
			userInput(fld, LATIN, "{red}(abcd**ef**)**ghij**klmn", f -> f.color("red", 0, 6).bold(4, 10));
			userInput(fld, LATIN, "{red}(***abc*defghi**jklmn)", f -> f.color("red", 0, 14).bold(0, 9).italic(0, 3));
			userInput(fld, LATIN, "{red}(abcd**ef**)**gh*ij***\u200B*klmn*", f -> f.color("red", 0, 6).bold(4, 10).italic(8, 14));
			userInput(fld, LATIN, "{red}(**++abc++defghi**jklmn)", f -> f.color("red", 0, 14).bold(0, 9).underline(0, 3));
			userInput(fld, LATIN, "{red}(abcd**ef**)**gh++ij++**++klmn++", f -> f.color("red", 0, 6).bold(4, 10).underline(8, 14));
			userInput(fld, LATIN, "{red}(**~~abc~~defghi**jklmn)", f -> f.color("red", 0, 14).bold(0, 9).strike(0, 3));
			userInput(fld, LATIN, "{red}(abcd**ef**)**gh~~ij~~**~~klmn~~", f -> f.color("red", 0, 6).bold(4, 10).strike(8, 14));
			userInput(fld, LATIN, "{red}(abc*defghijk*lmn)", f -> f.color("red", 0, 14).italic(3, 11));
			userInput(fld, LATIN, "{red}(abcde*fghijklmn*)", f -> f.color("red", 0, 14).italic(5, 14));
			userInput(fld, LATIN, "{red}(*abcdefghi*jklmn)", f -> f.color("red", 0, 14).italic(0, 9));
			userInput(fld, LATIN, "{red}(abcd*ef*)*ghij*klmn", f -> f.color("red", 0, 6).italic(4, 10));
			userInput(fld, LATIN, "{red}(***abc**defghi*jklmn)", f -> f.color("red", 0, 14).italic(0, 9).bold(0, 3));
			userInput(fld, LATIN, "{red}(abcd*ef*)*gh**ij***\u200B**klmn**", f -> f.color("red", 0, 6).italic(4, 10).bold(8, 14));
			userInput(fld, LATIN, "{red}(*++abc++defghi*jklmn)", f -> f.color("red", 0, 14).italic(0, 9).underline(0, 3));
			userInput(fld, LATIN, "{red}(abcd*ef*)*gh++ij++*++klmn++", f -> f.color("red", 0, 6).italic(4, 10).underline(8, 14));
			userInput(fld, LATIN, "{red}(*~~abc~~defghi*jklmn)", f -> f.color("red", 0, 14).italic(0, 9).strike(0, 3));
			userInput(fld, LATIN, "{red}(abcd*ef*)*gh~~ij~~*~~klmn~~", f -> f.color("red", 0, 6).italic(4, 10).strike(8, 14));
			userInput(fld, LATIN, "{red}(abc++defghijk++lmn)", f -> f.color("red", 0, 14).underline(3, 11));
			userInput(fld, LATIN, "{red}(abcde++fghijklmn++)", f -> f.color("red", 0, 14).underline(5, 14));
			userInput(fld, LATIN, "{red}(++abcdefghi++jklmn)", f -> f.color("red", 0, 14).underline(0, 9));
			userInput(fld, LATIN, "{red}(abcd++ef++)++ghij++klmn", f -> f.color("red", 0, 6).underline(4, 10));
			userInput(fld, LATIN, "{red}(++**abc**defghi++jklmn)", f -> f.color("red", 0, 14).underline(0, 9).bold(0, 3));
			userInput(fld, LATIN, "{red}(abcd++ef++)++gh**ij**++**klmn**", f -> f.color("red", 0, 6).underline(4, 10).bold(8, 14));
			userInput(fld, LATIN, "{red}(++*abc*defghi++jklmn)", f -> f.color("red", 0, 14).underline(0, 9).italic(0, 3));
			userInput(fld, LATIN, "{red}(abcd++ef++)++gh*ij*++*klmn*", f -> f.color("red", 0, 6).underline(4, 10).italic(8, 14));
			userInput(fld, LATIN, "{red}(++~~abc~~defghi++jklmn)", f -> f.color("red", 0, 14).underline(0, 9).strike(0, 3));
			userInput(fld, LATIN, "{red}(abcd++ef++)++gh~~ij~~++~~klmn~~", f -> f.color("red", 0, 6).underline(4, 10).strike(8, 14));
			userInput(fld, LATIN, "{red}(abc~~defghijk~~lmn)", f -> f.color("red", 0, 14).strike(3, 11));
			userInput(fld, LATIN, "{red}(abcde~~fghijklmn~~)", f -> f.color("red", 0, 14).strike(5, 14));
			userInput(fld, LATIN, "{red}(~~abcdefghi~~jklmn)", f -> f.color("red", 0, 14).strike(0, 9));
			userInput(fld, LATIN, "{red}(abcd~~ef~~)~~ghij~~klmn", f -> f.color("red", 0, 6).strike(4, 10));
			userInput(fld, LATIN, "{red}(~~**abc**defghi~~jklmn)", f -> f.color("red", 0, 14).strike(0, 9).bold(0, 3));
			userInput(fld, LATIN, "{red}(abcd~~ef~~)~~gh**ij**~~**klmn**", f -> f.color("red", 0, 6).strike(4, 10).bold(8, 14));
			userInput(fld, LATIN, "{red}(~~*abc*defghi~~jklmn)", f -> f.color("red", 0, 14).strike(0, 9).italic(0, 3));
			userInput(fld, LATIN, "{red}(abcd~~ef~~)~~gh*ij*~~*klmn*", f -> f.color("red", 0, 6).strike(4, 10).italic(8, 14));
			userInput(fld, LATIN, "{red}(~~++abc++defghi~~jklmn)", f -> f.color("red", 0, 14).strike(0, 9).underline(0, 3));
			userInput(fld, LATIN, "{red}(abcd~~ef~~)~~gh++ij++~~++klmn++", f -> f.color("red", 0, 6).strike(4, 10).underline(8, 14));
		});
		Allure.step("The other colours over the whole text: they are stored the same way as red", () -> {
			userInput(fld, LATIN, "{gray}(abcdefghijklmn)", f -> f.color("gray"));
			userInput(fld, LATIN, "{yellow}(abcdefghijklmn)", f -> f.color("yellow"));
			userInput(fld, LATIN, "{orange}(abcdefghijklmn)", f -> f.color("orange"));
			userInput(fld, LATIN, "{green}(abcdefghijklmn)", f -> f.color("green"));
			userInput(fld, LATIN, "{blue}(abcdefghijklmn)", f -> f.color("blue"));
			userInput(fld, LATIN, "{violet}(abcdefghijklmn)", f -> f.color("violet"));
		});
		Allure.step("KNOWN BUG, accepted for now: bold and italic with a third mark between them. The editor builds valid markdown, but when the value is opened again the outer ** is not recognised and comes back as text with backslashes. Each pair of lines checks what is built, and what it turns into", () -> {
			userInputButReopenBreaks(fld, LATIN, "**++*abc*defghi++jklmn**", f -> f.bold(0, 14).underline(0, 9).italic(0, 3));
			dbOldSpellingInput(fld, "**++*abc*defghi++jklmn**", "\\*\\*++*abc*defghi++jklmn\\*\\*");
			userInputButReopenBreaks(fld, LATIN, "**~~*abc*defghi~~jklmn**", f -> f.bold(0, 14).strike(0, 9).italic(0, 3));
			dbOldSpellingInput(fld, "**~~*abc*defghi~~jklmn**", "\\*\\*~~*abc*defghi~~jklmn\\*\\*");
			userInputButReopenBreaks(fld, LATIN, "**{red}(*abc*defghi)jklmn**", f -> f.bold(0, 14).color("red", 0, 9).italic(0, 3));
			dbOldSpellingInput(fld, "**{red}(*abc*defghi)jklmn**", "\\*\\*{red}(*abc*defghi)jklmn\\*\\*");
			userInputButReopenBreaks(fld, LATIN, "*++**abc**defghi++jklmn*", f -> f.italic(0, 14).underline(0, 9).bold(0, 3));
			dbOldSpellingInput(fld, "*++**abc**defghi++jklmn*", "\\*++**abc**defghi++jklmn\\*");
			userInputButReopenBreaks(fld, LATIN, "*~~**abc**defghi~~jklmn*", f -> f.italic(0, 14).strike(0, 9).bold(0, 3));
			dbOldSpellingInput(fld, "*~~**abc**defghi~~jklmn*", "\\*~~**abc**defghi~~jklmn\\*");
			userInputButReopenBreaks(fld, LATIN, "*{red}(**abc**defghi)jklmn*", f -> f.italic(0, 14).color("red", 0, 9).bold(0, 3));
			dbOldSpellingInput(fld, "*{red}(**abc**defghi)jklmn*", "\\*{red}(**abc**defghi)jklmn\\*");
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("The same marks on text made of markdown characters")
	@Description("The same lines as the first test, but the text is ab(cd)ef*gh_ij: parentheses, a star and an underscore. These characters are markdown syntax, so a mark next to them must be escaped correctly. Many lines end with REFUSED: the toolbar does not allow a mark that starts or ends next to punctuation inside a word, because such markdown would not open again.")
	void markCombinationsOverSyntax() {
		open();
		final String SYNTAX = "ab(cd)ef*gh_ij";
		Allure.step("One mark over the whole text", () -> {
			userInput(fld, SYNTAX, "**ab(cd)ef\\*gh\\_ij**", f -> f.bold());
			userInput(fld, SYNTAX, "*ab(cd)ef\\*gh\\_ij*", f -> f.italic());
			userInput(fld, SYNTAX, "++ab(cd)ef\\*gh\\_ij++", f -> f.underline());
			userInput(fld, SYNTAX, "~~ab(cd)ef\\*gh\\_ij~~", f -> f.strike());
			userInput(fld, SYNTAX, "{red}(ab\\(cd\\)ef\\*gh\\_ij)", f -> f.color("red"));
		});
		Allure.step("Two marks: one inside the other, same end, same start, crossing", () -> {
			userInput(fld, SYNTAX, "**ab(*cd)ef\\*gh*\\_ij**", f -> f.bold(0, 14).italic(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).italic(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).italic(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 6).italic(4, 10));
			userInput(fld, SYNTAX, "**ab(++cd)ef\\*gh++\\_ij**", f -> f.bold(0, 14).underline(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).underline(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).underline(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 6).underline(4, 10));
			userInput(fld, SYNTAX, "**ab(~~cd)ef\\*gh~~\\_ij**", f -> f.bold(0, 14).strike(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).strike(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 14).strike(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 6).strike(4, 10));
			userInput(fld, SYNTAX, "**ab({red}(cd\\)ef\\*gh)\\_ij**", f -> f.bold(0, 14).color("red", 3, 11));
			userInput(fld, SYNTAX, "**ab(cd{red}(\\)ef\\*gh\\_ij)**", f -> f.bold(0, 14).color("red", 5, 14));
			userInput(fld, SYNTAX, "**{red}(ab\\(cd\\)ef\\*)gh\\_ij**", f -> f.bold(0, 14).color("red", 0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.bold(0, 6).color("red", 4, 10));
			userInput(fld, SYNTAX, "*ab(**cd)ef\\*gh**\\_ij*", f -> f.italic(0, 14).bold(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).bold(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).bold(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 6).bold(4, 10));
			userInput(fld, SYNTAX, "*ab(++cd)ef\\*gh++\\_ij*", f -> f.italic(0, 14).underline(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).underline(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).underline(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 6).underline(4, 10));
			userInput(fld, SYNTAX, "*ab(~~cd)ef\\*gh~~\\_ij*", f -> f.italic(0, 14).strike(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).strike(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 14).strike(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 6).strike(4, 10));
			userInput(fld, SYNTAX, "*ab({red}(cd\\)ef\\*gh)\\_ij*", f -> f.italic(0, 14).color("red", 3, 11));
			userInput(fld, SYNTAX, "*ab(cd{red}(\\)ef\\*gh\\_ij)*", f -> f.italic(0, 14).color("red", 5, 14));
			userInput(fld, SYNTAX, "*{red}(ab\\(cd\\)ef\\*)gh\\_ij*", f -> f.italic(0, 14).color("red", 0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.italic(0, 6).color("red", 4, 10));
			userInput(fld, SYNTAX, "++ab(**cd)ef\\*gh**\\_ij++", f -> f.underline(0, 14).bold(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).bold(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).bold(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, SYNTAX, "++ab(*cd)ef\\*gh*\\_ij++", f -> f.underline(0, 14).italic(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).italic(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).italic(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 6).italic(4, 10));
			userInput(fld, SYNTAX, "++ab(~~cd)ef\\*gh~~\\_ij++", f -> f.underline(0, 14).strike(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).strike(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 14).strike(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 6).strike(4, 10));
			userInput(fld, SYNTAX, "++ab({red}(cd\\)ef\\*gh)\\_ij++", f -> f.underline(0, 14).color("red", 3, 11));
			userInput(fld, SYNTAX, "++ab(cd{red}(\\)ef\\*gh\\_ij)++", f -> f.underline(0, 14).color("red", 5, 14));
			userInput(fld, SYNTAX, "++{red}(ab\\(cd\\)ef\\*)gh\\_ij++", f -> f.underline(0, 14).color("red", 0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.underline(0, 6).color("red", 4, 10));
			userInput(fld, SYNTAX, "~~ab(**cd)ef\\*gh**\\_ij~~", f -> f.strike(0, 14).bold(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).bold(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).bold(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 6).bold(4, 10));
			userInput(fld, SYNTAX, "~~ab(*cd)ef\\*gh*\\_ij~~", f -> f.strike(0, 14).italic(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).italic(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).italic(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 6).italic(4, 10));
			userInput(fld, SYNTAX, "~~ab(++cd)ef\\*gh++\\_ij~~", f -> f.strike(0, 14).underline(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).underline(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 14).underline(0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 6).underline(4, 10));
			userInput(fld, SYNTAX, "~~ab({red}(cd\\)ef\\*gh)\\_ij~~", f -> f.strike(0, 14).color("red", 3, 11));
			userInput(fld, SYNTAX, "~~ab(cd{red}(\\)ef\\*gh\\_ij)~~", f -> f.strike(0, 14).color("red", 5, 14));
			userInput(fld, SYNTAX, "~~{red}(ab\\(cd\\)ef\\*)gh\\_ij~~", f -> f.strike(0, 14).color("red", 0, 9));
			userInput(fld, SYNTAX, REFUSED, f -> f.strike(0, 6).color("red", 4, 10));
			userInput(fld, SYNTAX, "{red}(ab\\(**cd\\)ef\\*gh**\\_ij)", f -> f.color("red", 0, 14).bold(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).bold(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).bold(0, 9));
			userInput(fld, SYNTAX, "{red}(ab\\(c**d\\)**)**ef\\*g**h\\_ij", f -> f.color("red", 0, 6).bold(4, 10));
			userInput(fld, SYNTAX, "{red}(ab\\(*cd\\)ef\\*gh*\\_ij)", f -> f.color("red", 0, 14).italic(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).italic(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).italic(0, 9));
			userInput(fld, SYNTAX, "{red}(ab\\(c*d\\)*)*ef\\*g*h\\_ij", f -> f.color("red", 0, 6).italic(4, 10));
			userInput(fld, SYNTAX, "{red}(ab\\(++cd\\)ef\\*gh++\\_ij)", f -> f.color("red", 0, 14).underline(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).underline(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).underline(0, 9));
			userInput(fld, SYNTAX, "{red}(ab\\(c++d\\)++)++ef\\*g++h\\_ij", f -> f.color("red", 0, 6).underline(4, 10));
			userInput(fld, SYNTAX, "{red}(ab\\(~~cd\\)ef\\*gh~~\\_ij)", f -> f.color("red", 0, 14).strike(3, 11));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).strike(5, 14));
			userInput(fld, SYNTAX, REFUSED, f -> f.color("red", 0, 14).strike(0, 9));
			userInput(fld, SYNTAX, "{red}(ab\\(c~~d\\)~~)~~ef\\*g~~h\\_ij", f -> f.color("red", 0, 6).strike(4, 10));
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("The same marks on Cyrillic text")
	@Description("The same lines over Cyrillic text. The rule that decides if a mark is allowed looks at the type of the neighbouring character, and Cyrillic letters go through a different code path than Latin ones.")
	void markCombinationsOverCyrillic() {
		open();
		final String CYRILLIC = "Орган тип опис";
		Allure.step("One mark over the whole text", () -> {
			userInput(fld, CYRILLIC, "**Орган тип опис**", f -> f.bold());
			userInput(fld, CYRILLIC, "*Орган тип опис*", f -> f.italic());
			userInput(fld, CYRILLIC, "++Орган тип опис++", f -> f.underline());
			userInput(fld, CYRILLIC, "~~Орган тип опис~~", f -> f.strike());
			userInput(fld, CYRILLIC, "{red}(Орган тип опис)", f -> f.color("red"));
		});
		Allure.step("Two marks: one inside the other, same end, same start, crossing", () -> {
			userInput(fld, CYRILLIC, "**Орг*ан тип о*пис**", f -> f.bold(0, 14).italic(3, 11));
			userInput(fld, CYRILLIC, "**Орган *тип опис***", f -> f.bold(0, 14).italic(5, 14));
			userInput(fld, CYRILLIC, "***Орган тип* опис**", f -> f.bold(0, 14).italic(0, 9));
			userInput(fld, CYRILLIC, "**Орга*н*** *тип* опис", f -> f.bold(0, 6).italic(4, 10));
			userInput(fld, CYRILLIC, "**Орг++ан тип о++пис**", f -> f.bold(0, 14).underline(3, 11));
			userInput(fld, CYRILLIC, "**Орган ++тип опис++**", f -> f.bold(0, 14).underline(5, 14));
			userInput(fld, CYRILLIC, "**++Орган тип++ опис**", f -> f.bold(0, 14).underline(0, 9));
			userInput(fld, CYRILLIC, "**Орга++н++** ++тип++ опис", f -> f.bold(0, 6).underline(4, 10));
			userInput(fld, CYRILLIC, "**Орг~~ан тип о~~пис**", f -> f.bold(0, 14).strike(3, 11));
			userInput(fld, CYRILLIC, "**Орган ~~тип опис~~**", f -> f.bold(0, 14).strike(5, 14));
			userInput(fld, CYRILLIC, "**~~Орган тип~~ опис**", f -> f.bold(0, 14).strike(0, 9));
			userInput(fld, CYRILLIC, "**Орга~~н~~** ~~тип~~ опис", f -> f.bold(0, 6).strike(4, 10));
			userInput(fld, CYRILLIC, "**Орг{red}(ан тип о)пис**", f -> f.bold(0, 14).color("red", 3, 11));
			userInput(fld, CYRILLIC, "**Орган {red}(тип опис)**", f -> f.bold(0, 14).color("red", 5, 14));
			userInput(fld, CYRILLIC, "**{red}(Орган тип) опис**", f -> f.bold(0, 14).color("red", 0, 9));
			userInput(fld, CYRILLIC, "**Орга{red}(н)** {red}(тип) опис", f -> f.bold(0, 6).color("red", 4, 10));
			userInput(fld, CYRILLIC, "*Орг**ан тип о**пис*", f -> f.italic(0, 14).bold(3, 11));
			userInput(fld, CYRILLIC, "*Орган **тип опис***", f -> f.italic(0, 14).bold(5, 14));
			userInput(fld, CYRILLIC, "***Орган тип** опис*", f -> f.italic(0, 14).bold(0, 9));
			userInput(fld, CYRILLIC, "*Орга**н*** **тип** опис", f -> f.italic(0, 6).bold(4, 10));
			userInput(fld, CYRILLIC, "*Орг++ан тип о++пис*", f -> f.italic(0, 14).underline(3, 11));
			userInput(fld, CYRILLIC, "*Орган ++тип опис++*", f -> f.italic(0, 14).underline(5, 14));
			userInput(fld, CYRILLIC, "*++Орган тип++ опис*", f -> f.italic(0, 14).underline(0, 9));
			userInput(fld, CYRILLIC, "*Орга++н++* ++тип++ опис", f -> f.italic(0, 6).underline(4, 10));
			userInput(fld, CYRILLIC, "*Орг~~ан тип о~~пис*", f -> f.italic(0, 14).strike(3, 11));
			userInput(fld, CYRILLIC, "*Орган ~~тип опис~~*", f -> f.italic(0, 14).strike(5, 14));
			userInput(fld, CYRILLIC, "*~~Орган тип~~ опис*", f -> f.italic(0, 14).strike(0, 9));
			userInput(fld, CYRILLIC, "*Орга~~н~~* ~~тип~~ опис", f -> f.italic(0, 6).strike(4, 10));
			userInput(fld, CYRILLIC, "*Орг{red}(ан тип о)пис*", f -> f.italic(0, 14).color("red", 3, 11));
			userInput(fld, CYRILLIC, "*Орган {red}(тип опис)*", f -> f.italic(0, 14).color("red", 5, 14));
			userInput(fld, CYRILLIC, "*{red}(Орган тип) опис*", f -> f.italic(0, 14).color("red", 0, 9));
			userInput(fld, CYRILLIC, "*Орга{red}(н)* {red}(тип) опис", f -> f.italic(0, 6).color("red", 4, 10));
			userInput(fld, CYRILLIC, "++Орг**ан тип о**пис++", f -> f.underline(0, 14).bold(3, 11));
			userInput(fld, CYRILLIC, "++Орган **тип опис**++", f -> f.underline(0, 14).bold(5, 14));
			userInput(fld, CYRILLIC, "++**Орган тип** опис++", f -> f.underline(0, 14).bold(0, 9));
			userInput(fld, CYRILLIC, "++Орга**н**++ **тип** опис", f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, CYRILLIC, "++Орг*ан тип о*пис++", f -> f.underline(0, 14).italic(3, 11));
			userInput(fld, CYRILLIC, "++Орган *тип опис*++", f -> f.underline(0, 14).italic(5, 14));
			userInput(fld, CYRILLIC, "++*Орган тип* опис++", f -> f.underline(0, 14).italic(0, 9));
			userInput(fld, CYRILLIC, "++Орга*н*++ *тип* опис", f -> f.underline(0, 6).italic(4, 10));
			userInput(fld, CYRILLIC, "++Орг~~ан тип о~~пис++", f -> f.underline(0, 14).strike(3, 11));
			userInput(fld, CYRILLIC, "++Орган ~~тип опис~~++", f -> f.underline(0, 14).strike(5, 14));
			userInput(fld, CYRILLIC, "++~~Орган тип~~ опис++", f -> f.underline(0, 14).strike(0, 9));
			userInput(fld, CYRILLIC, "++Орга~~н~~++ ~~тип~~ опис", f -> f.underline(0, 6).strike(4, 10));
			userInput(fld, CYRILLIC, "++Орг{red}(ан тип о)пис++", f -> f.underline(0, 14).color("red", 3, 11));
			userInput(fld, CYRILLIC, "++Орган {red}(тип опис)++", f -> f.underline(0, 14).color("red", 5, 14));
			userInput(fld, CYRILLIC, "++{red}(Орган тип) опис++", f -> f.underline(0, 14).color("red", 0, 9));
			userInput(fld, CYRILLIC, "++Орга{red}(н)++ {red}(тип) опис", f -> f.underline(0, 6).color("red", 4, 10));
			userInput(fld, CYRILLIC, "~~Орг**ан тип о**пис~~", f -> f.strike(0, 14).bold(3, 11));
			userInput(fld, CYRILLIC, "~~Орган **тип опис**~~", f -> f.strike(0, 14).bold(5, 14));
			userInput(fld, CYRILLIC, "~~**Орган тип** опис~~", f -> f.strike(0, 14).bold(0, 9));
			userInput(fld, CYRILLIC, "~~Орга**н**~~ **тип** опис", f -> f.strike(0, 6).bold(4, 10));
			userInput(fld, CYRILLIC, "~~Орг*ан тип о*пис~~", f -> f.strike(0, 14).italic(3, 11));
			userInput(fld, CYRILLIC, "~~Орган *тип опис*~~", f -> f.strike(0, 14).italic(5, 14));
			userInput(fld, CYRILLIC, "~~*Орган тип* опис~~", f -> f.strike(0, 14).italic(0, 9));
			userInput(fld, CYRILLIC, "~~Орга*н*~~ *тип* опис", f -> f.strike(0, 6).italic(4, 10));
			userInput(fld, CYRILLIC, "~~Орг++ан тип о++пис~~", f -> f.strike(0, 14).underline(3, 11));
			userInput(fld, CYRILLIC, "~~Орган ++тип опис++~~", f -> f.strike(0, 14).underline(5, 14));
			userInput(fld, CYRILLIC, "~~++Орган тип++ опис~~", f -> f.strike(0, 14).underline(0, 9));
			userInput(fld, CYRILLIC, "~~Орга++н++~~ ++тип++ опис", f -> f.strike(0, 6).underline(4, 10));
			userInput(fld, CYRILLIC, "~~Орг{red}(ан тип о)пис~~", f -> f.strike(0, 14).color("red", 3, 11));
			userInput(fld, CYRILLIC, "~~Орган {red}(тип опис)~~", f -> f.strike(0, 14).color("red", 5, 14));
			userInput(fld, CYRILLIC, "~~{red}(Орган тип) опис~~", f -> f.strike(0, 14).color("red", 0, 9));
			userInput(fld, CYRILLIC, "~~Орга{red}(н)~~ {red}(тип) опис", f -> f.strike(0, 6).color("red", 4, 10));
			userInput(fld, CYRILLIC, "{red}(Орг**ан тип о**пис)", f -> f.color("red", 0, 14).bold(3, 11));
			userInput(fld, CYRILLIC, "{red}(Орган **тип опис**)", f -> f.color("red", 0, 14).bold(5, 14));
			userInput(fld, CYRILLIC, "{red}(**Орган тип** опис)", f -> f.color("red", 0, 14).bold(0, 9));
			userInput(fld, CYRILLIC, "{red}(Орга**н**) **тип** опис", f -> f.color("red", 0, 6).bold(4, 10));
			userInput(fld, CYRILLIC, "{red}(Орг*ан тип о*пис)", f -> f.color("red", 0, 14).italic(3, 11));
			userInput(fld, CYRILLIC, "{red}(Орган *тип опис*)", f -> f.color("red", 0, 14).italic(5, 14));
			userInput(fld, CYRILLIC, "{red}(*Орган тип* опис)", f -> f.color("red", 0, 14).italic(0, 9));
			userInput(fld, CYRILLIC, "{red}(Орга*н*) *тип* опис", f -> f.color("red", 0, 6).italic(4, 10));
			userInput(fld, CYRILLIC, "{red}(Орг++ан тип о++пис)", f -> f.color("red", 0, 14).underline(3, 11));
			userInput(fld, CYRILLIC, "{red}(Орган ++тип опис++)", f -> f.color("red", 0, 14).underline(5, 14));
			userInput(fld, CYRILLIC, "{red}(++Орган тип++ опис)", f -> f.color("red", 0, 14).underline(0, 9));
			userInput(fld, CYRILLIC, "{red}(Орга++н++) ++тип++ опис", f -> f.color("red", 0, 6).underline(4, 10));
			userInput(fld, CYRILLIC, "{red}(Орг~~ан тип о~~пис)", f -> f.color("red", 0, 14).strike(3, 11));
			userInput(fld, CYRILLIC, "{red}(Орган ~~тип опис~~)", f -> f.color("red", 0, 14).strike(5, 14));
			userInput(fld, CYRILLIC, "{red}(~~Орган тип~~ опис)", f -> f.color("red", 0, 14).strike(0, 9));
			userInput(fld, CYRILLIC, "{red}(Орга~~н~~) ~~тип~~ опис", f -> f.color("red", 0, 6).strike(4, 10));
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("The same marks on characters that must be escaped")
	@Description("The same lines over text made only of characters that must be escaped: backslash, star, underscore, brackets, braces. Each must come back as the same character, and the escaping must not grow or shrink when a mark is next to it.")
	void markCombinationsOverEscapes() {
		open();
		final String ESCAPES = "a\\b*c_d[e]f{g}";
		Allure.step("One mark over the whole text", () -> {
			userInput(fld, ESCAPES, "**a\\\\b\\*c\\_d\\[e\\]f{g}**", f -> f.bold());
			userInput(fld, ESCAPES, "*a\\\\b\\*c\\_d\\[e\\]f{g}*", f -> f.italic());
			userInput(fld, ESCAPES, "++a\\\\b\\*c\\_d\\[e\\]f{g}++", f -> f.underline());
			userInput(fld, ESCAPES, "~~a\\\\b\\*c\\_d\\[e\\]f{g}~~", f -> f.strike());
			userInput(fld, ESCAPES, "{red}(a\\\\b\\*c\\_d\\[e\\]f{g})", f -> f.color("red"));
		});
		Allure.step("Two marks: one inside the other, same end, same start, crossing", () -> {
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).italic(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).italic(5, 14));
			userInput(fld, ESCAPES, "***a\\\\b\\*c\\_d\\[e*\\]f{g}**", f -> f.bold(0, 14).italic(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 6).italic(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).underline(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).underline(5, 14));
			userInput(fld, ESCAPES, "**++a\\\\b\\*c\\_d\\[e++\\]f{g}**", f -> f.bold(0, 14).underline(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 6).underline(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).strike(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 14).strike(5, 14));
			userInput(fld, ESCAPES, "**~~a\\\\b\\*c\\_d\\[e~~\\]f{g}**", f -> f.bold(0, 14).strike(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 6).strike(4, 10));
			userInput(fld, ESCAPES, "**a\\\\b{red}(\\*c\\_d\\[e\\]f){g}**", f -> f.bold(0, 14).color("red", 3, 11));
			userInput(fld, ESCAPES, "**a\\\\b\\*c{red}(\\_d\\[e\\]f{g})**", f -> f.bold(0, 14).color("red", 5, 14));
			userInput(fld, ESCAPES, "**{red}(a\\\\b\\*c\\_d\\[e)\\]f{g}**", f -> f.bold(0, 14).color("red", 0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.bold(0, 6).color("red", 4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).bold(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).bold(5, 14));
			userInput(fld, ESCAPES, "***a\\\\b\\*c\\_d\\[e**\\]f{g}*", f -> f.italic(0, 14).bold(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 6).bold(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).underline(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).underline(5, 14));
			userInput(fld, ESCAPES, "*++a\\\\b\\*c\\_d\\[e++\\]f{g}*", f -> f.italic(0, 14).underline(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 6).underline(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).strike(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 14).strike(5, 14));
			userInput(fld, ESCAPES, "*~~a\\\\b\\*c\\_d\\[e~~\\]f{g}*", f -> f.italic(0, 14).strike(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 6).strike(4, 10));
			userInput(fld, ESCAPES, "*a\\\\b{red}(\\*c\\_d\\[e\\]f){g}*", f -> f.italic(0, 14).color("red", 3, 11));
			userInput(fld, ESCAPES, "*a\\\\b\\*c{red}(\\_d\\[e\\]f{g})*", f -> f.italic(0, 14).color("red", 5, 14));
			userInput(fld, ESCAPES, "*{red}(a\\\\b\\*c\\_d\\[e)\\]f{g}*", f -> f.italic(0, 14).color("red", 0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.italic(0, 6).color("red", 4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).bold(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).bold(5, 14));
			userInput(fld, ESCAPES, "++**a\\\\b\\*c\\_d\\[e**\\]f{g}++", f -> f.underline(0, 14).bold(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).italic(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).italic(5, 14));
			userInput(fld, ESCAPES, "++*a\\\\b\\*c\\_d\\[e*\\]f{g}++", f -> f.underline(0, 14).italic(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 6).italic(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).strike(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 14).strike(5, 14));
			userInput(fld, ESCAPES, "++~~a\\\\b\\*c\\_d\\[e~~\\]f{g}++", f -> f.underline(0, 14).strike(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 6).strike(4, 10));
			userInput(fld, ESCAPES, "++a\\\\b{red}(\\*c\\_d\\[e\\]f){g}++", f -> f.underline(0, 14).color("red", 3, 11));
			userInput(fld, ESCAPES, "++a\\\\b\\*c{red}(\\_d\\[e\\]f{g})++", f -> f.underline(0, 14).color("red", 5, 14));
			userInput(fld, ESCAPES, "++{red}(a\\\\b\\*c\\_d\\[e)\\]f{g}++", f -> f.underline(0, 14).color("red", 0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.underline(0, 6).color("red", 4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).bold(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).bold(5, 14));
			userInput(fld, ESCAPES, "~~**a\\\\b\\*c\\_d\\[e**\\]f{g}~~", f -> f.strike(0, 14).bold(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 6).bold(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).italic(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).italic(5, 14));
			userInput(fld, ESCAPES, "~~*a\\\\b\\*c\\_d\\[e*\\]f{g}~~", f -> f.strike(0, 14).italic(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 6).italic(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).underline(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 14).underline(5, 14));
			userInput(fld, ESCAPES, "~~++a\\\\b\\*c\\_d\\[e++\\]f{g}~~", f -> f.strike(0, 14).underline(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 6).underline(4, 10));
			userInput(fld, ESCAPES, "~~a\\\\b{red}(\\*c\\_d\\[e\\]f){g}~~", f -> f.strike(0, 14).color("red", 3, 11));
			userInput(fld, ESCAPES, "~~a\\\\b\\*c{red}(\\_d\\[e\\]f{g})~~", f -> f.strike(0, 14).color("red", 5, 14));
			userInput(fld, ESCAPES, "~~{red}(a\\\\b\\*c\\_d\\[e)\\]f{g}~~", f -> f.strike(0, 14).color("red", 0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.strike(0, 6).color("red", 4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).bold(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).bold(5, 14));
			userInput(fld, ESCAPES, "{red}(**a\\\\b\\*c\\_d\\[e**\\]f{g})", f -> f.color("red", 0, 14).bold(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 6).bold(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).italic(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).italic(5, 14));
			userInput(fld, ESCAPES, "{red}(*a\\\\b\\*c\\_d\\[e*\\]f{g})", f -> f.color("red", 0, 14).italic(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 6).italic(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).underline(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).underline(5, 14));
			userInput(fld, ESCAPES, "{red}(++a\\\\b\\*c\\_d\\[e++\\]f{g})", f -> f.color("red", 0, 14).underline(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 6).underline(4, 10));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).strike(3, 11));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 14).strike(5, 14));
			userInput(fld, ESCAPES, "{red}(~~a\\\\b\\*c\\_d\\[e~~\\]f{g})", f -> f.color("red", 0, 14).strike(0, 9));
			userInput(fld, ESCAPES, REFUSED, f -> f.color("red", 0, 6).strike(4, 10));
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("The same marks on text with an emoji")
	@Description("The same lines over text with an emoji. An emoji is one character for the user but two for Java, so a mark next to it checks that positions are counted correctly.")
	void markCombinationsOverEmoji() {
		open();
		final String EMOJI = "ab😀cd ef gh ij";
		Allure.step("One mark over the whole text", () -> {
			userInput(fld, EMOJI, "**ab😀cd ef gh ij**", f -> f.bold());
			userInput(fld, EMOJI, "*ab😀cd ef gh ij*", f -> f.italic());
			userInput(fld, EMOJI, "++ab😀cd ef gh ij++", f -> f.underline());
			userInput(fld, EMOJI, "~~ab😀cd ef gh ij~~", f -> f.strike());
			userInput(fld, EMOJI, "{red}(ab😀cd ef gh ij)", f -> f.color("red"));
		});
		Allure.step("Two marks: one inside the other, same end, same start, crossing", () -> {
			userInput(fld, EMOJI, "**ab😀*cd ef gh* ij**", f -> f.bold(0, 14).italic(3, 11));
			userInput(fld, EMOJI, "**ab😀cd *ef gh ij***", f -> f.bold(0, 14).italic(5, 14));
			userInput(fld, EMOJI, "***ab😀cd ef* gh ij**", f -> f.bold(0, 14).italic(0, 9));
			userInput(fld, EMOJI, "**ab😀c*d*** *ef g*h ij", f -> f.bold(0, 6).italic(4, 10));
			userInput(fld, EMOJI, "**ab😀++cd ef gh++ ij**", f -> f.bold(0, 14).underline(3, 11));
			userInput(fld, EMOJI, "**ab😀cd ++ef gh ij++**", f -> f.bold(0, 14).underline(5, 14));
			userInput(fld, EMOJI, "**++ab😀cd ef++ gh ij**", f -> f.bold(0, 14).underline(0, 9));
			userInput(fld, EMOJI, "**ab😀c++d++** ++ef g++h ij", f -> f.bold(0, 6).underline(4, 10));
			userInput(fld, EMOJI, "**ab😀~~cd ef gh~~ ij**", f -> f.bold(0, 14).strike(3, 11));
			userInput(fld, EMOJI, "**ab😀cd ~~ef gh ij~~**", f -> f.bold(0, 14).strike(5, 14));
			userInput(fld, EMOJI, "**~~ab😀cd ef~~ gh ij**", f -> f.bold(0, 14).strike(0, 9));
			userInput(fld, EMOJI, "**ab😀c~~d~~** ~~ef g~~h ij", f -> f.bold(0, 6).strike(4, 10));
			userInput(fld, EMOJI, "**ab😀{red}(cd ef gh) ij**", f -> f.bold(0, 14).color("red", 3, 11));
			userInput(fld, EMOJI, "**ab😀cd {red}(ef gh ij)**", f -> f.bold(0, 14).color("red", 5, 14));
			userInput(fld, EMOJI, "**{red}(ab😀cd ef) gh ij**", f -> f.bold(0, 14).color("red", 0, 9));
			userInput(fld, EMOJI, "**ab😀c{red}(d)** {red}(ef g)h ij", f -> f.bold(0, 6).color("red", 4, 10));
			userInput(fld, EMOJI, "*ab😀**cd ef gh** ij*", f -> f.italic(0, 14).bold(3, 11));
			userInput(fld, EMOJI, "*ab😀cd **ef gh ij***", f -> f.italic(0, 14).bold(5, 14));
			userInput(fld, EMOJI, "***ab😀cd ef** gh ij*", f -> f.italic(0, 14).bold(0, 9));
			userInput(fld, EMOJI, "*ab😀c**d*** **ef g**h ij", f -> f.italic(0, 6).bold(4, 10));
			userInput(fld, EMOJI, "*ab😀++cd ef gh++ ij*", f -> f.italic(0, 14).underline(3, 11));
			userInput(fld, EMOJI, "*ab😀cd ++ef gh ij++*", f -> f.italic(0, 14).underline(5, 14));
			userInput(fld, EMOJI, "*++ab😀cd ef++ gh ij*", f -> f.italic(0, 14).underline(0, 9));
			userInput(fld, EMOJI, "*ab😀c++d++* ++ef g++h ij", f -> f.italic(0, 6).underline(4, 10));
			userInput(fld, EMOJI, "*ab😀~~cd ef gh~~ ij*", f -> f.italic(0, 14).strike(3, 11));
			userInput(fld, EMOJI, "*ab😀cd ~~ef gh ij~~*", f -> f.italic(0, 14).strike(5, 14));
			userInput(fld, EMOJI, "*~~ab😀cd ef~~ gh ij*", f -> f.italic(0, 14).strike(0, 9));
			userInput(fld, EMOJI, "*ab😀c~~d~~* ~~ef g~~h ij", f -> f.italic(0, 6).strike(4, 10));
			userInput(fld, EMOJI, "*ab😀{red}(cd ef gh) ij*", f -> f.italic(0, 14).color("red", 3, 11));
			userInput(fld, EMOJI, "*ab😀cd {red}(ef gh ij)*", f -> f.italic(0, 14).color("red", 5, 14));
			userInput(fld, EMOJI, "*{red}(ab😀cd ef) gh ij*", f -> f.italic(0, 14).color("red", 0, 9));
			userInput(fld, EMOJI, "*ab😀c{red}(d)* {red}(ef g)h ij", f -> f.italic(0, 6).color("red", 4, 10));
			userInput(fld, EMOJI, "++ab😀**cd ef gh** ij++", f -> f.underline(0, 14).bold(3, 11));
			userInput(fld, EMOJI, "++ab😀cd **ef gh ij**++", f -> f.underline(0, 14).bold(5, 14));
			userInput(fld, EMOJI, "++**ab😀cd ef** gh ij++", f -> f.underline(0, 14).bold(0, 9));
			userInput(fld, EMOJI, "++ab😀c**d**++ **ef g**h ij", f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, EMOJI, "++ab😀*cd ef gh* ij++", f -> f.underline(0, 14).italic(3, 11));
			userInput(fld, EMOJI, "++ab😀cd *ef gh ij*++", f -> f.underline(0, 14).italic(5, 14));
			userInput(fld, EMOJI, "++*ab😀cd ef* gh ij++", f -> f.underline(0, 14).italic(0, 9));
			userInput(fld, EMOJI, "++ab😀c*d*++ *ef g*h ij", f -> f.underline(0, 6).italic(4, 10));
			userInput(fld, EMOJI, "++ab😀~~cd ef gh~~ ij++", f -> f.underline(0, 14).strike(3, 11));
			userInput(fld, EMOJI, "++ab😀cd ~~ef gh ij~~++", f -> f.underline(0, 14).strike(5, 14));
			userInput(fld, EMOJI, "++~~ab😀cd ef~~ gh ij++", f -> f.underline(0, 14).strike(0, 9));
			userInput(fld, EMOJI, "++ab😀c~~d~~++ ~~ef g~~h ij", f -> f.underline(0, 6).strike(4, 10));
			userInput(fld, EMOJI, "++ab😀{red}(cd ef gh) ij++", f -> f.underline(0, 14).color("red", 3, 11));
			userInput(fld, EMOJI, "++ab😀cd {red}(ef gh ij)++", f -> f.underline(0, 14).color("red", 5, 14));
			userInput(fld, EMOJI, "++{red}(ab😀cd ef) gh ij++", f -> f.underline(0, 14).color("red", 0, 9));
			userInput(fld, EMOJI, "++ab😀c{red}(d)++ {red}(ef g)h ij", f -> f.underline(0, 6).color("red", 4, 10));
			userInput(fld, EMOJI, "~~ab😀**cd ef gh** ij~~", f -> f.strike(0, 14).bold(3, 11));
			userInput(fld, EMOJI, "~~ab😀cd **ef gh ij**~~", f -> f.strike(0, 14).bold(5, 14));
			userInput(fld, EMOJI, "~~**ab😀cd ef** gh ij~~", f -> f.strike(0, 14).bold(0, 9));
			userInput(fld, EMOJI, "~~ab😀c**d**~~ **ef g**h ij", f -> f.strike(0, 6).bold(4, 10));
			userInput(fld, EMOJI, "~~ab😀*cd ef gh* ij~~", f -> f.strike(0, 14).italic(3, 11));
			userInput(fld, EMOJI, "~~ab😀cd *ef gh ij*~~", f -> f.strike(0, 14).italic(5, 14));
			userInput(fld, EMOJI, "~~*ab😀cd ef* gh ij~~", f -> f.strike(0, 14).italic(0, 9));
			userInput(fld, EMOJI, "~~ab😀c*d*~~ *ef g*h ij", f -> f.strike(0, 6).italic(4, 10));
			userInput(fld, EMOJI, "~~ab😀++cd ef gh++ ij~~", f -> f.strike(0, 14).underline(3, 11));
			userInput(fld, EMOJI, "~~ab😀cd ++ef gh ij++~~", f -> f.strike(0, 14).underline(5, 14));
			userInput(fld, EMOJI, "~~++ab😀cd ef++ gh ij~~", f -> f.strike(0, 14).underline(0, 9));
			userInput(fld, EMOJI, "~~ab😀c++d++~~ ++ef g++h ij", f -> f.strike(0, 6).underline(4, 10));
			userInput(fld, EMOJI, "~~ab😀{red}(cd ef gh) ij~~", f -> f.strike(0, 14).color("red", 3, 11));
			userInput(fld, EMOJI, "~~ab😀cd {red}(ef gh ij)~~", f -> f.strike(0, 14).color("red", 5, 14));
			userInput(fld, EMOJI, "~~{red}(ab😀cd ef) gh ij~~", f -> f.strike(0, 14).color("red", 0, 9));
			userInput(fld, EMOJI, "~~ab😀c{red}(d)~~ {red}(ef g)h ij", f -> f.strike(0, 6).color("red", 4, 10));
			userInput(fld, EMOJI, "{red}(ab😀**cd ef gh** ij)", f -> f.color("red", 0, 14).bold(3, 11));
			userInput(fld, EMOJI, "{red}(ab😀cd **ef gh ij**)", f -> f.color("red", 0, 14).bold(5, 14));
			userInput(fld, EMOJI, "{red}(**ab😀cd ef** gh ij)", f -> f.color("red", 0, 14).bold(0, 9));
			userInput(fld, EMOJI, "{red}(ab😀c**d**) **ef g**h ij", f -> f.color("red", 0, 6).bold(4, 10));
			userInput(fld, EMOJI, "{red}(ab😀*cd ef gh* ij)", f -> f.color("red", 0, 14).italic(3, 11));
			userInput(fld, EMOJI, "{red}(ab😀cd *ef gh ij*)", f -> f.color("red", 0, 14).italic(5, 14));
			userInput(fld, EMOJI, "{red}(*ab😀cd ef* gh ij)", f -> f.color("red", 0, 14).italic(0, 9));
			userInput(fld, EMOJI, "{red}(ab😀c*d*) *ef g*h ij", f -> f.color("red", 0, 6).italic(4, 10));
			userInput(fld, EMOJI, "{red}(ab😀++cd ef gh++ ij)", f -> f.color("red", 0, 14).underline(3, 11));
			userInput(fld, EMOJI, "{red}(ab😀cd ++ef gh ij++)", f -> f.color("red", 0, 14).underline(5, 14));
			userInput(fld, EMOJI, "{red}(++ab😀cd ef++ gh ij)", f -> f.color("red", 0, 14).underline(0, 9));
			userInput(fld, EMOJI, "{red}(ab😀c++d++) ++ef g++h ij", f -> f.color("red", 0, 6).underline(4, 10));
			userInput(fld, EMOJI, "{red}(ab😀~~cd ef gh~~ ij)", f -> f.color("red", 0, 14).strike(3, 11));
			userInput(fld, EMOJI, "{red}(ab😀cd ~~ef gh ij~~)", f -> f.color("red", 0, 14).strike(5, 14));
			userInput(fld, EMOJI, "{red}(~~ab😀cd ef~~ gh ij)", f -> f.color("red", 0, 14).strike(0, 9));
			userInput(fld, EMOJI, "{red}(ab😀c~~d~~) ~~ef g~~h ij", f -> f.color("red", 0, 6).strike(4, 10));
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Colour, and parentheses inside it")
	@Description("A colour is stored as {red}(text), so a parenthesis inside the text must be escaped, or the colour would end early. Lines: real texts with parentheses, colour together with other marks, colour next to another colour, and values that can only be DB input.")
	void colour() {
		open();
		Allure.step("Colour over text with parentheses and markdown characters: inside {red}(...) they must be escaped", () -> {
			userInput(fld, "Hello (world)", "{red}(Hello \\(world\\))", f -> f.color("red"));
			userInput(fld, "()", "{red}(\\(\\))", f -> f.color("red"));
			userInput(fld, "a)b(c", "{red}(a\\)b\\(c)", f -> f.color("red"));
			userInput(fld, "smile :) ok", "{red}(smile :\\) ok)", f -> f.color("red"));
			userInput(fld, "((deep))", "{red}(\\(\\(deep\\)\\))", f -> f.color("red"));
			userInput(fld, "a))b", "{red}(a\\)\\)b)", f -> f.color("red"));
			userInput(fld, "a((b", "{red}(a\\(\\(b)", f -> f.color("red"));
			userInput(fld, "*", "{red}(\\*)", f -> f.color("red"));
			userInput(fld, "*x*", "{red}(\\*x\\*)", f -> f.color("red"));
			userInput(fld, "a*b", "{red}(a\\*b)", f -> f.color("red"));
			userInput(fld, "_x_", "{red}(\\_x\\_)", f -> f.color("red"));
			userInput(fld, "a[b]c", "{red}(a\\[b\\]c)", f -> f.color("red"));
			userInput(fld, "a`b", "{red}(a\\`b)", f -> f.color("red"));
		});
		Allure.step("Colour together with another mark", () -> {
			userInput(fld, "code", "`code`", f -> f.color("red").inlineCode());
			dbInput(fld, "{red}(`code`)", "Inline code has no colour, clicking it removes the colour");
			userInput(fld, "a\\b", "{red}(a\\\\b)", f -> f.color("red"));
			userInput(fld, "x", "{red}(*x*)", f -> f.color("red").italic());
			userInput(fld, "x", "{red}(++x++)", f -> f.color("red").underline());
			userInput(fld, "x", "{red}(~~x~~)", f -> f.color("red").strike());
			userInput(fld, "a(b)c", "{red}(**a\\(b\\)c**)", f -> f.color("red").bold());
			userInput(fld, "a(b)c", "{red}(++a\\(b\\)c++)", f -> f.color("red").underline());
			userInput(fld, "Орган (тип)", "{green}(***++Орган \\(тип\\)++***)", f -> f.color("green").bold().italic().underline());
			userInput(fld, "f(x)", "`f(x)`", f -> f.color("red").inlineCode());
		});
		Allure.step("Colour on a part of the text, and two colours side by side", () -> {
			userInput(fld, "before x after", "before {red}(x) after", f -> f.color("red", 7, 8));
			userInput(fld, "xy", "{red}(x){blue}(y)", f -> f.color("red", 0, 1).color("blue", 1, 2));
			userInput(fld, "x y", "{red}(x) {blue}(y)", f -> f.color("red", 0, 1).color("blue", 2, 3));
		});
		Allure.step("Values that can only be DB input, and text that only looks like a colour", () -> {
			dbInput(fld, "[{yellow}(site)](localhost)", "a link cannot be made with the toolbar");
			dbInput(fld, "{unknown}(x)", "this colour is not in the palette");
			userInput(fld, "{RED}(x)", "{RED}(x)");
			userInput(fld, "a{b}c", "a{b}c");
			userInput(fld, "ok 😀", "{red}(ok 😀)", f -> f.color("red"));
			userInput(fld, "1) first", "{red}(1\\) first)", f -> f.color("red"));
			dbInput(fld, "[{red}(**x**)](url)", "a link cannot be made with the toolbar");
			dbOldSpellingInput(fld, "[**{red}(x)**](url)", "[{red}(**x**)](url)");
			dbInput(fld, "{crimson}(x)", "this colour is not in the palette");
			dbInput(fld, "{red2}(x)", "this colour is not in the palette");
		});
		Allure.step("A link and a colour as user input are escaped like any text", () -> {
			userInput(fld, "[text](url)", "{red}(\\[text\\]\\(url\\))", f -> f.color("red"));
			userInput(fld, "{blue}(x)", "{red}({blue}\\(x\\))", f -> f.color("red"));
		});
		Allure.step("Colour over text with braces, percent, backslashes and parentheses at the edges", () -> {
			userInput(fld, "{not a color}", "{red}({not a color})", f -> f.color("red"));
			dbOldSpellingInput(fld, "{red}(\\{not a color\\})", "{red}({not a color})");
			userInput(fld, "100% (ok)", "{red}(100% \\(ok\\))", f -> f.color("red"));
			dbOldSpellingInput(fld, "{red}(100\\% \\(ok\\))", "{red}(100% \\(ok\\))");
			userInput(fld, "a\\(b)", "{red}(a\\\\\\(b\\))", f -> f.color("red"));
			userInput(fld, "ab\\", "{red}(ab\\\\)", f -> f.color("red"));
			userInput(fld, "\\", "{red}(\\\\)", f -> f.color("red"));
			userInput(fld, "(abc", "{red}(\\(abc)", f -> f.color("red"));
			userInput(fld, "abc)", "{red}(abc\\))", f -> f.color("red"));
			userInput(fld, "(abc)", "{red}(\\(abc\\))", f -> f.color("red"));
			userInput(fld, "f(x) = 2 * x", "{red}(f\\(x\\) = 2 \\* x)", f -> f.color("red"));
			userInput(fld, "+7 (999) 000-00-00", "{blue}(+7 \\(999\\) 000-00-00)", f -> f.color("blue"));
		});
		Allure.step("Colour on one character inside parentheses; an unknown colour name is text; an empty colour is nothing", () -> {
			userInput(fld, "(x)", "({red}(x))", f -> f.color("red", 1, 2));
			userInput(fld, "before (x) after", "before ({red}(x)) after", f -> f.color("red", 8, 9));
			userInput(fld, "{RED}(a(b))", "{RED}(a(b))");
			dbOldSpellingInput(fld, "{RED}(a\\(b\\))", "{RED}(a(b))");
			userInput(fld, "", "");
			dbOldSpellingInput(fld, "{red}()", "");
		});
		Allure.step("KNOWN BUG, accepted for now: a link or a colour inside a colour is turned into plain escaped text when the value is opened", () -> {
			dbInput(fld, "{red}(\\[text\\]\\(url))", "this is what the editor makes of a link inside a colour");
			dbOldSpellingInput(fld, "{red}([text](url))", "{red}(\\[text\\]\\(url))");
			dbInput(fld, "{red}({blue}\\(x))", "this is what the editor makes of a colour inside a colour");
			dbOldSpellingInput(fld, "{red}({blue}(x))", "{red}({blue}\\(x))");
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Plain text that looks like markdown")
	@Description("The user types characters that markdown uses: stars, underscores, backticks, brackets, &, <, >. The editor must escape them so they come back as the same text, and must not add or remove backslashes on the second save.")
	void syntaxText() {
		open();
		Allure.step("Markdown characters as user input are escaped and come back unchanged", () -> {
			userInput(fld, "a*b", "a\\*b");
			userInput(fld, "a**b", "a\\*\\*b");
			userInput(fld, "a_b", "a\\_b");
			userInput(fld, "a`b", "a\\`b");
			userInput(fld, "a[b]c", "a\\[b\\]c");
			userInput(fld, "a(b)c", "a(b)c");
			userInput(fld, "a{b}c", "a{b}c");
			userInput(fld, "a|b", "a|b");
			userInput(fld, "a~b", "a\\~b");
			userInput(fld, "a\\b", "a\\\\b");
			userInput(fld, "C:\\Users\\test", "C:\\\\Users\\\\test");
			userInput(fld, "**not bold**", "\\*\\*not bold\\*\\*");
			userInput(fld, "a****b", "a\\*\\*\\*\\*b");
			userInput(fld, "***", "\\*\\*\\*");
		});
		Allure.step("Characters that need no escaping: dashes, dots, currency, Cyrillic, emoji, CJK, special spaces", () -> {
			userInput(fld, "a-b-c", "a-b-c");
			userInput(fld, "v1.2.3", "v1.2.3");
			userInput(fld, "$1,000.00", "$1,000.00");
			userInput(fld, "100%", "100%");
			userInput(fld, "@mention", "@mention");
			userInput(fld, "Тест — тире, «кавычки», …", "Тест — тире, «кавычки», …");
			userInput(fld, "Орган (тип) — описание", "Орган (тип) — описание");
			userInput(fld, "emoji 😀 ok", "emoji 😀 ok");
			userInput(fld, "emoji 👍🏽 ok", "emoji 👍🏽 ok");
			userInput(fld, "中文 テスト 한국어", "中文 テスト 한국어");
			userInput(fld, "a b", "a\u00A0b");
			userInput(fld, "a​b", "a\u200Bb");
			userInput(fld, "a  b", "a  b");
			userInput(fld, "a x b", "a {red}(x) b", f -> f.color("red", 2, 3));
			userInput(fld, "```not a fence", "\\`\\`\\`not a fence");
		});
		Allure.step("# & < > are stored as HTML entities; as DB input their escaped spellings open to the same value", () -> {
			userInput(fld, "a#b", "a#b");
			dbOldSpellingInput(fld, "a\\#b", "a#b");
			userInput(fld, "a>b", "a&gt;b");
			dbOldSpellingInput(fld, "a\\>b", "a&gt;b");
			userInput(fld, "a&b", "a&amp;b");
			dbOldSpellingInput(fld, "a&b", "a&amp;b");
			userInput(fld, "a<b>c", "a&lt;b&gt;c");
			dbOldSpellingInput(fld, "a\\<b\\>c", "a&lt;b&gt;c");
			userInput(fld, "http://example.com/a?b=c&d=e", "http://example.com/a?b=c&amp;d=e");
			dbOldSpellingInput(fld, "http://example.com/a?b=c&d=e", "http://example.com/a?b=c&amp;d=e");
		});
		Allure.step("An entity as user input (six characters) is text, not an entity", () -> {
			userInput(fld, "a&gt;b", "a&amp;gt;b");
			userInput(fld, "a&amp;b", "a&amp;amp;b");
			userInput(fld, "a&lt;b&gt;c", "a&amp;lt;b&amp;gt;c");
		});
		Allure.step("Text that looks like markdown features this editor does not have: hashtags, tables, footnotes, task lists, links", () -> {
			userInput(fld, "#hashtag", "#hashtag");
			dbOldSpellingInput(fld, "\\#hashtag", "#hashtag");
			userInput(fld, "2 * 3 = 6", "2 \\* 3 = 6");
			dbOldSpellingInput(fld, "2 \\* 3 \\= 6", "2 \\* 3 = 6");
			userInput(fld, "key=value", "key=value");
			dbOldSpellingInput(fld, "key\\=value", "key=value");
			dbInput(fld, "!\\[alt\\](url)", "a link cannot be made with the toolbar");
			dbOldSpellingInput(fld, "\\!\\[alt\\](url)", "!\\[alt\\](url)");
			userInput(fld, "| a | b |", "| a | b |");
			userInput(fld, "[^1] note", "\\[^1\\] note");
			userInput(fld, "not a [ ] box", "not a \\[ \\] box");
			userInput(fld, "https://cxbox.org/page", "https://cxbox.org/page");
			userInput(fld, "user@example.com", "user@example.com");
			userInput(fld, "a^b#c", "a^b#c");
			userInput(fld, "a;b &amp;notanentity; c", "a;b &amp;amp;notanentity; c");
		});
		Allure.step("Marks on text with markdown characters", () -> {
			userInput(fld, "abc", "**a**++b++~~c~~", f -> f.bold(0, 1).underline(1, 2).strike(2, 3));
			userInput(fld, "a b c", "a ++b++ c", f -> f.underline(2, 3));
			userInput(fld, "**abc", "\\*\\*abc");
			userInput(fld, "abc**", "abc\\*\\*");
			userInput(fld, "a~~b", "a\\~\\~b");
			userInput(fld, "a++b", "a++b");
			userInput(fld, "Тест (круглые) [квадратные] {фигурные}", "Тест (круглые) \\[квадратные\\] {фигурные}");
			userInput(fld, "a.b,c;d:e!f?g-h—i…j", "a.b,c;d:e!f?g-h—i…j");
			userInput(fld, "a\tb", "a\tb");
			userInput(fld, "ab(cd)ef", "**ab(cd)ef**", f -> f.bold());
			userInput(fld, "a(b)c", "{red}(a\\(b\\)c)", f -> f.color("red"));
			userInput(fld, "a{b}c", "{red}(a{b}c)", f -> f.color("red"));
			userInput(fld, "a*b", "**a\\*b**", f -> f.bold());
			userInput(fld, "a_b", "**a\\_b**", f -> f.bold());
			userInput(fld, "a[b]c", "**a\\[b\\]c**", f -> f.bold());
			userInput(fld, "a`b", "**a\\`b**", f -> f.bold());
			userInput(fld, "a\\b", "**a\\\\b**", f -> f.bold());
			userInput(fld, "Орган (тип)", "**Орган (тип)**", f -> f.bold());
			userInput(fld, "ok 😀", "**ok 😀**", f -> f.bold());
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Marks across a line break (Shift+Enter)")
	@Description("The text has a line break inside one paragraph. A mark that spans the break must be closed before the break and opened again after it in the stored markdown, and the value must open again unchanged.")
	void lineBreaks() {
		open();
		Allure.step("A mark across a line break is closed before the break and opened again after it", () -> {
			userInput(fld, "abc\ndef", "**abc**  \n**def**", f -> f.bold());
			userInput(fld, "abc\ndef", "*abc*  \n*def*", f -> f.italic());
			userInput(fld, "abc\ndef", "++abc++  \n++def++", f -> f.underline());
			userInput(fld, "abc\ndef", "~~abc~~  \n~~def~~", f -> f.strike());
			userInput(fld, "abc\ndef", "{red}(abc)  \n{red}(def)", f -> f.color("red"));
			userInput(fld, "abc\ndef", "{red}(++abc++)  \n{red}(++def++)", f -> f.color("red").underline());
			userInput(fld, "abc\ndef", "{red}(**++abc++**)  \n{red}(**++def++**)", f -> f.color("red").bold().underline());
			userInput(fld, "abc\ndef", "{red}(***abc***)  \n{red}(***def***)", f -> f.color("red").bold().italic());
			userInput(fld, "abc\ndef", "{red}(***~~abc~~***)  \n{red}(***~~def~~***)", f -> f.color("red").bold().italic().strike());
			userInput(fld, "abc\ndef", "ab**c**  \n**def**", f -> f.bold(2, 7));
			userInput(fld, "abc\ndef", "**abc**  \n**de**f", f -> f.bold(0, 6));
			userInput(fld, "abc\ndef", "**abc**  \n*def*", f -> f.bold(0, 3).italic(4, 7));
			userInput(fld, "abc\ndef", "abc  \n++def++", f -> f.underline(4, 7));
			userInput(fld, "abc\ndef", "++abc++  \ndef", f -> f.underline(0, 3));
		});
		Allure.step("More lines, a break next to plain text, overlaps across the break", () -> {
			userInput(fld, "abc\ndef\nghi", "**abc**  \n**def**  \n**ghi**", f -> f.bold());
			userInput(fld, "abc\ndef\nghi\njkl", "**abc**  \n**def**  \n**ghi**  \n**jkl**", f -> f.bold());
			userInput(fld, "plain\nbold\nplain", "plain  \n**bold**  \nplain", f -> f.bold(6, 10));
			userInput(fld, "abcdef\nghi", "++abc**def**++  \n**++ghi++**", f -> f.underline(0, 6).bold(3, 10).underline(7, 10));
			userInput(fld, "abcdef\nghijkl", "++abc**def**++  \n**++ghi++jkl**", f -> f.underline(0, 6).bold(3, 13).underline(7, 10));
		});
		Allure.step("A break with parentheses and Cyrillic; a paragraph break; inline code across a break", () -> {
			userInput(fld, "a(b)\nc(d)", "{red}(a\\(b\\))  \n{red}(c\\(d\\))", f -> f.color("red"));
			userInput(fld, "Орган (тип)\nописание", "**Орган (тип)**  \n**описание**", f -> f.bold());
			userInput(fld, "abc\n\ndef", "**abc**\n\n**def**", f -> f.bold());
			userInput(fld, "abc def", "`abc def`", f -> f.inlineCode());
			dbOldSpellingInput(fld, "`abc\ndef`", "`abc def`");
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Headings, lists, quotes, code blocks")
	@Description("Block formatting: headings, bullet and numbered lists, quotes, code blocks, and documents with several blocks. Some values cannot be user input (deeper headings, nested lists, links): they are DB input only, checked to open and be stored again unchanged.")
	void blocks() {
		open();
		Allure.step("Headings, a quote, and a mark inside them", () -> {
			userInput(fld, "text", "# text", f -> f.heading(1));
			userInput(fld, "text", "## text", f -> f.heading(2));
			userInput(fld, "text", "### text", f -> f.heading(3));
			userInput(fld, "text", "> text", f -> f.quote());
			userInput(fld, "text", "text", f -> f.heading(2).paragraph());
			userInput(fld, "text", "# **text**", f -> f.heading(1).bold());
			userInput(fld, "text", "> **text**", f -> f.quote().bold());
		});
		Allure.step("Lists", () -> {
			userInput(fld, "item", "- item", f -> f.bulletList());
			userInput(fld, "item", "1. item", f -> f.orderedList());
			userInput(fld, "item", "- {red}(item)", f -> f.bulletList().color("red"));
			userInput(fld, "item", "1. *item*", f -> f.orderedList().italic());
		});
		Allure.step("A heading with a mark on a part of it; deeper headings are DB input only", () -> {
			userInput(fld, "Bold head", "# **Bold** head", f -> f.heading(1).bold(0, 4));
			userInput(fld, "Red head", "## {red}(Red) head", f -> f.heading(2).color("red", 0, 3));
			userInput(fld, "Head (with parens)", "# Head (with parens)", f -> f.heading(1));
			dbOldSpellingInput(fld, "# Head \\(with parens\\)", "# Head (with parens)");
			dbInput(fld, "#### Head", "the toolbar has Heading 1, 2 and 3 only");
			dbInput(fld, "##### Head", "the toolbar has Heading 1, 2 and 3 only");
			dbInput(fld, "###### Head", "the toolbar has Heading 1, 2 and 3 only");
			dbInput(fld, "# H1\n\n## H2\n\n### H3\n\n#### H4\n\n##### H5\n\n###### H6", "the toolbar has Heading 1, 2 and 3 only");
		});
		Allure.step("Several paragraphs turned into a list or a quote", () -> {
			userInput(fld, "one\n\ntwo\n\nthree", "- one\n- two\n- three", f -> f.bulletList());
			userInput(fld, "one\n\ntwo\n\nthree", "1. one\n2. two\n3. three", f -> f.orderedList());
			userInput(fld, "one\n\ntwo\n\nthree", "> one\n>\n> two\n>\n> three", f -> f.quote());
		});
		Allure.step("A quote with a line break; marks inside list items and quotes", () -> {
			userInput(fld, "one\ntwo", "> one  \n> two", f -> f.quote());
			userInput(fld, "one\ntwo", "> **one**  \n> **two**", f -> f.quote().bold());
			userInput(fld, "bold item\n\nred item\n\nunder item", "- **bold** item\n- {red}(red) item\n- ++under++ item", f -> f.bulletList().bold(0, 4).color("red", 10, 13).underline(19, 24));
			userInput(fld, "abcdefghi", "- ++abc**def**++**ghi**", f -> f.bulletList().underline(0, 6).bold(3, 9));
			userInput(fld, "bold quote", "> **bold** quote", f -> f.quote().bold(0, 4));
		});
		Allure.step("Lists and quotes that cannot be user input: nested lists, a list starting from 3, a quote inside a quote", () -> {
			dbInput(fld, "- one\n  - nested\n- two", "a nested list needs the Tab key, the toolbar has no button for it");
			dbInput(fld, "- one\n  - two\n    - three", "a nested list needs the Tab key, the toolbar has no button for it");
			dbInput(fld, "1. one\n  - nested", "a nested list needs the Tab key, the toolbar has no button for it");
			dbOldSpellingInput(fld, "1. one\n   - nested", "1. one\n  - nested");
			dbInput(fld, "3. three\n4. four", "a list that starts from 3 cannot be made with the toolbar");
			dbInput(fld, "- one\ntwo", "the editor never writes this spelling itself");
			dbOldSpellingInput(fld, "- one\n  two", "- one\ntwo");
			dbInput(fld, "> one\n> two", "the editor never writes this spelling itself");
			dbInput(fld, "> outer\n>\n> > inner", "a quote inside a quote cannot be made with the toolbar");
		});
		Allure.step("Code blocks and inline code", () -> {
			userInput(fld, "code", "```\ncode\n```", f -> f.codeBlock());
			userInput(fld, "**not bold** {red}(not red)", "```\n**not bold** {red}(not red)\n```", f -> f.codeBlock());
			userInput(fld, "****", "```\n****\n```", f -> f.codeBlock());
			userInput(fld, "line one\nline two", "```\nline one\nline two\n```", f -> f.codeBlock());
			dbInput(fld, "```js\nconst a = 1\n```", "the toolbar cannot set the code block language");
			userInput(fld, "a*b", "`a*b`", f -> f.inlineCode());
			userInput(fld, "x", "`x`", f -> f.inlineCode().color("red"));
			userInput(fld, "<div>", "`<div>`", f -> f.inlineCode());
		});
		Allure.step("Documents with several blocks", () -> {
			userInput(fld, "para one\n\npara two", "para one\n\npara two");
			userInput(fld, "one\n\ntwo\n\nthree", "one\n\ntwo\n\nthree");
			userInput(fld, "Head\n\npara\n\nitem\n\nquote", "# Head\n\npara\n\n- item\n\n> quote", f -> f.heading(1, 0, 4).bulletList(10, 14).quote(15, 20));
			userInput(fld, "Head\n\ncode\n\npara", "## Head\n\n```\ncode\n```\n\npara", f -> f.heading(2, 0, 4).codeBlock(5, 9));
			userInput(fld, "before\n\none\n\ntwo\n\nafter", "before\n\n1. one\n2. two\n\nafter", f -> f.orderedList(7, 14));
		});
		Allure.step("Links are DB input only; a heading with all four marks", () -> {
			dbInput(fld, "[text](url)", "a link cannot be made with the toolbar");
			dbInput(fld, "[**text**](url)", "a link cannot be made with the toolbar");
			dbInput(fld, "see [the docs](https://cxbox.org) for more", "a link cannot be made with the toolbar");
			dbInput(fld, "[text](https://cxbox.org/page#anchor)", "a link cannot be made with the toolbar");
			userInput(fld, "x", "### ***~~++x++~~***", f -> f.heading(3).bold().italic().strike().underline());
			dbOldSpellingInput(fld, "### ***++~~x~~++***", "### ***~~++x++~~***");
		});
		Allure.step("KNOWN BUG, accepted for now: Quote around a list also quotes two empty lines after the list", () -> {
			userInput(fld, "one\n\ntwo\n\nthree", "> - one\n> - two\n> - three\n>\n>", f -> f.bulletList().quote());
		});
		Allure.step("KNOWN BUG, accepted for now: a stored --- (horizontal rule) is lost when the value is opened: the editor has no such element", () -> {
			userInputButReopenBreaks(fld, "---", "---");
		});
	}

	@Test
	@Tag("Positive")
	@Severity(CRITICAL)
	@DisplayName("Formatting switched on and off again")
	@Description("A mark is clicked twice, or Clear format is clicked, or the colour is set back to default: the text must come back plain.")
	void builtByClicking() {
		open();
		Allure.step("Click the same mark twice, or Clear format, or Default colour: the text comes back plain", () -> {
			userInput(fld, "abc", "abc", f -> f.bold().bold());
			userInput(fld, "abc", "abc", f -> f.color("red").color("red"));
			userInput(fld, "abc", "{blue}(abc)", f -> f.color("red").color("blue"));
			userInput(fld, "abc", "abc", f -> f.color("red").color("default"));
			userInput(fld, "abc", "abc", f -> f.bold().clearFormat());
			userInput(fld, "abc", "abc", f -> f.heading(1).bold().clearFormat());
			userInput(fld, "abc", "abc", f -> f.color("red").clearFormat());
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Bold crossing italic next to other characters")
	@Description("When bold and italic cross, the editor puts an invisible separator between *** and * so the markdown opens correctly. Here the crossing is next to parentheses, escaped stars, inline code and a second crossing.")
	void boldMeetsItalic() {
		open();
		Allure.step("Bold crossing italic next to parentheses, escaped stars, inline code and a second crossing", () -> {
			userInput(fld, "abcdef", "**ab*cd***\u200B*ef*", f -> f.bold(0, 4).italic(2, 6));
			userInput(fld, "abc", "**a*b***\u200B*c*", f -> f.bold(0, 2).italic(1, 3));
			userInput(fld, "abcdefghij", "{red}(**abc*defg***\u200B*hij*)", f -> f.color("red").bold(0, 7).italic(3, 10));
			userInput(fld, "abc def", "**abc** *def*", f -> f.bold(0, 3).italic(4, 7));
			userInput(fld, "abc def", "*abc* **def**", f -> f.italic(0, 3).bold(4, 7));
			userInput(fld, "****", "`****`", f -> f.inlineCode());
			userInput(fld, "a****b", "`a****b`", f -> f.inlineCode());
			userInput(fld, "abcdefghi jkl mnopqrstu", "**abc*def***\u200B*ghi* jkl **mno*pqr***\u200B*stu*", f -> f.bold(0, 6).italic(3, 9).bold(14, 20).italic(17, 23));
			userInput(fld, "a(bc)def", "**a(b*c)d***\u200B*ef*", f -> f.bold(0, 6).italic(3, 8));
			userInput(fld, "a*bcdef", "**a\\*b*cd***\u200B*ef*", f -> f.bold(0, 5).italic(3, 7));
			userInput(fld, "x abcdefghi", "`x` **abc*def***\u200B*ghi*", f -> f.inlineCode(0, 1).bold(2, 8).italic(5, 11));
			userInput(fld, "abcdefghi ****", "**abc*def***\u200B*ghi* `****`", f -> f.bold(0, 6).italic(3, 9).inlineCode(10, 14));
			userInput(fld, "abcdefghi", "++**abc*def***\u200B*ghi*++", f -> f.underline().bold(0, 6).italic(3, 9));
			userInput(fld, "abcdefghi", "~~**abc*def***\u200B*ghi*~~", f -> f.strike().bold(0, 6).italic(3, 9));
			dbInput(fld, "\\*\\***abc**", "the toolbar greys Bold out here, the selection starts right after a star");
			dbOldSpellingInput(fld, "\\****abc**", "\\*\\***abc**");
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Overlaps of unusual sizes")
	@Description("Two marks overlap by one character, or by everything but one, or run to the end, or happen twice in one line, or overlap on text with parentheses and Cyrillic.")
	void awkwardOverlaps() {
		open();
		Allure.step("Overlaps by one character, by all but one, twice in one line, and on text with parentheses and Cyrillic", () -> {
			userInput(fld, "abcdef", "++ab**cd**++**ef**", f -> f.underline(0, 4).bold(2, 6));
			userInput(fld, "abcdefghijkl mnopqrstuvwx", "++abc**def**++**ghi**jkl ++mno**pqr**++**stu**vwx", f -> f.underline(0, 6).bold(3, 9).underline(13, 19).bold(16, 22));
			userInput(fld, "ab(cdefg)hij", "++ab(c**de**++**fg)h**ij", f -> f.underline(0, 6).bold(4, 10));
			userInput(fld, "ab*cdefghi", "++ab\\*c**de**++**fg**hi", f -> f.underline(0, 6).bold(4, 8));
			userInput(fld, "abc(d)efghij", "{red}(abc\\(d\\)**ef**)**gh**ij", f -> f.color("red", 0, 8).bold(6, 10));
			userInput(fld, "smile :)okyes", "{red}(smile :\\)**ok**)**yes**", f -> f.color("red", 0, 10).bold(8, 13));
			userInput(fld, "abcdefghijklmnopqrstuvwx", "++abc**def**++**ghi~~jkl~~**~~mno{red}(pqr)~~{red}(stu)vwx", f -> f.underline(0, 6).bold(3, 12).strike(9, 18).color("red", 15, 21));
			userInput(fld, "Орган (тип)описание", REFUSED, f -> f.underline(0, 11).bold(6, 19));
			dbInput(fld, "++Орган **(тип)**++**описание**", "the toolbar greys Bold out here, the selection starts at a parenthesis");
			userInput(fld, "**~~abcdef~~**ghijklmn", "++\\*\\*\\~\\~abcdef\\~\\~\\*\\*ghijklmn++", f -> f.underline());
		});
	}

	@Test
	@Tag("Positive")
	@DisplayName("Overlaps built step by step")
	@Description("Select, click a mark, select a part of it, click another mark: the way a user does it. Clicking the same mark twice turns it off.")
	void overlapsByHand() {
		open();
		Allure.step("Select, click, select a part, click again; the same mark clicked twice turns it off", () -> {
			userInput(fld, "abcdefghi", "++abc**def**++**ghi**", f -> f.underline(0, 6).bold(3, 9));
			userInput(fld, "abcdefghijklmnop", "++abcdef**gh**++**ij~~kl~~**~~mnop~~", f -> f.underline(0, 8).bold(6, 12).strike(10, 16));
			userInput(fld, "abcdefghi", "{red}(abc**def**)**ghi**", f -> f.color("red", 0, 6).bold(3, 9));
			userInput(fld, "abcdefghij", "**abc*defg***\u200B*hij*", f -> f.bold(0, 7).italic(3, 10));
			userInput(fld, "abcdefghij", "*abc**defg***\u200B**hij**", f -> f.italic(0, 7).bold(3, 10));
			userInput(fld, "abcdefghijklmnop", "++abc**def**++**ghi**~~jklmno~~{red}(p)", f -> f.underline(0, 6).bold(3, 9).strike(9, 15).color("red", 15, 16));
			userInput(fld, "ab(cde)fgh", "++ab(c**de**++**)f**gh", f -> f.underline(0, 6).bold(4, 8));
			userInput(fld, "\u041E\u0440\u0433\u0430\u043D \u0442\u0438\u043F\u0430", "++\u041E\u0440\u0433\u0430\u043D **\u0442\u0438**++**\u043F\u0430**", f -> f.underline(0, 8).bold(6, 10));
			userInput(fld, "abcdef", "**abcdef**", f -> f.bold(0, 3).bold(0, 6));
		});
	}

	@Test
	@Tag("Negative")
	@Severity(CRITICAL)
	@DisplayName("Marks the toolbar greys out")
	@Description("Markdown does not allow a mark to start or end next to punctuation inside a word, so the toolbar greys the button out there. Lines check where the line is: punctuation refuses, letters and digits allow. A mark already applied stays clickable so it can be removed. Symbols are allowed but should not be: a known bug.")
	void toolbarRefuses() {
		open();
		Allure.step("Bold on a plain word is allowed; a selection that starts or ends next to punctuation inside a word is refused", () -> {
			userInput(fld, "abcde", "**abcde**", f -> f.bold());
			userInput(fld, "abcde", "ab**c**de", f -> f.bold(2, 3));
			userInput(fld, "ab)de", "**ab)de**", f -> f.bold());
			userInput(fld, "ab)de", REFUSED, f -> f.bold(2, 5));
			userInput(fld, "ab(de", REFUSED, f -> f.bold(0, 3));
			userInput(fld, "ab.cd", REFUSED, f -> f.bold(0, 3));
			userInput(fld, "ab) cd", "**ab)** cd", f -> f.bold(0, 3));
			userInput(fld, "a b)cd", "a **b)cd**", f -> f.bold(2, 6));
			userInput(fld, ")abcd", "**)abcd**", f -> f.bold());
			userInput(fld, "abcd)", "**abcd)**", f -> f.bold());
			userInput(fld, "abc)", "**abc)**", f -> f.bold());
			userInput(fld, "abc)d", REFUSED, f -> f.bold(0, 4));
			userInput(fld, "a(bc)d", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a.bc.d", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a)b", REFUSED, f -> f.bold(1, 2));
			userInput(fld, "1)abc", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "Тест.Ещё", REFUSED, f -> f.bold(4, 8));
			userInput(fld, "Орган (тип)", "**Орган (тип)**", f -> f.bold());
			userInput(fld, "Орган (тип)", "Орган **(тип)**", f -> f.bold(6, 11));
			userInput(fld, "a1bcd", "a**1bcd**", f -> f.bold(1, 5));
		});
		Allure.step("Punctuation right after the first letter: the selection starts with it, so the mark is refused", () -> {
			userInput(fld, "a.bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a,bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a!bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a-bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a—bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a\"bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a_bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a*bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a[bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a:bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a?bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a/bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a;bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a'bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a]bcd", REFUSED, f -> f.bold(1, 5));
			userInput(fld, "a}bcd", REFUSED, f -> f.bold(1, 5));
		});
		Allure.step("KNOWN BUG, accepted for now: Bold before + = ~ $ | ^ ` is allowed by the toolbar, but markdown treats these symbols as punctuation, so the value does not open again: the stars come back as text", () -> {
			userInputButReopenBreaks(fld, "a+bcd", "a**+bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a=bcd", "a**=bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a~bcd", "a**\\~bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a$bcd", "a**$bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a|bcd", "a**|bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a^bcd", "a**^bcd**", f -> f.bold(1, 5));
			userInputButReopenBreaks(fld, "a`bcd", "a**\\`bcd**", f -> f.bold(1, 5));
		});
		Allure.step("A mark already applied stays clickable on such an edge, so it can be removed; a colour does not unlock the greyed-out marks", () -> {
			userInput(fld, "ab)de", "**ab**)de", f -> f.bold().bold(2, 5));
			userInput(fld, "ab)de", "++ab++)de", f -> f.underline().underline(2, 5));
			userInput(fld, "ab)de", "***ab**)de*", f -> f.bold(0, 5).italic(0, 5).bold(2, 5));
			userInput(fld, "ab)de", "***ab*)de**", f -> f.bold(0, 5).italic(0, 5).italic(2, 5));
			userInput(fld, "ab)de", REFUSED, f -> f.color("red").bold(2, 5));
		});
	}

}
