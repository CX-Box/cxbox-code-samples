package org.demo.documentation.widgets.property.showcondition.twobcshowcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyEntity3145;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.child.MyEntity3145Repository;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyEntity3146;
import org.demo.documentation.widgets.property.showcondition.twobcshowcondition.parent.MyEntity3146Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3145TestDataLoadService {

    @Autowired
    MyEntity3145Repository repository;
    @Autowired
    MyEntity3146Repository repositoryParent;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryParent.deleteAll();
        MyEntity3146 myEntity3146=new MyEntity3146().setCustomField(5L);
        repositoryParent.save(myEntity3146);
        repository.save(new MyEntity3145().setCustomField("test data").setCustomFieldEntity(myEntity3146));
        repositoryParent.save(new MyEntity3146().setCustomField(8L));
    }

}