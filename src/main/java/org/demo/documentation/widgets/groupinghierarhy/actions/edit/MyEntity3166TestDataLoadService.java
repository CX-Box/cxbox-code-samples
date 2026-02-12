package org.demo.documentation.widgets.groupinghierarhy.actions.edit;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.basic.MyEntity3166;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.basic.MyEntity3166Repository;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview.MyEntity3167;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.newview.MyEntity3167Repository;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.MyEntity3168;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget.MyEntity3168Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum.*;

@Service
public class MyEntity3166TestDataLoadService {

	@Autowired
	MyEntity3166Repository repository3166;
	@Autowired
	MyEntity3167Repository repository3167;
	@Autowired
	MyEntity3168Repository repository3168;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3166.deleteAll();
		repository3167.deleteAll();
		repository3168.deleteAll();

		repository3166.save(new MyEntity3166().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
		repository3166.save(new MyEntity3166().setCustomField("test data 2").setCustomFieldDictionary(LOW));
		repository3166.save(new MyEntity3166().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
		repository3166.save(new MyEntity3166().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
		repository3166.save(new MyEntity3166().setCustomField("test data 5").setCustomFieldDictionary(LOW));
		repository3166.save(new MyEntity3166().setCustomField("test data 6"));
		repository3166.save(new MyEntity3166().setCustomField("test data 7"));
		repository3166.save(new MyEntity3166().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
		repository3166.save(new MyEntity3166().setCustomField("test data 9"));

		repository3167.save(new MyEntity3167().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
		repository3167.save(new MyEntity3167().setCustomField("test data 2").setCustomFieldDictionary(LOW));
		repository3167.save(new MyEntity3167().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
		repository3167.save(new MyEntity3167().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
		repository3167.save(new MyEntity3167().setCustomField("test data 5").setCustomFieldDictionary(LOW));
		repository3167.save(new MyEntity3167().setCustomField("test data 6"));
		repository3167.save(new MyEntity3167().setCustomField("test data 7"));
		repository3167.save(new MyEntity3167().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
		repository3167.save(new MyEntity3167().setCustomField("test data 9"));

		repository3168.save(new MyEntity3168().setCustomField("test data 1").setCustomFieldDictionary(HIGH));
		repository3168.save(new MyEntity3168().setCustomField("test data 2").setCustomFieldDictionary(LOW));
		repository3168.save(new MyEntity3168().setCustomField("test data 3").setCustomFieldDictionary(HIGH));
		repository3168.save(new MyEntity3168().setCustomField("test data 4").setCustomFieldDictionary(HIGH));
		repository3168.save(new MyEntity3168().setCustomField("test data 5").setCustomFieldDictionary(LOW));
		repository3168.save(new MyEntity3168().setCustomField("test data 6"));
		repository3168.save(new MyEntity3168().setCustomField("test data 7"));
		repository3168.save(new MyEntity3168().setCustomField("test data 8").setCustomFieldDictionary(MIDDLE));
		repository3168.save(new MyEntity3168().setCustomField("test data 9"));
	}

}