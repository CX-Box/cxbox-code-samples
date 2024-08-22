package org.demo.documentation.fields.multivalue.validationruntimeex;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity196TestDataLoadService {

	@Autowired
	MyEntity196Repository repository;

	@Autowired
	MyEntity197Repository repository197;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity197 myEntity1 = new MyEntity197().setCustomField("Test data");
		MyEntity197 myEntity2 = new MyEntity197().setCustomField("Abs data");
		List<MyEntity197> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity196().setCustomFieldList(list));
	}

}