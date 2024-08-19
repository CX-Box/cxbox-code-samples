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
        MyEntity3422 myEntity3422_2 = new MyEntity3422().setCustomField("test data2").setCustomFieldDrilldown("test data2");
        repository.save(myEntity3422_2);
        MyEntity3422 myEntity3422_3 = new MyEntity3422().setCustomField("test data3").setCustomFieldDrilldown("test data3");
        repository.save(myEntity3422_3);
        MyEntity3422 myEntity3422_4 = new MyEntity3422().setCustomField("test data4").setCustomFieldDrilldown("test data4");
        repository.save(myEntity3422_4);
        MyEntity3422 myEntity3422_5 =new MyEntity3422().setCustomField("test data5").setCustomFieldDrilldown("test data5");
         repository.save(myEntity3422_5);
        MyEntity3422  myEntity3422_6 = new MyEntity3422().setCustomField("test data6").setCustomFieldDrilldown("test data6");
        repository.save(myEntity3422_6);
        MyEntity3422 myEntity3422_7 = new MyEntity3422().setCustomField("test data7").setCustomFieldDrilldown("test data7");
        repository.save(myEntity3422_7);

        MyEntity3423 myEntity3423_1_0 = new MyEntity3423().setCustomField("child test data 1[0]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_0);
        MyEntity3423 myEntity3423_1_1 = new MyEntity3423().setCustomField("child test data 1[1]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_1);
        MyEntity3423 myEntity3423_1_2 = new MyEntity3423().setCustomField("child test data 1[2]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_2);
        MyEntity3423 myEntity3423_1_3 = new MyEntity3423().setCustomField("child test data 1[3]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_3);
        MyEntity3423 myEntity3423_1_4 = new MyEntity3423().setCustomField("child test data 1[4]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_4);
        MyEntity3423 myEntity3423_1_5 = new MyEntity3423().setCustomField("child test data 1[5]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_5);
        MyEntity3423 myEntity3423_1_6 = new MyEntity3423().setCustomField("child test data 1[6]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_6);
        MyEntity3423 myEntity3423_1_7 = new MyEntity3423().setCustomField("child test data 1[7]").setCustomFieldEntity(myEntity3422_1);
        repositoryChild.save(myEntity3423_1_7);

        MyEntity3423 myEntity3423_2_0 = new MyEntity3423().setCustomField("child test data 2[0]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_0);
        MyEntity3423 myEntity3423_2_1 = new MyEntity3423().setCustomField("child test data 2[1]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_1);
        MyEntity3423 myEntity3423_2_2 = new MyEntity3423().setCustomField("child test data 2[2]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_2);
        MyEntity3423 myEntity3423_2_3 = new MyEntity3423().setCustomField("child test data 2[3]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_3);
        MyEntity3423 myEntity3423_2_4 = new MyEntity3423().setCustomField("child test data 2[4]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_4);
        MyEntity3423 myEntity3423_2_5 = new MyEntity3423().setCustomField("child test data 2[5]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_5);
        MyEntity3423 myEntity3423_2_6 = new MyEntity3423().setCustomField("child test data 2[6]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_6);
        MyEntity3423 myEntity3423_2_7 = new MyEntity3423().setCustomField("child test data 2[7]").setCustomFieldEntity(myEntity3422_2);
        repositoryChild.save(myEntity3423_2_7);

        MyEntity3423 myEntity3423_3_0 = new MyEntity3423().setCustomField("child test data 3[0]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_0);
        MyEntity3423 myEntity3423_3_1 = new MyEntity3423().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_1);
        MyEntity3423 myEntity3423_3_2 = new MyEntity3423().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_2);
        MyEntity3423 myEntity3423_3_3 = new MyEntity3423().setCustomField("child test data 3[2]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_3);
        MyEntity3423 myEntity3423_3_4 = new MyEntity3423().setCustomField("child test data 3[3]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_4);
        MyEntity3423 myEntity3423_3_5 = new MyEntity3423().setCustomField("child test data 3[4]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_5);
        MyEntity3423 myEntity3423_3_6 = new MyEntity3423().setCustomField("child test data 3[5]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_6);
        MyEntity3423 myEntity3423_3_7 = new MyEntity3423().setCustomField("child test data 3[6]").setCustomFieldEntity(myEntity3422_3);
        repositoryChild.save(myEntity3423_3_7);

        MyEntity3423 myEntity3423_4_0 = new MyEntity3423().setCustomField("child test data 4[0]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_0);
        MyEntity3423 myEntity3423_4_1 = new MyEntity3423().setCustomField("child test data 4[1]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_1);
        MyEntity3423 myEntity3423_4_2 = new MyEntity3423().setCustomField("child test data 4[2]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_2);
        MyEntity3423 myEntity3423_4_3 = new MyEntity3423().setCustomField("child test data 4[3]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_3);
        MyEntity3423 myEntity3423_4_4 = new MyEntity3423().setCustomField("child test data 4[4]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_4);
        MyEntity3423 myEntity3423_4_5 = new MyEntity3423().setCustomField("child test data 4[5]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_5);
        MyEntity3423 myEntity3423_4_6 = new MyEntity3423().setCustomField("child test data 4[6]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_6);
        MyEntity3423 myEntity3423_4_7 = new MyEntity3423().setCustomField("child test data 4[7]").setCustomFieldEntity(myEntity3422_4);
        repositoryChild.save(myEntity3423_4_7);

        MyEntity3423 myEntity3423_5_0 = new MyEntity3423().setCustomField("child test data 5[0]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_0);
        MyEntity3423 myEntity3423_5_1 = new MyEntity3423().setCustomField("child test data 5[1]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_1);
        MyEntity3423 myEntity3423_5_2 = new MyEntity3423().setCustomField("child test data 5[2]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_2);
        MyEntity3423 myEntity3423_5_3 = new MyEntity3423().setCustomField("child test data 5[3]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_3);
        MyEntity3423 myEntity3423_5_4 = new MyEntity3423().setCustomField("child test data 5[4]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_4);
        MyEntity3423 myEntity3423_5_5 = new MyEntity3423().setCustomField("child test data 5[5]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_5);
        MyEntity3423 myEntity3423_5_6 = new MyEntity3423().setCustomField("child test data 5[6]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_6);
        MyEntity3423 myEntity3423_5_7 = new MyEntity3423().setCustomField("child test data 5[7]").setCustomFieldEntity(myEntity3422_5);
        repositoryChild.save(myEntity3423_5_7);

        MyEntity3423 myEntity3423_6_0 = new MyEntity3423().setCustomField("child test data 6[0]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_0);
        MyEntity3423 myEntity3423_6_1 = new MyEntity3423().setCustomField("child test data 6[1]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_1);
        MyEntity3423 myEntity3423_6_2 = new MyEntity3423().setCustomField("child test data 6[2]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_2);
        MyEntity3423 myEntity3423_6_3 = new MyEntity3423().setCustomField("child test data 6[3]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_3);
        MyEntity3423 myEntity3423_6_4 = new MyEntity3423().setCustomField("child test data 6[4]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_4);
        MyEntity3423 myEntity3423_6_5 = new MyEntity3423().setCustomField("child test data 6[5]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_5);
        MyEntity3423 myEntity3423_6_6 = new MyEntity3423().setCustomField("child test data 6[6]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_6);
        MyEntity3423 myEntity3423_6_7 = new MyEntity3423().setCustomField("child test data 6[7]").setCustomFieldEntity(myEntity3422_6);
        repositoryChild.save(myEntity3423_6_7);


        MyEntity3423 myEntity3423_7_0 = new MyEntity3423().setCustomField("child test data 7[0]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_0);
        MyEntity3423 myEntity3423_7_1 = new MyEntity3423().setCustomField("child test data 7[1]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_1);
        MyEntity3423 myEntity3423_7_2 = new MyEntity3423().setCustomField("child test data 7[2]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_2);
        MyEntity3423 myEntity3423_7_3 = new MyEntity3423().setCustomField("child test data 7[3]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_3);
        MyEntity3423 myEntity3423_7_4 = new MyEntity3423().setCustomField("child test data 7[4]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_4);
        MyEntity3423 myEntity3423_7_5 = new MyEntity3423().setCustomField("child test data 7[5]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_5);
        MyEntity3423 myEntity3423_7_6 = new MyEntity3423().setCustomField("child test data 7[6]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_6);
        MyEntity3423 myEntity3423_7_7 = new MyEntity3423().setCustomField("child test data 7[7]").setCustomFieldEntity(myEntity3422_7);
        repositoryChild.save(myEntity3423_7_7);

    }

}