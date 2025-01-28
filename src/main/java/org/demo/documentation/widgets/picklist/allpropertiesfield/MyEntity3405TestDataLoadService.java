package org.demo.documentation.widgets.picklist.allpropertiesfield;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup.MyEntity3405PickListPopup;
import org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup.MyEntity3405PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3405TestDataLoadService {

    @Autowired
    MyEntity3405Repository repository;

    @Autowired
    MyEntity3405PickRepository repositoryPick;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3405().setCustomField("test data"));
        repositoryPick.save(new MyEntity3405PickListPopup()
                .setCustomField("test data")
                .setCustomFieldColorSort("test data 6")
                .setCustomFieldColorValidation("test data")
                .setCustomFieldDrilldown("test data 2")
                .setCustomFieldColorConst(60l)
                .setCustomFieldRequired("test data")
                .setCustomFieldColorConst(2L));
    }

}