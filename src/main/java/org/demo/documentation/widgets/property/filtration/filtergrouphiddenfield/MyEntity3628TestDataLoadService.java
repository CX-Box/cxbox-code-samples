package org.demo.documentation.widgets.property.filtration.filtergrouphiddenfield;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.filtration.filtergrouphiddenfield.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3628TestDataLoadService {

	@Autowired
	MyEntity3628Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3628().setCustomField("test data 1").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomFieldCheckbox(false));
		repository.save(new MyEntity3628().setCustomField("test data 2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW).setCustomFieldCheckbox(true));
		repository.save(new MyEntity3628().setCustomField("test data 3").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3628().setCustomField("test data 4"));
		repository.save(new MyEntity3628().setCustomField("test data 5"));
	}

}