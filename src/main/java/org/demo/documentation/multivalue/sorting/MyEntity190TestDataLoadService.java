package org.demo.documentation.multivalue.sorting;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity190TestDataLoadService {

	@Autowired
	MyEntity190Repository repository;

	@Autowired
	MyEntity191Repository repository191;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity191 myEntity1 = new MyEntity191().setCustomField("Test data");
		MyEntity191 myEntity2 = new MyEntity191().setCustomField("Test2 data");
		MyEntity191 myEntity3 = new MyEntity191().setCustomField("Abs data");
		MyEntity191 myEntity4 = new MyEntity191().setCustomField("Abs2 data");
		List<MyEntity191> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity190().setCustomFieldList(list));
		List<MyEntity191> list2 = new ArrayList<>();
		list.add(myEntity3);
		list.add(myEntity4);
		repository.save(new MyEntity190().setCustomFieldList(list2));
	}

}