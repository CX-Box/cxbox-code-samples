package org.demo.documentation.multivaluero.validationbusinessex;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity218TestDataLoadService {

	@Autowired
	MyEntity218Repository repository;

	@Autowired
	MyEntity219Repository repository219;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository219.save(new MyEntity219().setCustomField("Test data"));
		repository.save(new MyEntity218());
	}

}