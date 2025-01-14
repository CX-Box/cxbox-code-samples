package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3618TestDataLoadService {

    @Autowired
    MyEntity3618Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 5").setCustomFieldNew("test data new"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 2").setCustomFieldNew("test data new 2"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 3").setCustomFieldNew("test data new 3"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 5").setCustomFieldNew("test data new 4"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 5").setCustomFieldNew("test data new 5"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 6").setCustomFieldNew("test data new 6"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 7").setCustomFieldNew("test data new 7"));
    }

}