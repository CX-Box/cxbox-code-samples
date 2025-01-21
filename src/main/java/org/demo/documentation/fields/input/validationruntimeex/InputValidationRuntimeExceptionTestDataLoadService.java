package org.demo.documentation.fields.input.validationruntimeex;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class InputValidationRuntimeExceptionTestDataLoadService {

	@Autowired
	InputValidationRuntimeExceptionRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new InputValidationRuntimeException().setCustomField("test data"));
	}

}