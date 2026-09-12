package org.demo.documentation.widgets.picktree.actions.edit;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.MyEntity3353Pick;
import org.demo.documentation.widgets.picktree.actions.edit.picktreepopup.MyEntity3353PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3353TestDataLoadService {

	@Autowired
	MyEntity3353Repository repository;

	@Autowired
	MyEntity3353PickRepository repositoryPick;


	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3353().setCustomField("test data"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data6"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data7"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data8"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data9"));
		repositoryPick.save(new MyEntity3353Pick().setCustomField("test data10"));

		MyEntity3353Pick myEntity3353PickGroup = repositoryPick.save(new MyEntity3353Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3353PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3353PickGroup.getId())));
	}

}