package org.demo.documentation.fields.picklist.drilldown;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity110TestDataLoadService {

	@Autowired
	MyEntity110Repository repository;

	@Autowired
	MyEntity124Repository repository124;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository124.deleteAll();
		MyEntity124 myEntity124 = new MyEntity124().setCustomField("Test data");
		repository124.save(myEntity124);
		repository.save(new MyEntity110().setCustomFieldEntity(myEntity124));
	}

}