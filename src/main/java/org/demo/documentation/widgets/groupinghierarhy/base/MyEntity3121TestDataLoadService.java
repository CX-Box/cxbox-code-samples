package org.demo.documentation.widgets.groupinghierarhy.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldRadioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.widgets.groupinghierarhy.base.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyEntity3121TestDataLoadService {

	@Autowired
	MyEntity3121Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3121().setCustomField("test data 1").setCustomFieldDictionary(HIGH).setCustomFieldCheckbox(Boolean.TRUE).setCustomFieldRadio(CustomFieldRadioEnum.MIDDLE));
		repository.save(new MyEntity3121().setCustomField("test data 2").setCustomFieldDictionary(LOW).setCustomFieldRadio(CustomFieldRadioEnum.HIGH));
		repository.save(new MyEntity3121().setCustomField("test data 3").setCustomFieldDictionary(HIGH).setCustomFieldCheckbox(Boolean.TRUE).setCustomFieldRadio(CustomFieldRadioEnum.HIGH));
		repository.save(new MyEntity3121().setCustomField("test data 4").setCustomFieldDictionary(HIGH).setCustomFieldCheckbox(Boolean.FALSE));
		repository.save(new MyEntity3121().setCustomField("test data 5").setCustomFieldDictionary(LOW));
		repository.save(new MyEntity3121().setCustomField("test data 6").setCustomFieldCheckbox(Boolean.TRUE));
		repository.save(new MyEntity3121().setCustomField("test data 7").setCustomFieldCheckbox(Boolean.TRUE));
		repository.save(new MyEntity3121().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
		repository.save(new MyEntity3121().setCustomField("test data 9").setCustomFieldRadio(CustomFieldRadioEnum.MIDDLE));

	}

}