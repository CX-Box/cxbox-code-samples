package org.demo.documentation.widgets.funnel.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042;
import org.demo.documentation.widgets.funnel.base.data.MyExampleBc5042Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5041TestDataLoadService {

	@Autowired
	MyExampleBc5042Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		repository.save(new MyExampleBc5042().setCustomFieldNum(36L));
		repository.save(new MyExampleBc5042().setCustomFieldNum(40L));
		repository.save(new MyExampleBc5042().setCustomFieldNum(50L));
		repository.save(new MyExampleBc5042().setCustomFieldNum(60L));
	}
}