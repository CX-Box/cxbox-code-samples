package org.demo.documentation.checkbox.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity53TestDataLoadService {

	@Autowired
	MyEntity53Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity53().setCustomField(Boolean.TRUE));
		repository.save(new MyEntity53().setCustomField(Boolean.FALSE));
		repository.save(new MyEntity53().setCustomField(Boolean.FALSE));
	}

}