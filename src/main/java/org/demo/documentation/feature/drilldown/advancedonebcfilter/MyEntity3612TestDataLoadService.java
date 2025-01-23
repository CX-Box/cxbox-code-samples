package org.demo.documentation.feature.drilldown.advancedonebcfilter;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.drilldown.advancedonebcfilter.enums.CustomFieldFilterDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3612TestDataLoadService {

    @Autowired
    MyEntity3612Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3612().setCustomField("test data").setCustomFieldFilterDate(LocalDateTime.now().plusMonths(5)).setCustomFieldFilterDictionary(CustomFieldFilterDictionaryEnum.HIGH));
        repository.save(new MyEntity3612().setCustomField("test data2").setCustomFieldFilterDate(LocalDateTime.now().minusDays(3)).setCustomFieldFilterDictionary(CustomFieldFilterDictionaryEnum.LOW));
        repository.save(new MyEntity3612().setCustomField("test data3").setCustomFieldFilterDate(LocalDateTime.now().plusDays(8)).setCustomFieldFilterDictionary(CustomFieldFilterDictionaryEnum.MIDDLE));

    }

}