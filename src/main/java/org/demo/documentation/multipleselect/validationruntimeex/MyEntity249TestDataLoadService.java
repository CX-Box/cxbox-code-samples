package org.demo.documentation.multipleselect.validationruntimeex;

import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.multipleselect.validationruntimeex.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity249TestDataLoadService {

	@Autowired
	MyEntity249Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity249().setCustomField(Collections.singleton(CustomFieldEnum.LOW)));
	}

}