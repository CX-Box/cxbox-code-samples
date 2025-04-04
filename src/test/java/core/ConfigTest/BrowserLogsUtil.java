package core.ConfigTest;

import static core.ConfigTest.FileUtil.toZip;

import com.browserup.bup.BrowserUpProxy;
import de.sstoehr.harreader.model.Har;
import de.sstoehr.harreader.model.HarEntry;
import io.qameta.allure.Allure;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class BrowserLogsUtil {

	/**
	 * Attaches the browser console logs to the Allure report.
	 *
	 * @param webDriver the WebDriver instance from which to retrieve the browser console logs
	 */
	/*public static void allureAttachBrowserConsoleLog(@NonNull WebDriver webDriver) {
		var entries = webDriver.manage().logs().get(LogType.BROWSER.toString());
		var logs = entries.getAll().stream()
				.map(e -> new Date(e.getTimestamp()) + " " + e.getLevel() + " " + e.getMessage())
				.collect(Collectors.joining("\n\n", "Log entries found: " + entries.getAll().size() + "\n\n", ""));
		log.debug(logs);
		Allure.addAttachment("Browser Logs", logs);
	}
*/
	/**
	 * Attaches network logs to Allure reports, filtering only API requests that contain JSON responses.
	 *
	 * <p>This method processes the HAR (HTTP Archive) log from the provided {@link BrowserUpProxy} instance,
	 * extracting network requests and responses. It categorizes them into two groups:
	 * <ul>
	 *     <li>Requests related to the login API (`/api/v1/login`) are stored separately.</li>
	 *     <li>All other requests are logged separately.</li>
	 * </ul>
	 *
	 * <p>Once categorized, the method attaches two logs to the Allure report:
	 * <ul>
	 *     <li>A plain text attachment for general network logs.</li>
	 *     <li>A ZIP file containing login-related network logs.</li>
	 * </ul>
	 *
	 * @param har the {@link Har} instance containing the HAR logs.
	 */
	public static void allureAttachNetworkLog(@NonNull Har har) {
		var networkWithoutLogin = new StringBuilder();
		var networkLogin = new StringBuilder();
		har.getLog().getEntries().stream()
				.filter(x -> x.getResponse().getHeaders().stream().anyMatch(y -> "application/json".equals(y.getValue()))
						|| x.getResponse().getHeaders().stream().anyMatch(y -> "application/json".equals(y.getValue()))
				)
				.forEach(x -> {
					if (x.getRequest().getUrl().contains("/api/v1/login")) {
						networkLogin.append(toString(x));
					} else {
						networkWithoutLogin.append(toString(x));
					}
				});

		Allure.addAttachment("Browser network", networkWithoutLogin.toString());
		Allure.addAttachment("Login network logs", "application/zip", toZip("login", networkLogin), ".zip");
	}

	@NonNull
	private static String toString(@NonNull HarEntry entry) {
		return entry.getStartedDateTime() +
				"\n" + entry.getRequest().getMethod().name() +
				"\n" + entry.getRequest().getUrl() +
				"\n" + "Request: " + entry.getRequest().getPostData().getText() +
				"\n" + entry.getResponse().getStatus() +
				"\n" + "Response: " + entry.getResponse().getContent().getText() +
				"\n\n";
	}

}
