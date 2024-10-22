package org.demo.documentation.widgets.info.base;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.info.base.allfields.MyEntity3001;
import org.demo.documentation.widgets.info.base.allfields.MyEntity3001Repository;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.info.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.info.base.allfields.forfields.*;
import org.demo.documentation.widgets.info.base.onefield.MyEntity3009;
import org.demo.documentation.widgets.info.base.onefield.MyEntity3009Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity3001TestDataLoadService {
	@Autowired
	MyEntity3001Repository repository;

	@Autowired
	MyEntity3009Repository repository3009;

	@Autowired
	MyEntity4222PickRepository repositoryPick;

	@Autowired
	MyEntity4222Pick2Repository repositoryPick2;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3009.deleteAll();

		repository3009.save(new MyEntity3009().setCustomField("test data"));

		MyEntity4222Multi myEntity1 = new MyEntity4222Multi().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity4222Multi myEntity2 = new MyEntity4222Multi().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity4222Multi> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity4222Pick myEntityPick = new MyEntity4222Pick().setCustomField("Test data Pick");
		MyEntity4222Pick2 myEntityPick2 = new MyEntity4222Pick2().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick2.save(myEntityPick2);
		MyEntity4222Multi2 myEntity3 = new MyEntity4222Multi2().setCustomField("Test data 3");
		MyEntity4222Multi2 myEntity4 = new MyEntity4222Multi2().setCustomField("Test data 4");
		List<MyEntity4222Multi2> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
			MyEntity3001 myEntity3001new = new MyEntity3001().setCustomField("Test data")
				.setCustomFieldCheckbox(true)
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
				.setCustomFieldDateTime(LocalDateTime.now())
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldDate(LocalDateTime.now())
				.setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
				.setCustomFieldNum(7L)
				.setCustomFieldPercent(9L)
				.setCustomFieldHint("Test data Hint")
				.setCustomFieldMoney(10000.0)
				.setCustomFieldRadio(CustomFieldRadioEnum.LOW)
				.setCustomFieldPickListEntity(myEntityPick)
				.setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
				.setCustomFieldInlinePickListEntity(myEntityPick2)
			;
		repository.save(myEntity3001new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));


	}

}