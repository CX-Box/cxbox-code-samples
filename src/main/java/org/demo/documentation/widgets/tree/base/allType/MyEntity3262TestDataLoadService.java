package org.demo.documentation.widgets.tree.base.allType;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@AllArgsConstructor
public class MyEntity3262TestDataLoadService {

	private final CustomFileUploadServices customFileUploadServices;
	@Autowired
	MyEntity3262Repository repository;
	@Autowired
	MyEntity3262PickRepository repositoryPick;
	@Autowired
	MyEntity3262MultiRepository repositoryMulti;
	@Autowired
	MyEntity3262MultiHoverRepository repositoryMultiHover;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));

		repository.deleteAll();
		repositoryMulti.deleteAll();
		repositoryMultiHover.deleteAll();
		repositoryPick.deleteAll();
		repositoryPick.deleteAll();

		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("sample");


		Myexample3262Multi multi1 = new Myexample3262Multi().setCustomField("Multivalue option 1");
		Myexample3262Multi multi2 = new Myexample3262Multi().setCustomField("Multivalue option 2");
		repositoryMulti.save(multi1);
		repositoryMulti.save(multi2);
		List<Myexample3262Multi> multiList = Arrays.asList(multi1, multi2);


		Myexample3262MultiHover hover1 = new Myexample3262MultiHover()
				.setCustomField("Hover option A (long description for tooltip)");
		Myexample3262MultiHover hover2 = new Myexample3262MultiHover()
				.setCustomField("Hover option B (another long text)");
		repositoryMultiHover.save(hover1);
		repositoryMultiHover.save(hover2);
		List<Myexample3262MultiHover> hoverList = Arrays.asList(hover1, hover2);


		Myexample3262Pick pickEntity = new Myexample3262Pick().setCustomField("PickList target").setCustomField2("Inline PickList target");
		repositoryPick.save(pickEntity);

		Myexample3262Pick inlineEntity = new Myexample3262Pick().setCustomField("PickList target2").setCustomField2("Inline PickList target2");
		repositoryPick.save(inlineEntity);

		// Корень 1: будет иметь 3 дочерних узла
		Myexample3262 root1 = createBaseEntity("Root 1 (with children)")
			//	.setCustomFieldMultivalueList(multiList)
			//	.setCustomFieldMultivalueHoverList(hoverList)
			//	.setCustomFieldPickListEntity(pickEntity)
			//	.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(root1);

	}


	private Myexample3262 createBaseEntity(String customFieldValue) {
		return new Myexample3262()
				.setCustomField(customFieldValue)                                    // input
				.setCustomFieldHint("Подсказка: это поле содержит дополнительную информацию") // hint
				.setCustomFieldMultipleSelect(Set.of(
						CustomFieldMultipleSelectEnum.LOW,
						CustomFieldMultipleSelectEnum.HIGH
				))                                                                   // multipleSelect
				.setCustomFieldRadio(CustomFieldRadioEnum.HIGH)                      // radio (внутри multifield)
				.setCustomFieldMoney(12345.67)                                       // money (внутри multifield)
				.setCustomFieldPercent(75L)                                          // percent
				.setCustomFieldNumber(42L)                                           // number
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)          // dictionary
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())              // dateTimeWithSeconds
				.setCustomFieldDate(LocalDateTime.now())                                 // date
				.setCustomFieldCheckbox(true)                                        // checkbox
				.setCustomFieldDateTime(LocalDateTime.now())                         // dateTime
				.setCustomFieldText("Это длинный текст для поля text. Он может содержать несколько предложений и демонстрирует работу многострочного отображения.") // text
				.setCustomFieldHidden("Скрытое значение (не отображается в UI)");    // hidden
	}
}

