package org.demo.documentation.fields.multipleselect.basic;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;

import org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class MyEntity251TestDataLoadService {

	@Autowired
	MyEntity251Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity251().setCustomField(Collections.singleton(CustomFieldEnum.LOW)));
	}

}