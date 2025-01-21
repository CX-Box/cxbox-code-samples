package org.demo.documentation.fields.multipleselect.sorting;

import java.util.Collections;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.multipleselect.sorting.enums.CustomFieldEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity258TestDataLoadService {

	@Autowired
	MyEntity258Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		repository.save(new MyEntity258().setCustomField(Collections.singleton(CustomFieldEnum.LOW)));
		repository.save(new MyEntity258().setCustomField(Collections.singleton(CustomFieldEnum.HIGH)));
		repository.save(new MyEntity258().setCustomField(Collections.singleton(CustomFieldEnum.MIDDLE)));
	}

}