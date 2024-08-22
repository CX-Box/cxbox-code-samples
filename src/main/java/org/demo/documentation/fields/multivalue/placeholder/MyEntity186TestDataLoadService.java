package org.demo.documentation.fields.multivalue.placeholder;

import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity186TestDataLoadService {

	@Autowired
	MyEntity186Repository repository;

	@Autowired
	MyEntity187Repository repository187;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity187 myEntity1 = new MyEntity187().setCustomField("Test data");
		MyEntity187 myEntity2 = new MyEntity187().setCustomField("Abs data");
		List<MyEntity187> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity186());
	}

}