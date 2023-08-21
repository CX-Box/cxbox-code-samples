package org.demo.documentation.multivaluero.basic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity200TestDataLoadService {

	@Autowired
	MyEntity200Repository repository;

	@Autowired
	MyEntity201Repository repository201;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository201.save(new MyEntity201().setCustomField("Test data"));
		repository.save(new MyEntity200());
	}

}