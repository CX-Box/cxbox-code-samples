package org.demo.documentation.multivaluehover.validationconfirm;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity243TestDataLoadService {

	@Autowired
	MyEntity243Repository repository;

	@Autowired
	MyEntity244Repository repository244;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository244.save(new MyEntity244().setCustomField("Test data"));
		repository.save(new MyEntity243());
	}

}