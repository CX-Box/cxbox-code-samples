package org.demo.documentation.widgets.statsblock.drilldown.data;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.statsblock.drilldown.data.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity4208TestDataLoadService {

    @Autowired
    MyEntity4208Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity4208().setCustomField("Test data"));
        repository.save(new MyEntity4208().setCustomField("Test data").setCustomFieldStatus(CustomFieldEnum.CLOSE));
    }

}