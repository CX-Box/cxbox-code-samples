package org.demo.documentation.time.filtration;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
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
        repository.save(new MyEntity3504().setCustomField(LocalDateTime.now()));
    }

}