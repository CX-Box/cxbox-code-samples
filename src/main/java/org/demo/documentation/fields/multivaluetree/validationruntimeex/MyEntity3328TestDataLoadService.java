package org.demo.documentation.fields.multivaluetree.validationruntimeex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3328TestDataLoadService {

	@Autowired
	MyEntity3328Repository repository;

	@Autowired
	MyEntity3328MultivalueRepository repository3328Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3328Multivalue myEntity1 = new MyEntity3328Multivalue().setCustomField("Test data");
		MyEntity3328Multivalue myEntity2 = new MyEntity3328Multivalue().setCustomField("Abs data");
		List<MyEntity3328Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3328().setCustomFieldList(list));
		MyEntity3328Multivalue myEntity3328MultivalueGroup = repository3328Multivalue.save(new MyEntity3328Multivalue().setCustomField("Test group"));
		repository3328Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3328MultivalueGroup.getId()))
				.forEach(e -> repository3328Multivalue.save(e.setParentId(myEntity3328MultivalueGroup.getId())));
	}

}