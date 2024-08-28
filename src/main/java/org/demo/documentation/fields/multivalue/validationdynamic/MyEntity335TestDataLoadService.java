package org.demo.documentation.fields.multivalue.validationdynamic;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity335TestDataLoadService {

	@Autowired
	MyEntity335Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity337 myEntity1 = new MyEntity337().setCustomField("Test data 123").setCustomFieldAdditional("Abs data 123");
		List<MyEntity337> list = new ArrayList<>();
		list.add(myEntity1);
		repository.save(new MyEntity335().setCustomFieldList(list));
	}

}