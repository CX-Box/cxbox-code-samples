package org.demo.documentation.fields.datetimewithseconds.validationconfirm;

import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DateTimeWithSecondsValidationBusinessExEntityTestDataLoadService {

	@Autowired
	DateTimeWithSecondsValidationBusinessExEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new DateTimeWithSecondsValidationBusinessExEntity().setCustomField(LocalDateTime.now()));
	}

}