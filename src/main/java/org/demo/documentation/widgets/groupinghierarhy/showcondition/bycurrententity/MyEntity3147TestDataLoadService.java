package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;

import org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3147TestDataLoadService {

    @Autowired
    MyEntity3147Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3147().setCustomField(4L).setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
        repository.save(new MyEntity3147().setCustomField(8L).setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
        repository.save(new MyEntity3147().setCustomField(9L).setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
    }

}