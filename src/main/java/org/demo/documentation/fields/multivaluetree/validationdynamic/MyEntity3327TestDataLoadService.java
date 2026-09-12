package org.demo.documentation.fields.multivaluetree.validationdynamic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3327TestDataLoadService {

	@Autowired
	MyEntity3327Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3327Multivalue myEntity1 = new MyEntity3327Multivalue().setCustomField("Test data 123").setCustomFieldAdditional("Abs data 123");
		List<MyEntity3327Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		repository.save(new MyEntity3327().setCustomFieldList(list));
	}

}