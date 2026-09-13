package org.demo.documentation.fields.picktree.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3286TestDataLoadService {

	@Autowired
	MyEntity3286Repository repository;

	@Autowired
	MyEntity3286PickRepository repository3286Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3286Pick.deleteAll();
		MyEntity3286Pick myEntity1 = new MyEntity3286Pick().setCustomField("Test data");
		repository3286Pick.save(myEntity1);
		repository.save(new MyEntity3286().setCustomFieldEntity(myEntity1));
		MyEntity3286Pick myEntity2 = new MyEntity3286Pick().setCustomField("New data");
		repository3286Pick.save(myEntity2);
		repository.save(new MyEntity3286().setCustomFieldEntity(myEntity2));
		MyEntity3286Pick myEntity3 = new MyEntity3286Pick().setCustomField("Abs data");
		repository3286Pick.save(myEntity3);
		repository.save(new MyEntity3286().setCustomFieldEntity(myEntity3));
		MyEntity3286Pick myEntity3286PickGroup = repository3286Pick.save(new MyEntity3286Pick().setCustomField("Test group"));
		repository3286Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3286PickGroup.getId()))
				.forEach(e -> repository3286Pick.save(e.setParentId(myEntity3286PickGroup.getId())));
	}

}