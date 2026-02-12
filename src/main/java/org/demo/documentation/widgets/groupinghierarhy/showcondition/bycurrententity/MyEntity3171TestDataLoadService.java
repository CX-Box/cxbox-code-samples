package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3171TestDataLoadService {

	@Autowired
	MyEntity3171Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3171().setCustomField(3L).setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3171().setCustomField(8L).setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity3171().setCustomField(5L));
		repository.save(new MyEntity3171().setCustomField(6L).setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
	}

}