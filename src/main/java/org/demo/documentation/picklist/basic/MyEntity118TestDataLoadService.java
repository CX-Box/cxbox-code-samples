package org.demo.documentation.picklist.basic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity118TestDataLoadService {

	@Autowired
	MyEntity118Repository repository;

	@Autowired
	MyEntity120Repository repository120;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository120.deleteAll();
		MyEntity120 myEntity120 = new MyEntity120().setCustomField("Test data");
		repository120.save(myEntity120);
		repository.save(new MyEntity118().setCustomFieldEntity(myEntity120));
	}

}