package org.demo.documentation.fields.dictionary.icon;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3011TestDataLoadService {

    @Autowired
    MyEntity3011Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
        repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
        repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
    }

}