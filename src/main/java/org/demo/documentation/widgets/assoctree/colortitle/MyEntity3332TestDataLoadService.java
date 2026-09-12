package org.demo.documentation.widgets.assoctree.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3332TestDataLoadService {

	@Autowired
	MyEntity3332Repository repository;

	@Autowired
	MyEntity3332MultiRepository repositoryMulti;


	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3332());
		repositoryMulti.deleteAll();
		repositoryMulti.save(new MyEntity3332Multi().setCustomField("Test data").setCustomFieldText("Test data text"));
		MyEntity3332Multi myEntity3332MultiGroup = repositoryMulti.save(new MyEntity3332Multi().setCustomField("Test group"));
		repositoryMulti.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3332MultiGroup.getId()))
				.forEach(e -> repositoryMulti.save(e.setParentId(myEntity3332MultiGroup.getId())));
	}

}