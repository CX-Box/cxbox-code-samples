package org.demo.documentation.fields.multivalue.ro;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity180TestDataLoadService {

	@Autowired
	MyEntity180Repository repository;

	@Autowired
	MyEntity181Repository repository181;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity181 myEntity1 = new MyEntity181().setCustomField("Test data");
		MyEntity181 myEntity2 = new MyEntity181().setCustomField("Abs data");
		List<MyEntity181> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity180().setCustomFieldList(list));
	}

}