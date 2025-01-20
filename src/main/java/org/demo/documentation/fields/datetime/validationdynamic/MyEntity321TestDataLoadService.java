package org.demo.documentation.fields.datetime.validationdynamic;

import java.time.LocalDateTime;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity321TestDataLoadService {

	@Autowired
	MyEntity321Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity321().setCustomField(LocalDateTime.now().minusDays(30))
				.setCustomFieldAdditional(LocalDateTime.now().minusDays(30)));
	}

}