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
        repository.save(new MyEntity3900().setCustomField("Test data").setCustomField2("Test data"));
        repository.save(new MyEntity3900().setCustomField("Test data2").setCustomField2("Test data2"));
        repository.save(new MyEntity3900().setCustomField("Test data3").setCustomField2("Test data3"));
        repository.save(new MyEntity3900().setCustomField("Test data4").setCustomField2("Test data4"));
        repository.save(new MyEntity3900().setCustomField("Test data5").setCustomField2("Test data5"));
    }

}