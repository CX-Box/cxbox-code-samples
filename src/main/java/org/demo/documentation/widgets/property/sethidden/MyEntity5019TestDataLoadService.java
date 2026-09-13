package org.demo.documentation.widgets.property.sethidden;

import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum1;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity5019TestDataLoadService {

	@Autowired
	MyEntity5019Repository repository;

	@Autowired
	MyEntity5019PickRepository repositoryPick;

	@Autowired
	MyEntity5019MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repositoryMulti.deleteAll();
		repository.save(new MyEntity5019().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repositoryPick.save(new MyEntity5019Pick().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum2.HIGH));
		repositoryMulti.save(new MyEntity5019Multi().setCustomField("test data").setCustomFieldDictionary(CustomFieldDictionaryEnum1.HIGH));

		// the tree tab: the first record is the root, the others are its children
		List<MyEntity5019> all = repository.findAll();
		all.stream().skip(1).forEach(e -> repository.save(e.setParentId(all.get(0).getId())));
	}

}