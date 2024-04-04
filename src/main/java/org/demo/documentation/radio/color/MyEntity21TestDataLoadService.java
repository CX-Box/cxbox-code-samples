package org.demo.documentation.radio.color;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.radio.color.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity21TestDataLoadService {

	@Autowired
	MyEntity21Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity21().setCustomField(CustomFieldEnum.MIDDLE));
	}

}