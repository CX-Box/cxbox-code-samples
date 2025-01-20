package org.demo.documentation.other.savewithparent.example3;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.savewithparent.example3.client.MyEntity3425;
import org.demo.documentation.other.savewithparent.example3.client.MyEntity3425Repository;
import org.demo.documentation.other.savewithparent.example3.relatedobject.MyEntity3423;
import org.demo.documentation.other.savewithparent.example3.relatedobject.MyEntity3423Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3422TestDataLoadService {

    @Autowired
    MyEntity3422Repository repository;
    @Autowired
    MyEntity3423Repository repository3423;
    @Autowired
    MyEntity3425Repository repositoryClient;
    @Autowired
    InternalAuthorizationService authzService;

    @Transactional
    @PostConstruct
    public void load() {
        authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
        repository3423.deleteAll();
        repositoryClient.deleteAll();
        repository.deleteAll();

        MyEntity3422 myEntity3422_1 = new MyEntity3422().setCustomField("task ").setCustomFieldDrilldown("task ");
        repository.save(myEntity3422_1);
        MyEntity3422 myEntity3422_2 = new MyEntity3422().setCustomField("task 2").setCustomFieldDrilldown("task 2");
        repository.save(myEntity3422_2);
        MyEntity3422 myEntity3422_3 = new MyEntity3422().setCustomField("task 3").setCustomFieldDrilldown("task 3");
        repository.save(myEntity3422_3);
        MyEntity3422 myEntity3422_4 = new MyEntity3422().setCustomField("task 4").setCustomFieldDrilldown("task 4");
        repository.save(myEntity3422_4);
        MyEntity3422 myEntity3422_5 =new MyEntity3422().setCustomField("task 5").setCustomFieldDrilldown("task 5");
        repository.save(myEntity3422_5);
        MyEntity3422 myEntity3422_6 = new MyEntity3422().setCustomField("task 6").setCustomFieldDrilldown("task 6");
        repository.save(myEntity3422_6);
        MyEntity3422 myEntity3422_7 = new MyEntity3422().setCustomField("task 7").setCustomFieldDrilldown("task 7");
        repository.save(myEntity3422_7);

        MyEntity3423 myEntity3423_1_0 = new MyEntity3423().setCustomField("related object 1[0]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_0);
        MyEntity3423 myEntity3423_1_1 = new MyEntity3423().setCustomField("related object 1[1]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_1);
        MyEntity3423 myEntity3423_1_2 = new MyEntity3423().setCustomField("related object 1[2]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_2);
        MyEntity3423 myEntity3423_1_3 = new MyEntity3423().setCustomField("related object 1[3]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_3);
        MyEntity3423 myEntity3423_1_4 = new MyEntity3423().setCustomField("related object 1[4]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_4);
        MyEntity3423 myEntity3423_1_5 = new MyEntity3423().setCustomField("related object 1[5]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_5);
        MyEntity3423 myEntity3423_1_6 = new MyEntity3423().setCustomField("related object 1[6]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_6);
        MyEntity3423 myEntity3423_1_7 = new MyEntity3423().setCustomField("related object 1[7]").setCustomFieldEntity(myEntity3422_1);
        repository3423.save(myEntity3423_1_7);

        MyEntity3423 myEntity3423_2_0 = new MyEntity3423().setCustomField("child test data 2[0]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_0);
        MyEntity3423 myEntity3423_2_1 = new MyEntity3423().setCustomField("child test data 2[1]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_1);
        MyEntity3423 myEntity3423_2_2 = new MyEntity3423().setCustomField("child test data 2[2]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_2);
        MyEntity3423 myEntity3423_2_3 = new MyEntity3423().setCustomField("child test data 2[3]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_3);
        MyEntity3423 myEntity3423_2_4 = new MyEntity3423().setCustomField("child test data 2[4]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_4);
        MyEntity3423 myEntity3423_2_5 = new MyEntity3423().setCustomField("child test data 2[5]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_5);
        MyEntity3423 myEntity3423_2_6 = new MyEntity3423().setCustomField("child test data 2[6]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_6);
        MyEntity3423 myEntity3423_2_7 = new MyEntity3423().setCustomField("child test data 2[7]").setCustomFieldEntity(myEntity3422_2);
        repository3423.save(myEntity3423_2_7);

        MyEntity3423 myEntity3423_3_0 = new MyEntity3423().setCustomField("child test data 3[0]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_0);
        MyEntity3423 myEntity3423_3_1 = new MyEntity3423().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_1);
        MyEntity3423 myEntity3423_3_2 = new MyEntity3423().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_2);
        MyEntity3423 myEntity3423_3_3 = new MyEntity3423().setCustomField("child test data 3[2]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_3);
        MyEntity3423 myEntity3423_3_4 = new MyEntity3423().setCustomField("child test data 3[3]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_4);
        MyEntity3423 myEntity3423_3_5 = new MyEntity3423().setCustomField("child test data 3[4]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_5);
        MyEntity3423 myEntity3423_3_6 = new MyEntity3423().setCustomField("child test data 3[5]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_6);
        MyEntity3423 myEntity3423_3_7 = new MyEntity3423().setCustomField("child test data 3[6]").setCustomFieldEntity(myEntity3422_3);
        repository3423.save(myEntity3423_3_7);

        MyEntity3423 myEntity3423_4_0 = new MyEntity3423().setCustomField("child test data 4[0]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_0);
        MyEntity3423 myEntity3423_4_1 = new MyEntity3423().setCustomField("child test data 4[1]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_1);
        MyEntity3423 myEntity3423_4_2 = new MyEntity3423().setCustomField("child test data 4[2]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_2);
        MyEntity3423 myEntity3423_4_3 = new MyEntity3423().setCustomField("child test data 4[3]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_3);
        MyEntity3423 myEntity3423_4_4 = new MyEntity3423().setCustomField("child test data 4[4]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_4);
        MyEntity3423 myEntity3423_4_5 = new MyEntity3423().setCustomField("child test data 4[5]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_5);
        MyEntity3423 myEntity3423_4_6 = new MyEntity3423().setCustomField("child test data 4[6]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_6);
        MyEntity3423 myEntity3423_4_7 = new MyEntity3423().setCustomField("child test data 4[7]").setCustomFieldEntity(myEntity3422_4);
        repository3423.save(myEntity3423_4_7);

        MyEntity3423 myEntity3423_5_0 = new MyEntity3423().setCustomField("child test data 5[0]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_0);
        MyEntity3423 myEntity3423_5_1 = new MyEntity3423().setCustomField("child test data 5[1]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_1);
        MyEntity3423 myEntity3423_5_2 = new MyEntity3423().setCustomField("child test data 5[2]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_2);
        MyEntity3423 myEntity3423_5_3 = new MyEntity3423().setCustomField("child test data 5[3]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_3);
        MyEntity3423 myEntity3423_5_4 = new MyEntity3423().setCustomField("child test data 5[4]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_4);
        MyEntity3423 myEntity3423_5_5 = new MyEntity3423().setCustomField("child test data 5[5]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_5);
        MyEntity3423 myEntity3423_5_6 = new MyEntity3423().setCustomField("child test data 5[6]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_6);
        MyEntity3423 myEntity3423_5_7 = new MyEntity3423().setCustomField("child test data 5[7]").setCustomFieldEntity(myEntity3422_5);
        repository3423.save(myEntity3423_5_7);

        MyEntity3423 myEntity3423_6_0 = new MyEntity3423().setCustomField("child test data 6[0]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_0);
        MyEntity3423 myEntity3423_6_1 = new MyEntity3423().setCustomField("child test data 6[1]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_1);
        MyEntity3423 myEntity3423_6_2 = new MyEntity3423().setCustomField("child test data 6[2]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_2);
        MyEntity3423 myEntity3423_6_3 = new MyEntity3423().setCustomField("child test data 6[3]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_3);
        MyEntity3423 myEntity3423_6_4 = new MyEntity3423().setCustomField("child test data 6[4]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_4);
        MyEntity3423 myEntity3423_6_5 = new MyEntity3423().setCustomField("child test data 6[5]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_5);
        MyEntity3423 myEntity3423_6_6 = new MyEntity3423().setCustomField("child test data 6[6]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_6);
        MyEntity3423 myEntity3423_6_7 = new MyEntity3423().setCustomField("child test data 6[7]").setCustomFieldEntity(myEntity3422_6);
        repository3423.save(myEntity3423_6_7);


        MyEntity3423 myEntity3423_7_0 = new MyEntity3423().setCustomField("child test data 7[0]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_0);
        MyEntity3423 myEntity3423_7_1 = new MyEntity3423().setCustomField("child test data 7[1]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_1);
        MyEntity3423 myEntity3423_7_2 = new MyEntity3423().setCustomField("child test data 7[2]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_2);
        MyEntity3423 myEntity3423_7_3 = new MyEntity3423().setCustomField("child test data 7[3]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_3);
        MyEntity3423 myEntity3423_7_4 = new MyEntity3423().setCustomField("child test data 7[4]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_4);
        MyEntity3423 myEntity3423_7_5 = new MyEntity3423().setCustomField("child test data 7[5]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_5);
        MyEntity3423 myEntity3423_7_6 = new MyEntity3423().setCustomField("child test data 7[6]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_6);
        MyEntity3423 myEntity3423_7_7 = new MyEntity3423().setCustomField("child test data 7[7]").setCustomFieldEntity(myEntity3422_7);
        repository3423.save(myEntity3423_7_7);


        MyEntity3425 myEntity3425_1_0 = new MyEntity3425().setCustomField("client 1[0]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_0);
        MyEntity3425 myEntity3425_1_1 = new MyEntity3425().setCustomField("client 1[1]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_1);
        MyEntity3425 myEntity3425_1_2 = new MyEntity3425().setCustomField("client 1[2]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_2);
        MyEntity3425 myEntity3425_1_3 = new MyEntity3425().setCustomField("client 1[3]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_3);
        MyEntity3425 myEntity3425_1_4 = new MyEntity3425().setCustomField("client 1[4]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_4);
        MyEntity3425 myEntity3425_1_5 = new MyEntity3425().setCustomField("client 1[5]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_5);
        MyEntity3425 myEntity3425_1_6 = new MyEntity3425().setCustomField("client 1[6]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_6);
        MyEntity3425 myEntity3425_1_7 = new MyEntity3425().setCustomField("client 1[7]").setCustomFieldEntity(myEntity3422_1);
        repositoryClient.save(myEntity3425_1_7);
    }

}