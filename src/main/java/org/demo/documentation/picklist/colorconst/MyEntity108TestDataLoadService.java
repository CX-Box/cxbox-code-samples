package org.demo.documentation.picklist.colorconst;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity108TestDataLoadService {

	@Autowired
	MyEntity108Repository repository;

	@Autowired
	MyEntity122Repository repository122;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository122.deleteAll();
		MyEntity122 myEntity122 = new MyEntity122().setCustomField("Test data");
		repository122.save(myEntity122);
		repository.save(new MyEntity108().setCustomFieldEntity(myEntity122));
	}

}