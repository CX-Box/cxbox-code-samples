package org.demo.documentation.fields.picktree.validationdynamic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3294TestDataLoadService {

	@Autowired
	MyEntity3294Repository repository;

	@Autowired
	MyEntity3294PickRepository repository3294Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3294Pick.deleteAll();
		MyEntity3294Pick myEntity3294Pick = new MyEntity3294Pick().setCustomField("Test data 123")
				.setCustomFieldAdditional("Test data 123");
		repository3294Pick.save(myEntity3294Pick);
		repository.save(new MyEntity3294().setCustomFieldEntity(myEntity3294Pick));
		MyEntity3294Pick myEntity3294PickGroup = repository3294Pick.save(new MyEntity3294Pick().setCustomField("Test group"));
		repository3294Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3294PickGroup.getId()))
				.forEach(e -> repository3294Pick.save(e.setParentId(myEntity3294PickGroup.getId())));
	}

}