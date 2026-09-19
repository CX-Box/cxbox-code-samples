package org.demo.documentation.widgets.statsblock.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.child.MyEntity4233;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.child.MyEntity4233Repository;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent.MyEntity4232;
import org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent.MyEntity4232Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity4232TestDataLoadService {

	@Autowired
	MyEntity4232Repository repositoryParent;

	@Autowired
	MyEntity4233Repository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repositoryParent.deleteAll();
		MyEntity4232 parent = repositoryParent.save(new MyEntity4232().setCustomFieldNumber(8L));
		repositoryChild.save(new MyEntity4233().setCustomFieldEntity(parent).setTitle("Meetings").setValue(3L));
		repositoryChild.save(new MyEntity4233().setCustomFieldEntity(parent).setTitle("Calls").setValue(5L));
	}

}
