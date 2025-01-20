package org.demo.documentation.fields.inlinepicklist.color;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135;
import org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity134TestDataLoadService {

	@Autowired
	MyEntity134Repository repository;

	@Autowired
	MyEntity135Repository repository135;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository135.deleteAll();
		MyEntity135 myEntity135 = new MyEntity135().setCustomField("Test data");
		repository135.save(myEntity135);
		repository.save(new MyEntity134().setCustomFieldEntity(myEntity135));
	}

}