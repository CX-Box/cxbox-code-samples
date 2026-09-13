package org.demo.documentation.fields.multivaluetree.drilldown;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3317TestDataLoadService {

	@Autowired
	MyEntity3317Repository repository;

	@Autowired
	MyEntity3317MultivalueRepository repository3317Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3317Multivalue myEntity1 = new MyEntity3317Multivalue().setCustomField("Test data");
		MyEntity3317Multivalue myEntity2 = new MyEntity3317Multivalue().setCustomField("Abs data");
		List<MyEntity3317Multivalue> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		repository.save(new MyEntity3317().setCustomFieldList(list));
		MyEntity3317Multivalue myEntity3317MultivalueGroup = repository3317Multivalue.save(new MyEntity3317Multivalue().setCustomField("Test group"));
		repository3317Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3317MultivalueGroup.getId()))
				.forEach(e -> repository3317Multivalue.save(e.setParentId(myEntity3317MultivalueGroup.getId())));
	}

}