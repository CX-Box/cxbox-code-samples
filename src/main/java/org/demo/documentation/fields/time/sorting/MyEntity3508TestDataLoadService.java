package org.demo.documentation.fields.time.sorting;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class MyEntity3508TestDataLoadService {

    @Autowired
    MyEntity3508Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomField(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldh(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldhmm(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldhmmA(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldmmss(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldhmmssA(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldss(LocalDateTime.of(2024,12,5,5,58, 54))
                .setCustomFieldmm(LocalDateTime.of(2024,12,5,5,58, 54))
        );
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomField(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldh(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldhmm(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldhmmA(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldmmss(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldhmmssA(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldss(LocalDateTime.of(2024,12,5,10,58, 54))
                .setCustomFieldmm(LocalDateTime.of(2024,12,5,10,58, 54)));
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomField(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldh(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldhmm(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldhmmA(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldmmss(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldhmmssA(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldss(LocalDateTime.of(2024,12,5,12,28, 54))
                .setCustomFieldmm(LocalDateTime.of(2024,12,5,12,28, 54)));
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomField(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldh(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldhmm(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldhmmA(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldmmss(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldhmmssA(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldss(LocalDateTime.of(2024,12,5,12,58, 54))
                .setCustomFieldmm(LocalDateTime.of(2024,12,5,12,58, 54)));


    }

}