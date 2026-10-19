package core.util.report;

import io.qameta.allure.listener.StepLifecycleListener;
import io.qameta.allure.model.StepResult;

/**
 * Tells {@link StepReport} when a step starts and stops, so that a line of the first level gets the service steps made
 * before it. Registered for Allure in META-INF/services of the tests.
 */
public class StepReportListener implements StepLifecycleListener {

	@Override
	public void afterStepStart(StepResult step) {
		StepReport.started(step);
	}

	@Override
	public void afterStepStop(StepResult step) {
		StepReport.stopped(step);
	}

}
