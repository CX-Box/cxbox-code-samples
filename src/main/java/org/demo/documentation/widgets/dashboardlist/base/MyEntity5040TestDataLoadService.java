package org.demo.documentation.widgets.dashboardlist.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyEntity5040TestDataLoadService {

	@Autowired
	MyExampleBc5040Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		repository.save(new MyExampleBc5040().setCustomField("Test data 1"));
		repository.save(new MyExampleBc5040().setCustomField("Test data 2"));

	}
}