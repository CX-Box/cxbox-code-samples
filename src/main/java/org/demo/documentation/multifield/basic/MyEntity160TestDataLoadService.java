package org.demo.documentation.multifield.basic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity160TestDataLoadService {

	@Autowired
	MyEntity160Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity160()
				.setCustomField("Test data multi hint")
				.setInformationField("Information data")
				.setCustomFieldMulti("Test data multi")
				.setCustomFieldAdditionalMulti("Test data multi")
				.setCustomFieldAdditional("Test data multi hint")
		);

	}

}