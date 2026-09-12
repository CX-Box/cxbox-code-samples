package org.demo.documentation.widgets.picktree.actions.other.createwithparent;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3350TestDataLoadService {

	@Autowired
	MyEntity3350Repository repository;

	@Autowired
	MyEntity3350PickRepository repositoryPick;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.save(new MyEntity3350Pick().setCustomField("test data"));
		repository.save(new MyEntity3350().setCustomFieldText("test data text"));
		MyEntity3350Pick myEntity3350PickGroup = repositoryPick.save(new MyEntity3350Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3350PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3350PickGroup.getId())));
	}

}