package org.demo.documentation.widgets.headerwidget.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.child.MyEntity5029;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.child.MyEntity5029Repository;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent.MyEntity5030;
import org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent.MyEntity5030Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5029TestDataLoadService {

    @Autowired
    MyEntity5029Repository repository;

    @Autowired
    MyEntity5030Repository repository5030;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository5030.deleteAll();

        repository.save(new MyEntity5029().setCustomField("test data"));

        repository5030.save(new MyEntity5030().setCustomField(3L));
        repository5030.save(new MyEntity5030().setCustomField(1L));
        repository5030.save(new MyEntity5030().setCustomField(300L));
    }

}