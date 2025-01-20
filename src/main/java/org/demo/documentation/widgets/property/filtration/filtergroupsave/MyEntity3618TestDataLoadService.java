package org.demo.documentation.widgets.property.filtration.filtergroupsave;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624Repository;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist.MyEntity3618Pick;
import org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist.MyEntity3618PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3618TestDataLoadService {

    @Autowired
    MyEntity3618Repository repository;

    @Autowired
    MyEntity3624Repository repository3624;

    @Autowired
    MyEntity3618PickRepository repository3618Pick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 5").setCustomFieldNew("test data new"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW).setCustomField("test data 2").setCustomFieldNew("test data new 2"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 3").setCustomFieldNew("test data new 3"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE).setCustomField("test data 5").setCustomFieldNew("test data new 4"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 5").setCustomFieldNew("test data new 5"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE).setCustomField("test data 6").setCustomFieldNew("test data new 6"));
        repository.save(new MyEntity3618().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("test data 7").setCustomFieldNew("test data new 7"));

        repository3624.save(new MyEntity3624().setCustomField("test data 5").setCustomFieldNew("test data new"));
        repository3624.save(new MyEntity3624().setCustomField("test data 2").setCustomFieldNew("test data new 2"));
        repository3624.save(new MyEntity3624().setCustomField("test data 3").setCustomFieldNew("test data new 3"));
        repository3624.save(new MyEntity3624().setCustomField("test data 5").setCustomFieldNew("test data new 4"));
        repository3624.save(new MyEntity3624().setCustomField("test data 5").setCustomFieldNew("test data new 5"));
        repository3624.save(new MyEntity3624().setCustomField("test data 6").setCustomFieldNew("test data new 6"));
        repository3624.save(new MyEntity3624().setCustomField("test data 7").setCustomFieldNew("test data new 7"));

        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 5").setCustomFieldNew("test data new"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 2").setCustomFieldNew("test data new 2"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 3").setCustomFieldNew("test data new 3"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 5").setCustomFieldNew("test data new 4"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 5").setCustomFieldNew("test data new 5"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 6").setCustomFieldNew("test data new 6"));
        repository3618Pick.save(new MyEntity3618Pick().setCustomField("test data 7").setCustomFieldNew("test data new 7"));
    }

}