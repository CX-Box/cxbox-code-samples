package org.demo.documentation.multivalue.basic;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity176TestDataLoadService {

	@Autowired
	MyEntity176Repository repository;

	@Autowired
	MyEntity177Repository repository177;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity177 myEntity1 = new MyEntity177().setCustomField("Test data");
		MyEntity177 myEntity2 = new MyEntity177().setCustomField("Abs data");
		MyEntity177 myEntity3 = new MyEntity177().setCustomField("Information data");
		MyEntity177 myEntity4 = new MyEntity177().setCustomField("Information2 data");
		MyEntity177 myEntity5 = new MyEntity177().setCustomField("Information3 data");
		MyEntity177 myEntity6 = new MyEntity177().setCustomField("Information4 data");
		MyEntity177 myEntity7 = new MyEntity177().setCustomField("Information5 data");
		MyEntity177 myEntity8 = new MyEntity177().setCustomField("Information6 data");
		MyEntity177 myEntity9 = new MyEntity177().setCustomField("Information7 data");
		MyEntity177 myEntity10 = new MyEntity177().setCustomField("Information8 data");
		MyEntity177 myEntity11 = new MyEntity177().setCustomField("Information9 data");
		MyEntity177 myEntity12 = new MyEntity177().setCustomField("Information10 data");
		List<MyEntity177> list = new ArrayList<>();
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
		repository.save(new MyEntity176().setCustomFieldList(list));
	}

}