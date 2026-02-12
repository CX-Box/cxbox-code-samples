package org.demo.documentation.fields.multivalue.required;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity188TestDataLoadService {

	@Autowired
	MyEntity188Repository repository;

	@Autowired
	MyEntity189Repository repository189;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity189 myEntity1 = new MyEntity189().setCustomField("Test data");
		MyEntity189 myEntity2 = new MyEntity189().setCustomField("Abs data");
		List<MyEntity189> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity188().setCustomFieldList(list));
	}

}