package org.demo.documentation.widgets.list.fieldtitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6165TestDataLoadService {

	@Autowired
	MyEntity6165Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity6165().setCustomField("Test data"));
		repository.save(new MyEntity6165().setCustomField("Test data2"));
		repository.save(new MyEntity6165().setCustomField("Test data3"));
	}

}
