package org.demo.documentation.dictionary.drilldown;


import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.dictionary.drilldown.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity86TestDataLoadService {

	@Autowired
	MyEntity86Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity86().setCustomField(CustomFieldEnum.LOW));
	}

}