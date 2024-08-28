package org.demo.documentation.fields.hint.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity162TestDataLoadService {

	@Autowired
	MyEntity162Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity162().setCustomField("Test data"));
		repository.save(new MyEntity162().setCustomField("New data"));
		repository.save(new MyEntity162().setCustomField("Test123 data"));
		repository.save(new MyEntity162().setCustomField("Abs data"));
		repository.save(new MyEntity162().setCustomField("Test data"));
	}

}