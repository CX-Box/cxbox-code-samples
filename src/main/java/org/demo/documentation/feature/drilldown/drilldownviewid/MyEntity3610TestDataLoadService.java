package org.demo.documentation.feature.drilldown.drilldownviewid;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3610TestDataLoadService {

    @Autowired
    MyEntity3610Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3610().setCustomField("test data").setCustomFieldDrillDown("test data"));
        repository.save(new MyEntity3610().setCustomField("test data2").setCustomFieldDrillDown("test data2"));
    }

}