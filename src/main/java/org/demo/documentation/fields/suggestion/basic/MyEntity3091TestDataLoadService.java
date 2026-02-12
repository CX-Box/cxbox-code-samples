package org.demo.documentation.fields.suggestion.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.suggestion.basic.listvalues.MyEntity4601;
import org.demo.documentation.fields.suggestion.basic.listvalues.MyEntity4601Repository;
import org.demo.documentation.fields.suggestion.basic.microservice.forfield.MyEntity3091;
import org.demo.documentation.fields.suggestion.basic.microservice.forfield.MyEntity3091Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3091TestDataLoadService {

	@Autowired
	MyEntity3091Repository repository;

	@Autowired
	MyEntity4601Repository repository4601;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository4601.deleteAll();
		repository.save(new MyEntity3091());
		repository4601.save(new MyEntity4601());
	}

}