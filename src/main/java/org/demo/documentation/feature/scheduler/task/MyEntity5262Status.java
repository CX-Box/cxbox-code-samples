package org.demo.documentation.feature.scheduler.task;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MyEntity5262Status {

	NEW("New"),
	ENQUEUED("Enqueued"),
	SCHEDULED("Scheduled"),
	DONE("Done");

	private final String value;

}
