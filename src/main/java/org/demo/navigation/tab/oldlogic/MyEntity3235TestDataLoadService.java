package org.demo.navigation.tab.oldlogic;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3235TestDataLoadService {

    @Autowired
    MyEntity3235Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3235().setCustomField("test data"));
        repository.save(new MyEntity3235().setCustomField("test data2"));
        repository.save(new MyEntity3235().setCustomField("test data3"));
        repository.save(new MyEntity3235().setCustomField("test data4"));
    }

}