package org.demo.microservicestoringdata;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.microservicestoringdata.repository.MyEntity3900Repository;
import org.demo.microservicestoringdata.repository.entity.MyEntity3900;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class MyEntity3900TestDataLoadService {

    @Autowired
    MyEntity3900Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3900().setCustomField("Test data"));
    }

}