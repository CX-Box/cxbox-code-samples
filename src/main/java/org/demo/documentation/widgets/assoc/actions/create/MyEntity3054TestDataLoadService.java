package org.demo.documentation.widgets.assoc.actions.create;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052MultiMultiAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3054TestDataLoadService {

    @Autowired
    MyEntity3054Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3054Multi myEntity = new MyEntity3054Multi().setCustomField("Test data 1");
        List<MyEntity3054Multi> list = new ArrayList<>();
        list.add(myEntity);
         repository.save(new MyEntity3054().setCustomFieldList(list));
    }

}