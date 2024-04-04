package org.demo.documentation.radio.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.radio.filtration.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity25TestDataLoadService {

	@Autowired
	MyEntity25Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity25().setCustomField(CustomFieldEnum.MIDDLE));
		repository.save(new MyEntity25().setCustomField(CustomFieldEnum.HIGH));
		repository.save(new MyEntity25().setCustomField(CustomFieldEnum.LOW));
		repository.save(new MyEntity25().setCustomField(CustomFieldEnum.MIDDLE));
	}

}