package org.demo.documentation.widgets.additionalinfo.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4231TestDataLoadService {

	@Autowired
	MyEntity4231Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4231().setCustomField("test data"));
		repository.save(new MyEntity4231().setCustomField("test data2").setCustomFieldNum(6L));
	}

}