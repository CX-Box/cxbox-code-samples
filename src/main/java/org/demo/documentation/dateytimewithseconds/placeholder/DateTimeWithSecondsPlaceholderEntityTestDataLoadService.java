package org.demo.documentation.dateytimewithseconds.placeholder;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DateTimeWithSecondsPlaceholderEntityTestDataLoadService {

	@Autowired
	DateTimeWithSecondsPlaceholderEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeWithSecondsPlaceholderEntity().setCustomField(LocalDateTime.now()));
	}

}