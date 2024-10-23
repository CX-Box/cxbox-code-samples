package org.demo.documentation.widgets.form.base;

import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.form.base.allfields.MyEntity3010;
import org.demo.documentation.widgets.form.base.allfields.MyEntity3010Repository;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Pick;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010PickRepository;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.form.base.onefield.MyEntity3000;
import org.demo.documentation.widgets.form.base.onefield.MyEntity3000Repository;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity3000TestDataLoadService {

	@Autowired
	MyEntity3000Repository repository3000;

	@Autowired
	MyEntity3010Repository repository;

	@Autowired
	MyEntity3010PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3000.deleteAll();

		repository3000.save(new MyEntity3000().setCustomField("test data"));

		MyEntity3010MultiHover myEntity1 = new MyEntity3010MultiHover().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3010MultiHover myEntity2 = new MyEntity3010MultiHover().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3010MultiHover> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3010Pick myEntityPick = new MyEntity3010Pick().setCustomField("Test data Pick");
		MyEntity3010Pick  myEntityPick2 = new MyEntity3010Pick().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick.save(myEntityPick2);
		MyEntity3010Multi myEntity3 = new MyEntity3010Multi().setCustomField("Test data 3");
		MyEntity3010Multi  myEntity4 = new MyEntity3010Multi().setCustomField("Test data 4");
		List<MyEntity3010Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3010 myEntity3010new = new MyEntity3010().setCustomField("Test data")
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
				.setCustomFieldPickListEntity(myEntityPick)
				.setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
				.setCustomFieldInlineEntity(myEntityPick2)
				;
		repository.save(myEntity3010new.setCustomFieldMultivalueList(list2)
				.setCustomFieldMultivalueHoverList(list));
	}

}