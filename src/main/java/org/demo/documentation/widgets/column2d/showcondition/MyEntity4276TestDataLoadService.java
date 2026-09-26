package org.demo.documentation.widgets.column2d.showcondition;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyEntity4276TestDataLoadService {

	private final MyEntity4276Repository repository;

	private final InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity4276().setCustomField(8L));
	}

}
