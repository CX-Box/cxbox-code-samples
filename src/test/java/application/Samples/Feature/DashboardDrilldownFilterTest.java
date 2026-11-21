package application.Samples.Feature;

import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.Selenide;
import core.element.PlatformApp;
import core.util.DocShots;
import core.element.widget.form.PlatformFormWidget;
import core.element.widget.list.realization.inline.list.PlatformListWidgetInline;
import core.element.widget.statblock.StatsBlockWidget;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * The default suite covers distinct backend filter paths. The disabled matrix keeps the full field regression.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("application/Samples")
@Tag("Feature")
class DashboardDrilldownFilterTest extends BaseTestForSamples {
	private static final String FIRST = "Field_1 R&D + QA";
	private static final String SECOND = "Field_2 \"Quoted\" = 100%";
	private static final String[] ALL = {FIRST, SECOND, "Field_3", "Field_4", "Field_5", "Field_6", "Field_7", "Field_8", "Field_9", "Field_10"};
	private PlatformFormWidget form;
	private PlatformListWidgetInline list;
	private PlatformListWidgetInline compactList;
	private StatsBlockWidget stats;

	@BeforeEach
	void openDashboard() {
		var view = PlatformApp.screen("Drilldown filters").secondLevelView("Dashboard");
		form = view.formByName("myexample4300form");
		list = view.listByName("myexample4300listdrilldown");
		compactList = view.listByName("myexample4300compactlist");
		stats = view.statBlockByName("myexample4300dashboardstats");
		form.actions().click("Clear form");
		if (form.actions().names().contains("All columns")) {
			form.actions().click("All columns");
		}
		list.headers().clearFilters();
		assertUnfiltered();
	}

	@AfterEach
	void restoreDashboard() {
		if (form != null) {
			form.actions().click("Clear form");
			list.headers().clearFilters();
			assertUnfiltered();
		}
	}

	@AfterAll
	void returnToCompactLayout() {
		if (form != null && form.actions().names().contains("Compact columns")) {
			form.actions().click("Compact columns");
		}
	}

	private record Case(String name, Consumer<PlatformFormWidget> fill,
						Consumer<PlatformListWidgetInline> columnFilter, List<String> expected) {
		@Override
		public String toString() {
			return name;
		}
	}

	private static Case field(String name, Consumer<PlatformFormWidget> fill,
							  Consumer<PlatformListWidgetInline> column, String... expected) {
		return new Case(name, fill, column, List.of(expected));
	}

	static Stream<Case> allFields() {
		return Stream.of(
				field("input", f -> f.input("Input").setValue("Field_3"), l -> l.headers().filter(b -> b.input("Input", "Field_3")), "Field_3"),
				field("text", f -> f.text("Text").setValue("Text content 3"), l -> l.headers().filter(b -> b.text("Text", "Text content 3")), "Field_3"),
				field("hint", f -> f.input("Hint search").setValue("Hint_3"), l -> l.headers().filter(b -> b.hint("Hint", "Hint_3")), "Field_3"),
				field("multifield", f -> f.input("Multifield search").setValue("Text content 3"), l -> l.headers().filter(b -> b.multifield("Text / hint / file upload", "Text content 3")), "Field_3"),
				field("number", f -> f.number("Number / from").setValue(new BigDecimal("450")), l -> l.headers().filter(b -> b.numberFromTo("Number", 450, 450)), "Field_3"),
				field("money", f -> f.money("Money / from").setValue(new BigDecimal("300.00")), l -> l.headers().filter(b -> b.moneyFromTo("Money", new BigDecimal("300.00"), new BigDecimal("300.00"))), "Field_3"),
				field("money fraction", f -> f.money("Money / from").setValue(new BigDecimal("600.25")), l -> l.headers().filter(b -> b.moneyFromTo("Money", new BigDecimal("600.25"), new BigDecimal("600.25"))), "Field_6"),
				field("percent", f -> f.percent("Percent / from").setValue(new BigDecimal("60")), l -> l.headers().filter(b -> b.numberFromTo("Percent", 60, 60)), "Field_3"),
				field("number zero", f -> f.number("Number / from").setValue(BigDecimal.ZERO), l -> l.headers().filter(b -> b.numberFromTo("Number", 0, 0)), "Field_5"),
				field("money zero", f -> f.money("Money / from").setValue(new BigDecimal("0.00")), l -> l.headers().filter(b -> b.moneyFromTo("Money", new BigDecimal("0.00"), new BigDecimal("0.00"))), "Field_5"),
				field("percent zero", f -> f.percent("Percent / from").setValue(BigDecimal.ZERO), l -> l.headers().filter(b -> b.numberFromTo("Percent", 0, 0)), "Field_5"),
				field("checkbox true", f -> f.dictionary("Checkbox · All / Yes / No").setValue("Yes"), l -> l.headers().filter(b -> b.checkbox("Checkbox", true)), FIRST, "Field_3", "Field_7", "Field_9"),
				field("checkbox false and null", f -> f.dictionary("Checkbox · All / Yes / No").setValue("No"), l -> l.headers().filter(b -> b.checkbox("Checkbox", false)), SECOND, "Field_4", "Field_5", "Field_6", "Field_8", "Field_10"),
				field("dictionary", f -> f.dictionary("Dictionary").setValue("Review"), l -> l.headers().filter(b -> b.dictionary("Dictionary", "Review")), "Field_3", "Field_8"),
				field("dictionary enum", f -> f.dictionary("Enum").setValue("ThreeDE"), l -> l.headers().filter(b -> b.dictionary("Enum", "ThreeDE")), "Field_3", "Field_8"),
				field("radio", f -> f.radio("Radio").setValue("ThreeRE"), l -> l.headers().filter(b -> b.radio("Radio", "ThreeRE")), "Field_3", "Field_8"),
				field("multiple select", f -> f.multipleSelect("Multiple select").setValue(Set.of("ThreeRE", "FiveRE")), l -> l.headers().filter(b -> b.multipleSelect("Multiple select", Set.of("ThreeRE", "FiveRE"))), "Field_3", "Field_5", "Field_7", "Field_8", "Field_9", "Field_10"),
				field("dictionary multiple", f -> f.multipleSelect("Dictionary · multiple").setValue(Set.of("Review", "Draft")), l -> l.headers().filter(b -> b.dictionary("Dictionary", "Review").dictionary("Dictionary", "Draft")), "Field_3", "Field_5", "Field_8", "Field_10"),
				field("enum multiple", f -> f.multipleSelect("Enum · multiple").setValue(Set.of("ThreeDE", "FiveDE")), l -> l.headers().filter(b -> b.dictionary("Enum", "ThreeDE").dictionary("Enum", "FiveDE")), "Field_3", "Field_5", "Field_8", "Field_10"),
				field("radio multiple", f -> f.multipleSelect("Radio · multiple").setValue(Set.of("ThreeRE", "FiveRE")), l -> l.headers().filter(b -> b.radio("Radio", "ThreeRE").radio("Radio", "FiveRE")), "Field_3", "Field_5", "Field_8", "Field_10"),
				field("pick list", f -> f.pickList("Pick list").setValue("value", "PL3"), l -> l.headers().filter(b -> b.pickList("Pick list", List.of("PL3"))), "Field_3"),
				field("inline pick list", f -> f.inlinePickList("Inline pick list").setValue("IPL3"), l -> l.headers().filter(b -> b.inlinePickList("Inline pick list", "IPL3")), "Field_3"),
				field("multivalue", f -> f.multivalue("Multivalue").setValue("value", List.of("MV3")), l -> l.headers().filter(b -> b.multivalue("Multivalue", List.of("MV3"))), "Field_3"),
				field("multivalue hover", f -> f.multivalue("Multivalue hover selection").setValue("value", List.of("MVH3")), l -> l.headers().filter(b -> b.multivalue("Multivalue hover", List.of("MVH3"))), "Field_3"),
				field("several multivalue IDs", f -> f.multivalue("Multivalue").setValue("value", List.of("MV1 R&D + QA", "MV3")), l -> l.headers().filter(b -> b.multivalue("Multivalue", List.of("MV1 R&D + QA", "MV3"))), FIRST, "Field_3", "Field_5"),
				field("several hover IDs", f -> f.multivalue("Multivalue hover selection").setValue("value", List.of("MVH1 R&D + QA", "MVH3")), l -> l.headers().filter(b -> b.multivalue("Multivalue hover", List.of("MVH1 R&D + QA", "MVH3"))), FIRST, "Field_3", "Field_5"),
				field("date", f -> f.date("Date / from").setValue(LocalDate.of(2025, 7, 4)), l -> l.headers().filter(b -> b.dateFromTo("Date", LocalDate.of(2025, 7, 4), LocalDate.of(2025, 7, 4))), "Field_3"),
				field("date time", f -> f.dateTime("Date time / from").setValue(LocalDateTime.of(2025, 7, 13, 16, 0)), l -> l.headers().filter(b -> b.dateTimeFromTo("Date time", LocalDateTime.of(2025, 7, 13, 16, 0), LocalDateTime.of(2025, 7, 13, 16, 0))), "Field_3"),
				field("seconds", f -> f.dateTimeWithSecond("With seconds / from").setValue(LocalDateTime.of(2025, 7, 18, 9, 25, 55)), l -> l.headers().filter(b -> b.dateWithSecondFromTo("Date time with seconds", LocalDateTime.of(2025, 7, 18, 9, 25, 55), LocalDateTime.of(2025, 7, 18, 9, 25, 55))), "Field_3"),
				field("suggestion", f -> f.suggestionPickList("Suggestion").setValue("IPL3"), l -> l.headers().filter(b -> b.input("Suggestion pick list", "IPL3")), "Field_3"),
				field("ampersand and plus", f -> f.input("Input").setValue("R&D + QA"), l -> l.headers().filter(b -> b.input("Input", "R&D + QA")), FIRST),
				field("quotes equals percent", f -> f.input("Input").setValue("\"Quoted\" = 100%"), l -> l.headers().filter(b -> b.input("Input", "\"Quoted\" = 100%")), SECOND),
				field("text special characters", f -> f.text("Text").setValue("R&D + QA 100% = \"ok\" \\ путь"), l -> l.headers().filter(b -> b.text("Text", "R&D + QA 100% = \"ok\" \\ путь")), FIRST),
				field("hint special characters", f -> f.input("Hint search").setValue("R&D + QA 100% = \"ok\" \\ путь"), l -> l.headers().filter(b -> b.hint("Hint", "R&D + QA 100% = \"ok\" \\ путь")), FIRST),
				field("dictionary comma and spaces", f -> f.multipleSelect("Dictionary · multiple").setValue(Set.of("In progress, R&D + QA", "Done, archived")), l -> l.headers().filter(b -> b.dictionary("Dictionary", "In progress, R&D + QA").dictionary("Dictionary", "Done, archived")), FIRST, SECOND, "Field_6", "Field_7"),
				field("pick list special characters", f -> f.pickList("Pick list").setValue("value", "PL1 R&D + QA"), l -> l.headers().filter(b -> b.pickList("Pick list", List.of("PL1 R&D + QA"))), FIRST),
				field("inline special characters", f -> f.inlinePickList("Inline pick list").setValue("IPL1 R&D + QA"), l -> l.headers().filter(b -> b.inlinePickList("Inline pick list", "IPL1 R&D + QA")), FIRST),
				field("suggestion special characters", f -> f.suggestionPickList("Suggestion").setValue("IPL1 R&D + QA"), l -> l.headers().filter(b -> b.input("Suggestion pick list", "IPL1 R&D + QA")), FIRST),
				field("no matches", f -> f.input("Input").setValue("no such record"), l -> l.headers().filter(b -> b.input("Input", "no such record")))
		);
	}


	static Stream<Case> backendCornerCases() {
		return Stream.concat(
				allFields().filter(test -> Set.of("text special characters", "enum multiple", "number zero").contains(test.name())),
				ranges().filter(test -> "seconds range".equals(test.name()))
		);
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("backendCornerCases")
	void backendPaths(Case test) {
		if ("seconds range".equals(test.name())) {
			form.checkbox("Use ranges · from / to").setValue(true);
		}
		test.fill().accept(form);
		form.actions().click("Apply filters");
		assertMatches(test.expected().toArray(String[]::new));
		assertThat(stats.block("Active conditions").count()).isEqualTo("1");
	}

	@Test
	void collectionIdsAndValuesCombineWithAnd() {
		form.multivalue("Multivalue").setValue("value", List.of("MV1 R&D + QA", "MV3"));
		form.multipleSelect("Multiple select").setValue(Set.of("ThreeRE", "FiveRE"));
		form.actions().click("Apply filters");
		assertMatches("Field_3", "Field_5");
		assertThat(stats.block("Active conditions").count()).isEqualTo("2");
		list.headers().clearFilters();
		assertAllRows();
		stats.block("Matching records").click();
		assertMatches("Field_3", "Field_5");
	}

	@Test
	void falseRemainsAConditionAndCanGiveNoMatches() {
		form.input("Input").setValue("Field_3");
		form.dictionary("Checkbox · All / Yes / No").setValue("No");
		form.actions().click("Apply filters");
		assertMatches();
		assertThat(stats.block("Active conditions").count()).isEqualTo("2");
	}

	private static boolean isNumeric(Case test) {
		return test.name().startsWith("number") || test.name().startsWith("money") || test.name().startsWith("percent");
	}

	static Stream<Case> fieldFilters() {
		return allFields().filter(test -> !isNumeric(test));
	}

	static Stream<Case> numericFilters() {
		return allFields().filter(DashboardDrilldownFilterTest::isNumeric);
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("numericFilters")
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void numbers(Case test) {
		test.fill().accept(form);
		checkAllFilterPaths(test.columnFilter(), test.expected().toArray(String[]::new));
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("fieldFilters")
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void fields(Case test) {
		test.fill().accept(form);
		checkAllFilterPaths(test.columnFilter(), test.expected().toArray(String[]::new));
	}

	static Stream<Case> ranges() {
		return Stream.of(
				field("number range", f -> {
					f.number("Number / from").setValue(new BigDecimal("150"));
					f.number("Number to").setValue(new BigDecimal("300"));
				}, l -> l.headers().filter(b -> b.numberFromTo("Number", 150, 300)), FIRST, SECOND),
				field("money range", f -> {
					f.money("Money / from").setValue(new BigDecimal("100.00"));
					f.money("Money to").setValue(new BigDecimal("200.00"));
				}, l -> l.headers().filter(b -> b.moneyFromTo("Money", new BigDecimal("100.00"), new BigDecimal("200.00"))), FIRST, SECOND),
				field("percent range", f -> {
					f.percent("Percent / from").setValue(new BigDecimal("20"));
					f.percent("Percent to").setValue(new BigDecimal("40"));
				}, l -> l.headers().filter(b -> b.numberFromTo("Percent", 20, 40)), FIRST, SECOND),
				field("date range", f -> {
					f.date("Date / from").setValue(LocalDate.of(2025, 7, 2));
					f.date("Date to").setValue(LocalDate.of(2025, 7, 3));
				}, l -> l.headers().filter(b -> b.dateFromTo("Date", LocalDate.of(2025, 7, 2), LocalDate.of(2025, 7, 3))), FIRST, SECOND),
				field("date time range", f -> {
					f.dateTime("Date time / from").setValue(LocalDateTime.of(2025, 7, 11, 16, 0));
					f.dateTime("Date time to").setValue(LocalDateTime.of(2025, 7, 12, 16, 0));
				}, l -> l.headers().filter(b -> b.dateTimeFromTo("Date time", LocalDateTime.of(2025, 7, 11, 16, 0), LocalDateTime.of(2025, 7, 12, 16, 0))), FIRST, SECOND),
				field("seconds range", f -> {
					f.dateTimeWithSecond("With seconds / from").setValue(LocalDateTime.of(2025, 7, 16, 9, 25, 55));
					f.dateTimeWithSecond("With seconds to").setValue(LocalDateTime.of(2025, 7, 17, 9, 25, 55));
				}, l -> l.headers().filter(b -> b.dateWithSecondFromTo("Date time with seconds", LocalDateTime.of(2025, 7, 16, 9, 25, 55), LocalDateTime.of(2025, 7, 17, 9, 25, 55))), FIRST, SECOND)
		);
	}

	@ParameterizedTest(name = "{0}")
	@MethodSource("ranges")
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void intervals(Case test) {
		form.checkbox("Use ranges · from / to").setValue(true);
		test.fill().accept(form);
		checkAllFilterPaths(test.columnFilter(), test.expected().toArray(String[]::new));
	}

	@ParameterizedTest
	@ValueSource(strings = {"file_3.pdf", "report R&D + QA 100%.pdf"})
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void files(String name, @TempDir Path directory) throws Exception {
		var file = Files.writeString(directory.resolve(name), "%PDF-1.4\n%%EOF");
		form.fileUpload("File upload").setValue(file.toFile());
		checkAllFilterPaths(l -> l.headers().filter(b -> b.fileUpload("File upload", name)), name.startsWith("file_3") ? "Field_3" : FIRST);
		form.fileUpload("File upload").clear();
	}

	@Test
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void popupFilterSelectsValuesFromDifferentPages() {
		list.headers().filter(b -> b.pickList("Pick list", List.of("PL3", "PL8")));
		assertRows("Field_3", "Field_8");
	}

	@Test
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void fieldsCombineWithAndAndMultipleValuesWithOr() {
		form.multipleSelect("Dictionary · multiple").setValue(Set.of("Review", "Draft"));
		form.dictionary("Checkbox · All / Yes / No").setValue("No");
		checkAllFilterPaths(l -> l.headers().filter(b -> b.dictionary("Dictionary", "Review").dictionary("Dictionary", "Draft").checkbox("Checkbox", false)), 2, "Field_5", "Field_8", "Field_10");
		assertThat(form.multipleSelect("Dictionary · multiple").getValue()).containsExactlyInAnyOrder("Review", "Draft");
	}

	@Test
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void multipleSelectionOverridesTheSingleValue() {
		form.dictionary("Enum").setValue("ThreeDE");
		form.multipleSelect("Enum · multiple").setValue(Set.of("FiveDE"));
		checkAllFilterPaths(l -> l.headers().filter(b -> b.dictionary("Enum", "FiveDE")), "Field_5", "Field_10");
	}

	@Test
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void conflictingFieldsGiveAnEmptyListAndZeroCount() {
		form.input("Input").setValue("Field_3");
		form.dictionary("Checkbox · All / Yes / No").setValue("No");
		checkAllFilterPaths(l -> l.headers().filter(b -> b.input("Input", "Field_3").checkbox("Checkbox", false)), 2);
	}

	@Test
	@Disabled("Extended CXBOX-1219 field matrix. Remove @Disabled to run the full regression.")
	void compactViewContainsActualValuesOfAllFieldGroups() {
		form.input("Input").setValue("Field_3");
		form.actions().click("Apply filters");
		assertMatches("Field_3");
		var expandedList = list;
		form.actions().click("Compact columns");
		list = compactList;
		assertThat(list.headers().names()).containsExactly("Input", "Text / hint / file upload", "Dictionary / enum / radio / multiple select", "Number / money / percent", "Date / date time / date time with seconds", "Pick list / inline pick list / multivalue / multivalue hover / suggestion pick list", "Checkbox");
		var row = list.rows().row(0);
		assertThat(row.multivalueField("Dictionary / enum / radio / multiple select").getValue()).extracting(core.element.widget.field.type.multifield.MultifieldContainer::type).containsExactly("dictionary", "dictionary", "radio", "multipleSelect");
		assertThat(row.multivalueField("Text / hint / file upload").getValue()).extracting(core.element.widget.field.type.multifield.MultifieldContainer::type).contains("text", "hint", "fileUpload");
		assertThat(row.multivalueField("Text / hint / file upload").getValue()).extracting(core.element.widget.field.type.multifield.MultifieldContainer::data).anySatisfy(value -> assertThat(value).contains("Hint_3"));
		assertThat(row.multivalueField("Number / money / percent").getValue()).hasSize(3);
		assertThat(row.multivalueField("Date / date time / date time with seconds").getValue()).extracting(core.element.widget.field.type.multifield.MultifieldContainer::type).containsExactly("date", "dateTime", "dateTimeWithSeconds");
		assertThat(row.multivalueField("Pick list / inline pick list / multivalue / multivalue hover / suggestion pick list").getValue()).extracting(core.element.widget.field.type.multifield.MultifieldContainer::type).containsExactly("pickList", "inline-pickList", "multivalue", "multivalueHover", "suggestionPickList");
		DocShots.png("CXBOX-1219", "dashboard.png", 1700, 1600);
		form.actions().click("All columns");
		list = expandedList;
		assertThat(list.headers().names()).containsExactly("Input", "Text / hint / file upload", "Checkbox", "Dictionary", "Multivalue hover", "Hint", "Multivalue", "Multiple select", "Inline pick list", "Pick list", "Radio", "Money", "Percent", "Number", "File upload", "Enum", "Date time with seconds", "Date", "Date time", "Text", "Suggestion pick list");
		assertThat(list.rows().row(0).hint("Hint").getValue()).isEqualTo("Hint_3");
		assertThat(list.rows().row(0).multivalueHover("Multivalue hover").getValue()).contains("MVH3");
	}

	private void checkAllFilterPaths(Consumer<PlatformListWidgetInline> column, String... expected) {
		checkAllFilterPaths(column, 1, expected);
	}

	private void checkAllFilterPaths(Consumer<PlatformListWidgetInline> column, int conditions, String... expected) {
		form.actions().click("Apply filters");
		assertMatches(expected);
		assertThat(stats.block("Active conditions").count()).isEqualTo(String.valueOf(conditions));
		list.headers().clearFilters();
		assertAllRows();
		column.accept(list);
		assertRows(expected);
		list.headers().clearFilters();
		assertAllRows();
		stats.block("Matching records").click();
		assertMatches(expected);
		assertThat(stats.block("All records").count()).isEqualTo(String.valueOf(ALL.length));
	}

	private void assertAllRows() {
		assertRows(ALL);
	}

	private void assertUnfiltered() {
		Selenide.Wait().until(driver -> String.valueOf(ALL.length).equals(stats.block("Matching records").count()));
		assertAllRows();
		assertThat(stats.block("Active conditions").count()).isEqualTo("0");
	}

	private void assertMatches(String... expected) {
		try {
			Selenide.Wait().until(driver -> String.valueOf(expected.length).equals(stats.block("Matching records").count()));
		} catch (org.openqa.selenium.TimeoutException timeout) {
			throw new AssertionError("Expected count " + expected.length + ", got " + stats.block("Matching records").count()
					+ "; form number=" + form.number("Number / from").getValue()
					+ "; rows=" + list.rows().streamCurrentPage().map(row -> row.input("Input").getValue()).toList(), timeout);
		}
		assertRows(expected);
	}

	private void assertRows(String... expected) {
		Selenide.Wait().until(driver -> {
			try {
				list.pagination().firstPage();
				return list.rows().streamAllPages().map(row -> row.input("Input").getValue()).sorted().toList().equals(Arrays.stream(expected).sorted().toList());
			} catch (RuntimeException redraw) {
				return false;
			}
		});
	}
}
