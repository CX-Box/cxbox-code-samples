package org.demo.documentation.widgets.statsblock.showcondition.data;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4229TestDataLoadService {

    @Autowired
    MyEntity4229Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity4229().setCustomField("test data"));
        repository.save(new MyEntity4229().setCustomField("test data2"));
        repository.save(new MyEntity4229().setCustomField("test data3"));
    }

}