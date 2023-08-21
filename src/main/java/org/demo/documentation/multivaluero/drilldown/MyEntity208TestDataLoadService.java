package org.demo.documentation.multivaluero.drilldown;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity208TestDataLoadService {

	@Autowired
	MyEntity208Repository repository;

	@Autowired
	MyEntity209Repository repository209;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository209.save(new MyEntity209().setCustomField("Test data"));
		repository.save(new MyEntity208());
	}

}