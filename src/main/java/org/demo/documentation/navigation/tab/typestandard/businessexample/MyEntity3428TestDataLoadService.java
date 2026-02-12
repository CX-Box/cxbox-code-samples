package org.demo.documentation.navigation.tab.typestandard.businessexample;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.navigation.tab.typestandard.businessexample.client.MyEntity3426;
import org.demo.documentation.navigation.tab.typestandard.businessexample.client.MyEntity3426Repository;
import org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject.MyEntity3427;
import org.demo.documentation.navigation.tab.typestandard.businessexample.relatedobject.MyEntity3427Repository;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyEntity3428;
import org.demo.documentation.navigation.tab.typestandard.businessexample.task.MyEntity3428Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3428TestDataLoadService {

	@Autowired
	MyEntity3428Repository repository;
	@Autowired
	MyEntity3427Repository repository3427;
	@Autowired
	MyEntity3426Repository repositoryClient;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3427.deleteAll();
		repositoryClient.deleteAll();
		repository.deleteAll();

		MyEntity3428 myEntity3428_1 = new MyEntity3428().setCustomField("task ").setCustomFieldDrilldown("task ").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_1);
		MyEntity3428 myEntity3428_2 = new MyEntity3428().setCustomField("task 2").setCustomFieldDrilldown("task 2").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_2);
		MyEntity3428 myEntity3428_3 = new MyEntity3428().setCustomField("task 3").setCustomFieldDrilldown("task 3").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_3);
		MyEntity3428 myEntity3428_4 = new MyEntity3428().setCustomField("task 4").setCustomFieldDrilldown("task 4").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_4);
		MyEntity3428 myEntity3428_5 = new MyEntity3428().setCustomField("task 5").setCustomFieldDrilldown("task 5").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_5);
		MyEntity3428 myEntity3428_6 = new MyEntity3428().setCustomField("task 6").setCustomFieldDrilldown("task 6").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_6);
		MyEntity3428 myEntity3428_7 = new MyEntity3428().setCustomField("task 7").setCustomFieldDrilldown("task 7").setCustomFieldAdditional("task additional info");
		repository.save(myEntity3428_7);

		MyEntity3427 myEntity3427_1_0 = new MyEntity3427().setCustomField("related object 1[0]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_0);
		MyEntity3427 myEntity3427_1_1 = new MyEntity3427().setCustomField("related object 1[1]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_1);
		MyEntity3427 myEntity3427_1_2 = new MyEntity3427().setCustomField("related object 1[2]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_2);
		MyEntity3427 myEntity3427_1_3 = new MyEntity3427().setCustomField("related object 1[3]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_3);
		MyEntity3427 myEntity3427_1_4 = new MyEntity3427().setCustomField("related object 1[4]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_4);
		MyEntity3427 myEntity3427_1_5 = new MyEntity3427().setCustomField("related object 1[5]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_5);
		MyEntity3427 myEntity3427_1_6 = new MyEntity3427().setCustomField("related object 1[6]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_6);
		MyEntity3427 myEntity3427_1_7 = new MyEntity3427().setCustomField("related object 1[7]").setCustomFieldEntity(myEntity3428_1);
		repository3427.save(myEntity3427_1_7);

		MyEntity3427 myEntity3427_2_0 = new MyEntity3427().setCustomField("child test data 2[0]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_0);
		MyEntity3427 myEntity3427_2_1 = new MyEntity3427().setCustomField("child test data 2[1]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_1);
		MyEntity3427 myEntity3427_2_2 = new MyEntity3427().setCustomField("child test data 2[2]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_2);
		MyEntity3427 myEntity3427_2_3 = new MyEntity3427().setCustomField("child test data 2[3]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_3);
		MyEntity3427 myEntity3427_2_4 = new MyEntity3427().setCustomField("child test data 2[4]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_4);
		MyEntity3427 myEntity3427_2_5 = new MyEntity3427().setCustomField("child test data 2[5]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_5);
		MyEntity3427 myEntity3427_2_6 = new MyEntity3427().setCustomField("child test data 2[6]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_6);
		MyEntity3427 myEntity3427_2_7 = new MyEntity3427().setCustomField("child test data 2[7]").setCustomFieldEntity(myEntity3428_2);
		repository3427.save(myEntity3427_2_7);

		MyEntity3427 myEntity3427_3_0 = new MyEntity3427().setCustomField("child test data 3[0]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_0);
		MyEntity3427 myEntity3427_3_1 = new MyEntity3427().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_1);
		MyEntity3427 myEntity3427_3_2 = new MyEntity3427().setCustomField("child test data 3[1]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_2);
		MyEntity3427 myEntity3427_3_3 = new MyEntity3427().setCustomField("child test data 3[2]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_3);
		MyEntity3427 myEntity3427_3_4 = new MyEntity3427().setCustomField("child test data 3[3]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_4);
		MyEntity3427 myEntity3427_3_5 = new MyEntity3427().setCustomField("child test data 3[4]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_5);
		MyEntity3427 myEntity3427_3_6 = new MyEntity3427().setCustomField("child test data 3[5]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_6);
		MyEntity3427 myEntity3427_3_7 = new MyEntity3427().setCustomField("child test data 3[6]").setCustomFieldEntity(myEntity3428_3);
		repository3427.save(myEntity3427_3_7);

		MyEntity3427 myEntity3427_4_0 = new MyEntity3427().setCustomField("child test data 4[0]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_0);
		MyEntity3427 myEntity3427_4_1 = new MyEntity3427().setCustomField("child test data 4[1]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_1);
		MyEntity3427 myEntity3427_4_2 = new MyEntity3427().setCustomField("child test data 4[2]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_2);
		MyEntity3427 myEntity3427_4_3 = new MyEntity3427().setCustomField("child test data 4[3]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_3);
		MyEntity3427 myEntity3427_4_4 = new MyEntity3427().setCustomField("child test data 4[4]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_4);
		MyEntity3427 myEntity3427_4_5 = new MyEntity3427().setCustomField("child test data 4[5]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_5);
		MyEntity3427 myEntity3427_4_6 = new MyEntity3427().setCustomField("child test data 4[6]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_6);
		MyEntity3427 myEntity3427_4_7 = new MyEntity3427().setCustomField("child test data 4[7]").setCustomFieldEntity(myEntity3428_4);
		repository3427.save(myEntity3427_4_7);

		MyEntity3427 myEntity3427_5_0 = new MyEntity3427().setCustomField("child test data 5[0]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_0);
		MyEntity3427 myEntity3427_5_1 = new MyEntity3427().setCustomField("child test data 5[1]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_1);
		MyEntity3427 myEntity3427_5_2 = new MyEntity3427().setCustomField("child test data 5[2]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_2);
		MyEntity3427 myEntity3427_5_3 = new MyEntity3427().setCustomField("child test data 5[3]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_3);
		MyEntity3427 myEntity3427_5_4 = new MyEntity3427().setCustomField("child test data 5[4]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_4);
		MyEntity3427 myEntity3427_5_5 = new MyEntity3427().setCustomField("child test data 5[5]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_5);
		MyEntity3427 myEntity3427_5_6 = new MyEntity3427().setCustomField("child test data 5[6]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_6);
		MyEntity3427 myEntity3427_5_7 = new MyEntity3427().setCustomField("child test data 5[7]").setCustomFieldEntity(myEntity3428_5);
		repository3427.save(myEntity3427_5_7);

		MyEntity3427 myEntity3427_6_0 = new MyEntity3427().setCustomField("child test data 6[0]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_0);
		MyEntity3427 myEntity3427_6_1 = new MyEntity3427().setCustomField("child test data 6[1]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_1);
		MyEntity3427 myEntity3427_6_2 = new MyEntity3427().setCustomField("child test data 6[2]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_2);
		MyEntity3427 myEntity3427_6_3 = new MyEntity3427().setCustomField("child test data 6[3]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_3);
		MyEntity3427 myEntity3427_6_4 = new MyEntity3427().setCustomField("child test data 6[4]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_4);
		MyEntity3427 myEntity3427_6_5 = new MyEntity3427().setCustomField("child test data 6[5]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_5);
		MyEntity3427 myEntity3427_6_6 = new MyEntity3427().setCustomField("child test data 6[6]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_6);
		MyEntity3427 myEntity3427_6_7 = new MyEntity3427().setCustomField("child test data 6[7]").setCustomFieldEntity(myEntity3428_6);
		repository3427.save(myEntity3427_6_7);


		MyEntity3427 myEntity3427_7_0 = new MyEntity3427().setCustomField("child test data 7[0]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_0);
		MyEntity3427 myEntity3427_7_1 = new MyEntity3427().setCustomField("child test data 7[1]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_1);
		MyEntity3427 myEntity3427_7_2 = new MyEntity3427().setCustomField("child test data 7[2]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_2);
		MyEntity3427 myEntity3427_7_3 = new MyEntity3427().setCustomField("child test data 7[3]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_3);
		MyEntity3427 myEntity3427_7_4 = new MyEntity3427().setCustomField("child test data 7[4]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_4);
		MyEntity3427 myEntity3427_7_5 = new MyEntity3427().setCustomField("child test data 7[5]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_5);
		MyEntity3427 myEntity3427_7_6 = new MyEntity3427().setCustomField("child test data 7[6]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_6);
		MyEntity3427 myEntity3427_7_7 = new MyEntity3427().setCustomField("child test data 7[7]").setCustomFieldEntity(myEntity3428_7);
		repository3427.save(myEntity3427_7_7);


		MyEntity3426 myEntity3426_1_0 = new MyEntity3426().setCustomField("client 1[0]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_0);
		MyEntity3426 myEntity3426_1_1 = new MyEntity3426().setCustomField("client 1[1]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_1);
		MyEntity3426 myEntity3426_1_2 = new MyEntity3426().setCustomField("client 1[2]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_2);
		MyEntity3426 myEntity3426_1_3 = new MyEntity3426().setCustomField("client 1[3]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_3);
		MyEntity3426 myEntity3426_1_4 = new MyEntity3426().setCustomField("client 1[4]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_4);
		MyEntity3426 myEntity3426_1_5 = new MyEntity3426().setCustomField("client 1[5]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_5);
		MyEntity3426 myEntity3426_1_6 = new MyEntity3426().setCustomField("client 1[6]").setCustomFieldEntity(myEntity3428_1);
		repositoryClient.save(myEntity3426_1_6);
		MyEntity3426 myEntity3426_1_7 = new MyEntity3426().setCustomField("client 1[7]").setCustomFieldEntity(myEntity3428_1).setAddress("Moscow, st. Makarenko, 57");
		repositoryClient.save(myEntity3426_1_7);
	}

}