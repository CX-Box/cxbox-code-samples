package org.demo.documentation.fields.multipleselect.validationdynamic;

import java.util.Collections;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.multipleselect.validationdynamic.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity334TestDataLoadService {

	@Autowired
	MyEntity334Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity334().setCustomField(Collections.singleton(CustomFieldEnum.HIGH))
				.setCustomFieldAdditional(Collections.singleton(CustomFieldEnum.HIGH)));
	}

}