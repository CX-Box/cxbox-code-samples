package org.demo.documentation.widgets.assoc.title;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3090TestDataLoadService {

	@Autowired
	MyEntity3090Repository repository;

	@Autowired
	MyEntity3090MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3090().setCustomField("test data"));
		repository.save(new MyEntity3090().setCustomField("test data2"));

		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3090Multi().setCustomField("test data"));
	}

}