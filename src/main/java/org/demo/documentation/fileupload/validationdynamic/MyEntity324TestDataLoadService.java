package org.demo.documentation.fileupload.validationdynamic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity324TestDataLoadService {

	@Autowired
	MyEntity324Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity324().setCustomField("IMG_5867.jpg")
				.setCustomFieldId("a43d9b32-98c6-44fa-a198-e98de138c833")
				.setCustomFieldAdditional("IMG_5866.jpg").setCustomFieldAdditionalId("b3728d86-14cb-11ee-be56-0242ac120002"));
	}

}

