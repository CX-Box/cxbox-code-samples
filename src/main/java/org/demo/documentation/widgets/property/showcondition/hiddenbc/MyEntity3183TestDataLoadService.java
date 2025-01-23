package org.demo.documentation.widgets.property.showcondition.hiddenbc;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.child.MyEntity3183;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.child.MyEntity3183Repository;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc.MyEntity3184;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.mainbc.MyEntity3184Repository;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.parent.MyEntity3185;
import org.demo.documentation.widgets.property.showcondition.hiddenbc.parent.MyEntity3185Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3183TestDataLoadService {

    @Autowired
    MyEntity3183Repository repositoryChild;

    @Autowired
    MyEntity3184Repository repositoryMain;

    @Autowired
    MyEntity3185Repository repositoryParent;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repositoryChild.deleteAll();
        repositoryMain.deleteAll();
        repositoryParent.deleteAll();

        MyEntity3184 myEntity3184 = new MyEntity3184().setCustomField("test data");
        repositoryMain.save(myEntity3184);

        MyEntity3185 myEntity3185 = new MyEntity3185().setCustomField("test data").setCustomFieldCheckbox(true);
        repositoryParent.save(myEntity3185.setCustomFieldEntity(myEntity3184));

        MyEntity3185 myEntity3185_2 = new MyEntity3185().setCustomField("test data2").setCustomFieldCheckbox(false);
        repositoryParent.save(myEntity3185_2.setCustomFieldEntity(myEntity3184));

        repositoryChild.save(new MyEntity3183().setCustomField("test data").setCustomFieldEntity(myEntity3185));
        repositoryChild.save(new MyEntity3183().setCustomField("test data2").setCustomFieldEntity(myEntity3185_2));

    }

}