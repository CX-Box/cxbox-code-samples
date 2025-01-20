package org.demo.documentation.fields.fileupload.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity102TestDataLoadService {

	@Autowired
	MyEntity102Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity102().setCustomField("IMG_5865.jpg")
				.setCustomFieldId("a43d9b32-98c6-44fa-a198-e98de138c833"));
		repository.save(new MyEntity102().setCustomField("IMG_5866.jpg")
				.setCustomFieldId("b3728d86-14cb-11ee-be56-0242ac120002"));
		repository.save(new MyEntity102().setCustomField("IMG_5867.jpg")
				.setCustomFieldId("f86a9546-14cb-11ee-be56-0242ac120002"));
	}

}