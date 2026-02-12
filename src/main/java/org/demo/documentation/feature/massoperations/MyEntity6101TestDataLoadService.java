package org.demo.documentation.feature.massoperations;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.massoperations.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6101TestDataLoadService {

	@Autowired
	MyEntity6101Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity6101().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.ERROR));
		repository.save(new MyEntity6101().setCustomField("test data 2"));
		repository.save(new MyEntity6101().setCustomField("test data 3"));
		repository.save(new MyEntity6101().setCustomField("test data 4"));
		repository.save(new MyEntity6101().setCustomField("test data 5"));
		repository.save(new MyEntity6101().setCustomField("test data 6"));
		repository.save(new MyEntity6101().setCustomField("test data 7"));
	}

}