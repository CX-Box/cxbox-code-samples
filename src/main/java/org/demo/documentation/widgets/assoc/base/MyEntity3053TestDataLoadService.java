package org.demo.documentation.widgets.assoc.base;

import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053Multi;
import org.demo.documentation.widgets.assoc.base.forfield.MyEntity3053MultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3053TestDataLoadService {

    @Autowired
    MyEntity3053Repository repository;

    @Autowired
    MyEntity3053MultiRepository repositoryMulti;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3053());
        repositoryMulti.save(new MyEntity3053Multi().setCustomField("Test data").setCustomFieldNew("Test data New"));
        repositoryMulti.save(new MyEntity3053Multi().setCustomField("Test data1").setCustomFieldNew("Test data New1"));
        repositoryMulti.save(new MyEntity3053Multi().setCustomField("Test data2").setCustomFieldNew("Test data New2"));
        repositoryMulti.save(new MyEntity3053Multi().setCustomField("Test data3").setCustomFieldNew("Test data New3"));


    }

}