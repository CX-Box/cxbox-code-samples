package org.demo.documentation.widgets.property.pagination.availablelimitselist;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3867TestDataLoadService {

    @Autowired
    MyEntity3867Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3867().setCustomField("test data"));
        repository.save(new MyEntity3867().setCustomField("test data7"));
        repository.save(new MyEntity3867().setCustomField("test data3"));
        repository.save(new MyEntity3867().setCustomField("test data4"));
        repository.save(new MyEntity3867().setCustomField("test data5"));
        repository.save(new MyEntity3867().setCustomField("test data6"));
        repository.save(new MyEntity3867().setCustomField("test data7"));
        repository.save(new MyEntity3867().setCustomField("test data8"));
        repository.save(new MyEntity3867().setCustomField("test data9"));
        repository.save(new MyEntity3867().setCustomField("test data10"));
    }

}