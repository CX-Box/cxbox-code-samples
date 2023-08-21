package org.demo.documentation.multivaluero.validationconfirm;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity220TestDataLoadService {

	@Autowired
	MyEntity220Repository repository;

	@Autowired
	MyEntity223Repository repository221;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository221.save(new MyEntity223().setCustomField("Test data"));
		repository.save(new MyEntity220());
	}

}