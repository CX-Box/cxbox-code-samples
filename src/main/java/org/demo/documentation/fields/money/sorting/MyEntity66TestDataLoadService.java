package org.demo.documentation.fields.money.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity66TestDataLoadService {

	@Autowired
	MyEntity66Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity66().setCustomField(Double.valueOf(27000.78)));
		repository.save(new MyEntity66().setCustomField(Double.valueOf(45500.00)));
		repository.save(new MyEntity66().setCustomField(Double.valueOf(89000.22)));
		repository.save(new MyEntity66().setCustomField(Double.valueOf(11001.00)));
	}

}