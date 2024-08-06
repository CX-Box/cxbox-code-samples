package org.demo.documentation.widgets.groupinghierarhy.base;

import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyEntity3121TestDataLoadService {

    @Autowired
    MyEntity3121Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3121().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3121().setCustomField("test data 2").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3121().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3121().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3121().setCustomField("test data 5").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3121().setCustomField("test data 6"));
        repository.save(new MyEntity3121().setCustomField("test data 7"));
        repository.save(new MyEntity3121().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
        repository.save(new MyEntity3121().setCustomField("test data 9"));

    }

}