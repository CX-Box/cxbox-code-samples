package org.demo.documentation.fields.multivaluetree.placeholder;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyEntity3319TestDataLoadService {

	@Autowired
	MyEntity3319Repository repository;

	@Autowired
	MyEntity3319MultivalueRepository repository3319Multivalue;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3319Multivalue.deleteAll();
		MyEntity3319Multivalue myEntity1 = new MyEntity3319Multivalue().setCustomField("Test data");
		MyEntity3319Multivalue myEntity2 = new MyEntity3319Multivalue().setCustomField("Abs data");
		repository3319Multivalue.save(myEntity1);
		repository3319Multivalue.save(myEntity2);
		repository.save(new MyEntity3319());
		MyEntity3319Multivalue myEntity3319MultivalueGroup = repository3319Multivalue.save(new MyEntity3319Multivalue().setCustomField("Test group"));
		repository3319Multivalue.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3319MultivalueGroup.getId()))
				.forEach(e -> repository3319Multivalue.save(e.setParentId(myEntity3319MultivalueGroup.getId())));
	}

}