package org.demo.documentation.fields.picklist.validationconfirm;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity115TestDataLoadService {

	@Autowired
	MyEntity115Repository repository;

	@Autowired
	MyEntity130Repository repository130;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository130.deleteAll();
		MyEntity130 myEntity130 = new MyEntity130().setCustomField("Test data");
		repository130.save(myEntity130);
		repository.save(new MyEntity115().setCustomFieldEntity(myEntity130));
	}

}