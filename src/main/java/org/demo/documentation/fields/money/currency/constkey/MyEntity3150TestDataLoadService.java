package org.demo.documentation.fields.money.currency.constkey;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.money.currency.constkey.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3150TestDataLoadService {

	@Autowired
	MyEntity3150Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3150().setCustomField(Double.valueOf(27000.78)).setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3150().setCustomField(Double.valueOf(87000.78)).setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity3150().setCustomField(Double.valueOf(27000.32)).setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository.save(new MyEntity3150().setCustomField(Double.valueOf(27000.78)).setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3150().setCustomField(Double.valueOf(34567.00)));
	}

}