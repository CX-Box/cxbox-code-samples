package org.demo.documentation.fields.multivalue.color;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity174TestDataLoadService {

	@Autowired
	MyEntity174Repository repository;

	@Autowired
	MyEntity175Repository repository175;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity175 myEntity1 = new MyEntity175().setCustomField("Test data");
		MyEntity175 myEntity2 = new MyEntity175().setCustomField("Abs data");
		List<MyEntity175> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity174().setCustomFieldList(list));
	}

}