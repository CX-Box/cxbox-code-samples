package org.demo.documentation.widgets.calendarlist.title;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5055TestDataLoadService {

	@Autowired
	MyEntity5055Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		LocalDate month = LocalDate.now();
		repository.save(new MyEntity5055().setCustomField("Meeting 1")
				.setStartDateTime(month.withDayOfMonth(10).atTime(10, 0))
				.setEndDateTime(month.withDayOfMonth(10).atTime(11, 0)));
		repository.save(new MyEntity5055().setCustomField("Meeting 2")
				.setStartDateTime(month.withDayOfMonth(12).atTime(14, 0))
				.setEndDateTime(month.withDayOfMonth(12).atTime(15, 30)));
		repository.save(new MyEntity5055().setCustomField("Conference")
				.setStartDateTime(month.withDayOfMonth(20).atTime(9, 0))
				.setEndDateTime(month.withDayOfMonth(21).atTime(18, 0)));
	}

}
