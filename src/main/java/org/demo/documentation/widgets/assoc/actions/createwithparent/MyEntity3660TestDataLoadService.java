package org.demo.documentation.widgets.assoc.actions.createwithparent;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3661;
import org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3661Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3660TestDataLoadService {

    @Autowired
    MyEntity3660Repository repository;
    @Autowired
    MyEntity3661Repository repositoryParent;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryParent.deleteAll();

        MyEntity3661 myEntity3661 = new MyEntity3661().setCustomField("test data");
        repositoryParent.save(myEntity3661);
        MyEntity3661 myEntity3661_2 = new MyEntity3661().setCustomField("test data2");
        repositoryParent.save(myEntity3661_2);
        repository.save(new MyEntity3660().setCustomFieldEntity(myEntity3661_2).setCustomFieldText("test data").setCustomFieldTextReq("test data"));
    }

}