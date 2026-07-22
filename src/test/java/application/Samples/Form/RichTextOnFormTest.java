package application.Samples.Form;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.widget.field.type.richtext.RichText;
import core.element.widget.form.PlatformFormWidget;
import io.qameta.allure.Epic;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

/**
 * Full behaviour of the RichText field, all exercised on the single "Text basic" screen.
 *
 * <p>The breakdown lives inside this one class via {@link Nested} groups:
 * <ul>
 *   <li>{@link ToolbarMarks} / {@link ToolbarBlocks} / {@link ToolbarCombinations} — the real user
 *       path: build formatting by clicking the toolbar panel with the mouse, then assert the markdown;</li>
 *   <li>{@link RoundTrip} — data-driven regression: every supported markdown must survive
 *       markdown → visual → markdown byte-for-byte. This is the safety net so updates lose nothing;</li>
 *   <li>{@link EdgeCases} — documented limitations that lock the current behaviour.</li>
 * </ul>
 * The markdown is YFM-compatible; colour is stored as {@code {color}(text)}.
 */
@DisplayName("RichText. Full behaviour on the 'Text basic' screen")
@Epic("application/Samples")
@Tag("application/Samples")
@Tag("Form")
@Tag("RichText")
public class RichTextOnFormTest extends BaseTestForSamples {

	private static final String SCREEN = "Text basic";
	private static final String FIELD = "Custom Field";

	private RichText<PlatformFormWidget, ?> field() {
		return PlatformApp.screen(SCREEN)
				.secondLevelView("Form")
				.form("Form title")
				.richText(FIELD);
	}

	/** Fresh field with {@code text} typed and fully selected, ready for a toolbar action. */
	private RichText<PlatformFormWidget, ?> selected(String text) {
		var f = field();
		f.clearContent().type(text).selectAll();
		return f;
	}

	// =========================================================================================
	@Nested
	@DisplayName("Marks via toolbar (mouse)")
	class ToolbarMarks {

		@Test
		@DisplayName("Bold")
		void bold() {
			selected("text").bold().checkValue(v -> assertThat(v).isEqualTo("**text**"));
		}

		@Test
		@DisplayName("Italic")
		void italic() {
			selected("text").italic().checkValue(v -> assertThat(v).isEqualTo("*text*"));
		}

		@Test
		@DisplayName("Underline")
		void underline() {
			selected("text").underline().checkValue(v -> assertThat(v).isEqualTo("++text++"));
		}

		@Test
		@DisplayName("Strikethrough")
		void strike() {
			selected("text").strike().checkValue(v -> assertThat(v).isEqualTo("~~text~~"));
		}

		@Test
		@DisplayName("Inline code")
		void inlineCode() {
			selected("text").inlineCode().checkValue(v -> assertThat(v).isEqualTo("`text`"));
		}

		@Test
		@DisplayName("Colour (red)")
		void colorRed() {
			selected("text").color("Red").checkValue(v -> assertThat(v).isEqualTo("{red}(text)"));
		}

		@Test
		@DisplayName("Colour (green)")
		void colorGreen() {
			selected("text").color("Green").checkValue(v -> assertThat(v).isEqualTo("{green}(text)"));
		}
	}

	// =========================================================================================
	@Nested
	@DisplayName("Blocks via toolbar (mouse)")
	class ToolbarBlocks {

		@Test
		@DisplayName("Heading 1 / 2 / 3")
		void headings() {
			selected("text").heading(1).checkValue(v -> assertThat(v).isEqualTo("# text"));
			selected("text").heading(2).checkValue(v -> assertThat(v).isEqualTo("## text"));
			selected("text").heading(3).checkValue(v -> assertThat(v).isEqualTo("### text"));
		}

		@Test
		@DisplayName("Bullet list")
		void bulletList() {
			selected("item").bulletList().checkValue(v -> assertThat(v).isEqualTo("- item"));
		}

		@Test
		@DisplayName("Ordered list")
		void orderedList() {
			selected("item").orderedList().checkValue(v -> assertThat(v).isEqualTo("1. item"));
		}

		@Test
		@DisplayName("Quote")
		void quote() {
			selected("text").quote().checkValue(v -> assertThat(v).isEqualTo("> text"));
		}
	}

	// =========================================================================================
	@Nested
	@DisplayName("Combinations via toolbar (mouse)")
	class ToolbarCombinations {

		@Test
		@DisplayName("Bold + italic -> ***text***")
		void boldItalic() {
			selected("text").bold().selectAll().italic()
					.checkValue(v -> assertThat(v).isEqualTo("***text***"));
		}

		@Test
		@DisplayName("Bold + underline -> **++text++**")
		void boldUnderline() {
			selected("text").bold().selectAll().underline()
					.checkValue(v -> assertThat(v).isEqualTo("**++text++**"));
		}

		@Test
		@DisplayName("Colour + bold -> {red}(**text**)")
		void colorBold() {
			selected("text").color("Red").selectAll().bold()
					.checkValue(v -> assertThat(v).isEqualTo("{red}(**text**)"));
		}

		@Test
		@DisplayName("Colour + bold + italic + underline -> {green}(***++text++***)")
		void colorAll() {
			selected("text").color("Green").selectAll().bold().selectAll().italic().selectAll().underline()
					.checkValue(v -> assertThat(v).isEqualTo("{green}(***++text++***)"));
		}

		@Test
		@DisplayName("Formatting only part of a coloured span -> {green}(a**b**c)")
		void partialInsideColor() {
			var f = selected("abc").color("Green");
			f.selectRange(1, 1).bold() // select only "b"
					.checkValue(v -> assertThat(v).isEqualTo("{green}(a**b**c)"));
		}

		@Test
		@DisplayName("Bold inside a heading -> # **text**")
		void boldInHeading() {
			selected("text").heading(1).selectAll().bold()
					.checkValue(v -> assertThat(v).isEqualTo("# **text**"));
		}

		@Test
		@DisplayName("Colour inside a bullet list -> - {red}(item)")
		void colorInList() {
			selected("item").bulletList().selectAll().color("Red")
					.checkValue(v -> assertThat(v).isEqualTo("- {red}(item)"));
		}

		@Test
		@DisplayName("Bold inside a quote -> > **text**")
		void boldInQuote() {
			selected("text").quote().selectAll().bold()
					.checkValue(v -> assertThat(v).isEqualTo("> **text**"));
		}
	}

	// =========================================================================================
	@Nested
	@DisplayName("Round-trip regression — markdown must survive unchanged")
	class RoundTrip {

		/** Markdown that MUST round-trip (markdown -> visual editor -> markdown) byte-for-byte. */
		private List<String> stableMarkdown() {
			return List.of(
					// --- single marks ---
					"**bold**",
					"*italic*",
					"++under++",
					"~~strike~~",
					"`code`",
					// --- every colour ---
					"{gray}(x)",
					"{yellow}(x)",
					"{orange}(x)",
					"{red}(x)",
					"{green}(x)",
					"{blue}(x)",
					"{violet}(x)",
					// --- colour + a mark ---
					"{red}(**x**)",
					"{red}(*x*)",
					"{red}(++x++)",
					"{red}(~~x~~)",
					"{green}(***++text++***)",
					// --- colour with parentheses / escaping ---
					"{red}(Hello \\(world\\))",
					"{red}(smile :\\) ok)",
					"{green}(***++Орган \\(тип\\)++***)",
					"a\\*b",
					// --- links ---
					"[text](url)",
					"[**text**](url)",
					"[{yellow}(site)](localhost)",
					// --- blocks ---
					"# Head",
					"## Head",
					"### Head",
					"> quote",
					"- item",
					"1. item",
					// --- properly-nested combinations ---
					"***text***",
					"**++text++**",
					"{yellow}(**text**)",
					"{green}(a**b**c)",
					// --- overlaps our patches keep valid ---
					"++abc**def**++**gh~~ij~~**~~kl~~",       // staircase
					"++**~~abc~~defghi**jklmn++",             // shared start, longest mark outermost
					"**abc*def***\u200B*ghij*"                // bold ∩ italic: invisible U+200B separator
			);
		}

		@TestFactory
		@DisplayName("stable markdown round-trips")
		Stream<DynamicTest> stableRoundTrips() {
			var f = field(); // navigate once; reuse across cases (Form value is transient)
			return stableMarkdown().stream().map(md -> dynamicTest(
					display(md),
					() -> assertThat(f.roundTrip(md)).isEqualTo(md)
			));
		}

		private String display(String md) {
			String oneLine = md.replace("\u200B", "⟨U+200B⟩").replace("\n", "\\n");
			return oneLine.length() <= 60 ? oneLine : oneLine.substring(0, 57) + "...";
		}
	}

	// =========================================================================================
	@Nested
	@DisplayName("Edge cases — documented limitations")
	class EdgeCases {

		@Test
		@DisplayName("Bold ∩ italic overlap stays parseable via an invisible separator")
		void boldItalicOverlapSeparator() {
			// A staggered bold/italic overlap would collide into `****`; the editor inserts a
			// zero-width space so it round-trips instead of losing the formatting.
			var f = field();
			String md = "**abc*def***\u200B*ghij*";
			assertThat(f.roundTrip(md)).isEqualTo(md);
			assertThat(f.roundTrip(md)).doesNotContain("****");
		}

		@Test
		@DisplayName("Escaped star before a run is NOT split")
		void escapedStarNotSplit() {
			// The separator is only inserted into a real `****` collision, never into an escaped `\*`.
			var f = field();
			assertThat(f.roundTrip("a\\*b")).isEqualTo("a\\*b");
			assertThat(f.roundTrip("{red}(\\*)")).isEqualTo("{red}(\\*)");
		}

		@Test
		@DisplayName("Formatting is disabled when the selection edge touches a parenthesis")
		void parenthesisFlankingGuard() {
			// `*`-delimited marks can't wrap a selection whose edge is a parenthesis (CommonMark
			// flanking), so the toolbar greys out formatting there — exactly like Yandex-Wiki.
			var f = field();
			f.clearContent().type("ab)de").selectRange(2, 3); // select ")de"
			assertThat(f.isToolbarEnabled("Bold")).isFalse();
			assertThat(f.isToolbarEnabled("Italic")).isFalse();
			assertThat(f.isToolbarEnabled("Underline")).isTrue(); // `++` doesn't use flanking
		}
	}
}
