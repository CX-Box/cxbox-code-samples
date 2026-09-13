package org.demo.documentation.widgets.picktree.actions.other.createcustomsave;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3349TestDataLoadService {

	@Autowired
	MyEntity3349Repository repository;

	@Autowired
	MyEntity3349PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();

		repository.save(new MyEntity3349().setCustomFieldRequred("test data"));
		repositoryPick.save(new MyEntity3349Pick().setCustomField("test data pick"));
		MyEntity3349Pick myEntity3349PickGroup = repositoryPick.save(new MyEntity3349Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3349PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3349PickGroup.getId())));
	}

}