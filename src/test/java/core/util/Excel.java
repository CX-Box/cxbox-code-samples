package core.util;

import core.util.report.StepReport;
import io.qameta.allure.Allure;
import java.io.File;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import static core.util.i18n.CoreMessageSource.message;

/**
 * Reads an .xlsx file downloaded by a test, e.g. the export of a List to Excel.
 */
@UtilityClass
public class Excel {

	/**
	 * The column titles of the first sheet, as the cells show them. The export writes them in bold, so they are the first
	 * row with a bold first cell: the line "Date of upload" above them is not bold.
	 */
	public static List<String> headers(File file) {
		return Allure.step(message("excel.headers", file.getName()), () -> {
			var headers = read(file);
			StepReport.list(headers, "columns");
			return headers;
		});
	}

	@SneakyThrows
	private static List<String> read(File file) {
		try (Workbook workbook = WorkbookFactory.create(file, null, true)) {
			DataFormatter formatter = new DataFormatter();
			return StreamSupport.stream(workbook.getSheetAt(0).spliterator(), false)
					.filter(row -> isBold(workbook, row.getCell(0)))
					.findFirst()
					.map(row -> StreamSupport.stream(row.spliterator(), false).map(formatter::formatCellValue).toList())
					.orElseThrow(() -> new IllegalStateException("No column titles in " + file.getName()));
		}
	}

	private static boolean isBold(Workbook workbook, Cell cell) {
		return cell != null && workbook.getFontAt(cell.getCellStyle().getFontIndex()).getBold();
	}

}
