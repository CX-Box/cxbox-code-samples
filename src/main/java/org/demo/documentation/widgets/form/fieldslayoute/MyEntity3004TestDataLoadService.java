package org.demo.documentation.widgets.form.fieldslayoute;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;

@Service
public class MyEntity3004TestDataLoadService {

    @Autowired
    MyEntity3004Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3004()
                .setCustomField("Test data")
                .setCustomField2("Test data")
                .setCustomField3("Test data")
                .setCustomField4("Test data")
                .setCustomField5("Test data")
                .setCustomField6("Test data")
        );
    }

}