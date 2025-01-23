package org.demo.documentation.fields.dictionary.dictionarydictionary.icon;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity355TestDataLoadService {

    @Autowired
    MyEntity355Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity355().setCustomField("test data").setCustomFieldDictionary(CustomDictionary.HIGH));
        repository.save(new MyEntity355().setCustomField("test data").setCustomFieldDictionary(CustomDictionary.MIDDLE));
        repository.save(new MyEntity355().setCustomField("test data").setCustomFieldDictionary(CustomDictionary.UPPER_MIDDLE));
        repository.save(new MyEntity355().setCustomField("test data").setCustomFieldDictionary(CustomDictionary.LOW));
    }

}