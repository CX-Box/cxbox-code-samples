package org.demo.documentation.widgets.groupinghierarhy.colortitle;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.widgets.groupinghierarhy.colortitle.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyEntity3133TestDataLoadService {

    @Autowired
    MyEntity3133Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3133().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3133().setCustomField("test data 2").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3133().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3133().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3133().setCustomField("test data 5").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3133().setCustomField("test data 6"));
        repository.save(new MyEntity3133().setCustomField("test data 7"));
        repository.save(new MyEntity3133().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
        repository.save(new MyEntity3133().setCustomField("test data 9"));
    }

}