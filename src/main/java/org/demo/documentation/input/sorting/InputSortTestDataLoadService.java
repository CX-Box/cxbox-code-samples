package org.demo.documentation.input.sorting;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputSortTestDataLoadService {

	@Autowired
	InputSortRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new InputSort().setCustomField("1 row"));
		repository.save(new InputSort().setCustomField("2 row"));
		repository.save(new InputSort().setCustomField("Abc row"));
		repository.save(new InputSort().setCustomField("Acb row"));
		repository.save(new InputSort().setCustomField("A1 row"));
		repository.save(new InputSort().setCustomField("A2 row"));
	}

}
