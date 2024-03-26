package org.demo.documentation.multivalue.filtration;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyEntity184TestDataLoadService {

	@Autowired
	MyEntity184Repository repository;

	@Autowired
	MyEntity185Repository repository185;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity185 myEntity1 = new MyEntity185().setCustomField("Test data");
		MyEntity185 myEntity2 = new MyEntity185().setCustomField("Test2 data");
		MyEntity185 myEntity3 = new MyEntity185().setCustomField("Test3 data");
		MyEntity185 myEntity4 = new MyEntity185().setCustomField("Test4 data");
		MyEntity185 myEntity5 = new MyEntity185().setCustomField("Test5 data");
		List<MyEntity185> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity184().setCustomFieldList(list));
		List<MyEntity185> list2 = new ArrayList<>();
		list2.add(myEntity4);
		list2.add(myEntity5);
		repository.save(new MyEntity184().setCustomFieldList(list2));
		List<MyEntity185> list3 = new ArrayList<>();
		list3.add(myEntity3);
		repository.save(new MyEntity184().setCustomFieldList(list3));
	}

}