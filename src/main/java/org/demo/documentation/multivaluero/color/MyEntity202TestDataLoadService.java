package org.demo.documentation.multivaluero.color;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity202TestDataLoadService {

	@Autowired
	MyEntity202Repository repository;

	@Autowired
	MyEntity203Repository repository203;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository203.save(new MyEntity203().setCustomField("Test data"));
		repository.save(new MyEntity202());
	}

}