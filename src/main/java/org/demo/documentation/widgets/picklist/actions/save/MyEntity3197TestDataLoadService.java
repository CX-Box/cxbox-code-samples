package org.demo.documentation.widgets.picklist.actions.save;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup.MyEntity3197Pick;
import org.demo.documentation.widgets.picklist.actions.save.forpicklistpopup.MyEntity3197PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3197TestDataLoadService {

	@Autowired
	MyEntity3197Repository repository;
	@Autowired
	MyEntity3197PickRepository repositoryPick;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repository.save(new MyEntity3197().setCustomField("test data"));

		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3197Pick().setCustomField("test data6"));
	}

}