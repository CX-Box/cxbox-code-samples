package org.demo.documentation.inlinepicklist.basic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132;
import org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity133TestDataLoadService {

	@Autowired
	MyEntity133Repository repository;

	@Autowired
	MyEntity132Repository repository132;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository132.deleteAll();
		MyEntity132 myEntity1 = new MyEntity132().setCustomField("Test data");
		repository132.save(myEntity1);
		MyEntity132 myEntity2 = new MyEntity132().setCustomField("Abs data");
		repository132.save(myEntity2);
		repository.save(new MyEntity133().setCustomFieldEntity(myEntity1));
	}

}