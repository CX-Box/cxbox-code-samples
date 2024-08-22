package org.demo.documentation.widgets.picklist.fieldslayoute;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3070TestDataLoadService {

    @Autowired
    MyEntity3070Repository repository;
    @Autowired
    MyEntity3070PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3070Pick myEntity3070Pick = new MyEntity3070Pick().setCustomFieldPick("Test data") ;
        repositoryPick.save(myEntity3070Pick);
        repository.save(new MyEntity3070().setCustomFieldEntity(myEntity3070Pick));
    }

}