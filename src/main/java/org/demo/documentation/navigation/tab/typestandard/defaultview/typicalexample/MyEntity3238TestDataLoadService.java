package org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.child.MyEntity3239Repository;
import org.demo.documentation.navigation.tab.typestandard.defaultview.typicalexample.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3238TestDataLoadService {

	@Autowired
	MyEntity3238Repository repository;

	@Autowired
	MyEntity3239Repository repositoryChild;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repository.deleteAll();
		repository.save(new MyEntity3238().setFullName("Gilbert L.").setAddress("Moscow, st. Bagritsky, 3").setStatus(StatusEnum.HIGH));
		repository.save(new MyEntity3238().setFullName("Tommy J. Houghton").setAddress("St. Petersburg, st. Narvskaya, 41").setStatus(StatusEnum.MIDDLE));
		repository.save(new MyEntity3238().setFullName("Blair L. Smith").setAddress("Moscow, Kotelny proezd, 93").setStatus(StatusEnum.LOW));

	}

}