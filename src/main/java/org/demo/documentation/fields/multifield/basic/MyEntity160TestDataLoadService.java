package org.demo.documentation.fields.multifield.basic;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
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
				.setCustomField("Test data 2")
				.setInformationField("Information data 2")
				.setCustomFieldMulti("Data multi 2")
				.setCustomFieldAdditionalMulti("Additional data multi 2")
				.setCustomFieldAdditional("Additional test data 2")
		);
		repository.save(new MyEntity160()
				.setCustomField("Test data")
				.setInformationField("Information data")
				.setCustomFieldMulti("Data multi")
				.setCustomFieldAdditionalMulti("Additional data multi")
				.setCustomFieldAdditional("Additional test data")
		);
	}

}