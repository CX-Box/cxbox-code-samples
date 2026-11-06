package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3296TestDataLoadService {

	@Autowired
	MyEntity3296Repository repository;

	@Autowired
	MyEntity3296ConfigRepository configRepository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		configRepository.deleteAll();

		// default hierarchy, stored in DB
		configRepository.save(new MyEntity3296Config()
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH)
				.setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH)
				.setDefaultExpanded(true));
		configRepository.save(new MyEntity3296Config()
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH)
				.setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE));
		configRepository.save(new MyEntity3296Config()
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE));

		// data rows
		repository.save(new MyEntity3296()
				.setCustomField("test data 1")
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH)
				.setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH));
		repository.save(new MyEntity3296()
				.setCustomField("test data 2")
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW)
				.setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW));
	}

}
