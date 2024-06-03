package org.demo.documentation.time.sorting;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
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
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.now())
                .setCustomField(LocalDateTime.now())
                .setCustomFieldh(LocalDateTime.now())
                .setCustomFieldhmm(LocalDateTime.now())
                .setCustomFieldhmmA(LocalDateTime.now())
                .setCustomFieldmmss(LocalDateTime.now())
                .setCustomFieldhmmssA(LocalDateTime.now())
                .setCustomFieldss(LocalDateTime.now())
                .setCustomFieldmm(LocalDateTime.now())
        );
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.now().minusMinutes(30))
                .setCustomField(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldh(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldhmm(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldhmmA(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldmmss(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldhmmssA(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldss(LocalDateTime.now().minusMinutes(30))
                .setCustomFieldmm(LocalDateTime.now().minusMinutes(30)));
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.now().minusHours(2))
                .setCustomField(LocalDateTime.now().minusHours(2))
                .setCustomFieldh(LocalDateTime.now().minusHours(2))
                .setCustomFieldhmm(LocalDateTime.now().minusHours(2))
                .setCustomFieldhmmA(LocalDateTime.now().minusHours(2))
                .setCustomFieldmmss(LocalDateTime.now().minusHours(2))
                .setCustomFieldhmmssA(LocalDateTime.now().minusHours(2))
                .setCustomFieldss(LocalDateTime.now().minusHours(2))
                .setCustomFieldmm(LocalDateTime.now().minusHours(2)));
        repository.save(new MyEntity3508().setCustomField(LocalDateTime.now().minusDays(1)
                .minusHours(2).minusMinutes(3))
                .setCustomField(LocalDateTime.now().minusHours(7))
                .setCustomFieldh(LocalDateTime.now().minusHours(7))
                .setCustomFieldhmm(LocalDateTime.now().minusHours(7))
                .setCustomFieldhmmA(LocalDateTime.now().minusHours(7))
                .setCustomFieldmmss(LocalDateTime.now().minusHours(7))
                .setCustomFieldhmmssA(LocalDateTime.now().minusHours(7))
                .setCustomFieldss(LocalDateTime.now().minusHours(7))
                .setCustomFieldmm(LocalDateTime.now().minusHours(7)));


    }

}