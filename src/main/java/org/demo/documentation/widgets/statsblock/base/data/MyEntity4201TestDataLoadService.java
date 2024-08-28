package org.demo.documentation.widgets.statsblock.base.data;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class MyEntity4201TestDataLoadService {

    @Autowired
    MyEntity4201Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity4201().setCustomField("Test data").setCustomFieldNum(5L));
        repository.save(new MyEntity4201().setCustomField("Test data2").setCustomFieldNum(0L));
    }

}