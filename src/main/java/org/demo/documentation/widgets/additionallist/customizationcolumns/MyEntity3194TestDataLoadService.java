package org.demo.documentation.widgets.additionallist.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3194TestDataLoadService {

    @Autowired
    MyEntity3194Repository repository;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repository.save(new MyEntity3194().setCustomField("test data1").setCustomFieldText("test data text1"));
        repository.save(new MyEntity3194().setCustomField("test data2").setCustomFieldText("test data text2"));
        repository.save(new MyEntity3194().setCustomField("test data3").setCustomFieldText("test data text3"));
        repository.save(new MyEntity3194().setCustomField("test data4").setCustomFieldText("test data text4"));
        repository.save(new MyEntity3194().setCustomField("test data5").setCustomFieldText("test data text5"));
    }

}