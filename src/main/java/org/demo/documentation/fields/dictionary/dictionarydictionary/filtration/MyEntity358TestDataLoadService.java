package org.demo.documentation.fields.dictionary.dictionarydictionary.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity358TestDataLoadService {

    @Autowired
    MyEntity358Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity358().setCustomField("test data1").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.HIGH).setCustomFieldDictionary(CustomDictionaryFiltration.HIGH).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.A));
        repository.save(new MyEntity358().setCustomField("test data2").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.LOW).setCustomFieldDictionary(CustomDictionaryFiltration.LOW).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.A));
        repository.save(new MyEntity358().setCustomField("test data3").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.LOW).setCustomFieldDictionary(CustomDictionaryFiltration.HIGH).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.A));
        repository.save(new MyEntity358().setCustomField("test data4").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.LOW).setCustomFieldDictionary(CustomDictionaryFiltration.HIGH).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.A));
        repository.save(new MyEntity358().setCustomField("test data5").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.HIGH).setCustomFieldDictionary(CustomDictionaryFiltration.LOW).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.B));
        repository.save(new MyEntity358().setCustomField("test data6").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.HIGH).setCustomFieldDictionary(CustomDictionaryFiltration.HIGH).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.B));
        repository.save(new MyEntity358().setCustomField("test data7"));
        repository.save(new MyEntity358().setCustomField("test data8").setCustomFieldDictionarySecond(CustomDictionaryFiltrationSecond.HIGH).setCustomFieldDictionary(CustomDictionaryFiltration.HIGH).setCustomFieldNewDictionary(CustomDictionaryNewFiltration.B));
    }

}