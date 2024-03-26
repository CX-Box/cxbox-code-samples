package org.demo.documentation.percent.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity6TestDataLoadService {

	@Autowired
	MyEntity6Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity6().setCustomField(Long.valueOf(27)));
		repository.save(new MyEntity6().setCustomField(Long.valueOf(1)));
		repository.save(new MyEntity6().setCustomField(Long.valueOf(100)));
		repository.save(new MyEntity6().setCustomField(Long.valueOf(12)));
		repository.save(new MyEntity6().setCustomField(Long.valueOf(13)));
	}

}