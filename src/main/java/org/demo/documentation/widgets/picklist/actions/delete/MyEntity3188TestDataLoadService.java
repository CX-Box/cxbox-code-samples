package org.demo.documentation.widgets.picklist.actions.delete;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup.MyEntity3188Pick;
import org.demo.documentation.widgets.picklist.actions.delete.forpicklistpopup.MyEntity3188PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3188TestDataLoadService {

	@Autowired
	MyEntity3188Repository repository;

	@Autowired
	MyEntity3188PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repository.save(new MyEntity3188().setCustomField("test data"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3188Pick().setCustomField("test data6"));
	}

}