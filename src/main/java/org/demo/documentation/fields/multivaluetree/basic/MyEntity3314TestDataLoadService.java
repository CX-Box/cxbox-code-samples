package org.demo.documentation.fields.multivaluetree.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3314TestDataLoadService {

	@Autowired
	MyEntity3314Repository repository;

	@Autowired
	MyEntity3314MultivalueRepository repository3314Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3314Multivalue myEntity1 = new MyEntity3314Multivalue().setCustomField("Test data");
		MyEntity3314Multivalue myEntity2 = new MyEntity3314Multivalue().setCustomField("Abs data");
		MyEntity3314Multivalue myEntity3 = new MyEntity3314Multivalue().setCustomField("Information data");
		MyEntity3314Multivalue myEntity4 = new MyEntity3314Multivalue().setCustomField("Information2 data");
		MyEntity3314Multivalue myEntity5 = new MyEntity3314Multivalue().setCustomField("Information3 data");
		MyEntity3314Multivalue myEntity6 = new MyEntity3314Multivalue().setCustomField("Information4 data");
		MyEntity3314Multivalue myEntity7 = new MyEntity3314Multivalue().setCustomField("Information5 data");
		MyEntity3314Multivalue myEntity8 = new MyEntity3314Multivalue().setCustomField("Information6 data");
		MyEntity3314Multivalue myEntity9 = new MyEntity3314Multivalue().setCustomField("Information7 data");
		MyEntity3314Multivalue myEntity10 = new MyEntity3314Multivalue().setCustomField("Information8 data");
		MyEntity3314Multivalue myEntity11 = new MyEntity3314Multivalue().setCustomField("Information9 data");
		MyEntity3314Multivalue myEntity12 = new MyEntity3314Multivalue().setCustomField("Information10 data");
		List<MyEntity3314Multivalue> list = new ArrayList<>();
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
		repository.save(new MyEntity3314().setCustomFieldList(list));
		MyEntity3314Multivalue myEntity3314MultivalueGroup = repository3314Multivalue.save(new MyEntity3314Multivalue().setCustomField("Test group"));
		repository3314Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3314MultivalueGroup.getId()))
				.forEach(e -> repository3314Multivalue.save(e.setParentId(myEntity3314MultivalueGroup.getId())));
	}

}