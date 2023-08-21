package org.demo.documentation.fileupload.ro;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity97TestDataLoadService {

	@Autowired
	MyEntity97Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity97().setCustomField("IMG_5865.jpg")
				.setCustomFieldId("a43d9b32-98c6-44fa-a198-e98de138c833"));
	}

}