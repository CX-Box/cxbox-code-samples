package org.demo.documentation.widgets.statsblock.drilldown.drilldown.data;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.statsblock.drilldown.drilldown.data.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        repository.save(new MyEntity4208().setCustomField("Test data1").setCustomFieldStatus(CustomFieldEnum.CLOSE));
        repository.save(new MyEntity4208().setCustomField("Test data2").setCustomFieldStatus(CustomFieldEnum.CLOSE));
        repository.save(new MyEntity4208().setCustomField("Test data3").setCustomFieldStatus(CustomFieldEnum.NEW));
        repository.save(new MyEntity4208().setCustomField("Test data4").setCustomFieldStatus(CustomFieldEnum.NEW));
        repository.save(new MyEntity4208().setCustomField("Test data5").setCustomFieldStatus(CustomFieldEnum.NEW));
        repository.save(new MyEntity4208().setCustomField("Test data6").setCustomFieldStatus(CustomFieldEnum.IN_PROGRESS));

    }

}