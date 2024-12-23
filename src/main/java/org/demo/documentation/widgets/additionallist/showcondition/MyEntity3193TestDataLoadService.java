package org.demo.documentation.widgets.additionallist.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.additionallist.showcondition.bycurrententity.MyEntity3193;
import org.demo.documentation.widgets.additionallist.showcondition.bycurrententity.MyEntity3193Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3193TestDataLoadService {

    @Autowired
    MyEntity3193Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3193().setCustomField(3L).setCustomFieldText("test data text"));
        repository.save(new MyEntity3193().setCustomField(6L).setCustomFieldText("test data text 2"));
    }

}