package org.demo.documentation.fields.picktree.validationbusinessex;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3292TestDataLoadService {

	@Autowired
	MyEntity3292Repository repository;

	@Autowired
	MyEntity3292PickRepository repository3292Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3292Pick.deleteAll();
		MyEntity3292Pick myEntity1 = new MyEntity3292Pick().setCustomField("Test data");
		repository3292Pick.save(myEntity1);
		MyEntity3292Pick myEntity2 = new MyEntity3292Pick().setCustomField("1234");
		repository3292Pick.save(myEntity2);
		repository.save(new MyEntity3292().setCustomFieldEntity(myEntity1));
		MyEntity3292Pick myEntity3292PickGroup = repository3292Pick.save(new MyEntity3292Pick().setCustomField("Test group"));
		repository3292Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3292PickGroup.getId()))
				.forEach(e -> repository3292Pick.save(e.setParentId(myEntity3292PickGroup.getId())));
	}

}