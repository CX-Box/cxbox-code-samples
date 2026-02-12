package org.demo.documentation.widgets.property.excel.inner;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.property.excel.inner.forfields.*;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MyEntity3134TestDataLoadService {

	private final CustomFileUploadServices customFileUploadServices;
	@Autowired
	MyEntity3134Repository repository;
	@Autowired
	MyEntity3134SuggRepository repositorySugg;
	@Autowired
	MyEntity3134PickRepository repositoryPick;
	@Autowired
	MyEntity3134InlinePickRepository repositoryInlinePick;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");

		MyEntity3134MultiHover myEntity1 = new MyEntity3134MultiHover().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3134MultiHover myEntity2 = new MyEntity3134MultiHover().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3134MultiHover> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3134SuggectionPick myEntiMyEntity3134SuggectionPickyPick = new MyEntity3134SuggectionPick().setCustomField("Test data Pick");
		repositorySugg.save(myEntiMyEntity3134SuggectionPickyPick);
		MyEntity3134Pick myEntityPick = new MyEntity3134Pick().setCustomField("Test data Pick");
		MyEntity3134InlinePick myEntityPick2 = new MyEntity3134InlinePick().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryInlinePick.save(myEntityPick2);
		MyEntity3134Multi myEntity3 = new MyEntity3134Multi().setCustomField("Test data 3");
		MyEntity3134Multi myEntity4 = new MyEntity3134Multi().setCustomField("Test data 4");
		List<MyEntity3134Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3134 myEntity3134new = new MyEntity3134().setCustomField("Test data")
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
				.setCustomFieldSuggectionPickListEntity(myEntiMyEntity3134SuggectionPickyPick)
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(myEntity3134new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
	}

}