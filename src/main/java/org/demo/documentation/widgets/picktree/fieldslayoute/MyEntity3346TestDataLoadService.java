package org.demo.documentation.widgets.picktree.fieldslayoute;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3346TestDataLoadService {

	@Autowired
	MyEntity3346Repository repository;
	@Autowired
	MyEntity3346PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3346Pick myEntity3346Pick = new MyEntity3346Pick().setCustomFieldPick("Test data");
		repositoryPick.save(myEntity3346Pick);
		repository.save(new MyEntity3346().setCustomFieldEntity(myEntity3346Pick));
		MyEntity3346Pick myEntity3346PickGroup = repositoryPick.save(new MyEntity3346Pick().setCustomFieldPick("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3346PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3346PickGroup.getId())));
	}

}