package org.demo.documentation.feature.drilldown.simple;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3611TestDataLoadService {

	@Autowired
	MyEntity3611Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3611().setCustomField("test data").setCustomFieldDrillDowm("test data"));
		repository.save(new MyEntity3611().setCustomField("test data2").setCustomFieldDrillDowm("test data2"));

	}

}