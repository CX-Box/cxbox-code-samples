package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.twolevel.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3157TestDataLoadService {

    @Autowired
    MyEntity3157Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        // repository.save(new MyEntity3157().setCustomField("test data7").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE));
        // repository.save(new MyEntity3157().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE));
        //repository.save(new MyEntity3157().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_MIDDLE));
        repository.save(new MyEntity3157().setCustomField("test data3").setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_LOW));
        //repository.save(new MyEntity3157().setCustomField("test data5"));
    }

}