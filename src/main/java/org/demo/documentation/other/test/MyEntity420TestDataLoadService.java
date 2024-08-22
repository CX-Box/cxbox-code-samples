package org.demo.documentation.other.test;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity420TestDataLoadService {

	@Autowired
	MyEntity420Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity420()
				.setCustomFieldForceActive2("Test2").setCustomFieldForceActive3("Test3").setCustomFieldForceActive("Test44")
				.setCustomField2("Test2").setCustomField3("Test3").setCustomField("Test44"));
	}

}