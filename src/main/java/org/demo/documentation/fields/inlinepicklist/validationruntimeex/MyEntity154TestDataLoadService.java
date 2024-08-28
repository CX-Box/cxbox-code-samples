package org.demo.documentation.fields.inlinepicklist.validationruntimeex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155;
import org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity154TestDataLoadService {

	@Autowired
	MyEntity154Repository repository;

	@Autowired
	MyEntity155Repository repository155;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository155.deleteAll();
		MyEntity155 myEntity155 = new MyEntity155().setCustomField("Test data");
		repository155.save(myEntity155);
		repository.save(new MyEntity154().setCustomFieldEntity(myEntity155));
	}

}