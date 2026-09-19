package core.config.selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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

	/**
	 * @param body the body of a POST as the browser sent it (form parameters as one string), null when there was none
	 */
	public record NetworkRequest(String method, String url, String body) {

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

	/** Documents the tabs have loaded into their main frame (first load, F5, redirect) */
	private static int pagesCommitted;

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
						requests.add(new NetworkRequest(
								params.path("request").path("method").asText(),
								params.path("request").path("url").asText(),
								params.path("request").path("postData").asText(null)
						));
				case "Page.frameNavigated" -> {
					if (params.path("frame").path("parentId").isMissingNode()) {
						pagesCommitted++;
					}
				}
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
	 * The answers to the current tab arrive at this speed while the requests leave at full speed; {@code -1} lifts the throttle.
	 * {@link #delayNetwork(Duration)} holds the request itself, so the server never sees it; this one lets the request through
	 * and keeps the answer on its way, which is how a browser is caught in the middle of an exchange the server has already done.
	 */
	public static void throttleDownload(long bytesPerSecond) {
		direct("Network.enable", Map.of());
		direct("Network.emulateNetworkConditions", Map.of(
				"offline", false,
				"latency", 0,
				"downloadThroughput", bytesPerSecond,
				"uploadThroughput", -1
		));
	}

	/**
	 * F5 of the current tab by the browser itself, no script on the page. Returns when the old page is gone and the new one has
	 * started to load; does not wait for the load to end, so it works while {@link #throttleDownload(long)} is on.
	 */
	public static void reload() {
		readPerformanceLog();
		int before = pagesCommitted;
		direct("Page.reload", Map.of());
		var deadline = Instant.now().plus(RELOAD_COMMIT_TIMEOUT);
		while (pagesCommitted == before) {
			if (Instant.now().isAfter(deadline)) {
				throw new IllegalStateException("The tab has not reloaded in " + RELOAD_COMMIT_TIMEOUT.toSeconds() + " s");
			}
			Selenide.sleep(200);
			readPerformanceLog();
		}
	}

	private static final Duration RELOAD_COMMIT_TIMEOUT = Duration.ofSeconds(120);

	/**
	 * Freezes the current tab as the browser freezes a background tab: no timers, no code, until {@link #unfreezeTab()}
	 */
	public static void freezeTab() {
		cdp("Page.setWebLifecycleState", Map.of("state", "frozen"));
	}

	public static void unfreezeTab() {
		cdp("Page.setWebLifecycleState", Map.of("state", "active"));
	}

	/**
	 * A command over an own DevTools connection to the current tab, past the WebDriver. The WebDriver waits for the page to load
	 * before and after each of its commands, so under {@link #throttleDownload(long)} its commands time out.
	 */
	private static void direct(String command, Map<String, Object> params) {
		if (WebDriverRunner.getWebDriver() instanceof ChromiumDriver chromium) {
			DirectConnection.to(chromium).send(command, params);
		}
	}

	/**
	 * The connection stays open between the commands: the browser drops the network conditions of a connection that has closed.
	 * One connection at a time, reopened when the driver or the tab is another one.
	 */
	private static final class DirectConnection implements WebSocket.Listener {

		private static final Duration ANSWER_TIMEOUT = Duration.ofSeconds(10);

		private static DirectConnection current;

		private final String url;

		private final WebSocket socket;

		private final StringBuilder message = new StringBuilder();

		private final Map<Integer, CompletableFuture<Void>> answers = new ConcurrentHashMap<>();

		private final AtomicInteger lastId = new AtomicInteger();

		private volatile boolean closed;

		private DirectConnection(String url) {
			this.url = url;
			this.socket = HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(URI.create(url), this).join();
		}

		/** The window handle of the WebDriver is the id of the tab in the DevTools protocol */
		static synchronized DirectConnection to(ChromiumDriver driver) {
			var options = (Map<?, ?>) driver.getCapabilities().getCapability("goog:chromeOptions");
			String url = "ws://" + options.get("debuggerAddress") + "/devtools/page/" + driver.getWindowHandle();
			if (current == null || current.closed || !current.url.equals(url)) {
				if (current != null) {
					current.socket.abort();
				}
				current = new DirectConnection(url);
			}
			return current;
		}

		@SneakyThrows
		void send(String command, Map<String, Object> params) {
			int id = lastId.incrementAndGet();
			var answer = new CompletableFuture<Void>();
			answers.put(id, answer);
			socket.sendText(objectMapper.writeValueAsString(Map.of("id", id, "method", command, "params", params)), true).join();
			answer.get(ANSWER_TIMEOUT.toSeconds(), TimeUnit.SECONDS);
		}

		@Override
		@SneakyThrows
		public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
			message.append(data);
			if (last) {
				var json = objectMapper.readTree(message.toString());
				message.setLength(0);
				var answer = answers.remove(json.path("id").asInt());
				if (answer != null && json.has("error")) {
					answer.completeExceptionally(new IllegalStateException(json.path("error").toString()));
				} else if (answer != null) {
					answer.complete(null);
				}
			}
			webSocket.request(1);
			return null;
		}

		@Override
		public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
			closed = true;
			return null;
		}

		@Override
		public void onError(WebSocket webSocket, Throwable error) {
			closed = true;
		}

	}

	private static void cdp(String command, Map<String, Object> params) {
		if (WebDriverRunner.getWebDriver() instanceof ChromiumDriver chromium) {
			chromium.executeCdpCommand(command, params);
		}
	}

}
