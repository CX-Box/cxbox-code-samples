package org.demo.documentation.inlinepicklist.drilldown;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141;
import org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity140TestDataLoadService {

	@Autowired
	MyEntity140Repository repository;

	@Autowired
	MyEntity141Repository repository141;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository141.deleteAll();
		MyEntity141 myEntity141 = new MyEntity141().setCustomField("Test data");
		repository141.save(myEntity141);
		repository.save(new MyEntity140().setCustomFieldEntity(myEntity141));
	}

}