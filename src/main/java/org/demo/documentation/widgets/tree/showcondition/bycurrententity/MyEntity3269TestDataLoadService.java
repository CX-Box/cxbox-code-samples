package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3269TestDataLoadService {

	@Autowired
	MyEntity3269Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3269().setCustomField(4L));
		repository.save(new MyEntity3269().setCustomField(8L));
		repository.save(new MyEntity3269().setCustomField(9L));
	}

}