package core.config.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

/**
 * Browser-level controls through the WebDriver (Chrome DevTools protocol): nothing runs inside the page.
 * Chromium only; every method is a no-op for other browsers.
 * <p>
 * The console and network logs cover every tab of the browser and are handed out by the WebDriver once; the network events
 * are buffered here until {@link #clearNetworkLog()}.
 */
@UtilityClass
public class BrowserDevTools {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public record NetworkRequest(String method, String url) {

	}

	public record WebSocketHandshake(String url, int status) {

	}

	/**
	 * Console messages of every tab written since the previous call
	 */
	public static List<String> consoleLog() {
		if (!WebDriverRunner.hasWebDriverStarted()) {
			return List.of();
		}
		return WebDriverRunner.getWebDriver().manage().logs().get(LogType.BROWSER).getAll().stream()
				.map(LogEntry::getMessage)
				.toList();
	}

	public static void clearConsoleLog() {
		consoleLog();
	}

	/**
	 * Requests the browser has sent since {@link #clearNetworkLog()}, in order
	 */
	public static List<NetworkRequest> networkRequests() {
		readPerformanceLog();
		return List.copyOf(requests);
	}

	/**
	 * Websocket handshakes answered since {@link #clearNetworkLog()} (101 connected, 401 token rejected, ...)
	 */
	public static List<WebSocketHandshake> webSocketHandshakes() {
		readPerformanceLog();
		return List.copyOf(handshakes);
	}

	/**
	 * Forgets the network events recorded so far. The base test class calls it before every test: the browser is shared by the tests
	 * of a fork and the log would otherwise grow for the whole run.
	 */
	public static void clearNetworkLog() {
		readPerformanceLog();
		requests.clear();
		handshakes.clear();
		webSocketUrls.clear();
	}

	private static final List<NetworkRequest> requests = new ArrayList<>();

	private static final List<WebSocketHandshake> handshakes = new ArrayList<>();

	private static final Map<String, String> webSocketUrls = new HashMap<>();

	/**
	 * The WebDriver hands the performance log out once; only the few events the tests need are kept, as small records
	 */
	@SneakyThrows
	private static void readPerformanceLog() {
		if (!WebDriverRunner.hasWebDriverStarted()) {
			return;
		}
		for (LogEntry entry : WebDriverRunner.getWebDriver().manage().logs().get(LogType.PERFORMANCE).getAll()) {
			var event = objectMapper.readTree(entry.getMessage()).path("message");
			var params = event.path("params");
			switch (event.path("method").asText()) {
				case "Network.requestWillBeSent" ->
						requests.add(new NetworkRequest(params.path("request").path("method").asText(), params.path("request").path("url").asText()));
				case "Network.webSocketCreated" -> webSocketUrls.put(params.path("requestId").asText(), params.path("url").asText());
				case "Network.webSocketHandshakeResponseReceived" -> handshakes.add(new WebSocketHandshake(
						webSocketUrls.getOrDefault(params.path("requestId").asText(), ""),
						params.path("response").path("status").asInt()
				));
				default -> {
				}
			}
		}
	}

	/**
	 * Headless Chrome denies clipboard access unless the permission is granted for the origin
	 */
	public static void grantClipboardPermission(@NonNull URI uri) {
		var origin = uri.getScheme() + "://" + uri.getHost() + (uri.getPort() != -1 ? ":" + uri.getPort() : "");
		cdp("Browser.grantPermissions", Map.of(
				"origin", origin,
				"permissions", List.of("clipboardReadWrite", "clipboardSanitizedWrite")
		));
	}

	/**
	 * Makes the urls unreachable for the browser (the page sees a network failure); an empty list lifts the block
	 */
	public static void blockUrls(@NonNull List<String> patterns) {
		cdp("Network.enable", Map.of());
		cdp("Network.setBlockedURLs", Map.of("urls", patterns));
	}

	/**
	 * Every request of the current tab takes at least this long; {@link Duration#ZERO} lifts the delay
	 */
	public static void delayNetwork(@NonNull Duration latency) {
		cdp("Network.enable", Map.of());
		cdp("Network.emulateNetworkConditions", Map.of(
				"offline", false,
				"latency", latency.toMillis(),
				"downloadThroughput", -1,
				"uploadThroughput", -1
		));
	}

	/**
	 * Freezes the current tab as the browser freezes a background tab: no timers, no code, until {@link #unfreezeTab()}
	 */
	public static void freezeTab() {
		cdp("Page.setWebLifecycleState", Map.of("state", "frozen"));
	}

	public static void unfreezeTab() {
		cdp("Page.setWebLifecycleState", Map.of("state", "active"));
	}

	private static void cdp(String command, Map<String, Object> params) {
		if (WebDriverRunner.getWebDriver() instanceof ChromiumDriver chromium) {
			chromium.executeCdpCommand(command, params);
		}
	}

}
