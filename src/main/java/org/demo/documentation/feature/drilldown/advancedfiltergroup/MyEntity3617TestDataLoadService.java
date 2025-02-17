package org.demo.documentation.feature.drilldown.advancedfiltergroup;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3617TestDataLoadService {

    @Autowired
    MyEntity3617Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3617().setCustomField("test data").setCustomFieldNew("test data new").setCustomFieldDrillDown("test data"));
        repository.save(new MyEntity3617().setCustomField("test data2").setCustomFieldNew("test data new2").setCustomFieldDrillDown("test data2"));
        repository.save(new MyEntity3617().setCustomField("test data3").setCustomFieldNew("test data new3").setCustomFieldDrillDown("test data3"));

    }

}