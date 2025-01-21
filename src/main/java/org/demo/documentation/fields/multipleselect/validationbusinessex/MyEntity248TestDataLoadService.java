package org.demo.documentation.fields.multipleselect.validationbusinessex;

import java.util.Collections;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.multipleselect.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
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