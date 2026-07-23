package org.demo.documentation.widgets.picktreepopup;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktreepopup.tree.MyEntity3261Repository;
import org.demo.documentation.widgets.picktreepopup.tree.Myexample3261;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3261TestDataLoadService {

	@Autowired
	MyEntity3261Repository repository3261;

	@Autowired
	MyEntity3260Repository repository3260;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3261.deleteAll();
		repository3260.deleteAll();
		repository3261.save(new Myexample3261().setDepartment("test data"));
		repository3260.save(new Myexample3260());
	}

}