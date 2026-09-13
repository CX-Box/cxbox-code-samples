package org.demo.documentation.fields.multivaluetree.validationconfirm;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3326TestDataLoadService {

	@Autowired
	MyEntity3326Repository repository;

	@Autowired
	MyEntity3326MultivalueRepository repository3326Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3326Multivalue myEntity1 = new MyEntity3326Multivalue().setCustomField("Test data");
		MyEntity3326Multivalue myEntity2 = new MyEntity3326Multivalue().setCustomField("Abs data");
		List<MyEntity3326Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3326().setCustomFieldList(list));
		MyEntity3326Multivalue myEntity3326MultivalueGroup = repository3326Multivalue.save(new MyEntity3326Multivalue().setCustomField("Test group"));
		repository3326Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3326MultivalueGroup.getId()))
				.forEach(e -> repository3326Multivalue.save(e.setParentId(myEntity3326MultivalueGroup.getId())));
	}

}