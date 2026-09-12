package org.demo.documentation.widgets.assoctree.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330Multi;
import org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330MultiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3330TestDataLoadService {

	@Autowired
	MyEntity3330Repository repository;

	@Autowired
	MyEntity3330MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3330());
		repositoryMulti.save(new MyEntity3330Multi().setCustomField("Test data").setCustomFieldNew("Test data New"));
		repositoryMulti.save(new MyEntity3330Multi().setCustomField("Test data1").setCustomFieldNew("Test data New1"));
		repositoryMulti.save(new MyEntity3330Multi().setCustomField("Test data2").setCustomFieldNew("Test data New2"));
		repositoryMulti.save(new MyEntity3330Multi().setCustomField("Test data3").setCustomFieldNew("Test data New3"));


		MyEntity3330Multi myEntity3330MultiGroup = repositoryMulti.save(new MyEntity3330Multi().setCustomField("Test group"));
		repositoryMulti.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3330MultiGroup.getId()))
				.forEach(e -> repositoryMulti.save(e.setParentId(myEntity3330MultiGroup.getId())));
	}

}