package org.demo.documentation.fields.picktree.validationruntimeex;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3295TestDataLoadService {

	@Autowired
	MyEntity3295Repository repository;

	@Autowired
	MyEntity3295PickRepository repository3295Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3295Pick.deleteAll();
		MyEntity3295Pick myEntity3295Pick = new MyEntity3295Pick().setCustomField("Test data");
		repository3295Pick.save(myEntity3295Pick);
		repository.save(new MyEntity3295().setCustomFieldEntity(myEntity3295Pick));
		MyEntity3295Pick myEntity3295PickGroup = repository3295Pick.save(new MyEntity3295Pick().setCustomField("Test group"));
		repository3295Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3295PickGroup.getId()))
				.forEach(e -> repository3295Pick.save(e.setParentId(myEntity3295PickGroup.getId())));
	}

}