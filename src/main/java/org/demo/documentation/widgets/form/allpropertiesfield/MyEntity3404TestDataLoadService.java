package org.demo.documentation.widgets.form.allpropertiesfield;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3404TestDataLoadService {

	@Autowired
	MyEntity3404Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3404()
				.setCustomField("test data")
				.setCustomFieldColorSort("test data 6")
				.setCustomFieldColorValidation("test data")
				.setCustomFieldColorDrilldown("test data 2")
				.setCustomFieldColorConst(60l)
				.setCustomFieldRequired("test data")
				.setCustomFieldColorConst(2L));
	}

}