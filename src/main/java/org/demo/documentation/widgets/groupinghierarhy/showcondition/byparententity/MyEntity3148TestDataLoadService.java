package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child.MyEntity3148;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child.MyEntity3148Repository;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyEntity3149Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3148TestDataLoadService {

    @Autowired
    MyEntity3148Repository repository;

    @Autowired
    MyEntity3149Repository repositoryParent;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3148().setCustomField("test data"));
    }

}