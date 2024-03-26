package org.demo.documentation.inlinepicklist.sorting;


import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149;
import org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity148TestDataLoadService {

	@Autowired
	MyEntity148Repository repository;

	@Autowired
	MyEntity149Repository repository149;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository149.deleteAll();
		MyEntity149 myEntityData = new MyEntity149().setCustomField("Test data");
		MyEntity149 myEntityData2 = new MyEntity149().setCustomField("123 data");
		MyEntity149 myEntityData3 = new MyEntity149().setCustomField("Abs data");
		repository149.save(myEntityData);
		repository149.save(myEntityData2);
		repository149.save(myEntityData3);
		repository.save(new MyEntity148().setCustomFieldEntity(myEntityData));
		repository.save(new MyEntity148().setCustomFieldEntity(myEntityData2));
		repository.save(new MyEntity148().setCustomFieldEntity(myEntityData3));
	}

}