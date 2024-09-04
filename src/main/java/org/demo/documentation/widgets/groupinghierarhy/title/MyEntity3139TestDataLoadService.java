package org.demo.documentation.widgets.groupinghierarhy.title;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.title.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3139TestDataLoadService {

    @Autowired
    MyEntity3139Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3139().setCustomField("test data1").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3139().setCustomField("test data2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3139().setCustomField("test data3"));
        repository.save(new MyEntity3139().setCustomField("test data4").setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
        repository.save(new MyEntity3139().setCustomField("test data5"));
        repository.save(new MyEntity3139().setCustomField("test data6").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));

    }

}