package core.element.widget.field.type.richtext;

import static com.codeborne.selenide.Selenide.executeJavaScript;

import com.codeborne.selenide.SelenideElement;
import java.util.Map;

/**
 * The editor inside the field (Tiptap over ProseMirror): read the markdown, open markdown, type,
 * select.
 *
 * <h2>Why JavaScript and not Selenide</h2>
 * Every method here is one call to the same {@code Editor} object the application uses, because
 * there is no DOM to do it through:
 * <ul>
 *   <li><b>The value.</b> The markdown is not on the page; the application gets it from
 *       {@code editor.getMarkdown()} in its change handler. The only way to see it through the UI is
 *       to switch the field to "Markdown markup" mode and read the source editor: four mode switches
 *       per check, about 500 ms, and a test of the mode switch rather than of the editor.</li>
 *   <li><b>Opening a value.</b> {@code editor.setContent(markdown)} is exactly what the application
 *       calls when a value comes from the database. The UI has no other way to put markdown in.</li>
 *   <li><b>Typing.</b> {@code sendKeys("**abc**")} into ProseMirror runs the editor's markdown
 *       shortcuts: the stars become bold and disappear. The test needs the characters as typed, so the
 *       text is inserted as text nodes, which cannot trigger a shortcut.</li>
 *   <li><b>Selecting.</b> Shift+Arrow fourteen times is fourteen browser calls, and the arrow steps
 *       over an emoji or a line break differently from how the editor counts positions.
 *       {@code setTextSelection} takes the editor's own positions; {@code positionOf} below turns a
 *       character position into one.</li>
 * </ul>
 * Toolbar buttons are still clicked for real, see {@link RichTextToolbar}: the click handlers are
 * what the tests are about.
 */
final class RichTextCanvas {

	private RichTextCanvas() {
	}

	/**
	 * Finds the Tiptap {@code Editor} behind the field. {@code .ProseMirror} is not a React element,
	 * so the search starts from the nearest React element above it and walks up the React tree to the
	 * component that holds the editor.
	 */
	private static final String FIND_EDITOR = """
			var root = arguments[0].querySelector('.ProseMirror');
			if (!root) { return {error: 'the editor (.ProseMirror) is not on the page'}; }
			var node = root, fiber = null;
			while (node && !fiber) {
			  var key = Object.keys(node).find(function (k) { return k.indexOf('__reactFiber') === 0; });
			  if (key) { fiber = node[key]; } else { node = node.parentElement; }
			}
			var editor = null;
			for (var hops = 0; fiber && hops < 40 && !editor; hops++) {
			  var props = fiber.memoizedProps;
			  if (props && props.editor && typeof props.editor.getMarkdown === 'function') { editor = props.editor; }
			  else if (fiber.stateNode && fiber.stateNode.editor && typeof fiber.stateNode.editor.getMarkdown === 'function') { editor = fiber.stateNode.editor; }
			  else { fiber = fiber.return; }
			}
			if (!editor) {
			  return {error: 'the Tiptap Editor was not found above .ProseMirror in the React tree - '
			    + 'the prop was renamed or React changed. Update FIND_EDITOR in RichTextCanvas.java.'};
			}
			""";

	/**
	 * A character position (what a person counts: one per character, one per line break, one per
	 * paragraph break) to the editor's own position.
	 */
	private static final String POSITIONS = """
			function positionOf(offset) {
			  var doc = editor.state.doc, seen = 0, pos = null;
			  doc.descendants(function (node, p) {
			    if (pos !== null) { return false; }
			    if (!node.isTextblock) { return true; }
			    var units = [];
			    node.forEach(function (child) {
			      if (child.isText) {
			        Array.from(child.text).forEach(function (cp) { units.push(cp.length); });
			      } else { units.push(child.nodeSize); }
			    });
			    if (seen + units.length >= offset) {
			      var inside = 0;
			      for (var i = 0; i < offset - seen; i++) { inside += units[i]; }
			      pos = p + 1 + inside;
			      return false;
			    }
			    seen += units.length + 1;   // one step from one paragraph into the next
			    return true;
			  });
			  return pos;
			}
			""";

	static String markdown(SelenideElement field) {
		return value(executeJavaScript(FIND_EDITOR + "return {value: editor.getMarkdown()};", field));
	}

	/** Opens the markdown as a stored value. */
	static void load(SelenideElement field, String markdown) {
		check(executeJavaScript(FIND_EDITOR + """
				editor.commands.setContent(arguments[1], { contentType: 'markdown', emitUpdate: false });
				return {ok: true};
				""", field, markdown));
	}

	/** Empties the editor the way the user does (select all, delete): unlike {@link #load}, the application gets the change. */
	static void clearAsUser(SelenideElement field) {
		check(executeJavaScript(FIND_EDITOR + "editor.chain().focus().clearContent(true).run(); return {ok: true};", field));
	}

	/**
	 * Whether the application already has the value the editor shows, as a change of the field. The editor
	 * passes a change on after a short pause (DEBOUNCE_MS in ui/src/components/RichText/wysiwyg/hooks.ts), so a
	 * Save right after the change can still send the old value. The change is read from the store
	 * ({@code view.pendingDataChanges}): the props in the React tree above the editor can be an older copy.
	 */
	static boolean applied(SelenideElement field) {
		return "true".equals(value(executeJavaScript(FIND_EDITOR + """
				var store = null;
				for (var f = fiber, hops = 0; f && hops < 200 && !store; hops++, f = f.return) {
				  var p = f.memoizedProps;
				  if (p && p.store && typeof p.store.getState === 'function' && p.store.getState().view) { store = p.store; }
				}
				if (!store) { return {error: 'the store was not found above the editor in the React tree'}; }
				var key = arguments[0].getAttribute('data-test-field-key'), md = editor.getMarkdown();
				var changes = store.getState().view.pendingDataChanges || {}, applied = false;
				Object.keys(changes).forEach(function (bc) {
				  Object.keys(changes[bc] || {}).forEach(function (id) {
				    var v = (changes[bc][id] || {})[key];
				    if (v !== undefined && (v || '') === md) { applied = true; }
				  });
				});
				return {value: String(applied)};
				""", field)));
	}

	/** Adds plain text at the end: a line break is Shift+Enter, an empty line starts a new paragraph. */
	static void type(SelenideElement field, String text) {
		check(executeJavaScript(FIND_EDITOR + """
				var paragraphs = arguments[1].split('\\n\\n').map(function (para) {
				  var content = [];
				  para.split('\\n').forEach(function (line, i) {
				    if (i > 0) { content.push({type: 'hardBreak'}); }
				    if (line) { content.push({type: 'text', text: line}); }
				  });
				  return content.length ? {type: 'paragraph', content: content} : {type: 'paragraph'};
				});
				var empty = editor.state.doc.textContent.length === 0 && editor.state.doc.childCount === 1;
				if (empty) { editor.commands.setContent(paragraphs); }
				else { editor.chain().focus('end').insertContent(paragraphs).run(); }
				editor.commands.focus('end');
				return {ok: true};
				""", field, text));
	}

	static void selectAll(SelenideElement field) {
		check(executeJavaScript(FIND_EDITOR + "editor.commands.focus(); editor.commands.selectAll(); return {ok: true};", field));
	}

	static void select(SelenideElement field, int from, int to) {
		check(executeJavaScript(FIND_EDITOR + POSITIONS + """
				var from = positionOf(arguments[1]), to = positionOf(arguments[2]);
				if (from === null || to === null) {
				  return {error: 'selection [' + arguments[1] + ', ' + arguments[2] + ') is outside the text'};
				}
				editor.chain().focus().setTextSelection({from: from, to: to}).run();
				return {ok: true};
				""", field, from, to));
	}

	private static String value(Map<String, String> result) {
		check(result);
		String value = result.get("value");
		return value == null ? "" : value.replaceAll("\\s+$", "");
	}

	private static void check(Map<String, ?> result) {
		if (result == null) {
			throw new IllegalStateException("The editor script returned nothing");
		}
		if (result.get("error") != null) {
			throw new IllegalStateException("RichText editor: " + result.get("error"));
		}
	}

}
