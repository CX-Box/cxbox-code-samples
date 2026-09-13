package org.demo.documentation.widgets.picktree.actions.cancelcreate;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.basic.MyEntity3356Pick;
import org.demo.documentation.widgets.picktree.actions.cancelcreate.basic.MyEntity3356PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3356TestDataLoadService {

	@Autowired
	MyEntity3356Repository repository;

	@Autowired
	MyEntity3356PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3356().setCustomField("test data"));

		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3356Pick().setCustomField("test data6"));
		MyEntity3356Pick myEntity3356PickGroup = repositoryPick.save(new MyEntity3356Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3356PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3356PickGroup.getId())));
	}

}