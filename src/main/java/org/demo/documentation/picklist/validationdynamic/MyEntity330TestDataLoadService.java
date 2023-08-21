package org.demo.documentation.picklist.validationdynamic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity330TestDataLoadService {

	@Autowired
	MyEntity330Repository repository;

	@Autowired
	MyEntity331Repository repository331;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository331.deleteAll();
		MyEntity331 myEntity331 = new MyEntity331().setCustomField("Test data 123")
				.setCustomFieldAdditional("Test data 123");
		repository331.save(myEntity331);
		repository.save(new MyEntity330().setCustomFieldEntity(myEntity331));
	}

}