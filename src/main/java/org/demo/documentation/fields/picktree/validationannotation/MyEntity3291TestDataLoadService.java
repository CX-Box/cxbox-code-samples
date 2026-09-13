package org.demo.documentation.fields.picktree.validationannotation;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3291TestDataLoadService {

	@Autowired
	MyEntity3291Repository repository;

	@Autowired
	MyEntity3291PickRepository repository3291Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3291Pick.deleteAll();
		MyEntity3291Pick myEntity3291Pick = new MyEntity3291Pick().setCustomField("Test123 data");
		repository3291Pick.save(myEntity3291Pick);
		repository.save(new MyEntity3291().setCustomFieldEntity(myEntity3291Pick));
		MyEntity3291Pick myEntity3291PickGroup = repository3291Pick.save(new MyEntity3291Pick().setCustomField("Test group"));
		repository3291Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3291PickGroup.getId()))
				.forEach(e -> repository3291Pick.save(e.setParentId(myEntity3291PickGroup.getId())));
	}

}