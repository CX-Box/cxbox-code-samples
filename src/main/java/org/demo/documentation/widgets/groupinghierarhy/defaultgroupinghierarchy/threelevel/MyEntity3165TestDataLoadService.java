package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelThreeEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3165TestDataLoadService {

    @Autowired
    MyEntity3165Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3165().setCustomField("test data7").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_HIGH));
        repository.save(new MyEntity3165().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_LOW));
        repository.save(new MyEntity3165().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_HIGH));
        repository.save(new MyEntity3165().setCustomField("test data3").setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW));
        repository.save(new MyEntity3165().setCustomField("test data4").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW));
        repository.save(new MyEntity3165().setCustomField("test data5"));
        repository.save(new MyEntity3165().setCustomField("test data6").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH));
        repository.save(new MyEntity3165().setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH));
       /* repository.save(new MyEntity3165().setCustomField("test data8").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH));
        repository.save(new MyEntity3165().setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH));
        repository.save(new MyEntity3165().setCustomField("test data9").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_HIGH));
        repository.save(new MyEntity3165().setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_HIGH));
        repository.save(new MyEntity3165().setCustomField("test data10").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelThree(CustomFieldDictionaryLevelThreeEnum.LEVEL_3_LOW));
     */
    }

}