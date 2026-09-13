package org.demo.documentation.widgets.assoctree.actions;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3331TestDataLoadService {

	@Autowired
	MyEntity3331Repository repository;

	@Autowired
	MyEntity3331MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryMulti.deleteAll();

		repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test data 2"));
		repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test data 3"));
		repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test data 4"));
		repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test data 5"));
		repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test data 6"));

		MyEntity3331Multi myEntity = new MyEntity3331Multi().setCustomField("Test data 1");
		List<MyEntity3331Multi> list = new ArrayList<>();
		list.add(myEntity);
		repository.save(new MyEntity3331().setCustomFieldList(list));
		MyEntity3331Multi myEntity3331MultiGroup = repositoryMulti.save(new MyEntity3331Multi().setCustomField("Test group"));
		repositoryMulti.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3331MultiGroup.getId()))
				.forEach(e -> repositoryMulti.save(e.setParentId(myEntity3331MultiGroup.getId())));
	}

}