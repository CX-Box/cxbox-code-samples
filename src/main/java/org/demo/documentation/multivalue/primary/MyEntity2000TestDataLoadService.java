package org.demo.documentation.multivalue.primary;

import org.cxbox.api.service.session.InternalAuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity2000TestDataLoadService {

	@Autowired
    MyEntity2000Repository repository;

	@Autowired
    MyEntity2001Repository repository177;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity2001 myEntity1 = new MyEntity2001().setCustomField("Test data");
		MyEntity2001 myEntity2 = new MyEntity2001().setCustomField("Abs data");
		MyEntity2001 myEntity3 = new MyEntity2001().setCustomField("Information data");
		MyEntity2001 myEntity4 = new MyEntity2001().setCustomField("Information2 data");
		MyEntity2001 myEntity5 = new MyEntity2001().setCustomField("Information3 data");
		MyEntity2001 myEntity6 = new MyEntity2001().setCustomField("Information4 data");
		MyEntity2001 myEntity7 = new MyEntity2001().setCustomField("Information5 data");
		MyEntity2001 myEntity8 = new MyEntity2001().setCustomField("Information6 data");
		MyEntity2001 myEntity9 = new MyEntity2001().setCustomField("Information7 data");
		MyEntity2001 myEntity10 = new MyEntity2001().setCustomField("Information8 data");
		MyEntity2001 myEntity11 = new MyEntity2001().setCustomField("Information9 data");
		MyEntity2001 myEntity12 = new MyEntity2001().setCustomField("Information10 data");
		List<MyEntity2001> list = new ArrayList<>();
		list.add(myEntity2);
		list.add(myEntity1);
		list.add(myEntity3);
		list.add(myEntity4);
		list.add(myEntity5);
		list.add(myEntity6);
		list.add(myEntity7);
		list.add(myEntity8);
		list.add(myEntity9);
		list.add(myEntity10);
		list.add(myEntity11);
		list.add(myEntity12);
		repository.save(new MyEntity2000().setCustomFieldList(list));
	}

}