package org.demo.documentation.fields.datetimewithseconds.validationbusinessex;



import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MyEntity300TestDataLoadService {

    @Autowired
    MyEntity300Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity300().setCustomField(LocalDateTime.now().minusDays(30)));
    }

}