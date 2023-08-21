package org.demo.documentation.picklist.validationbusinessex;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity114TestDataLoadService {

	@Autowired
	MyEntity114Repository repository;

	@Autowired
	MyEntity129Repository repository129;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository129.deleteAll();
		MyEntity129 myEntity1 = new MyEntity129().setCustomField("Test data");
		repository129.save(myEntity1);
		MyEntity129 myEntity2 = new MyEntity129().setCustomField("1234");
		repository129.save(myEntity2);
		repository.save(new MyEntity114().setCustomFieldEntity(myEntity1));
	}

}