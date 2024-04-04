package org.demo.documentation.inlinepicklist.validationconfirm;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.validationconfirm.picklist.MyEntity153;
import org.demo.documentation.inlinepicklist.validationconfirm.picklist.MyEntity153Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity152TestDataLoadService {

	@Autowired
	MyEntity152Repository repository;

	@Autowired
	MyEntity153Repository repository153;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository153.deleteAll();
		MyEntity153 myEntity153 = new MyEntity153().setCustomField("Test data");
		repository153.save(myEntity153);
		repository.save(new MyEntity152().setCustomFieldEntity(myEntity153));
	}

}