package org.demo.documentation.fields.dictionary.dictionarydictionary.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity106TestDataLoadService {

    @Autowired
    MyEntity106Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity106().setCustomField("test data").setCustomFieldDictionary(CustomDictionarySorting.HIGH));
        repository.save(new MyEntity106().setCustomField("test data2").setCustomFieldDictionary(CustomDictionarySorting.MIDDLE));
        repository.save(new MyEntity106().setCustomField("test data3").setCustomFieldDictionary(CustomDictionarySorting.MIDDLE));
        repository.save(new MyEntity106().setCustomField("test data4"));
        repository.save(new MyEntity106().setCustomField("test data5"));
    }

}