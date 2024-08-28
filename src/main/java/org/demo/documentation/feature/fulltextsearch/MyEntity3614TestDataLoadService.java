package org.demo.documentation.feature.fulltextsearch;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3614TestDataLoadService {

    @Autowired
    MyEntity3614Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3614().setCustomField("test data").setAddress("Moscow, Polevoy 1st, lane, 72").setFullName("Ivanov Ivan"));
        repository.save(new MyEntity3614().setCustomField("test data2").setAddress("Moscow, Polevoy 1st, lane, 72").setFullName("Michael V. Neal"));
        repository.save(new MyEntity3614().setAddress("Moscow, Dmitrov, st. Soviet, 18").setFullName("Michael V. Neal"));
        repository.save(new MyEntity3614().setCustomField("test data3").setFullName("Jared K. Moser"));
        repository.save(new MyEntity3614().setCustomField("test data").setAddress("Moscow, Dmitrov, st. Soviet, 14"));

    }

}