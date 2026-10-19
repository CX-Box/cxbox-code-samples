package application.Samples.Feature.multiFileUpload;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Multi-upload of files: the button of the action and the drop zone")
@Epic("Samples")
@Tag("Samples")
public class MultiFileUploadTest extends BaseTestForSamples {

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Files by the button of the action")
	@Description("The button «Add Files» gets two files: a record comes for each file. The records are deleted after the check.")
	void button() throws IOException {
		var screen = PlatformApp.screen("File options multi-upload files");
		screen.secondLevelView("Button And Multi-upload files");
		var list = screen.thirdLevelView("Button").listInlineByName("MyExample6100DefaultList");
		var first = file();
		var second = file();
		list.actions().upload("Add Files", first, second);
		for (var file : List.of(first, second)) {
			var row = list.rows().streamAllPages()
					.filter(r -> {
						var value = r.fileUpload("Custom Field File").getValue();
						return value != null && value.getName().equals(file.getName());
					})
					.findFirst();
			assertThat(row).as("the record of " + file.getName()).isPresent();
			row.get().burgerAction("Delete").click();
		}
	}

	@Test
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Files on the drop zone")
	@Description("The drop zone above the list gets two files: a record comes for each file. The records are deleted after the check.")
	void dropZone() throws IOException {
		var screen = PlatformApp.screen("File options multi-upload files");
		screen.secondLevelView("Button And Multi-upload files");
		var list = screen.thirdLevelView("Multi-upload files").listInlineByName("MyExample6100FileList");
		var first = file();
		var second = file();
		list.actions().uploadToDropZone(first, second);
		for (var file : List.of(first, second)) {
			var row = list.rows().streamAllPages()
					.filter(r -> {
						var value = r.fileUpload("Custom Field File").getValue();
						return value != null && value.getName().equals(file.getName());
					})
					.findFirst();
			assertThat(row).as("the record of " + file.getName()).isPresent();
			row.get().burgerAction("Delete").click();
		}
	}

	/**
	 * A copy of {@code FILE_1.pdf} with a name of its own: the records of an earlier run do not match it. The sample takes
	 * pdf, png and jpg.
	 */
	private static File file() throws IOException {
		var file = Files.createTempDirectory("multi-upload").resolve(UUID.randomUUID() + ".pdf");
		try (var pdf = MultiFileUploadTest.class.getClassLoader().getResourceAsStream("FILE_1.pdf")) {
			Files.copy(pdf, file);
		}
		return file.toFile();
	}

}
