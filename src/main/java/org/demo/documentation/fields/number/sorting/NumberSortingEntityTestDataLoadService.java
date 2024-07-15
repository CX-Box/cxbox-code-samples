package org.demo.documentation.fields.number.sorting;

import javax.annotation.PostConstruct;
import  jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NumberSortingEntityTestDataLoadService {

	@Autowired
	NumberSortingEntityRepository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new NumberSortingEntity().setCustomField(Long.valueOf(234567)));
		repository.save(new NumberSortingEntity().setCustomField(Long.valueOf(123456)));
		repository.save(new NumberSortingEntity().setCustomField(Long.valueOf(456789)));
	}

}