package org.demo.documentation.fields.picktree.ro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3289TestDataLoadService {

	@Autowired
	MyEntity3289Repository repository;

	@Autowired
	MyEntity3289PickRepository repository3289Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3289Pick.deleteAll();
		MyEntity3289Pick myEntity3289Pick = new MyEntity3289Pick().setCustomField("Test data");
		repository3289Pick.save(myEntity3289Pick);
		repository.save(new MyEntity3289().setCustomFieldEntity(myEntity3289Pick));
		MyEntity3289Pick myEntity3289PickGroup = repository3289Pick.save(new MyEntity3289Pick().setCustomField("Test group"));
		repository3289Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3289PickGroup.getId()))
				.forEach(e -> repository3289Pick.save(e.setParentId(myEntity3289PickGroup.getId())));
	}

}