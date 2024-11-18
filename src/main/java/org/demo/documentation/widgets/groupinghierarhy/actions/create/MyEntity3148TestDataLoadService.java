package org.demo.documentation.widgets.groupinghierarhy.actions.create;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.basic.MyEntity3148;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.basic.MyEntity3148Repository;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.newview.MyEntity3149;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.newview.MyEntity3149Repository;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget.MyEntity3159;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget.MyEntity3159Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyEntity3148TestDataLoadService {
    @Autowired
    MyEntity3159Repository repository3159;

    @Autowired
    MyEntity3148Repository repository;

    @Autowired
    MyEntity3149Repository repository3149;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository3159.deleteAll();
        repository3149.deleteAll();
        repository.save(new MyEntity3148().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3148().setCustomField("test data 2").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3148().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3148().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
        repository.save(new MyEntity3148().setCustomField("test data 5").setCustomFieldDictionary(LOW));
        repository.save(new MyEntity3148().setCustomField("test data 6"));
        repository.save(new MyEntity3148().setCustomField("test data 7"));
        repository.save(new MyEntity3148().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
        repository.save(new MyEntity3148().setCustomField("test data 9"));

        repository3149.save(new MyEntity3149().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
        repository3149.save(new MyEntity3149().setCustomField("test data 2").setCustomFieldDictionary(LOW));
        repository3149.save(new MyEntity3149().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
        repository3149.save(new MyEntity3149().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
        repository3149.save(new MyEntity3149().setCustomField("test data 5").setCustomFieldDictionary(LOW));
        repository3149.save(new MyEntity3149().setCustomField("test data 6"));
        repository3149.save(new MyEntity3149().setCustomField("test data 7"));
        repository3149.save(new MyEntity3149().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
        repository3149.save(new MyEntity3149().setCustomField("test data 9"));

        repository3159.save(new MyEntity3159().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
        repository3159.save(new MyEntity3159().setCustomField("test data 2").setCustomFieldDictionary(LOW));
        repository3159.save(new MyEntity3159().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
        repository3159.save(new MyEntity3159().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
        repository3159.save(new MyEntity3159().setCustomField("test data 5").setCustomFieldDictionary(LOW));
        repository3159.save(new MyEntity3159().setCustomField("test data 6"));
        repository3159.save(new MyEntity3159().setCustomField("test data 7"));
        repository3159.save(new MyEntity3159().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
        repository3159.save(new MyEntity3159().setCustomField("test data 9"));
    }

}