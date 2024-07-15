package org.demo.documentation.fields.picklist.validationdynamic;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity400TestDataLoadService {

	@Autowired
	MyEntity400Repository repository;

	@Autowired
	MyEntity401PickRepository repository401;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository401.deleteAll();
		MyEntity401Pick myEntity401 = new MyEntity401Pick().setCustomField("Test data 123")
				.setCustomFieldAdditional("Test data 123");
		repository401.save(myEntity401);
		repository.save(new MyEntity400().setCustomFieldEntity(myEntity401));
	}

}