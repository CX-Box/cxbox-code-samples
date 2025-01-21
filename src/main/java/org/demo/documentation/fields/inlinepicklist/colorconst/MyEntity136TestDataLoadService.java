package org.demo.documentation.fields.inlinepicklist.colorconst;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137;
import org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity136TestDataLoadService {

	@Autowired
	MyEntity136Repository repository;

	@Autowired
	MyEntity137Repository repository137;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository137.deleteAll();
		MyEntity137 myEntity137 = new MyEntity137().setCustomField("Test data");
		repository137.save(myEntity137);
		repository.save(new MyEntity136().setCustomFieldEntity(myEntity137));
	}

}