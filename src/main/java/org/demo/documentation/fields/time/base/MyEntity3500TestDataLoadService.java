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
                .setCustomField(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldh(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldhmm(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldhmmA(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldmmss(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldhmmssA(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldss(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldmm(LocalDateTime.of(2024,12,5,11,54, 25))
                .setCustomFieldhA(LocalDateTime.of(2024,12,5,11,54, 25))
        );
    }

}