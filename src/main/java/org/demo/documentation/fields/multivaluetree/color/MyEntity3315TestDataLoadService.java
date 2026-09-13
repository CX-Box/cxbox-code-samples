package org.demo.documentation.fields.multivaluetree.color;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3315TestDataLoadService {

	@Autowired
	MyEntity3315Repository repository;

	@Autowired
	MyEntity3315MultivalueRepository repository3315Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3315Multivalue myEntity1 = new MyEntity3315Multivalue().setCustomField("Test data");
		MyEntity3315Multivalue myEntity2 = new MyEntity3315Multivalue().setCustomField("Abs data");
		List<MyEntity3315Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3315().setCustomFieldList(list));
		MyEntity3315Multivalue myEntity3315MultivalueGroup = repository3315Multivalue.save(new MyEntity3315Multivalue().setCustomField("Test group"));
		repository3315Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3315MultivalueGroup.getId()))
				.forEach(e -> repository3315Multivalue.save(e.setParentId(myEntity3315MultivalueGroup.getId())));
	}

}