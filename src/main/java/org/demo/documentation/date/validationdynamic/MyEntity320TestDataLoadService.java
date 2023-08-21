package org.demo.documentation.date.validationdynamic;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyEntity320TestDataLoadService {

	@Autowired
	MyEntity320Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity320().setCustomField(LocalDate.now().minusDays(30))
				.setCustomFieldAdditional(LocalDate.now().minusDays(30)));

	}

}