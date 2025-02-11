package org.demo.documentation.widgets.picklist.title.calculatedtitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3071TestDataLoadService {

    @Autowired
    MyEntity3071Repository repository;

    @Autowired
    MyEntity3071PickRepository repositoryPick;


    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3071Pick myEntity3071Pick = new MyEntity3071Pick().setCustomFieldPick("Test data Pick") ;
        repositoryPick.save(myEntity3071Pick);
        repository.save(new MyEntity3071().setCustomFieldEntity(myEntity3071Pick));
    }

}