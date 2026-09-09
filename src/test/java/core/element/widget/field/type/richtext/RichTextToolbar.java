package core.element.widget.field.type.richtext;

import static com.codeborne.selenide.Selenide.executeAsyncJavaScript;

import java.util.Map;

/**
 * The toolbar above the editor: click a button, or ask if it is enabled.
 *
 * <h2>Why JavaScript and not Selenide selectors</h2>
 * A button can be in three places, depending on how wide the field is: on the toolbar, under the
 * "⋯" button when the toolbar is too narrow, or inside a menu (Heading, List, Code, Text color) that
 * exists in the DOM only while it is open. The page also keeps a hidden copy of every button to
 * measure widths, so a selector by key finds two elements and must take the visible one.
 *
 * <p>With Selenide this was: find the visible copy, click "⋯" if it is not there, open the menu,
 * wait for the item, check it is enabled, click. Every step is a browser call, and Selenide repeats
 * the whole locator chain for every call, so one click was about 15 browser calls and 170 ms. The
 * RichText test does about 3000 clicks: 8 minutes of waiting for nothing. The same search inside the
 * page is one call and about 15 ms, and it waits only for what it looks for (an item of an opening
 * menu), never for a fixed time. The click is the element's own {@code click()}, so the application
 * handler runs exactly as for a real click.
 */
final class RichTextToolbar {

	private RichTextToolbar() {
	}

	private static final String SCRIPT = """
			var key = arguments[0], menuKey = arguments[1], clickIt = arguments[2], done = arguments[3];
			function visible(el) {
			  if (el.closest('[aria-hidden="true"]')) { return false; }
			  var r = el.getBoundingClientRect();
			  return r.width > 0 && r.height > 0;
			}
			function find(k) {
			  return Array.prototype.find.call(document.querySelectorAll('[data-test-rich-text-action="' + k + '"]'), visible) || null;
			}
			function disabled(el) {
			  return !!(el.disabled || el.getAttribute('aria-disabled') === 'true'
			    || el.classList.contains('ant-btn-disabled') || el.classList.contains('ant-dropdown-menu-item-disabled'));
			}
			// poll every 10 ms, up to 2 s, until probe() returns something
			function until(probe, then, fail) {
			  var start = Date.now();
			  (function tick() {
			    var v = probe();
			    if (v) { return then(v); }
			    if (Date.now() - start > 2000) { return fail(); }
			    setTimeout(tick, 10);
			  })();
			}
			// a button on the toolbar itself, or behind the "..." button
			function topLevel(k, then, fail) {
			  var el = find(k);
			  if (el) { return then(el); }
			  var more = find('More');
			  if (!more) { return fail('"' + k + '" is not on the toolbar'); }
			  more.click();
			  until(function () { return find(k); }, then, function () { fail('"' + k + '" did not appear after opening the "..." button'); });
			}
			function hover(el) {
			  ['mouseover', 'mouseenter'].forEach(function (t) { el.dispatchEvent(new MouseEvent(t, {bubbles: true})); });
			}
			function found(el) {
			  if (!clickIt) { return done({enabled: !disabled(el)}); }
			  if (disabled(el)) { return done({error: '"' + key + '" is disabled'}); }
			  el.click();
			  done({enabled: true});
			}
			function fail(why) { done({error: why}); }
			if (!menuKey) { return topLevel(key, found, fail); }
			topLevel(menuKey, function (trigger) {
			  trigger.click();
			  until(function () { var it = find(key); if (!it) { hover(trigger); } return it; }, found,
			    function () { fail('"' + key + '" did not appear in the "' + menuKey + '" menu'); });
			}, fail);
			""";

	/** Clicks the button; throws {@link RichText.Refused} if it is disabled. */
	static void click(RichTextAction action) {
		run(action, true);
	}

	static boolean isEnabled(RichTextAction action) {
		return (Boolean) run(action, false).get("enabled");
	}

	private static Map<String, Object> run(RichTextAction action, boolean click) {
		Map<String, Object> result = executeAsyncJavaScript(SCRIPT, action.key(), action.menu(), click);
		if (result == null) {
			throw new IllegalStateException("The toolbar script returned nothing");
		}
		String error = (String) result.get("error");
		if (error != null && error.endsWith("is disabled")) {
			throw new RichText.Refused("RichText toolbar: " + error);
		}
		if (error != null) {
			throw new IllegalStateException("RichText toolbar: " + error);
		}
		return result;
	}

}
