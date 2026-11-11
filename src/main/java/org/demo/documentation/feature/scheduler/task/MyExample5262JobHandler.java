package org.demo.documentation.feature.scheduler.task;

import static org.cxbox.api.service.session.InternalAuthorizationService.SystemUsers.VANILLA;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.jobrunr.jobs.annotations.Job;
import org.jobrunr.jobs.annotations.Recurring;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Methods of this bean are run by the JobRunr background job server.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MyExample5262JobHandler {

	private final MyEntity5262Repository repository;

	private final InternalAuthorizationService authzService;

	// --8<-- [start:job]
	@Job(name = "MyExample5262: execute record %0", retries = 2)
	@Transactional
	public void execute(Long id) {
		authzService.loginAs(authzService.createAuthentication(VANILLA));
		repository.findById(id).ifPresent(entity -> entity
				.setStatus(MyEntity5262Status.DONE)
				.setExecutedDate(LocalDateTime.now())
		);
	}
	// --8<-- [end:job]

	// --8<-- [start:recurring]
	@Recurring(id = "myexample5262-recurring", cron = "*/5 * * * *")
	@Job(name = "MyExample5262: recurring job")
	public void recurring() {
		log.info("MyExample5262: recurring job, records in DB: {}", repository.count());
	}
	// --8<-- [end:recurring]

}
