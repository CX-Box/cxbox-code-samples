package org.demo.documentation.widgets.headerwidget.showcondition.bycurrententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5026TestDataLoadService {

	@Autowired
	MyEntity5026Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity5026().setCustomField(5L));
		repository.save(new MyEntity5026().setCustomField(2L));
		repository.save(new MyEntity5026().setCustomField(100L));
	}

}