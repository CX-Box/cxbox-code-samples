package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.threelevel.enums.CustomFieldDictionaryEnum;
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
        repository.save(new MyEntity3165().setCustomField("test data5").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE).setCustomFieldDictionaryLevelTwo(CustomFieldDictionaryLevelTwoEnum.LEVEL_2_HIGH));

    }

}