package org.demo.documentation.widgets.formpopup.base.onefield;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.MyEntity3400InlinePicklist;
import org.demo.documentation.widgets.formpopup.base.onefield.forfields.MyEntity3400InlinePicklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class MyEntity3400TestDataLoadService {

    @Autowired
    MyEntity3400Repository repository;


    @Autowired
    MyEntity3400InlinePicklistRepository repository3400;


    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3400().setCustomField("Text for approval").setCustomFieldRequired("Test").setCustomFieldRequired2("Test2"));
        repository3400.save(new MyEntity3400InlinePicklist().setCustomField("Test1"));
        repository3400.save(new MyEntity3400InlinePicklist().setCustomField("Test2"));
        repository3400.save(new MyEntity3400InlinePicklist().setCustomField("Test3"));
        repository3400.save(new MyEntity3400InlinePicklist().setCustomField("Test4"));
        repository3400.save(new MyEntity3400InlinePicklist().setCustomField("Test5"));
    }

}