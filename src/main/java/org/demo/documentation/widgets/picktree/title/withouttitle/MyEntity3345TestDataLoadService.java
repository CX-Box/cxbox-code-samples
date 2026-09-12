package org.demo.documentation.widgets.picktree.title.withouttitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3345TestDataLoadService {

	@Autowired
	MyEntity3345Repository repository;

	@Autowired
	MyEntity3345PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3345Pick myEntity3345Pick = new MyEntity3345Pick().setCustomFieldPick("Test data");
		repositoryPick.save(myEntity3345Pick);
		repository.save(new MyEntity3345().setCustomFieldEntity(myEntity3345Pick));
		MyEntity3345Pick myEntity3345PickGroup = repositoryPick.save(new MyEntity3345Pick().setCustomFieldPick("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3345PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3345PickGroup.getId())));
	}


}