package org.demo.documentation.widgets.assoc.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3078TestDataLoadService {

	@Autowired
	MyEntity3078Repository repository;

	@Autowired
	MyEntity3078MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3078().setCustomField("test data").setCustomFieldTest("test data text").setCustomFieldNumber(5L));
		repository.save(new MyEntity3078().setCustomField("test data 2").setCustomFieldTest("test data text 2").setCustomFieldNumber(6L));
		repository.save(new MyEntity3078().setCustomField("test data 3").setCustomFieldTest("test data text 3").setCustomFieldNumber(7L));
		repository.save(new MyEntity3078().setCustomField("test data 4").setCustomFieldTest("test data text 4").setCustomFieldNumber(8L));
		repository.save(new MyEntity3078().setCustomField("test data 5").setCustomFieldTest("test data text 5").setCustomFieldNumber(95L));
		repository.save(new MyEntity3078().setCustomField("test data 6").setCustomFieldTest("test data text 6").setCustomFieldNumber(55L));
		repository.save(new MyEntity3078().setCustomField("test data 7").setCustomFieldTest("test data text 7").setCustomFieldNumber(53L));
		repository.save(new MyEntity3078().setCustomField("test data 8").setCustomFieldTest("test data text 8").setCustomFieldNumber(55L));

		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data").setCustomFieldTest("test data text").setCustomFieldNumber(5L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 2").setCustomFieldTest("test data text 2").setCustomFieldNumber(6L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 3").setCustomFieldTest("test data text 3").setCustomFieldNumber(7L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 4").setCustomFieldTest("test data text 4").setCustomFieldNumber(8L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 5").setCustomFieldTest("test data text 5").setCustomFieldNumber(95L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 6").setCustomFieldTest("test data text 6").setCustomFieldNumber(55L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 7").setCustomFieldTest("test data text 7").setCustomFieldNumber(53L));
		repositoryMulti.save(new MyEntity3078Assoc().setCustomField("test data 8").setCustomFieldTest("test data text 8").setCustomFieldNumber(55L));
	}

}