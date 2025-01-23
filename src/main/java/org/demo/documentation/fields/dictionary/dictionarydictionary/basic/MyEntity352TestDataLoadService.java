package org.demo.documentation.fields.dictionary.dictionarydictionary.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity352TestDataLoadService {

    @Autowired
    MyEntity352Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity352().setCustomField("test data2").setCustomFieldDictionary(Regions.MOSCOW));
        repository.save(new MyEntity352().setCustomField("test data").setCustomFieldDictionary(Regions.SAINT_PETERBURG));
    }

}