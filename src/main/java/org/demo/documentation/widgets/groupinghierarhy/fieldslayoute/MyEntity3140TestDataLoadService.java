package org.demo.documentation.widgets.groupinghierarhy.fieldslayoute;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.fieldslayoute.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3140TestDataLoadService {

	@Autowired
	MyEntity3140Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3140().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity3140().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3140().setCustomField("test data3").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity3140().setCustomField("test data4").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));

	}

}