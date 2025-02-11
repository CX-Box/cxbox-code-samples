package org.demo.documentation.fields.input.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputFiltrationTestDataLoadService {

	@Autowired
	InputFiltrationRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new InputFiltration().setCustomField("Test data1"));
		repository.save(new InputFiltration().setCustomField("Test data2"));
		repository.save(new InputFiltration().setCustomField("Test data3"));
		repository.save(new InputFiltration().setCustomField("Test data4"));
		repository.save(new InputFiltration().setCustomField("Test data5"));
		repository.save(new InputFiltration().setCustomField("Test data6"));
		repository.save(new InputFiltration().setCustomField("Test data7"));
	}

}
