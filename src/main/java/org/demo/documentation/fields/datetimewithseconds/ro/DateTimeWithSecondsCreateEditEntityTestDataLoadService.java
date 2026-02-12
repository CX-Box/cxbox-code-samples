package org.demo.documentation.fields.datetimewithseconds.ro;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DateTimeWithSecondsCreateEditEntityTestDataLoadService {

	@Autowired
	DateTimeWithSecondsCreateEditEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeWithSecondsCreateEditEntity().setCustomField(LocalDateTime.now()));
	}

}