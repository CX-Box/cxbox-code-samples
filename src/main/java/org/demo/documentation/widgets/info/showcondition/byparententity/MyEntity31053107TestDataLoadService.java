package org.demo.documentation.widgets.info.showcondition.byparententity;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyEntity3107;
import org.demo.documentation.widgets.info.showcondition.byparententity.child.MyEntity3107Repository;
import org.demo.documentation.widgets.info.showcondition.byparententity.parent.MyEntity3105;
import org.demo.documentation.widgets.info.showcondition.byparententity.parent.MyEntity3105Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class MyEntity31053107TestDataLoadService {

    @Autowired
    MyEntity3105Repository repository;
    @Autowired
    MyEntity3107Repository repository3107;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3105 myEntity3105 = new MyEntity3105().setCustomField(7l);
        repository.save(myEntity3105);
        repository.save(myEntity3105);
        repository3107.save(new MyEntity3107().setCustomFieldEntity(myEntity3105).setCustomField("Test data"));
    }

}