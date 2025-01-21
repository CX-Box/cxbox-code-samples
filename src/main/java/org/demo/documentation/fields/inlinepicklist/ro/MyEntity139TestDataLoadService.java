package org.demo.documentation.fields.inlinepicklist.ro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138;
import org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity139TestDataLoadService {

	@Autowired
	MyEntity139Repository repository;

	@Autowired
	MyEntity138Repository repository138;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository138.deleteAll();
		MyEntity138 myEntity138 = new MyEntity138().setCustomField("Test data");
		repository138.save(myEntity138);
		repository.save(new MyEntity139().setCustomFieldEntity(myEntity138));
	}

}