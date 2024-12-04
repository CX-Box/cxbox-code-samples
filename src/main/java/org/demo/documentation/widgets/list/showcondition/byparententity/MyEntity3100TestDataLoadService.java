package org.demo.documentation.widgets.list.showcondition.byparententity;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyEntity3106;
import org.demo.documentation.widgets.list.showcondition.byparententity.child.MyEntity3106Repository;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100;
import org.demo.documentation.widgets.list.showcondition.byparententity.parent.MyEntity3100Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class MyEntity3100TestDataLoadService {

    @Autowired
    MyEntity3100Repository repositoryParent;

    @Autowired
    MyEntity3106Repository repositoryChild;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repositoryChild.deleteAll();
        repositoryParent.deleteAll();
        MyEntity3100 myEntity3100Parent = new MyEntity3100().setCustomFieldNumber(8L).setCustomField("Test data");
        MyEntity3100 myEntity3100Parent2 = new MyEntity3100().setCustomFieldNumber(8L).setCustomField("Test data");
        repositoryParent.save(myEntity3100Parent);
        repositoryParent.save(myEntity3100Parent2);
        repositoryChild.save(new MyEntity3106().setCustomFieldEntity(myEntity3100Parent).setCustomField("Test data"));
        repositoryChild.save(new MyEntity3106().setCustomFieldEntity(myEntity3100Parent).setCustomField("Test data2"));
    }

}