package org.demo.documentation.widgets.picklist.actions.edit;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092Pick;
import org.demo.documentation.widgets.picklist.actions.edit.picklistpopup.MyEntity3092PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3092TestDataLoadService {

    @Autowired
    MyEntity3092Repository repository;

    @Autowired
    MyEntity3092PickRepository repositoryPick;


    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3092().setCustomField("test data"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data2"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data3"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data4"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data5"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data6"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data7"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data8"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data9"));
        repositoryPick.save(new MyEntity3092Pick().setCustomField("test data10"));

    }

}