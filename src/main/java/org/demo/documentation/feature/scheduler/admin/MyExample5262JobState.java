package org.demo.documentation.feature.scheduler.admin;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jobrunr.jobs.states.StateName;

/**
 * JobRunr job states shown on the administration screen.
 */
@Getter
@AllArgsConstructor
public enum MyExample5262JobState {

	SCHEDULED("Scheduled", StateName.SCHEDULED, "clock-circle"),
	ENQUEUED("Enqueued", StateName.ENQUEUED, "history"),
	PROCESSING("Processing", StateName.PROCESSING, "code"),
	SUCCEEDED("Succeeded", StateName.SUCCEEDED, "check-circle"),
	FAILED("Failed", StateName.FAILED, "exclamation-circle"),
	DELETED("Deleted", StateName.DELETED, "delete");

	private final String title;

	private final StateName stateName;

	private final String icon;

	public static MyExample5262JobState getById(String id) {
		return Arrays.stream(values()).filter(v -> v.name().equals(id)).findFirst().orElse(null);
	}

}
