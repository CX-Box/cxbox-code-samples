package org.demo.documentation.fields.money.currency.fieldkey;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3151TestDataLoadService {

	@Autowired
	MyEntity3151Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.deleteAll();
		repository.save(new MyEntity3151().setCustomField(Double.valueOf(27000.78)));
		repository.save(new MyEntity3151().setCustomField(Double.valueOf(87000.78)));
		repository.save(new MyEntity3151().setCustomField(Double.valueOf(27000.32)));
		repository.save(new MyEntity3151().setCustomField(Double.valueOf(27000.78)));
		repository.save(new MyEntity3151().setCustomField(Double.valueOf(34567.00)));
	}

}