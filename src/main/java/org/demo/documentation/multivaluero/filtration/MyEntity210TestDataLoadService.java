package org.demo.documentation.multivaluero.filtration;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity210TestDataLoadService {

	@Autowired
	MyEntity210Repository repository;

	@Autowired
	MyEntity211Repository repository211;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository211.save(new MyEntity211().setCustomField("Test data"));
		repository.save(new MyEntity210());
	}

}