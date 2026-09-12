package org.demo.documentation.fields.picktree.placeholder;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3287TestDataLoadService {

	@Autowired
	MyEntity3287Repository repository;

	@Autowired
	MyEntity3287PickRepository repository3287Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3287());
		MyEntity3287Pick myEntity3287PickGroup = repository3287Pick.save(new MyEntity3287Pick().setCustomField("Test group"));
		repository3287Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3287PickGroup.getId()))
				.forEach(e -> repository3287Pick.save(e.setParentId(myEntity3287PickGroup.getId())));
	}

}