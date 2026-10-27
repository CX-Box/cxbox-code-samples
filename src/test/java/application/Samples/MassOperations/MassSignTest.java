package application.Samples.MassOperations;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.assertj.core.api.Assertions.assertThat;

import application.config.BaseTestForSamples;
import core.element.PlatformApp;
import core.element.screen.view.PlatformView;
import core.element.widget.list.MassOperation;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

/**
 * Mass signing and encrypting, List and GroupingHierarchy of the four operation types. The browser of the tests has no
 * CryptoPro plugin: the steps are checked up to the certificate selection, which then offers only Back.
 */
@Disabled("Excluded from the build and the local runs")
@DisplayName("Mass signing and encrypting")
@Epic("Samples")
@Feature("widget/type/property/massoperations/sign")
@Tag("Samples")
@Tag("MassOperations")
public class MassSignTest extends BaseTestForSamples {

	/** One row without a value of customFieldDictionary and one row of each value: High, Middle, Low. */
	private static final String[] ROWS = {"FILE_10.pdf", "FILE_1.pdf", "FILE_4.pdf", "FILE_7.pdf"};

	@ParameterizedTest(name = "{0}: {2}")
	@CsvSource({
			"Signing documents using QES with CryptoPro, Mass Document Sign, List, MyExample3711MassList",
			"Signing documents using QES with CryptoPro, Mass Document Sign, GroupingHierarchy, MyExample3711MassGH",
			"Encrypting documents with CryptoPro, Mass Document Encrypt, List, MyExample3713MassList",
			"Encrypting documents with CryptoPro, Mass Document Encrypt, GroupingHierarchy, MyExample3713MassGH",
			"Signing and encrypting documents using QES with CryptoPro, Mass Document Sign Encrypt, List, MyExample3714MassList",
			"Signing and encrypting documents using QES with CryptoPro, Mass Document Sign Encrypt, GroupingHierarchy, MyExample3714MassGH",
			"Encrypting and signing documents using QES with CryptoPro, Mass Document Encrypt Sign, List, MyExample3712MassList",
			"Encrypting and signing documents using QES with CryptoPro, Mass Document Encrypt Sign, GroupingHierarchy, MyExample3712MassGH"
	})
	@Severity(CRITICAL)
	@Tag("Positive")
	@DisplayName("Select rows, review, certificate selection")
	@Description("The mass action goes through Select rows and Review rows to Certificate selection; Back returns, Cancel leaves the mode")
	void steps(String screen, String action, String view, String widget) {
		var mass = start(screen, action, view, widget);
		assertThat(mass.step()).isEqualTo("Select rows");
		mass.select(ROWS).click("Next");
		assertThat(mass.step()).isEqualTo("Review rows");
		assertThat(mass.rows()).containsExactlyInAnyOrder(ROWS);
		mass.click("Next");
		assertThat(mass.step()).isEqualTo("Certificate selection");
		assertThat(mass.buttons()).contains("Back");
		mass.click("Back");
		assertThat(mass.step()).isEqualTo("Review rows");
		mass.click("Cancel");
		assertThat(mass.isActive()).isFalse();
	}

	private static MassOperation<?> start(String screenName, String action, String view, String widget) {
		var screen = PlatformApp.screen(screenName);
		screen.secondLevelView("Mass operation");
		PlatformView platformView = screen.thirdLevelView(view);
		if ("List".equals(view)) {
			var list = platformView.listInlineByName(widget);
			list.actions().click(action);
			return new MassOperation<>(list, "file");
		}
		var gh = platformView.groupingHierarchyInlineByName(widget);
		gh.actions().click(action);
		return new MassOperation<>(gh, "file");
	}

}
