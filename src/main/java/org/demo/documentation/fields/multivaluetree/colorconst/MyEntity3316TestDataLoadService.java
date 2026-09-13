package org.demo.documentation.fields.multivaluetree.colorconst;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3316TestDataLoadService {

	@Autowired
	MyEntity3316Repository repository;

	@Autowired
	MyEntity3316MultivalueRepository repository3316Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3316Multivalue myEntity1 = new MyEntity3316Multivalue().setCustomField("Test data");
		MyEntity3316Multivalue myEntity2 = new MyEntity3316Multivalue().setCustomField("Abs data");
		List<MyEntity3316Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3316().setCustomFieldList(list));
		MyEntity3316Multivalue myEntity3316MultivalueGroup = repository3316Multivalue.save(new MyEntity3316Multivalue().setCustomField("Test group"));
		repository3316Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3316MultivalueGroup.getId()))
				.forEach(e -> repository3316Multivalue.save(e.setParentId(myEntity3316MultivalueGroup.getId())));
	}

}