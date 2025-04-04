package core.config.allure;

import io.qameta.allure.listener.TestLifecycleListener;
import io.qameta.allure.model.TestResult;

public class AllureDescConfig implements TestLifecycleListener {

	/**
	 * Converts an Allure test path to a Maven-style (java method FQN) identifier by replacing the last '.' with '#'.
	 * <br>
	 * Example: {@code application.Samples.Form.HintOnFormTest.filtration → application.Samples.Form.HintOnFormTest#filtration}
	 * <br>
	 * To use this listener, add file {@code io.qameta.allure.listener.TestLifecycleListener}
	 * to folder {@code src/test/resources/META-INF/services/} and fill it with this listener
	 * FQN: {@code core.config.CustomAllureListener}.
	 * <br>
	 *
	 * @param result the test path
	 */
	@Override
	public void beforeTestStop(TestResult result) {
		String testName = result.getFullName();
		int lastDotIndex = testName.lastIndexOf('.');
		if (lastDotIndex != -1) {
			var fqn = testName.substring(0, lastDotIndex) + "#" + testName.substring(lastDotIndex + 1);
			String link = "https://github.com/CX-Box/cxbox-code-samples/actions/workflows/build_button_qa.yml";
			String manualRunHtml = """
					<br><br>
					<strong>Manual run:</strong>
					<code style="background:#f6f8fa;padding:4px 8px;border-radius:6px;display:inline-flex;align-items:center;gap:6px;">
					  <button onclick="navigator.clipboard.writeText('%s')" style="padding:4px 8px;border:none;border-radius:4px;background:#d0d7de;cursor:pointer;display:flex;align-items:center;">
					    📋 Copy
					  </button>
					  %s
					</code>
					into <a href="%s" target="_blank">GitHub Actions</a> → <strong>Run Workflow</strong> → <strong>include PATH</strong>
					""".formatted(fqn, fqn, link);
			result.setDescriptionHtml(result.getDescription() + manualRunHtml);
		}
	}

}