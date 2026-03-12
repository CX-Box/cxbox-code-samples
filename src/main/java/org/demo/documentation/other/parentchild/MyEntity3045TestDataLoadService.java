package org.demo.documentation.other.parentchild;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.other.parentchild.child.MyExampleBc3045Child;
import org.demo.documentation.other.parentchild.child.MyExampleBc3045ChildRepository;
import org.demo.documentation.other.parentchild.parent.MyExampleBc3045;
import org.demo.documentation.other.parentchild.parent.MyExampleBc3045Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3045TestDataLoadService {

	@Autowired
	MyExampleBc3045Repository repository;

	@Autowired
	MyExampleBc3045ChildRepository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repository.deleteAll();

		MyExampleBc3045 myExampleBc3045 = new MyExampleBc3045().setCustomField(50L).setCustomFieldDrilldown("Test data 1");
		repository.save(myExampleBc3045);
		repositoryChild.save(new MyExampleBc3045Child().setMyExampleBc3045(myExampleBc3045).setCustomField("test1"));
		repositoryChild.save(new MyExampleBc3045Child().setMyExampleBc3045(myExampleBc3045).setCustomField("test2"));

	}

}