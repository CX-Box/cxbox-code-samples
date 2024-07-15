package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity245TestDataLoadService {

	@Autowired
	MyEntity245Repository repository;

	@Autowired
	MyEntity246Repository repository246;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository246.save(new MyEntity246().setCustomField("Test data"));
		repository.save(new MyEntity245());
	}

}