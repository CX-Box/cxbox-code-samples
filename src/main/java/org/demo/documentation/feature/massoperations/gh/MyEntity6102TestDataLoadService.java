package org.demo.documentation.feature.massoperations.gh;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.massoperations.gh.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6102TestDataLoadService {

	@Autowired
	MyEntity6102Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity6102().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity6102().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity6102().setCustomField("test data3").setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository.save(new MyEntity6102().setCustomField("test data4").setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository.save(new MyEntity6102().setCustomField("test data5").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity6102().setCustomField("test data6").setCustomFieldDictionary(CustomFieldDictionaryEnum.ERROR));
	}

}
