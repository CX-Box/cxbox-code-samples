package org.demo.documentation.widgets.groupinghierarhy.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.sorting.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3176TestDataLoadService {

    @Autowired
    MyEntity3176Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3176().setCustomField("1 test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3176().setCustomField("2 test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3176().setCustomField("3 test data"));
        repository.save(new MyEntity3176().setCustomField("4 test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
        repository.save(new MyEntity3176().setCustomField("5 test data"));
        repository.save(new MyEntity3176().setCustomField("6 test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
    }

}