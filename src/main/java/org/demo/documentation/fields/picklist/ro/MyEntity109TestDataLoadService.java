package org.demo.documentation.fields.picklist.ro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity109TestDataLoadService {

	@Autowired
	MyEntity109Repository repository;

	@Autowired
	MyEntity123Repository repository123;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository123.deleteAll();
		MyEntity123 myEntity123 = new MyEntity123().setCustomField("Test data");
		repository123.save(myEntity123);
		repository.save(new MyEntity109().setCustomFieldEntity(myEntity123));
	}

}