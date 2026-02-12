package org.demo.documentation.widgets.picklist.actions.cancelcreate;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3198TestDataLoadService {

	@Autowired
	MyEntity3198Repository repository;

	@Autowired
	MyEntity3198PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3198().setCustomField("test data"));

		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3198Pick().setCustomField("test data6"));
	}

}