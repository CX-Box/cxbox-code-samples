package org.demo.documentation.fields.percent.sorting;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity9TestDataLoadService {

	@Autowired
	MyEntity9Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity9().setCustomField(Long.valueOf(27)));
		repository.save(new MyEntity9().setCustomField(Long.valueOf(4)));
		repository.save(new MyEntity9().setCustomField(Long.valueOf(76)));
		repository.save(new MyEntity9().setCustomField(Long.valueOf(54)));
		repository.save(new MyEntity9().setCustomField(Long.valueOf(11)));
		repository.save(new MyEntity9().setCustomField(Long.valueOf(0)));

	}

}