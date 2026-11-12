package application.Samples;

import application.config.BaseTestForSamples;
import com.codeborne.selenide.HighlightOptions;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.io.File;
import java.time.Duration;
import java.util.List;
import lombok.SneakyThrows;
import core.element.PlatformApp;
import core.element.widget.form.PlatformInlineFormWidget;
import core.element.widget.list.realization.inline.list.PlatformListRowsInline;
import core.element.widget.statblock.StatsBlock;
import core.element.widget.statblock.StatsBlockWidget;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Checking the functions for bug fix")
@Epic("Samples")
@Tag("Samples")
public class BugFixTests extends BaseTestForSamples {

	@Test
	@DisplayName("Include Id when No Fields In Widgets On Bc ")
	@Description("Id field should be automatically added to the API response when no fields of the Business Component (BC) are added to widgets on the screen during the initial load. Check when the BC has no visible fields but acts as a parent BC, child bc data should load")
	public void testIncludeIdWhenNoFieldsInWidgetsOnBc () {
	//CXBOX-1242
	var list = PlatformApp.screen("ShowCondition example")
			.view()
			.listInline("Child Bc");
	var row = list.rows().clickRow(0);
	row.text("Custom Field");
	}

	@Test
	@DisplayName("Row menu of the second list on a view")
	@Description("The view has two lists, each with the row menu. The test changes a row of the second list and saves it by the row menu of this list.")
	public void rowMenuOfSecondList() {
		//CXBOX-1371
		var list = PlatformApp.screen("List widget title")
				.secondLevelView("List widget empty title")
				.listInlineByName("myexample3104emptytitle");
		var row = list.rows().clickRow(0);
		row.input("Custom Field widget2: Empty Title").setValue("Row menu of the second list");
		row.burgerAction("Save").click();
		list.rows().row(0)
				.input("Custom Field widget2: Empty Title")
				.checkValue(value -> assertThat(value).isEqualTo("Row menu of the second list"));
	}

	//CXBOX-1348: the test is commented out; it passes with the fix (the browser of the tests has no CryptoPro plugin, a test double of it is used)
//	/**
//	 * The browser of the tests has no CryptoPro plugin: a test double of it gives one certificate, and every other call
//	 * of the plugin fails, so the signing itself stops after the document is read. Before that the front reads the
//	 * document by its id: the requests of the files are recorded — the id of the uploaded file and the ids the document
//	 * is read by.
//	 */
//	private static final String FAKE_CRYPTO_PRO_PLUGIN = """
//			window.__cxbox1348 = { uploaded: [], read: [] };
//			const open = XMLHttpRequest.prototype.open;
//			XMLHttpRequest.prototype.open = function (method, url) {
//				const path = String(url);
//				if (/\\/file(\\?|$)/.test(path)) {
//					if (String(method).toUpperCase() === 'GET') {
//						window.__cxbox1348.read.push(new URL(path, location.href).searchParams.get('id'));
//					} else {
//						this.addEventListener('load', () => {
//							try {
//								window.__cxbox1348.uploaded.push(JSON.parse(this.responseText).data.id);
//							} catch (e) {
//								window.__cxbox1348.uploaded.push(null);
//							}
//						});
//					}
//				}
//				return open.apply(this, arguments);
//			};
//			const value = result => Promise.resolve(result);
//			const certificate = {
//				ValidToDate: value(new Date(Date.now() + 86400000).toISOString()),
//				ValidFromDate: value(new Date(Date.now() - 86400000).toISOString()),
//				IsValid: () => value({ Result: value(true) }),
//				HasPrivateKey: () => value(true),
//				PrivateKey: value({ ProviderName: value('Crypto-Pro GOST R 34.10-2012 CSP'), UniqueContainerName: value('c') }),
//				PublicKey: () => value({
//					Algorithm: value({ Value: value('1.2.643.7.1.1.1.1'), FriendlyName: value('GOST R 34.10-2012 256') }),
//					EncodedKey: value({ Value: () => value('AQID') })
//				}),
//				GetInfo: type => value(['CXBOX-1348 test', 'Test CA', 'a@b.c', 'ca@b.c'][type]),
//				Thumbprint: value('CXBOX1348')
//			};
//			const objects = {
//				'CAdESCOM.About': () => ({ Version: value('2.0.15820') }),
//				'CAdESCOM.Store': () => ({
//					Open: () => value(),
//					Close: () => value(),
//					Certificates: value({ Count: value(1), Item: () => value(certificate) })
//				})
//			};
//			// LOG_LEVEL_DEBUG: cadesplugin_api.js counts the plugin as loaded and keeps it
//			window.cadesplugin = {
//				LOG_LEVEL_DEBUG: 4,
//				CreateObjectAsync: name => objects[name]
//						? value(objects[name]())
//						: Promise.reject({ message: 'The test double of the plugin has no ' + name, requestid: 1, type: 'error' })
//			};
//			""";
//
//	@Test
//	@DisplayName("Signing a record that is not saved reads the uploaded document")
//	@Description("A new record gets a file, and the action of signing and encrypting is clicked before Save: the front reads "
//			+ "the document by the id of the uploaded file, which is only in the changes of the record that are not saved")
//	public void signRecordThatIsNotSaved() {
//		//CXBOX-1348
//		var form = PlatformApp.screen("Signing a record that is not saved")
//				.view()
//				.formByName("myexample1348form");
//		form.actions().click("Create");
//		Selenide.executeJavaScript(FAKE_CRYPTO_PRO_PLUGIN);
//		form.fileUpload("File").setValue(resourceFile("FILE_1.pdf"));
//
//		form.actions().click("Document Sign Encrypt");
//		var popup = $(".ant-modal-content").shouldBe(visible, Duration.ofSeconds(20));
//		chooseCertificate(popup, 0);
//		chooseCertificate(popup, 1);
//		popup.$$("button").findBy(text("Execute")).click();
//
//		Selenide.Wait().withTimeout(Duration.ofSeconds(20))
//				.withMessage("The front did not read the document to sign")
//				.until(driver -> !readDocumentIds().isEmpty());
//		List<String> uploaded = Selenide.executeJavaScript("return window.__cxbox1348.uploaded");
//		assertThat(uploaded).hasSize(1);
//		assertThat(uploaded.get(0)).isNotBlank();
//		assertThat(readDocumentIds()).containsExactly(uploaded.get(0));
//	}
//
//	private static List<String> readDocumentIds() {
//		return Selenide.executeJavaScript("return window.__cxbox1348.read");
//	}
//
//	private static void chooseCertificate(SelenideElement popup, int select) {
//		popup.$$(".ant-select-selection").get(select).click();
//		$$("li.ant-select-dropdown-menu-item").filter(visible).findBy(text("CXBOX-1348 test")).click();
//	}
//
//	@SneakyThrows
//	private static File resourceFile(String name) {
//		return new File(BugFixTests.class.getClassLoader().getResource(name).toURI());
//	}
}
