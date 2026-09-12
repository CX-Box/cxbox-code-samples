package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329MultiMultiAssoc;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329Picklist;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.forfields.MyEntity3329PicklistAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3329TestDataLoadService {

	@Autowired
	MyEntity3329Repository repository;

	@Autowired
	MyEntity3329PickAssocRepository repositoryPick;

	@Autowired
	MyEntity3329PicklitsAssocRepository repositoryPick2;

	@Autowired
	MyEntity3329MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3329 myEntity3329 = new MyEntity3329().setCustomField("test data");
		repository.save(myEntity3329);
		MyEntity3329MultiAssoc myEntity1 = new MyEntity3329MultiAssoc().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3329MultiAssoc myEntity2 = new MyEntity3329MultiAssoc().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3329MultiAssoc> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);

		MyEntity3329PicklistAssoc myEntityPick = new MyEntity3329PicklistAssoc().setCustomField("Test data Pick");
		MyEntity3329Picklist myEntityPick2 = new MyEntity3329Picklist().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick2.save(myEntityPick2);
		MyEntity3329MultiMultiAssoc myEntity3 = new MyEntity3329MultiMultiAssoc().setCustomField("Test data 3");
		MyEntity3329MultiMultiAssoc myEntity4 = new MyEntity3329MultiMultiAssoc().setCustomField("Test data 4");
		List<MyEntity3329MultiMultiAssoc> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3329Multi myEntity3329new = new MyEntity3329Multi().setCustomField("Test data")
				.setCustomFieldColorCheckbox(true)
				.setCustomFieldColorDictionary(CustomFieldColorDictionaryEnum.HIGH)
				.setCustomFieldColorDateTime(LocalDateTime.now())
				.setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldColorDate(LocalDateTime.now())
				.setCustomFieldColorText("Test data")
				.setCustomFieldColorNumber(7L)
				.setCustomFieldColorPercent(9L)
				.setCustomFieldColorMoney(10000.0)
				.setCustomFieldColorRadio(CustomFieldColorRadioEnum.LOW)
				.setCustomFieldColorPicklistEntity(myEntityPick)
				.setCustomFieldColorInlinePicklistEntity(myEntityPick2);
		repositoryMulti.save(myEntity3329new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));

		MyEntity3329Multi myEntity3329MultiGroup = repositoryMulti.save(new MyEntity3329Multi().setCustomField("Test group"));
		repositoryMulti.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3329MultiGroup.getId()))
				.forEach(e -> repositoryMulti.save(e.setParentId(myEntity3329MultiGroup.getId())));
		MyEntity3329PicklistAssoc myEntity3329PicklistAssocGroup = repositoryPick.save(new MyEntity3329PicklistAssoc().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3329PicklistAssocGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3329PicklistAssocGroup.getId())));
		MyEntity3329Picklist myEntity3329PicklistGroup = repositoryPick2.save(new MyEntity3329Picklist().setCustomField("Test group"));
		repositoryPick2.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3329PicklistGroup.getId()))
				.forEach(e -> repositoryPick2.save(e.setParentId(myEntity3329PicklistGroup.getId())));
	}

}