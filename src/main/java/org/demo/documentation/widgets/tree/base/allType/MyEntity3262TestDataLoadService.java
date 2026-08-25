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
		repositoryPick.deleteAll();
		repositoryPick.deleteAll();

		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("sample");


		Myexample3262Multi multi1 = new Myexample3262Multi().setCustomField("Multivalue option 1");
		Myexample3262Multi multi2 = new Myexample3262Multi().setCustomField("Multivalue option 2");
		List<Myexample3262Multi> multiList = Arrays.asList(multi1, multi2);


		Myexample3262MultiHover hover1 = new Myexample3262MultiHover()
				.setCustomField("Hover option A (long description for tooltip)");
		Myexample3262MultiHover hover2 = new Myexample3262MultiHover()
				.setCustomField("Hover option B (another long text)");
		List<Myexample3262MultiHover> hoverList = Arrays.asList(hover1, hover2);


		Myexample3262Pick pickEntity = new Myexample3262Pick().setCustomField("PickList target").setCustomField2("Inline PickList target");
		repositoryPick.save(pickEntity);

		Myexample3262Pick inlineEntity = new Myexample3262Pick().setCustomField("PickList target2").setCustomField2("Inline PickList target2");
		repositoryPick.save(inlineEntity);

		// root 1: 3 child
		Myexample3262 root1 = createBaseEntity("Root 1 (with children)");
		repository.save(root1.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity).setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId()));

		repository.save(root1.setCustomFieldMultivalueList(multiList)
				.setCustomFieldMultivalueHoverList(hoverList));

		// root 2: without Child
		Myexample3262 root2 = createBaseEntity("Root 2 (leaf)");

		repository.save(root2.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId()));
		repository.save(root2.setCustomFieldMultivalueList(Collections.singletonList(multi1))
				.setCustomFieldMultivalueHoverList(Collections.singletonList(hover1)));

		// root 3: without Child
		Myexample3262 root3 = createBaseEntity("Root 3 (leaf)");
		repository.save(root3.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId()));
		repository.save(root3).setCustomFieldMultivalueList(multiList)
				.setCustomFieldMultivalueHoverList(hoverList);

		// root 4: without Child
		Myexample3262 root4 = createBaseEntity("Root 4 (leaf)");
		repository.save(root4.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId()));
		repository.save(root4).setCustomFieldMultivalueList(multiList)
				.setCustomFieldMultivalueHoverList(hoverList);

		// root 5: without Child
		Myexample3262 root5 = createBaseEntity("Root 5 (leaf)");

		repository.save(root5).setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(root5).setCustomFieldMultivalueList(multiList)
 .setCustomFieldMultivalueHoverList(hoverList);

		// ---- Create 3 child for root1 ----
		for (int i = 1; i <= 3; i++) {
			Myexample3262 child = createBaseEntity("Child " + i + " of Root 1")
					.setParentId(root1.getId())
 					.setCustomFieldFileUpload(file.getData().getName())
					.setCustomFieldFileUploadId(file.getData().getId());
			repository.save(child).setCustomFieldPickListEntity(pickEntity)
			.setCustomFieldInlineEntity(inlineEntity);
			repository.save(child).setCustomFieldMultivalueList(multiList)
			.setCustomFieldMultivalueHoverList(hoverList);

		}
	}

	private Myexample3262 createBaseEntity(String customFieldValue) {
		return new Myexample3262()
				.setCustomField(customFieldValue)                                    // input
				.setCustomFieldHint("Field Hint") // hint
				.setCustomFieldMultipleSelect(Set.of(
						CustomFieldMultipleSelectEnum.LOW,
						CustomFieldMultipleSelectEnum.HIGH
				))                                                                   // multipleSelect
				.setCustomFieldRadio(CustomFieldRadioEnum.HIGH)                      // radio ( multifield)
				.setCustomFieldMoney(12345.67)                                       // money ( multifield)
				.setCustomFieldPercent(75L)                                          // percent
				.setCustomFieldNumber(42L)                                           // number
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)          // dictionary
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())              // dateTimeWithSeconds
				.setCustomFieldDate(LocalDateTime.now())                                 // date
				.setCustomFieldCheckbox(true)                                        // checkbox
				.setCustomFieldDateTime(LocalDateTime.now())                         // dateTime
				.setCustomFieldText("This is a long text for the text field. It can contain multiple sentences and demonstrates how multi-line display works.") // text
				.setCustomFieldHidden("Field Hidden");    // hidden
	}
}

