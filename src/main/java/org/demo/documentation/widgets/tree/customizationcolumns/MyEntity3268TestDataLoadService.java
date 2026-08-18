package org.demo.documentation.widgets.tree.customizationcolumns;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.*;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MyEntity3268TestDataLoadService {


	@Autowired
	MyEntity3268Repository repository;
	@Autowired
	MyEntity3268PickRepository repositoryPick;
	@Autowired
	MyEntity3268InlinePickRepository repositoryInlinePick;

	@Autowired
	InternalAuthorizationService authzService;

	@Autowired
	CustomFileUploadServices customFileUploadServices;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");


		MyEntity3268MultiHover myEntity1 = new MyEntity3268MultiHover().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3268MultiHover myEntity2 = new MyEntity3268MultiHover().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3268MultiHover> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3268Pick myEntityPick = new MyEntity3268Pick().setCustomField("Test data Pick");
		MyEntity3268InlinePick myEntityPick2 = new MyEntity3268InlinePick().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryInlinePick.save(myEntityPick2);
		MyEntity3268Multi myEntity3 = new MyEntity3268Multi().setCustomField("Test data 3");
		MyEntity3268Multi myEntity4 = new MyEntity3268Multi().setCustomField("Test data 4");
		List<MyEntity3268Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3268 myEntity3268new = new MyEntity3268().setCustomField("Test data")
				.setCustomFieldCheckBox(true)
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
				.setCustomFieldPickTreeEntity(myEntityPick)
				.setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
				.setCustomFieldInlineEntity(myEntityPick2)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(myEntity3268new.setCustomFieldMultivalueHoverTree(list).setCustomFieldMultivalueTree(list2));
	}

}