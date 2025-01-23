package org.demo.documentation.feature.drilldown.goingbackafterdrilldown;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3620TestDataLoadService {

    @Autowired
    MyEntity3620Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3620().setCustomField("test data"));
        repository.save(new MyEntity3620().setCustomField("test data2"));
        repository.save(new MyEntity3620().setCustomField("test data3"));
        repository.save(new MyEntity3620().setCustomField("test data4"));
        repository.save(new MyEntity3620().setCustomField("test data5"));
        repository.save(new MyEntity3620().setCustomField("test data6"));
    }

}