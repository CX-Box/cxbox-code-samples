package org.demo.documentation.widgets.tree.colortitle;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorRadioEnum;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267InlinePicklist;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Multi;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti;
import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Picklist;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MyEntity3267TestDataLoadService {
	private final CustomFileUploadServices customFileUploadServices;
	@Autowired
	MyEntity3267Repository repository;
	@Autowired
	MyEntity3267PickRepository repositoryPick;
	@Autowired
	MyEntity3267InlineRepository repositoryPick2;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
		MyEntity3267Multi myEntity1 = new MyEntity3267Multi().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3267Multi myEntity2 = new MyEntity3267Multi().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3267Multi> list = new ArrayList<>();
		list.add(myEntity1);
		list.add(myEntity2);
		MyEntity3267Picklist myEntityPick = new MyEntity3267Picklist().setCustomField("Test data Pick");
		MyEntity3267InlinePicklist myEntityPick2 = new MyEntity3267InlinePicklist().setCustomField("Test data Pick2");
		repositoryPick.save(myEntityPick);
		repositoryPick2.save(myEntityPick2);
		MyEntity3267MultiMulti myEntity3 = new MyEntity3267MultiMulti().setCustomField("Test data 3");
		MyEntity3267MultiMulti myEntity4 = new MyEntity3267MultiMulti().setCustomField("Test data 4");
		List<MyEntity3267MultiMulti> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3267 myEntity3267new = new MyEntity3267().setCustomField("Test data")
				.setCustomFieldText("Test data text")
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
				.setCustomFieldColorInput("Test data")
				.setCustomFieldColorFileUploade(file.getData().getName())
				.setCustomFieldColorFileUploadeId(file.getData().getId())
				.setCustomFieldColorInlinePicklistEntity(myEntityPick2);
		repository.save(myEntity3267new.setCustomFieldColorMultivalueHoverTree(list).setCustomFieldColorMultivalueTree(list2));
	}
}