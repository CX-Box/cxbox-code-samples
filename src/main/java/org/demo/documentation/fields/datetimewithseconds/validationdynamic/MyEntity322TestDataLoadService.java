package org.demo.documentation.fields.datetimewithseconds.validationdynamic;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity322TestDataLoadService {

	@Autowired
	MyEntity322Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity322().setCustomField(LocalDateTime.now().minusDays(30))
				.setCustomFieldAdditional(LocalDateTime.now().minusDays(30)));

	}

}