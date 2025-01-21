package org.demo.documentation.widgets.picklist.title.withouttitle;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3069TestDataLoadService {

    @Autowired
    MyEntity3069Repository repository;

    @Autowired
    MyEntity3069PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3069Pick myEntity3069Pick = new MyEntity3069Pick().setCustomFieldPick("Test data") ;
        repositoryPick.save(myEntity3069Pick);
        repository.save(new MyEntity3069().setCustomFieldEntity(myEntity3069Pick));
    }


}