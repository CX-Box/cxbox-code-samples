package org.demo.documentation.fields.percent.additionalproperties.nullable;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity58TestDataLoadService {

	@Autowired
	MyEntity58Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity58().setCustomField(Long.valueOf(27)));
		repository.save(new MyEntity58().setCustomField(null));
	}

}