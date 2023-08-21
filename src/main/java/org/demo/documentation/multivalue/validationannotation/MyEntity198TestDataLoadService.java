package org.demo.documentation.multivalue.validationannotation;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity198TestDataLoadService {

	@Autowired
	MyEntity198Repository repository;

	@Autowired
	MyEntity199Repository repository199;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity199 myEntity1 = new MyEntity199().setCustomField("Test data");
		MyEntity199 myEntity2 = new MyEntity199().setCustomField("Abs data");
		List<MyEntity199> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity198());
	}

}