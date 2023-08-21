package org.demo.documentation.multivaluero.placeholder;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity212TestDataLoadService {

	@Autowired
	MyEntity212Repository repository;

	@Autowired
	MyEntity213Repository repository213;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository213.save(new MyEntity213().setCustomField("Test data"));
		repository.save(new MyEntity212());
	}

}