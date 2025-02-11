package org.demo.documentation.feature.drilldown.drilldowntypes;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3613TestDataLoadService {

    @Autowired
    MyEntity3613Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3613().setCustomField("test data")
                .setCustomFieldExternal("test data2")
                .setCustomFieldExternalNew("test data3")
                .setCustomFieldRelative("test data3")
                .setCustomFieldRelativeNew("test data3")
        );
    }

}