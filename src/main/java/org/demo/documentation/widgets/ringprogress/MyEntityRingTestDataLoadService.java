package org.demo.documentation.widgets.ringprogress;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.statsblock.base.data.MyEntity4201;
import org.demo.documentation.widgets.statsblock.base.data.MyEntity4201Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntityRingTestDataLoadService {

	@Autowired
	MyEntity4201Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4201().setCustomField("Test data").setCustomFieldNum(5986L));
		repository.save(new MyEntity4201().setCustomField("Test data2").setCustomFieldNum(890L));
	}

}