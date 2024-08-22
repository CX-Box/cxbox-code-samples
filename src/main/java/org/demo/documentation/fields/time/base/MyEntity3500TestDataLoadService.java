package org.demo.documentation.fields.time.base;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class MyEntity3500TestDataLoadService {

    @Autowired
    MyEntity3500Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3500()
                .setCustomField(LocalDateTime.now())
                .setCustomFieldh(LocalDateTime.now())
                .setCustomFieldhmm(LocalDateTime.now())
                .setCustomFieldhmmA(LocalDateTime.now())
                .setCustomFieldmmss(LocalDateTime.now())
                .setCustomFieldhmmssA(LocalDateTime.now())
                .setCustomFieldss(LocalDateTime.now())
                .setCustomFieldmm(LocalDateTime.now())
        );
    }

}