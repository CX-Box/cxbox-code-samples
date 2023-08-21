package org.demo.documentation.fileupload.validationbusinessex;


import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity103TestDataLoadService {

	@Autowired
	MyEntity103Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity103().setCustomField("IMG.jpg")
				.setCustomFieldId("a43d9b32-98c6-44fa-a198-e98de138c833"));
	}

}