package org.demo.documentation.widgets.tree.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.tree.showcondition.byparententity.child.MyEntity3277;
import org.demo.documentation.widgets.tree.showcondition.byparententity.child.MyEntity3277Repository;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3276TestDataLoadService {

	@Autowired
	MyEntity3276Repository repositoryParent;

	@Autowired
	MyEntity3277Repository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repositoryParent.deleteAll();
		MyEntity3276 myEntity3276Parent = new MyEntity3276().setCustomFieldNumber(8L).setCustomField("Test data");
		MyEntity3276 myEntity3276Parent2 = new MyEntity3276().setCustomFieldNumber(8L).setCustomField("Test data");
		repositoryParent.save(myEntity3276Parent);
		repositoryParent.save(myEntity3276Parent2);
		repositoryChild.save(new MyEntity3277().setCustomFieldEntity(myEntity3276Parent).setCustomField("Test data"));
		repositoryChild.save(new MyEntity3277().setCustomFieldEntity(myEntity3276Parent).setCustomField("Test data2"));
	}

}
