package org.demo.documentation.feature.filtergroup;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3616TestDataLoadService {

    @Autowired
    MyEntity3616Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3616().setCustomField("test data").setCustomFieldNew("test data new"));
        repository.save(new MyEntity3616().setCustomField("test data 2").setCustomFieldNew("test data new 2"));
    }

}