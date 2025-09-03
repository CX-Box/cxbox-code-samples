package org.demo.documentation.widgets.emptywidget.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035;
import org.demo.documentation.widgets.emptywidget.colortitle.allfields.MyEntity5035Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5031TestDataLoadService {

    @Autowired
    MyEntity5031Repository repository;

    @Autowired
    MyEntity5035Repository repository5035;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository5035.deleteAll();

        repository5035.save(new MyEntity5035().setCustomField("test data"));
        repository.save(new MyEntity5031().setCustomField("test data"));
    }

}