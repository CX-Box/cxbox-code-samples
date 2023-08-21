package org.demo.documentation.radio.validationdynamic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.radio.validationdynamic.enums.CustomFieldAdditionalEnum;
import org.demo.documentation.radio.validationdynamic.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity340TestDataLoadService {

	@Autowired
	MyEntity340Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity340().setCustomField(CustomFieldEnum.MIDDLE)
				.setCustomFieldAdditional(CustomFieldAdditionalEnum.MIDDLE));
	}

}