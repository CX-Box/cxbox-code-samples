package org.demo.documentation.fields.picklist.validationannotation;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity296TestDataLoadService {

	@Autowired
	MyEntity296Repository repository;

	@Autowired
	MyEntity297Repository repository297;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository297.deleteAll();
		MyEntity297 myEntity297 = new MyEntity297().setCustomField("Test123 data");
		repository297.save(myEntity297);
		repository.save(new MyEntity296().setCustomFieldEntity(myEntity297));
	}

}