package org.demo.documentation.widgets.calendaryearlist.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class MyEntity5039TestDataLoadService {

	@Autowired
	MyExampleBc5039Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		// --8<-- [start:events]
		// an event of the year calendar is one whole day: from 00:00 to 23:59, one event per day
		int year = LocalDate.now().getYear();
		saveDayEvent("Meeting 1", LocalDate.of(year, 2, 10));
		saveDayEvent("Meeting 2", LocalDate.of(year, 4, 22));
		saveDayEvent("Conference", LocalDate.of(year, 6, 17));
		saveDayEvent("Release", LocalDate.of(year, 9, 3));
		saveDayEvent("Annual report", LocalDate.of(year, 12, 15));
		// --8<-- [end:events]
	}

	private void saveDayEvent(String name, LocalDate day) {
		repository.save(new MyExampleBc5039().setCustomField(name)
				.setStartDateTime(day.atStartOfDay())
				.setEndDateTime(day.atTime(LocalTime.of(23, 59))));
	}
}