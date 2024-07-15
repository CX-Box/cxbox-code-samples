package org.demo.documentation.fields.inlinepicklist.validationbusinessex;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151;
import org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity150TestDataLoadService {

	@Autowired
	MyEntity150Repository repository;

	@Autowired
	MyEntity151Repository repository151;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository151.deleteAll();
		MyEntity151 myEntity151 = new MyEntity151().setCustomField("Test data");
		repository151.save(myEntity151);
		repository.save(new MyEntity150().setCustomFieldEntity(myEntity151));
	}

}