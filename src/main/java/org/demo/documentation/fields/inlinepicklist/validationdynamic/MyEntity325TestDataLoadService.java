package org.demo.documentation.fields.inlinepicklist.validationdynamic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity325TestDataLoadService {

	@Autowired
	MyEntity325Repository repository;

	@Autowired
	MyEntity327Repository repository327;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository327.deleteAll();
		MyEntity327 myEntity327 = new MyEntity327().setCustomField("Test data 123")
				.setCustomFieldAdditional("Test data 123");
		repository327.save(myEntity327);
		repository.save(new MyEntity325().setCustomFieldEntity(myEntity327));
	}

}