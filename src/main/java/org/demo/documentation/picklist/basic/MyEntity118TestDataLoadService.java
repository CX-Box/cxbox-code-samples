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
		MyEntity120 myEntity1 = new MyEntity120().setCustomField("Test data");
		MyEntity120 myEntity3 = new MyEntity120().setCustomField("Data");
		repository120.save(myEntity1);
		repository120.save(myEntity3);
		repository.save(new MyEntity118().setCustomFieldEntity(myEntity1));
		MyEntity120 myEntity2 = new MyEntity120().setCustomField("New data");
		repository120.save(myEntity2);
		repository.save(new MyEntity118().setCustomFieldEntity(myEntity2));
	}

}