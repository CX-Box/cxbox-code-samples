package org.demo.documentation.fields.multivaluetree.primary;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3320TestDataLoadService {

	@Autowired
	MyEntity3320Repository repository;

	@Autowired
	MyEntity3320MultivalueRepository repository177;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3320Multivalue myEntity1 = new MyEntity3320Multivalue().setCustomField("Test data");
		MyEntity3320Multivalue myEntity2 = new MyEntity3320Multivalue().setCustomField("Abs data");
		MyEntity3320Multivalue myEntity3 = new MyEntity3320Multivalue().setCustomField("Information data");
		MyEntity3320Multivalue myEntity4 = new MyEntity3320Multivalue().setCustomField("Information2 data");
		MyEntity3320Multivalue myEntity5 = new MyEntity3320Multivalue().setCustomField("Information3 data");
		MyEntity3320Multivalue myEntity6 = new MyEntity3320Multivalue().setCustomField("Information4 data");
		MyEntity3320Multivalue myEntity7 = new MyEntity3320Multivalue().setCustomField("Information5 data");
		MyEntity3320Multivalue myEntity8 = new MyEntity3320Multivalue().setCustomField("Information6 data");
		MyEntity3320Multivalue myEntity9 = new MyEntity3320Multivalue().setCustomField("Information7 data");
		MyEntity3320Multivalue myEntity10 = new MyEntity3320Multivalue().setCustomField("Information8 data");
		MyEntity3320Multivalue myEntity11 = new MyEntity3320Multivalue().setCustomField("Information9 data");
		MyEntity3320Multivalue myEntity12 = new MyEntity3320Multivalue().setCustomField("Information10 data");
		List<MyEntity3320Multivalue> list = new ArrayList<>();
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
		repository.save(new MyEntity3320().setCustomFieldList(list));
		MyEntity3320Multivalue myEntity3320MultivalueGroup = repository177.save(new MyEntity3320Multivalue().setCustomField("Test group"));
		repository177.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3320MultivalueGroup.getId()))
				.forEach(e -> repository177.save(e.setParentId(myEntity3320MultivalueGroup.getId())));
	}

}