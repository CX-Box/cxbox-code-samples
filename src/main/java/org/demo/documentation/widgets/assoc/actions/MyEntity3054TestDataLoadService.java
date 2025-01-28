package org.demo.documentation.widgets.assoc.actions;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3054TestDataLoadService {

    @Autowired
    MyEntity3054Repository repository;

    @Autowired
    MyEntity3054MultiRepository repositoryMulti;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryMulti.deleteAll();

        repositoryMulti.save(new MyEntity3054Multi().setCustomField("Test data 2"));
        repositoryMulti.save(new MyEntity3054Multi().setCustomField("Test data 3"));
        repositoryMulti.save(new MyEntity3054Multi().setCustomField("Test data 4"));
        repositoryMulti.save(new MyEntity3054Multi().setCustomField("Test data 5"));
        repositoryMulti.save(new MyEntity3054Multi().setCustomField("Test data 6"));

        MyEntity3054Multi myEntity = new MyEntity3054Multi().setCustomField("Test data 1");
        List<MyEntity3054Multi> list = new ArrayList<>();
        list.add(myEntity);
         repository.save(new MyEntity3054().setCustomFieldList(list));
    }

}