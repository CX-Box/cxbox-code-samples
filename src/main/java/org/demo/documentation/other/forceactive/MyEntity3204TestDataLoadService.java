package org.demo.documentation.other.forceactive;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3204TestDataLoadService {

    @Autowired
    MyEntity3204Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3204().setCustomField("test data").setCustomFieldDrillDown("Test"));
        repository.save(new MyEntity3204().setCustomField("test data2").setCustomFieldDrillDown("Test"));
        repository.save(new MyEntity3204().setCustomField("test data3").setCustomFieldDrillDown("Test"));
        repository.save(new MyEntity3204().setCustomField("test data4").setCustomFieldDrillDown("Test"));

    }

}