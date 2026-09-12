package org.demo.documentation.fields.multivaluetree.filtration;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MyEntity3318TestDataLoadService {

	@Autowired
	MyEntity3318Repository repository;

	@Autowired
	MyEntity3318MultivalueRepository repository3318Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3318Multivalue myEntity1 = new MyEntity3318Multivalue().setCustomField("Test data");
		MyEntity3318Multivalue myEntity2 = new MyEntity3318Multivalue().setCustomField("Test2 data");
		MyEntity3318Multivalue myEntity3 = new MyEntity3318Multivalue().setCustomField("Test3 data");
		MyEntity3318Multivalue myEntity4 = new MyEntity3318Multivalue().setCustomField("Test4 data");
		MyEntity3318Multivalue myEntity5 = new MyEntity3318Multivalue().setCustomField("Test5 data");
		List<MyEntity3318Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3318().setCustomFieldList(list));
		List<MyEntity3318Multivalue> list2 = new ArrayList<>();
		list2.add(myEntity4);
		list2.add(myEntity5);
		repository.save(new MyEntity3318().setCustomFieldList(list2));
		List<MyEntity3318Multivalue> list3 = new ArrayList<>();
		list3.add(myEntity3);
		repository.save(new MyEntity3318().setCustomFieldList(list3));
		MyEntity3318Multivalue myEntity3318MultivalueGroup = repository3318Multivalue.save(new MyEntity3318Multivalue().setCustomField("Test group"));
		repository3318Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3318MultivalueGroup.getId()))
				.forEach(e -> repository3318Multivalue.save(e.setParentId(myEntity3318MultivalueGroup.getId())));
	}

}