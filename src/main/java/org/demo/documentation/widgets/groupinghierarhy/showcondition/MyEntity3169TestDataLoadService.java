package org.demo.documentation.widgets.groupinghierarhy.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyEntity3169;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.MyEntity3169Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3169TestDataLoadService {

	@Autowired
	MyEntity3169Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3169().setCustomField("test data"));
	}

}