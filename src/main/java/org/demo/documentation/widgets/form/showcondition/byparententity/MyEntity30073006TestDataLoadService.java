package org.demo.documentation.widgets.form.showcondition.byparententity;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.form.showcondition.byparententity.child.MyEntity3006;
import org.demo.documentation.widgets.form.showcondition.byparententity.child.MyEntity3006Repository;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007;
import org.demo.documentation.widgets.form.showcondition.byparententity.parent.MyEntity3007Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@Service
public class MyEntity30073006TestDataLoadService {

    @Autowired
    MyEntity3007Repository repository;

    @Autowired
    MyEntity3006Repository repository3006;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        MyEntity3007 myEntity3007 = new MyEntity3007().setCustomField(7L);
        repository.save(myEntity3007);
        repository3006.save(new MyEntity3006().setCustomFieldEntity(myEntity3007).setCustomField("Test data"));}

}