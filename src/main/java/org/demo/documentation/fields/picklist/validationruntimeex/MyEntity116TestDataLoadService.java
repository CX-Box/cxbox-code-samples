package org.demo.documentation.fields.picklist.validationruntimeex;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity116TestDataLoadService {

	@Autowired
	MyEntity116Repository repository;

	@Autowired
	MyEntity131Repository repository131;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository131.deleteAll();
		MyEntity131 myEntity131 = new MyEntity131().setCustomField("Test data");
		repository131.save(myEntity131);
		repository.save(new MyEntity116().setCustomFieldEntity(myEntity131));
	}

}