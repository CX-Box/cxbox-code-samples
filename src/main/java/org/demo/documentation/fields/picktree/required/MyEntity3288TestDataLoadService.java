package org.demo.documentation.fields.picktree.required;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3288TestDataLoadService {

	@Autowired
	MyEntity3288Repository repository;

	@Autowired
	MyEntity3288PickRepository repository3288Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3288Pick myEntity3288Pick = new MyEntity3288Pick().setCustomField("Test data");
		repository3288Pick.save(myEntity3288Pick);
		repository.save(new MyEntity3288().setCustomFieldEntity(myEntity3288Pick));
		MyEntity3288Pick myEntity3288PickGroup = repository3288Pick.save(new MyEntity3288Pick().setCustomField("Test group"));
		repository3288Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3288PickGroup.getId()))
				.forEach(e -> repository3288Pick.save(e.setParentId(myEntity3288PickGroup.getId())));
	}

}