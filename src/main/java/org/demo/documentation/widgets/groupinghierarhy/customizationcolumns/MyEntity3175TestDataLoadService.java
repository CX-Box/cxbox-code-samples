package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.*;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MyEntity3175TestDataLoadService {

	@Autowired
	MyEntity3175Repository repository;
	@Autowired
	MyEntity3175PickRepository repositoryPick;
	@Autowired
	MyEntity3175InlinePickRepository repositoryInlinePick;

	@Autowired
	InternalAuthorizationService authzService;

	@Autowired
	CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3175().setCustomField("test data"));
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");

		MyEntity3175MultiHover myEntity1 = new MyEntity3175MultiHover().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3175MultiHover myEntity2 = new MyEntity3175MultiHover().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3175MultiHover> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3175Pick myEntityPick = new MyEntity3175Pick().setCustomField("Test data Pick");
		MyEntity3175InlinePick myEntityPick2 = new MyEntity3175InlinePick().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryInlinePick.save(myEntityPick2);
		MyEntity3175Multi myEntity3 = new MyEntity3175Multi().setCustomField("Test data 3");
		MyEntity3175Multi myEntity4 = new MyEntity3175Multi().setCustomField("Test data 4");
		List<MyEntity3175Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3175 myEntity3175new = new MyEntity3175().setCustomField("Test data")
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
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(myEntity3175new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
	}

}