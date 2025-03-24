package org.demo.documentation.feature.postaction.drilldownandwaituntil;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton.MyEntity3232;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton.MyEntity3232Repository;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.basic.MyEntity3234;
import org.demo.documentation.feature.postaction.drilldownandwaituntil.basic.MyEntity3234Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3232TestDataLoadService {

    @Autowired
    MyEntity3232Repository repository;
    @Autowired
    MyEntity3234Repository repository3234;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3232().setCustomField("test data").setCustomFieldForm("Test data2"));

        repository3234.deleteAll();
        repository3234.save(new MyEntity3234().setCustomField("test data").setCustomFieldForm("Test data2"));

    }

}