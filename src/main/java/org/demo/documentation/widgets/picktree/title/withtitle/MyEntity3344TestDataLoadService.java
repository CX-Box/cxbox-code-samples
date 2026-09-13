package org.demo.documentation.widgets.picktree.title.withtitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3344TestDataLoadService {

	@Autowired
	MyEntity3344Repository repository;

	@Autowired
	MyEntity3344PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3344Pick myEntity3344Pick = new MyEntity3344Pick().setCustomFieldPick("Test data");
		repositoryPick.save(myEntity3344Pick);
		repository.save(new MyEntity3344().setCustomFieldEntity(myEntity3344Pick));
		MyEntity3344Pick myEntity3344PickGroup = repositoryPick.save(new MyEntity3344Pick().setCustomFieldPick("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3344PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3344PickGroup.getId())));
	}


}