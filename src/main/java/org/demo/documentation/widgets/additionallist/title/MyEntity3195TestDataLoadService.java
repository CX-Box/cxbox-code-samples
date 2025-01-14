package org.demo.documentation.widgets.additionallist.title;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3195TestDataLoadService {

    @Autowired
    MyEntity3195Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3195().setCustomField("test data").setCustomFieldText("test data text"));
        repository.save(new MyEntity3195().setCustomField("test data2").setCustomFieldText("test data text2"));
        repository.save(new MyEntity3195().setCustomField("test data3").setCustomFieldText("test data text3"));
    }

}