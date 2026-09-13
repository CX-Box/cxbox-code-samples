package org.demo.documentation.fields.multivaluetree.validationbusinessex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3325TestDataLoadService {

	@Autowired
	MyEntity3325Repository repository;

	@Autowired
	MyEntity3325MultivalueRepository repository3325Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3325Multivalue myEntity1 = new MyEntity3325Multivalue().setCustomField("Test data");
		MyEntity3325Multivalue myEntity2 = new MyEntity3325Multivalue().setCustomField("123 data");
		List<MyEntity3325Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3325().setCustomFieldList(list));
		MyEntity3325Multivalue myEntity3325MultivalueGroup = repository3325Multivalue.save(new MyEntity3325Multivalue().setCustomField("Test group"));
		repository3325Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3325MultivalueGroup.getId()))
				.forEach(e -> repository3325Multivalue.save(e.setParentId(myEntity3325MultivalueGroup.getId())));
	}

}