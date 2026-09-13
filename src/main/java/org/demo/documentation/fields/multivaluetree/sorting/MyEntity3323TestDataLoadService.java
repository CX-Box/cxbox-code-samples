package org.demo.documentation.fields.multivaluetree.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3323TestDataLoadService {

	@Autowired
	MyEntity3323Repository repository;

	@Autowired
	MyEntity3323MultivalueRepository repository3323Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3323Multivalue myEntity1 = new MyEntity3323Multivalue().setCustomField("Test data");
		MyEntity3323Multivalue myEntity2 = new MyEntity3323Multivalue().setCustomField("Test2 data");
		MyEntity3323Multivalue myEntity3 = new MyEntity3323Multivalue().setCustomField("Abs data");
		MyEntity3323Multivalue myEntity4 = new MyEntity3323Multivalue().setCustomField("Abs2 data");
		List<MyEntity3323Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3323().setCustomFieldList(list));
		List<MyEntity3323Multivalue> list2 = new ArrayList<>();
		list.add(myEntity3);
		list.add(myEntity4);
		repository.save(new MyEntity3323().setCustomFieldList(list2));
		MyEntity3323Multivalue myEntity3323MultivalueGroup = repository3323Multivalue.save(new MyEntity3323Multivalue().setCustomField("Test group"));
		repository3323Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3323MultivalueGroup.getId()))
				.forEach(e -> repository3323Multivalue.save(e.setParentId(myEntity3323MultivalueGroup.getId())));
	}

}