package org.demo.documentation.multipleselect.validationbusinessex;

import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.multipleselect.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity248TestDataLoadService {

	@Autowired
	MyEntity248Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity248().setCustomField(Collections.singleton(CustomFieldEnum.LOW)));
	}

}