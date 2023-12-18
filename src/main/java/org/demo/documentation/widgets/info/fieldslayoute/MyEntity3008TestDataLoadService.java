package org.demo.documentation.widgets.info.fieldslayoute;

import org.cxbox.api.service.session.InternalAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class MyEntity3008TestDataLoadService {

	@Autowired
    MyEntity3008Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3008()
				.setCustomField("Test data")
				.setCustomField2("Test data")
				.setCustomField3("Test data")
				.setCustomField4("Test data")
				.setCustomField5("Test data")
		);
	}

}