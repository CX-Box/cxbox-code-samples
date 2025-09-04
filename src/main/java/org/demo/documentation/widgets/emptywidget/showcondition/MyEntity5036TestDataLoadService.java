package org.demo.documentation.widgets.emptywidget.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity.MyEntity5033;
import org.demo.documentation.widgets.emptywidget.showcondition.bycurrententity.MyEntity5033Repository;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child.MyEntity5037;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child.MyEntity5037Repository;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent.MyEntity5036;
import org.demo.documentation.widgets.emptywidget.showcondition.byparententity.parent.MyEntity5036Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5036TestDataLoadService {
    @Autowired
    MyEntity5033Repository repository;

    @Autowired
    MyEntity5036Repository repositoryParent;

    @Autowired
    MyEntity5037Repository repositoryChild;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repositoryParent.deleteAll();
        MyEntity5036 myEntity5036 = new MyEntity5036().setCustomField(20L);
        MyEntity5036 myEntity5036_2 = new MyEntity5036().setCustomField(0L);
        MyEntity5036 myEntity5036_3 = new MyEntity5036().setCustomField(1L);
        repositoryParent.save(myEntity5036);
        repositoryParent.save(myEntity5036_2);
        repositoryParent.save(myEntity5036_3);

        repositoryChild.deleteAll();
        repositoryChild.save(new MyEntity5037().setCustomField("test data").setCustomFieldEntity(myEntity5036));
        repositoryChild.save(new MyEntity5037().setCustomField("test data").setCustomFieldEntity(myEntity5036_2));
        repositoryChild.save(new MyEntity5037().setCustomField("test data").setCustomFieldEntity(myEntity5036_3));

        repository.deleteAll();
        repository.save(new MyEntity5033().setCustomField(20L));
        repository.save(new MyEntity5033().setCustomField(0L));
        repository.save(new MyEntity5033().setCustomField(1L));
    }

}