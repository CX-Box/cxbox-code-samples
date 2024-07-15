package org.demo.documentation.fields.picklist.sorting;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity113TestDataLoadService {

	@Autowired
	MyEntity113Repository repository;

	@Autowired
	MyEntity128Repository repository128;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository128.deleteAll();
		MyEntity128 myEntity1 = new MyEntity128().setCustomField("Test data");
		repository128.save(myEntity1);
		MyEntity128 myEntity2 = new MyEntity128().setCustomField("Abs data");
		repository128.save(myEntity1);
		repository128.save(myEntity2);
		repository.save(new MyEntity113().setCustomFieldEntity(myEntity1));
		repository.save(new MyEntity113().setCustomFieldEntity(myEntity2));
	}

}