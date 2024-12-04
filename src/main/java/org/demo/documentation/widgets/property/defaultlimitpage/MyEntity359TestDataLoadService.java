package org.demo.documentation.widgets.property.defaultlimitpage;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity359TestDataLoadService {

    @Autowired
    MyEntity359Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity359().setCustomField("test data 1"));
        repository.save(new MyEntity359().setCustomField("test data 2"));
        repository.save(new MyEntity359().setCustomField("test data 3"));
        repository.save(new MyEntity359().setCustomField("test data 4"));
        repository.save(new MyEntity359().setCustomField("test data 5"));
        repository.save(new MyEntity359().setCustomField("test data 6"));
        repository.save(new MyEntity359().setCustomField("test data 7"));
        repository.save(new MyEntity359().setCustomField("test data 8"));

    }

}