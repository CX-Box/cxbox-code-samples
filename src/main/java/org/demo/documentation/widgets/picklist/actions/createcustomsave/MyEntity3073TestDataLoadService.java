package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3073TestDataLoadService {

    @Autowired
    MyEntity3073Repository repository;

    @Autowired
    MyEntity3073PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryPick.deleteAll();

        repository.save(new MyEntity3073().setCustomFieldRequred("test data"));
        repositoryPick.save(new MyEntity3073Pick().setCustomField("test data pick"));
    }

}