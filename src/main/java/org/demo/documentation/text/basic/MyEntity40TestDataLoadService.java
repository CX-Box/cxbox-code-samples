package org.demo.documentation.text.basic;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity40TestDataLoadService {

	@Autowired
	MyEntity40Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity40().setCustomField(
				"Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included."));
	}

}