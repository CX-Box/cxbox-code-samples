package org.demo.documentation.fields.suggestion.sorting.forfield;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3122TestDataLoadService {

    @Autowired
    MyEntity3122Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3122().setCustomField("test data"));
        repository.save(new MyEntity3122().setCustomField("test data1"));
        repository.save(new MyEntity3122().setCustomField("test data2"));
        repository.save(new MyEntity3122().setCustomField("test data3"));
        repository.save(new MyEntity3122().setCustomField("test data4"));
        repository.save(new MyEntity3122().setCustomField("test data5"));
        repository.save(new MyEntity3122().setCustomField("test data6"));
        repository.save(new MyEntity3122().setCustomField("test data7"));



    }

}