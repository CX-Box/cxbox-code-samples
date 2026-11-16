package org.demo.documentation.feature.file.availability;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.feature.file.availability.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6104TestDataLoadService {

	@Autowired
	MyEntity6104Repository repository;

	@Autowired
	MyEntity6105Repository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repository.deleteAll();
		MyEntity6104 task = repository.save(new MyEntity6104().setCustomField("Contract approval").setStatus(StatusEnum.OPEN));
		repositoryChild.save(new MyEntity6105().setCustomField("test data").setCustomFieldEntity(task));
	}

}
