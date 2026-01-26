package org.demo.documentation.fields.time.filtration;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@Service
public class MyEntity3504TestDataLoadService {

    @Autowired
    MyEntity3504Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3504().setCustomField(LocalDateTime.now())
                .setCustomField(LocalDateTime.now())
                .setCustomFieldh(LocalDateTime.now())
                .setCustomFieldhmm(LocalDateTime.now())
                .setCustomFieldhmmA(LocalDateTime.now())
                .setCustomFieldmmss(LocalDateTime.now())
                .setCustomFieldhmmssA(LocalDateTime.now())
                .setCustomFieldss(LocalDateTime.now())
                .setCustomFieldmm(LocalDateTime.now()));
        repository.save(new MyEntity3504().setCustomField(LocalDateTime.now().minusMinutes(30))
                .setCustomField(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldh(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldhmm(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldhmmA(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldmmss(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldhmmssA(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldss(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldhA(LocalDateTime.now().minusMinutes(30).minusDays(4))
                .setCustomFieldmm(LocalDateTime.now().minusMinutes(30).minusDays(4)));

        repository.save(new MyEntity3504().setCustomField(LocalDateTime.now().minusHours(2))
                .setCustomField(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldh(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldhmm(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldhmmA(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldmmss(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldhmmssA(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldss(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldhA(LocalDateTime.now().minusHours(2).minusYears(1))
                .setCustomFieldmm(LocalDateTime.now().minusHours(2).minusYears(1)));
        repository.save(new MyEntity3504().setCustomField(LocalDateTime.now().minusDays(1)
                        .minusHours(2).minusMinutes(3))
                .setCustomField(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldh(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldhmm(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldhmmA(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldmmss(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldhmmssA(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldss(LocalDateTime.now().minusHours(7).minusMonths(2))
                .setCustomFieldmm(LocalDateTime.now().minusHours(7).minusMonths(2)));
    }

}