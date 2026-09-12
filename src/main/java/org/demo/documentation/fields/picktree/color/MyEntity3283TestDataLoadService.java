package org.demo.documentation.fields.picktree.color;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3283TestDataLoadService {

	@Autowired
	MyEntity3283Repository repository;

	@Autowired
	MyEntity3283PickRepository repository3283Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3283Pick.deleteAll();
		MyEntity3283Pick myEntity3283Pick = new MyEntity3283Pick().setCustomField("Test data");
		repository3283Pick.save(myEntity3283Pick);
		repository.save(new MyEntity3283().setCustomFieldEntity(myEntity3283Pick));
		MyEntity3283Pick myEntity3283PickGroup = repository3283Pick.save(new MyEntity3283Pick().setCustomField("Test group"));
		repository3283Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3283PickGroup.getId()))
				.forEach(e -> repository3283Pick.save(e.setParentId(myEntity3283PickGroup.getId())));
	}

}