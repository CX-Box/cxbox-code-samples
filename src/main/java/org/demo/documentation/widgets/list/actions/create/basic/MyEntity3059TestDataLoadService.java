package org.demo.documentation.widgets.list.actions.create.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3059TestDataLoadService {

	@Autowired
	MyEntity3059Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3059().setCustomField("test data"));
		repository.save(new MyEntity3059().setCustomField("test data2"));
		repository.save(new MyEntity3059().setCustomField("test data3"));
		repository.save(new MyEntity3059().setCustomField("test data4"));
	}

}