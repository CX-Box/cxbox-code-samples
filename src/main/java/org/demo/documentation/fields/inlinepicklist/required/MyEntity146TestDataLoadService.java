package org.demo.documentation.fields.inlinepicklist.required;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147;
import org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity146TestDataLoadService {

	@Autowired
	MyEntity146Repository repository;

	@Autowired
	MyEntity147Repository repository147;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository147.deleteAll();
		MyEntity147 myEntity147 = new MyEntity147().setCustomField("Test data");
		repository147.save(myEntity147);
		repository.save(new MyEntity146().setCustomFieldEntity(myEntity147));
	}

}