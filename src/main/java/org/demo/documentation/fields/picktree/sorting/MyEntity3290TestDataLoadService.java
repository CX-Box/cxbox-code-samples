package org.demo.documentation.fields.picktree.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3290TestDataLoadService {

	@Autowired
	MyEntity3290Repository repository;

	@Autowired
	MyEntity3290PickRepository repository3290Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3290Pick.deleteAll();
		MyEntity3290Pick myEntity1 = new MyEntity3290Pick().setCustomField("Test data");
		repository3290Pick.save(myEntity1);
		MyEntity3290Pick myEntity2 = new MyEntity3290Pick().setCustomField("Abs data");
		repository3290Pick.save(myEntity1);
		repository3290Pick.save(myEntity2);
		repository.save(new MyEntity3290().setCustomFieldEntity(myEntity1));
		repository.save(new MyEntity3290().setCustomFieldEntity(myEntity2));
		MyEntity3290Pick myEntity3290PickGroup = repository3290Pick.save(new MyEntity3290Pick().setCustomField("Test group"));
		repository3290Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3290PickGroup.getId()))
				.forEach(e -> repository3290Pick.save(e.setParentId(myEntity3290PickGroup.getId())));
	}

}