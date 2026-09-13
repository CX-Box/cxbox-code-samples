package org.demo.documentation.widgets.picktree.title.calculatedtitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3347TestDataLoadService {

	@Autowired
	MyEntity3347Repository repository;

	@Autowired
	MyEntity3347PickRepository repositoryPick;


	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3347Pick myEntity3347Pick = new MyEntity3347Pick().setCustomFieldPick("Test data Pick");
		repositoryPick.save(myEntity3347Pick);
		repository.save(new MyEntity3347().setCustomFieldEntity(myEntity3347Pick));
		MyEntity3347Pick myEntity3347PickGroup = repositoryPick.save(new MyEntity3347Pick().setCustomFieldPick("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3347PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3347PickGroup.getId())));
	}

}