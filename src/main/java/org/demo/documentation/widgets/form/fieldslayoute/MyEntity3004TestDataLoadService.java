package org.demo.documentation.widgets.form.fieldslayoute;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3004TestDataLoadService {

	@Autowired
	MyEntity3004Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3004()
				.setCustomField("Test data")
				.setCustomField2("Test data")
				.setCustomField3("Test data")
				.setCustomField4("Test data")
				.setCustomField5("Test data")
				.setCustomField6("Test data")
				.setCustomField7("Test data")
				.setCustomField8("Test data")
				.setCustomField9("Test data")
				.setCustomField10("Test data")
		);
	}

}