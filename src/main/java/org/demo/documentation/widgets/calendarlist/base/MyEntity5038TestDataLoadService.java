package org.demo.documentation.widgets.calendarlist.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyEntity5038TestDataLoadService {

	@Autowired
	MyExampleBc5038Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		repository.save(new MyExampleBc5038().setCustomField("Meeting 1")
				.setEndDateTime(LocalDateTime.now())
				.setStartDateTime(LocalDateTime.now().minusDays(3)));
        repository.save(new MyExampleBc5038().setCustomField("Meeting 2")
                .setEndDateTime(LocalDateTime.now().plusMonths(2))
                .setStartDateTime(LocalDateTime.now().minusDays(2)));
	}
}