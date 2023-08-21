package org.demo.documentation.inlinepicklist.filtration;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.filtration.picklist.MyEntity143;
import org.demo.documentation.inlinepicklist.filtration.picklist.MyEntity143Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity142TestDataLoadService {

	@Autowired
	MyEntity142Repository repository;

	@Autowired
	MyEntity143Repository repository143;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository143.deleteAll();
		MyEntity143 myEntity1 = new MyEntity143().setCustomField("Test data");
		repository143.save(myEntity1);
		repository.save(new MyEntity142().setCustomFieldEntity(myEntity1));
		MyEntity143 myEntity2 = new MyEntity143().setCustomField("Abs data");
		repository143.save(myEntity2);
		repository.save(new MyEntity142().setCustomFieldEntity(myEntity2));
		MyEntity143 myEntity3 = new MyEntity143().setCustomField("Test12 data");
		repository143.save(myEntity3);
		repository.save(new MyEntity142().setCustomFieldEntity(myEntity3));
	}

}