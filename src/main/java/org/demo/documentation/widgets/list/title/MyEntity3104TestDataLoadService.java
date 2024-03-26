package org.demo.documentation.widgets.list.title;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;

@Service
public class MyEntity3104TestDataLoadService {

    @Autowired
    MyEntity3104Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3104().setCustomField("Test data"));
        repository.save(new MyEntity3104().setCustomField("Test data2"));
        repository.save(new MyEntity3104().setCustomField("Test data3"));
    }

}