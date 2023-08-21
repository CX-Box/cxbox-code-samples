package org.demo.documentation.multipleselect.filtration;

import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.multipleselect.filtration.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity256TestDataLoadService {

	@Autowired
	MyEntity256Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity256().setCustomField(Collections.singleton(CustomFieldEnum.LOW)));
		repository.save(new MyEntity256().setCustomField(Collections.singleton(CustomFieldEnum.HIGH)));
		repository.save(new MyEntity256().setCustomField(Collections.singleton(CustomFieldEnum.HIGH)));
		repository.save(new MyEntity256().setCustomField(Collections.singleton(CustomFieldEnum.MIDDLE)));
	}

}