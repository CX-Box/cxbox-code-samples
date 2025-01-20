package org.demo.documentation.widgets.picklist.title.withtitle;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3068TestDataLoadService {

    @Autowired
    MyEntity3068Repository repository;

    @Autowired
    MyEntity3068PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3068Pick myEntity3068Pick = new MyEntity3068Pick().setCustomFieldPick("Test data") ;
        repositoryPick.save(myEntity3068Pick);
        repository.save(new MyEntity3068().setCustomFieldEntity(myEntity3068Pick));
    }


}