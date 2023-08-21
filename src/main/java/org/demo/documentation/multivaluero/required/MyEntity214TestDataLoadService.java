package org.demo.documentation.multivaluero.required;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity214TestDataLoadService {

	@Autowired
	MyEntity214Repository repository;

	@Autowired
	MyEntity215Repository repository215;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository215.save(new MyEntity215().setCustomField("Test data"));
		repository.save(new MyEntity214());
	}

}