package org.demo.documentation.fields.inlinepicklist.validationannotation;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity281TestDataLoadService {

	@Autowired
	MyEntity281Repository repository;

	@Autowired
	MyEntity280Repository repository280;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity280 myEntity280 = new MyEntity280().setCustomField("Test123 data");
		repository280.save(myEntity280);
		repository.save(new MyEntity281().setCustomFieldEntity(myEntity280));
	}

}