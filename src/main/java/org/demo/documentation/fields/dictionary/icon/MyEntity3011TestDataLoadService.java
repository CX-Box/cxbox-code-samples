package org.demo.documentation.fields.dictionary.icon;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011Multi;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3011MultiRepository;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012Multi;
import org.demo.documentation.fields.dictionary.icon.assoc.MyEntity3012MultiRepository;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3012Repository;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3013;
import org.demo.documentation.fields.dictionary.icon.picklistpopup.MyEntity3013Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3011TestDataLoadService {

	@Autowired
	MyEntity3011Repository repository;

	@Autowired
	MyEntity3012Repository repository3012;

	@Autowired
	MyEntity3013Repository repository3013;

	@Autowired
	MyEntity3011MultiRepository repository3011multi;

	@Autowired
	MyEntity3012MultiRepository repository3012multi;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository3012.deleteAll();
		repository.deleteAll();
		repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));
		repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository.save(new MyEntity3011().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));

		repository3012.save(new MyEntity3012().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW).setCustomField("Test data"));
		repository3012.save(new MyEntity3012().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE).setCustomField("Test data2"));
		repository3012.save(new MyEntity3012().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH).setCustomField("Test data3"));

		repository3013.save(new MyEntity3013().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository3013.save(new MyEntity3013().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository3013.save(new MyEntity3013().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));

		repository3011multi.save(new MyEntity3011Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository3011multi.save(new MyEntity3011Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository3011multi.save(new MyEntity3011Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));

		repository3012multi.save(new MyEntity3012Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.LOW));
		repository3012multi.save(new MyEntity3012Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.MIDDLE));
		repository3012multi.save(new MyEntity3012Multi().setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH));

	}

}