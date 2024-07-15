package org.demo.documentation.fields.dictionary.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.dictionary.filtration.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity87TestDataLoadService {

	@Autowired
	MyEntity87Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity87().setCustomField(CustomFieldEnum.LOW));
		repository.save(new MyEntity87().setCustomField(CustomFieldEnum.HIGH));
		repository.save(new MyEntity87().setCustomField(CustomFieldEnum.MIDDLE));
		repository.save(new MyEntity87().setCustomField(CustomFieldEnum.LOW));
	}

}