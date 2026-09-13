package org.demo.documentation.widgets.assoctree.actions.other.createwithparent;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyEntity3338;
import org.demo.documentation.widgets.assoctree.actions.other.createwithparent.parent.MyEntity3338Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3337TestDataLoadService {

	@Autowired
	MyEntity3337Repository repository;
	@Autowired
	MyEntity3338Repository repositoryParent;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryParent.deleteAll();

		MyEntity3338 myEntity3338 = new MyEntity3338().setCustomField("test data");
		repositoryParent.save(myEntity3338);
		MyEntity3338 myEntity3338_2 = new MyEntity3338().setCustomField("test data2");
		repositoryParent.save(myEntity3338_2);
		repository.save(new MyEntity3337().setCustomFieldEntity(myEntity3338_2).setCustomFieldText("test data").setCustomFieldTextReq("test data"));
	}

}