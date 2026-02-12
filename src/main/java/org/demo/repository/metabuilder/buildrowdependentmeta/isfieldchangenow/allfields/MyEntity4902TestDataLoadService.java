package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldRadioEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity4902TestDataLoadService {

	@Autowired
	MyEntity4902Repository repository;

	@Autowired
	MyEntity4902SuggectionRepository repoSuggection;

	@Autowired
	MyEntity4902PickRepository repositoryPick;

	@Autowired
	MyEntity4902PickInlineRepository repositoryPickInline;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repositoryPickInline.deleteAll();
		repoSuggection.save(new MyEntity4902Suggection().setCustomField("Test data Suggection 2"));
		repoSuggection.save(new MyEntity4902Suggection().setCustomField("Test data Suggection 3"));
		repoSuggection.save(new MyEntity4902Suggection().setCustomField("Test data Suggection 4"));

		MyEntity4902MultiHover myEntity1 = new MyEntity4902MultiHover().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity4902MultiHover myEntity2 = new MyEntity4902MultiHover().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity4902MultiHover> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity4902Pick myEntityPick = new MyEntity4902Pick().setCustomField("Test data Pick");
		MyEntity4902PickInline myEntityPick2 = new MyEntity4902PickInline().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick.save(new MyEntity4902Pick().setCustomField("Test data Pick2"));
		repositoryPick.save(new MyEntity4902Pick().setCustomField("Test data Pick3"));
		repositoryPick.save(new MyEntity4902Pick().setCustomField("Test data Pick4"));
		repositoryPick.save(new MyEntity4902Pick().setCustomField("Test data Pick5"));
		repositoryPickInline.save(myEntityPick2);
		MyEntity4902Multi myEntity3 = new MyEntity4902Multi().setCustomField("Test data 3");
		MyEntity4902Multi myEntity4 = new MyEntity4902Multi().setCustomField("Test data 4");
		List<MyEntity4902Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity4902 myEntity4902new = new MyEntity4902().setCustomField("Test data")
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
				.setCustomFieldInlineEntity(myEntityPick2);
		repository.save(myEntity4902new.setCustomFieldMultivalueList(list2)
				.setCustomFieldMultivalueHoverList(list));
	}

}