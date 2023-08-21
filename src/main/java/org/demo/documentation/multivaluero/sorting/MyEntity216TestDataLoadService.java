package org.demo.documentation.multivaluero.sorting;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity216TestDataLoadService {

	@Autowired
	MyEntity216Repository repository;

	@Autowired
	MyEntity217Repository repository217;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository217.save(new MyEntity217().setCustomField("Test data"));
		repository.save(new MyEntity216());
	}

}