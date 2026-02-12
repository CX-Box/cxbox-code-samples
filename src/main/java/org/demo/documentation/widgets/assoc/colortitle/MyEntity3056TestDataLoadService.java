package org.demo.documentation.widgets.assoc.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3056TestDataLoadService {

	@Autowired
	MyEntity3056Repository repository;

	@Autowired
	MyEntity3056MultiRepository repositoryMulti;


	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3056());
		repositoryMulti.deleteAll();
		repositoryMulti.save(new MyEntity3056Multi().setCustomField("Test data").setCustomFieldText("Test data text"));
	}

}