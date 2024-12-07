package org.demo.documentation.fields.dictionary.dictionarydictionary.old.icon;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.dictionary.dictionarydictionary.old.AdministeredDictionaryTypeOld.REGIONS;

@Service
public class MyEntity351TestDataLoadService {

    @Autowired
    MyEntity351Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity351().setCustomField("test data").setCustomFieldDictionary(REGIONS.lookupName("Kostroma")));
    }

}