package core.element.widget.action;

import com.codeborne.selenide.Selenide;

import java.time.Duration;

/**
 * The requests of the application page (XHR and fetch).
 * <ul>
 * <li>A popup widget has no loading spinner, so an operation started by a click is finished when its requests are done
 * and their results are rendered. TODO temporary for the actions: the spinner wait is enough when the popup widgets
 * show the loading spinner.</li>
 * <li>The full text search sends its request after a pause, so the search first waits until the request is sent
 * ({@link #waitSent}).</li>
 * </ul>
 */
public final class PageRequests {

	/**
	 * Counts the sent and the pending requests; a request is done a few tasks after its end, when React has rendered
	 * the result.
	 */
	private static final String TRACK = """
			if (!window.__cxboxRequests) {
				const requests = window.__cxboxRequests = { pending: 0, sent: 0 };
				const done = () => setTimeout(() => setTimeout(() => setTimeout(() => requests.pending--)));
				const send = XMLHttpRequest.prototype.send;
				XMLHttpRequest.prototype.send = function () {
					requests.sent++;
					requests.pending++;
					this.addEventListener('loadend', done);
					return send.apply(this, arguments);
				};
				const fetch = window.fetch;
				window.fetch = function () {
					requests.sent++;
					requests.pending++;
					return fetch.apply(this, arguments).finally(done);
				};
			}
			""";

	private static final String PENDING = "return window.__cxboxRequests ? window.__cxboxRequests.pending : 0;";

	private static final String SENT = "return window.__cxboxRequests ? window.__cxboxRequests.sent : 0;";

	private PageRequests() {
	}

	/** Starts counting the requests of the page (again after a reload of the page): call it before the click. */
	public static void track() {
		try {
			Selenide.executeJavaScript(TRACK);
		} catch (RuntimeException e) {
			// a page that is not available for scripts has nothing to count
		}
	}

	/** Waits until the requests sent after {@link #track()} are done and rendered. */
	public static void waitDone(Duration timeout) {
		Selenide.Wait().withTimeout(timeout).until(driver -> {
			try {
				Number pending = Selenide.executeJavaScript(PENDING);
				return pending == null || pending.longValue() <= 0;
			} catch (RuntimeException e) {
				return true;
			}
		});
	}

	/** The number of the requests sent after {@link #track()}: pass it to {@link #waitSent} before the action. */
	public static long sent() {
		try {
			Number sent = Selenide.executeJavaScript(SENT);
			return sent == null ? 0 : sent.longValue();
		} catch (RuntimeException e) {
			return 0;
		}
	}

	/** Waits until a request is sent after the {@link #sent()} value taken before the action. */
	public static void waitSent(long sentBefore, Duration timeout) {
		Selenide.Wait().withTimeout(timeout).until(driver -> sent() > sentBefore);
	}

}
