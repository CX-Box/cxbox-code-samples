package org.demo.documentation.fields.radio.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.radio.sorting.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity28TestDataLoadService {

	@Autowired
	MyEntity28Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity28().setCustomField(CustomFieldEnum.MIDDLE));
		repository.save(new MyEntity28().setCustomField(CustomFieldEnum.HIGH));
		repository.save(new MyEntity28().setCustomField(CustomFieldEnum.LOW));
	}

}