package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.defaultexpanded.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3203TestDataLoadService {

	@Autowired
	MyEntity3203Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3203().setCustomField("test data"));
		repository.save(new MyEntity3203().setCustomField("test data7").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));

		repository.save(new MyEntity3203().setCustomField("test data7").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));

		repository.save(new MyEntity3203().setCustomField("test data7").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));
		repository.save(new MyEntity3203().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_MIDDLE));

	}

}