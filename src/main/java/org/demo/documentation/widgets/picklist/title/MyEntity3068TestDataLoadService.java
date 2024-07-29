package org.demo.documentation.widgets.picklist.title;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3068TestDataLoadService {

    @Autowired
    MyEntity3068Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
      //  repository.save(new MyEntity3068().setCustomField("test data"));
    }

}