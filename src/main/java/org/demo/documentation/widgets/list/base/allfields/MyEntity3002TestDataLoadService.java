package org.demo.documentation.widgets.list.base.allfields;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.list.base.allfields.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity3002TestDataLoadService {

	@Autowired
	MyEntity3002Repository repository;

	@Autowired
	MyEntity3002PickRepository repositoryPick;

	@Autowired
	MyEntity3002Pick2Repository repositoryPick2;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3002Multi myEntity1 = new MyEntity3002Multi().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3002Multi myEntity2 = new MyEntity3002Multi().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3002Multi> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3002Pick myEntityPick = new MyEntity3002Pick().setCustomField("Test data Pick");
		MyEntity3002Pick2 myEntityPick2 = new MyEntity3002Pick2().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick2.save(myEntityPick2);
		MyEntity3002Multi2 myEntity3 = new MyEntity3002Multi2().setCustomField("Test data 3");
		MyEntity3002Multi2 myEntity4 = new MyEntity3002Multi2().setCustomField("Test data 4");
		List<MyEntity3002Multi2> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3002 myEntity3002new = new MyEntity3002().setCustomField("Test data")
				.setCustomFieldCheckbox(true)
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
				.setCustomFieldDateTime(LocalDateTime.now())
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldDate(LocalDateTime.now())
				.setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
				.setCustomFieldNumber(7L)
				.setCustomFieldPercent(9L)
				.setCustomFieldHint("Test data Hint")
				.setCustomFieldMoney(10000.0)
				.setCustomFieldRadio(CustomFieldRadioEnum.LOW)
				.setCustomFieldPickListEntity(myEntityPick2)
				.setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
				.setCustomFieldInlineEntity(myEntityPick);
		repository.save(myEntity3002new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
	}


}