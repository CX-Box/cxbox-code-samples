package org.demo.documentation.fields.picktree.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3282TestDataLoadService {

	@Autowired
	MyEntity3282Repository repository;

	@Autowired
	MyEntity3282PickRepository repository3282Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3282Pick.deleteAll();
		MyEntity3282Pick myEntity1 = new MyEntity3282Pick().setCustomField("Test data");
		MyEntity3282Pick myEntity3 = new MyEntity3282Pick().setCustomField("Data");
		repository3282Pick.save(myEntity1);
		repository3282Pick.save(myEntity3);
		repository.save(new MyEntity3282().setCustomFieldEntity(myEntity1));
		MyEntity3282Pick myEntity2 = new MyEntity3282Pick().setCustomField("New data");
		repository3282Pick.save(myEntity2);
		repository.save(new MyEntity3282().setCustomFieldEntity(myEntity2));
		MyEntity3282Pick myEntity3282PickGroup = repository3282Pick.save(new MyEntity3282Pick().setCustomField("Test group"));
		repository3282Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3282PickGroup.getId()))
				.forEach(e -> repository3282Pick.save(e.setParentId(myEntity3282PickGroup.getId())));
	}

}