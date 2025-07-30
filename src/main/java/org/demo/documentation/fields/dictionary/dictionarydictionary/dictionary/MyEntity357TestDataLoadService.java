package org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.example.ClientImportance;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.example.MyEntity356;
import org.demo.documentation.fields.dictionary.dictionarydictionary.dictionary.example.MyEntity356Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity357TestDataLoadService {

    @Autowired
    MyEntity356Repository repository356;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));

        repository356.deleteAll();
        repository356.save(new MyEntity356().setCustomField("test data").setCustomFieldDictionary(ClientImportance.HIGH));
    }

}