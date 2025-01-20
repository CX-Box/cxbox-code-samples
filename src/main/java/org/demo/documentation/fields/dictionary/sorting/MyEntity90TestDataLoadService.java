package org.demo.documentation.fields.dictionary.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.dictionary.sorting.enums.CustomFieldDictionaryCustomOrderEnum;
import org.demo.documentation.fields.dictionary.sorting.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity90TestDataLoadService {

	@Autowired
	MyEntity90Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity90().setCustomField(CustomFieldEnum.HIGH).setCustomFieldDictionaryCustomOrder(CustomFieldDictionaryCustomOrderEnum.MIDDLE));
		repository.save(new MyEntity90().setCustomField(CustomFieldEnum.MIDDLE).setCustomFieldDictionaryCustomOrder(CustomFieldDictionaryCustomOrderEnum.HIGH));
		repository.save(new MyEntity90().setCustomField(CustomFieldEnum.LOW).setCustomFieldDictionaryCustomOrder(CustomFieldDictionaryCustomOrderEnum.LOW));
	}

}