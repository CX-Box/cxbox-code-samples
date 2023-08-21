package org.demo.documentation.multivaluero.colorconst;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity204TestDataLoadService {

	@Autowired
	MyEntity204Repository repository;

	@Autowired
	MyEntity205Repository repository205;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository205.save(new MyEntity205().setCustomField("Test data"));
		repository.save(new MyEntity204());
	}

}