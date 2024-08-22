package org.demo.documentation.widgets.list.showcondition.byparententity;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class MyEntity3100TestDataLoadService {

    @Autowired
    MyEntity3100Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3100().setCustomField(8L));
    }

}