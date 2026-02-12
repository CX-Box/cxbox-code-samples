package org.demo.documentation.fields.multivalue.validationbusinessex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity192TestDataLoadService {

	@Autowired
	MyEntity192Repository repository;

	@Autowired
	MyEntity193Repository repository193;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity193 myEntity1 = new MyEntity193().setCustomField("Test data");
		MyEntity193 myEntity2 = new MyEntity193().setCustomField("123 data");
		List<MyEntity193> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity192().setCustomFieldList(list));
	}

}