package org.demo.documentation.feature.postaction.waituntil;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.postaction.waituntil.allbutton.MyEntity3231;
import org.demo.documentation.feature.postaction.waituntil.allbutton.MyEntity3231Repository;
import org.demo.documentation.feature.postaction.waituntil.basic.MyEntity3233;
import org.demo.documentation.feature.postaction.waituntil.basic.MyEntity3233Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3231TestDataLoadService {

    @Autowired
    MyEntity3231Repository repository;
    @Autowired
    MyEntity3233Repository repository3233;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3231().setCustomFieldForm("Test data2"));
        repository3233.save(new MyEntity3233().setCustomFieldForm("Test data2"));

    }

}