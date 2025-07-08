package org.demo.documentation.fields.input.drilldown;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputDrilldownTestDataLoadService {

	@Autowired
	InputDrilldownRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new InputDrilldown().setCustomField("test data 1").setCustomField2("test data 1"));
		repository.save(new InputDrilldown().setCustomField("test data 2").setCustomField2("test data 2"));
		repository.save(new InputDrilldown().setCustomField("test data 3").setCustomField2("test data 3"));
		repository.save(new InputDrilldown().setCustomField("test data 4").setCustomField2("test data 4"));
		repository.save(new InputDrilldown().setCustomField("test data 5").setCustomField2("test data 5"));
		repository.save(new InputDrilldown().setCustomField("test data 6").setCustomField2("test data 6"));
		repository.save(new InputDrilldown());
	}

}
