package org.demo.documentation.fields.multivalue.colorconst;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity178TestDataLoadService {

	@Autowired
	MyEntity178Repository repository;

	@Autowired
	MyEntity179Repository repository179;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity179 myEntity1 = new MyEntity179().setCustomField("Test data");
		MyEntity179 myEntity2 = new MyEntity179().setCustomField("Abs data");
		List<MyEntity179> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity178().setCustomFieldList(list));
	}

}