package org.demo.documentation.fields.fileupload.validationbusinessex;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
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
	 	}

}