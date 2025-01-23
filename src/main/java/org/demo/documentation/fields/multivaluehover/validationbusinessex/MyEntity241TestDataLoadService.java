package org.demo.documentation.fields.multivaluehover.validationbusinessex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity241TestDataLoadService {

	@Autowired
	MyEntity241Repository repository;

	@Autowired
	MyEntity242Repository repository242;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository242.save(new MyEntity242().setCustomField("Test data"));
		repository.save(new MyEntity241());
	}

}