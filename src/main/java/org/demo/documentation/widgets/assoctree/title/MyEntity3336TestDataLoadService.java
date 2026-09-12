package org.demo.documentation.widgets.assoctree.title;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3336TestDataLoadService {

	@Autowired
	MyEntity3336Repository repository;

	@Autowired
	MyEntity3336MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3336().setCustomField("test data"));
		repository.save(new MyEntity3336().setCustomField("test data2"));

		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3336Multi().setCustomField("test data"));
		MyEntity3336Multi myEntity3336MultiGroup = repositoryMulti.save(new MyEntity3336Multi().setCustomField("Test group"));
		repositoryMulti.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3336MultiGroup.getId()))
				.forEach(e -> repositoryMulti.save(e.setParentId(myEntity3336MultiGroup.getId())));
	}

}