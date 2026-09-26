package core.element.widget.action;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;

/**
 * The requests of the application page (XHR and fetch). A popup widget has no loading spinner, so an operation
 * started by a click is finished when its requests are done and their results are rendered.
 * <p>
 * TODO temporary: remove when the popup widgets show the loading spinner, the spinner wait of the actions is enough then.
 */
public final class PageRequests {

	/** Counts the pending requests; a request is done a few tasks after its end, when React has rendered the result. */
	private static final String TRACK = """
			if (!window.__cxboxRequests) {
				const requests = window.__cxboxRequests = { pending: 0, sent: 0 };
				const done = () => setTimeout(() => setTimeout(() => setTimeout(() => requests.pending--)));
				const send = XMLHttpRequest.prototype.send;
				XMLHttpRequest.prototype.send = function () {
					requests.pending++;
					requests.sent++;
					this.addEventListener('loadend', done);
					return send.apply(this, arguments);
				};
				const fetch = window.fetch;
				window.fetch = function () {
					requests.pending++;
					requests.sent++;
					return fetch.apply(this, arguments).finally(done);
				};
			}
			""";

	private static final String PENDING = "return window.__cxboxRequests ? window.__cxboxRequests.pending : 0;";

	private static final String SENT = "return window.__cxboxRequests ? window.__cxboxRequests.sent : 0;";

	private PageRequests() {
	}

	/** Starts counting the requests of the page (again after a reload of the page): call it before the click. */
	static void track() {
		try {
			Selenide.executeJavaScript(TRACK);
		} catch (RuntimeException e) {
			// a page that is not available for scripts has nothing to count
		}
	}

	/**
	 * Runs the action and waits for the requests it sends with a delay (a debounced input): first until a request is
	 * sent, at most {@code start}, then until the requests are done and rendered. An action that sends no request
	 * (the same value again) only costs the {@code start} wait.
	 */
	public static void runAndWaitDelayedRequests(Runnable action, Duration start, Duration done) {
		track();
		long before = sent();
		action.run();
		try {
			Selenide.Wait().withTimeout(start).until(driver -> sent() > before);
		} catch (TimeoutException e) {
			return;
		}
		waitDone(done);
	}

	private static long sent() {
		try {
			Number sent = Selenide.executeJavaScript(SENT);
			return sent == null ? 0 : sent.longValue();
		} catch (RuntimeException e) {
			return 0;
		}
	}

	/** Waits until the requests sent after {@link #track()} are done and rendered. */
	static void waitDone(Duration timeout) {
		Selenide.Wait().withTimeout(timeout).until(driver -> {
			try {
				Number pending = Selenide.executeJavaScript(PENDING);
				return pending == null || pending.longValue() <= 0;
			} catch (RuntimeException e) {
				return true;
			}
		});
	}

}
