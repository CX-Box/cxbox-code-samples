package org.demo.documentation.fields.picktree.colorconst;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3284TestDataLoadService {

	@Autowired
	MyEntity3284Repository repository;

	@Autowired
	MyEntity3284PickRepository repository3284Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3284Pick.deleteAll();
		MyEntity3284Pick myEntity3284Pick = new MyEntity3284Pick().setCustomField("Test data");
		repository3284Pick.save(myEntity3284Pick);
		repository.save(new MyEntity3284().setCustomFieldEntity(myEntity3284Pick));
		MyEntity3284Pick myEntity3284PickGroup = repository3284Pick.save(new MyEntity3284Pick().setCustomField("Test group"));
		repository3284Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3284PickGroup.getId()))
				.forEach(e -> repository3284Pick.save(e.setParentId(myEntity3284PickGroup.getId())));
	}

}