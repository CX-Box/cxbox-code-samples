package org.demo.documentation.widgets.picktree.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.picktree.colortitle.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342PickPick;
import org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Pick;

@Service
public class MyEntity3341TestDataLoadService {

	@Autowired
	MyEntity3341Repository repository;

	@Autowired
	MyEntity3342Repository repository2;

	@Autowired
	MyEntity3342PickRepository repositoryPick;

	@Autowired
	MyEntity3342PickPickRepository repositoryPick2;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3341().setCustomField("test data"));
		MyEntity3342Multi myEntity1 = new MyEntity3342Multi().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core");
		MyEntity3342Multi myEntity2 = new MyEntity3342Multi().setCustomField("Saturn's mass is not in the gas phase");
		List<MyEntity3342Multi> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3342PickPick myEntityPick = new
				MyEntity3342PickPick().setCustomField("Test data Pick");
		MyEntity3342Pick myEntityPick2 = new MyEntity3342Pick().setCustomField("Test data Pick2");
		repositoryPick2.save(myEntityPick);
		repositoryPick.save(myEntityPick2);
		MyEntity3342MultiMulti myEntity3 = new MyEntity3342MultiMulti().setCustomField("Test data 3");
		MyEntity3342MultiMulti myEntity4 = new MyEntity3342MultiMulti().setCustomField("Test data 4");
		List<MyEntity3342MultiMulti> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3342 myEntity3342new = new MyEntity3342().setCustomField("Test data")
				.setCustomFieldColorCheckbox(true)
				.setCustomFieldColorDictionary(CustomFieldColorDictionaryEnum.HIGH)
				.setCustomFieldColorDateTime(LocalDateTime.now())
				.setCustomFieldColorDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldColorDate(LocalDateTime.now())
				.setCustomFieldColorText("Unlike a digital typeface")
				.setCustomFieldColorNumber(7L)
				.setCustomFieldColorPercent(9L)
				.setCustomFieldColorMoney(10000.0)
				.setCustomFieldColorRadio(CustomFieldColorRadioEnum.LOW)
				.setCustomFieldColorPicktreeEntity(myEntityPick)
				.setCustomFieldColorInput("Test data")
				.setCustomFieldColorInputConst("Test data")
				.setCustomFieldColorTextConst("Test data")
				.setCustomFieldColorInlinePicktreeEntity(myEntityPick2);
		repository2.save(myEntity3342new.setCustomFieldColorMultivalueHoverList(list).setCustomFieldColorMultivalueList(list2));
		MyEntity3342 myEntity3342Group = repository2.save(new MyEntity3342().setCustomField("Test group"));
		repository2.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3342Group.getId()))
				.forEach(e -> repository2.save(e.setParentId(myEntity3342Group.getId())));
		MyEntity3342PickPick myEntity3342PickPickGroup = repositoryPick2.save(new MyEntity3342PickPick().setCustomField("Test group"));
		repositoryPick2.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3342PickPickGroup.getId()))
				.forEach(e -> repositoryPick2.save(e.setParentId(myEntity3342PickPickGroup.getId())));
		MyEntity3342Pick myEntity3342PickGroup = repositoryPick.save(new MyEntity3342Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3342PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3342PickGroup.getId())));
	}

}