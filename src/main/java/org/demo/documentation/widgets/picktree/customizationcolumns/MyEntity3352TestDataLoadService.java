package org.demo.documentation.widgets.picktree.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3352TestDataLoadService {

	@Autowired
	MyEntity3352Repository repository;

	@Autowired
	MyEntity3352PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3352().setCustomField("test data"));
		repository.save(new MyEntity3352().setCustomField("test data2"));
		repository.save(new MyEntity3352().setCustomField("test data3"));

		repositoryPick.save(new MyEntity3352Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3352Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3352Pick().setCustomField("test data3"));
		MyEntity3352Pick myEntity3352PickGroup = repositoryPick.save(new MyEntity3352Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3352PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3352PickGroup.getId())));
	}

}