package org.demo.documentation.widgets.picklist.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3089TestDataLoadService {

	@Autowired
	MyEntity3089Repository repository;

	@Autowired
	MyEntity3089PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3089().setCustomField("test data"));
		repository.save(new MyEntity3089().setCustomField("test data2"));
		repository.save(new MyEntity3089().setCustomField("test data3"));

		repositoryPick.save(new MyEntity3089Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3089Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3089Pick().setCustomField("test data3"));
	}

}