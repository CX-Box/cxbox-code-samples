package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.fourlevel.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3155TestDataLoadService {

    @Autowired
    MyEntity3155Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3155().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW));
        //repository.save(new MyEntity3155().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_LOW));
        //repository.save(new MyEntity3155().setCustomField("test data3"));
        //repository.save(new MyEntity3155().setCustomField("test data4").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE));
        //repository.save(new MyEntity3155().setCustomField("test data5"));
        //repository.save(new MyEntity3155().setCustomField("test data6").setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH));
        //repository.save(new MyEntity3155().setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE));
        //repository.save(new MyEntity3155().setCustomFieldDictionary(CustomFieldDictionaryEnum.LEVEL_1_HIGH));
    }

}