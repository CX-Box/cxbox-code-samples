package org.demo.documentation.inlinepicklist.placeholder;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.placeholder.picklist.MyEntity145Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity144TestDataLoadService {

	@Autowired
	MyEntity144Repository repository;

	@Autowired
	MyEntity145Repository repository145;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity144());
	}

}