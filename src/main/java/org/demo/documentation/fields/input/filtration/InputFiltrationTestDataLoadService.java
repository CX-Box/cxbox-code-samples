package org.demo.documentation.fields.input.filtration;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.input.placeholder.InputPlaceholder;
import org.demo.documentation.fields.input.placeholder.InputPlaceholderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InputFiltrationTestDataLoadService {

	@Autowired
    InputPlaceholderRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new InputPlaceholder().setCustomField(""));
	}

}
