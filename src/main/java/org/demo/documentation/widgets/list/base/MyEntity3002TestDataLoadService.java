package org.demo.documentation.widgets.list.base;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;

@Service
public class MyEntity3002TestDataLoadService {

	@Autowired
    MyEntity3002Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3002().setCustomField("Test data"));
		repository.save(new MyEntity3002().setCustomField("Test data2"));
		repository.save(new MyEntity3002().setCustomField("Test data3"));
	}

}