package org.demo.documentation.fields.multivaluetree.ro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3322TestDataLoadService {

	@Autowired
	MyEntity3322Repository repository;

	@Autowired
	MyEntity3322MultivalueRepository repository3322Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3322Multivalue myEntity1 = new MyEntity3322Multivalue().setCustomField("Test data");
		MyEntity3322Multivalue myEntity2 = new MyEntity3322Multivalue().setCustomField("Abs data");
		List<MyEntity3322Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3322().setCustomFieldList(list));
		MyEntity3322Multivalue myEntity3322MultivalueGroup = repository3322Multivalue.save(new MyEntity3322Multivalue().setCustomField("Test group"));
		repository3322Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3322MultivalueGroup.getId()))
				.forEach(e -> repository3322Multivalue.save(e.setParentId(myEntity3322MultivalueGroup.getId())));
	}

}