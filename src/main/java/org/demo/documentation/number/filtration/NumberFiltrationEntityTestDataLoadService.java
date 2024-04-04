package org.demo.documentation.number.filtration;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberFiltrationEntityTestDataLoadService {

	@Autowired
	NumberFiltrationEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new NumberFiltrationEntity().setCustomField(Long.valueOf(234567)));
		repository.save(new NumberFiltrationEntity().setCustomField(Long.valueOf(289567)));
		repository.save(new NumberFiltrationEntity().setCustomField(Long.valueOf(734567)));
		repository.save(new NumberFiltrationEntity().setCustomField(Long.valueOf(234567)));
		repository.save(new NumberFiltrationEntity().setCustomField(Long.valueOf(74567)));

	}

}