package org.demo.documentation.fields.picklist.required;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity112TestDataLoadService {

	@Autowired
	MyEntity112Repository repository;

	@Autowired
	MyEntity127Repository repository127;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity127 myEntity127 = new MyEntity127().setCustomField("Test data");
		repository127.save(myEntity127);
		repository.save(new MyEntity112().setCustomFieldEntity(myEntity127));
	}

}