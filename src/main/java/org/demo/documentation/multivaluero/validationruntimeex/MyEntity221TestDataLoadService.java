package org.demo.documentation.multivaluero.validationruntimeex;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity221TestDataLoadService {

	@Autowired
	MyEntity221Repository repository;

	@Autowired
	MyEntity222Repository repository222;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository222.save(new MyEntity222().setCustomField("Test data"));
		repository.save(new MyEntity221());
	}

}