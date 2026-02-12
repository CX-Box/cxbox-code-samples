package org.demo.documentation.widgets.assoc.colortitle.allfields;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.assoc.colortitle.allfields.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoc.colortitle.allfields.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052MultiAssoc;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052MultiMultiAssoc;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052Picklist;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052PicklistAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyEntity3052TestDataLoadService {

	@Autowired
	MyEntity3052Repository repository;

	@Autowired
	MyEntity3052PickAssocRepository repositoryPick;

	@Autowired
	MyEntity3052PicklitsAssocRepository repositoryPick2;

	@Autowired
	MyEntity3052MultiRepository repositoryMulti;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3052 myEntity3052 = new MyEntity3052().setCustomField("test data");
		repository.save(myEntity3052);
		MyEntity3052MultiAssoc myEntity1 = new MyEntity3052MultiAssoc().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3052MultiAssoc myEntity2 = new MyEntity3052MultiAssoc().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3052MultiAssoc> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);

		MyEntity3052PicklistAssoc myEntityPick = new MyEntity3052PicklistAssoc().setCustomField("Test data Pick");
		MyEntity3052Picklist myEntityPick2 = new MyEntity3052Picklist().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick2.save(myEntityPick2);
		MyEntity3052MultiMultiAssoc myEntity3 = new MyEntity3052MultiMultiAssoc().setCustomField("Test data 3");
		MyEntity3052MultiMultiAssoc myEntity4 = new MyEntity3052MultiMultiAssoc().setCustomField("Test data 4");
		List<MyEntity3052MultiMultiAssoc> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3052Multi myEntity3052new = new MyEntity3052Multi().setCustomField("Test data")
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
		repositoryMulti.save(myEntity3052new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));

	}

}