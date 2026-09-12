package org.demo.documentation.fields.multivaluetree.required;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3321TestDataLoadService {

	@Autowired
	MyEntity3321Repository repository;

	@Autowired
	MyEntity3321MultivalueRepository repository3321Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3321Multivalue myEntity1 = new MyEntity3321Multivalue().setCustomField("Test data");
		MyEntity3321Multivalue myEntity2 = new MyEntity3321Multivalue().setCustomField("Abs data");
		List<MyEntity3321Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3321().setCustomFieldList(list));
		MyEntity3321Multivalue myEntity3321MultivalueGroup = repository3321Multivalue.save(new MyEntity3321Multivalue().setCustomField("Test group"));
		repository3321Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3321MultivalueGroup.getId()))
				.forEach(e -> repository3321Multivalue.save(e.setParentId(myEntity3321MultivalueGroup.getId())));
	}

}