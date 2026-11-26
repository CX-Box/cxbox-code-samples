package application.Samples.Export;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.util.DocShots;
import core.util.Excel;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import java.io.File;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Export to Excel. The file of the export")
@Epic("Samples")
@Feature(ExportExcelTest.ARTICLE)
@Tag("Samples")
@Tag("Export")
public class ExportExcelTest extends BaseTestForSamples {

	static final String ARTICLE = "widget/type/property/export/excel";

	private static final String SCREEN = "Widget property export Excel title";

	private static final int WIDTH = 1600;

	private static final int HEIGHT = 900;

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Calculated title: the file name and the column titles")
	@Description("The title of the widget and of a column hold ${period}, a hidden date field; the file name and the column title of the file show its value in the format of the field, as the screen does")
	void calculatedTitle() {
		var list = PlatformApp.screen(SCREEN).secondLevelView("Calculated title").listInlineByName("myexample3141list");
		assertThat(list.title()).isEqualTo("Sales on 31.10.2026");
		assertThat(list.headers().names()).contains("Sum on 31.10.2026");
		DocShots.png(list.element(), ARTICLE, "calctitle.png", WIDTH, HEIGHT);

		File file = list.settings().download("Excel");
		assertThat(file.getName()).startsWith("Sales on 31.10.2026 ").endsWith(".xlsx");
		// the export adds the technical column id after the columns of the widget
		assertThat(Excel.headers(file)).containsExactly("Client", "Sum on 31.10.2026", "id");
	}

	@Test
	@Tag("Positive")
	@DisplayName("Calculated export title: the file name")
	@Description("export.title holds ${period}; the file name shows its value")
	void exportTitle() {
		var list = PlatformApp.screen(SCREEN).secondLevelView("Export title").listInlineByName("myexample3141exporttitle");
		File file = list.settings().download("Excel");
		assertThat(file.getName()).startsWith("Sales report on 31.10.2026 ").endsWith(".xlsx");
	}

	@Test
	@Tag("Positive")
	@DisplayName("Empty title: the file is named by the date")
	@Description("A widget without a title and without export.title exports the file named by the current date")
	void emptyTitle() {
		var list = PlatformApp.screen(SCREEN).secondLevelView("Empty title").listInlineByName("myexample3141emptytitle");
		File file = list.settings().download("Excel");
		assertThat(file.getName()).matches("\\d{2}-\\d{2}-\\d{4}\\.xlsx");
		assertThat(Excel.headers(file)).containsExactly("Client", "Sum on 31.10.2026", "id");
	}

}
