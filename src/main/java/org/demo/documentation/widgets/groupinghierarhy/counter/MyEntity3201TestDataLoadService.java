package org.demo.documentation.widgets.groupinghierarhy.counter;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.counter.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3201TestDataLoadService {

    @Autowired
    MyEntity3201Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3201().setCustomField("test data 1").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
        repository.save(new MyEntity3201().setCustomField("test data 2").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3201().setCustomField("test data 3").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
        repository.save(new MyEntity3201().setCustomField("test data 4").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
        repository.save(new MyEntity3201().setCustomField("test data 5").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3201().setCustomField("test data 6"));
        repository.save(new MyEntity3201().setCustomField("test data 7"));
        repository.save(new MyEntity3201().setCustomField("test data 8").setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
        repository.save(new MyEntity3201().setCustomField("test data 9"));
    }

}