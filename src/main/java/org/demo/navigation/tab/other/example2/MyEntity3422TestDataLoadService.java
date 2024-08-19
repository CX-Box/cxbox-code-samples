package org.demo.navigation.tab.other.example2;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;

import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.navigation.tab.other.example2.relatedobject.MyEntity3423;
import org.demo.navigation.tab.other.example2.relatedobject.MyEntity3423Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3422TestDataLoadService {

    @Autowired
    MyEntity3422Repository repository;
    @Autowired
    MyEntity3423Repository repositoryChild;

    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository.deleteAll();
        repositoryChild.deleteAll();
        MyEntity3422 myEntity3422_1 = new MyEntity3422().setCustomField("test data").setCustomFieldDrilldown("test data");
        repository.save(myEntity3422_1);
        repository.save(new MyEntity3422().setCustomField("test data2").setCustomFieldDrilldown("test data2"));
        repository.save(new MyEntity3422().setCustomField("test data3").setCustomFieldDrilldown("test data3"));
        repository.save(new MyEntity3422().setCustomField("test data4").setCustomFieldDrilldown("test data4"));
        repository.save(new MyEntity3422().setCustomField("test data5").setCustomFieldDrilldown("test data5"));
        MyEntity3422  myEntity3422_2 = new MyEntity3422().setCustomField("test data6").setCustomFieldDrilldown("test data6");
        MyEntity3422 myEntity3422 = new MyEntity3422().setCustomField("test data7").setCustomFieldDrilldown("test data7");
        repository.save(myEntity3422_2);
        repository.save(myEntity3422);
        MyEntity3423 myEntity3423 = new MyEntity3423().setCustomField("child test data1").setCustomFieldEntity(myEntity3422);
        repositoryChild.save(myEntity3423);
        MyEntity3423 myEntity3423_2 = new MyEntity3423().setCustomField("child test data2").setCustomFieldEntity(myEntity3422);
        repositoryChild.save(myEntity3423_2);
        MyEntity3423 myEntity3423_3 = new MyEntity3423().setCustomField("child test data1").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_3);
        MyEntity3423 myEntity3423_4 = new MyEntity3423().setCustomField("child test data2").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_4);
    }

}