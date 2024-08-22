package org.demo.documentation.fields.picklist.color;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity119TestDataLoadService {

	@Autowired
	MyEntity119Repository repository;

	@Autowired
	MyEntity121Repository repository121;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository121.deleteAll();
		MyEntity121 myEntity121 = new MyEntity121().setCustomField("Test data");
		repository121.save(myEntity121);
		repository.save(new MyEntity119().setCustomFieldEntity(myEntity121));
	}

}