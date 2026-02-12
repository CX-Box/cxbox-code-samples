package org.demo.documentation.fields.time.baselocaltime;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MyEntity3512TestDataLoadService {

	@Autowired
	MyEntity3512Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3512()
				.setCustomField(LocalTime.from(LocalDateTime.now()))
				.setCustomFieldh(LocalTime.from(LocalDateTime.now()))
				.setCustomFieldhmm(LocalTime.from(LocalDateTime.now()))
				.setCustomFieldhmmA(LocalTime.from(LocalDateTime.now()))
				.setCustomFieldhmmssA(LocalTime.from(LocalDateTime.now()))
		);
	}

}