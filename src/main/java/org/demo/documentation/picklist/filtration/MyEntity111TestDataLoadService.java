package org.demo.documentation.picklist.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity111TestDataLoadService {

	@Autowired
	MyEntity111Repository repository;

	@Autowired
	MyEntity125Repository repository125;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository125.deleteAll();
		MyEntity125 myEntity1 = new MyEntity125().setCustomField("Test data");
		repository125.save(myEntity1);
		repository.save(new MyEntity111().setCustomFieldEntity(myEntity1));
		MyEntity125 myEntity2 = new MyEntity125().setCustomField("New data");
		repository125.save(myEntity2);
		repository.save(new MyEntity111().setCustomFieldEntity(myEntity2));
		MyEntity125 myEntity3 = new MyEntity125().setCustomField("Abs data");
		repository125.save(myEntity3);
		repository.save(new MyEntity111().setCustomFieldEntity(myEntity3));
	}

}