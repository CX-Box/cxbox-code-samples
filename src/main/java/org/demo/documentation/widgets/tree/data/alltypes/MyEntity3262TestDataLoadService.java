package org.demo.documentation.widgets.tree.data.alltypes;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.tree.base.allType.repository.MyEntity3262PickRepository;
import org.demo.documentation.widgets.tree.base.allType.repository.MyEntity3262Repository;
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

		// root 1: without Child
		Myexample3262 root1 = createBaseEntity("Root 1 without children")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueList(multiList)
				.setCustomFieldMultivalueHoverList(hoverList);

		repository.save(root1);

		// root 2: without Child
		Myexample3262 root2 = createBaseEntity("Root 2 (without children)")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(root2);

		Myexample3262Multi multi3 = new Myexample3262Multi().setCustomField("Multivalue option 3");
		Myexample3262Multi multi4 = new Myexample3262Multi().setCustomField("Multivalue option 4");

		List<Myexample3262Multi> multiList2 = Arrays.asList(multi3, multi4);

		Myexample3262MultiHover hover3 = new Myexample3262MultiHover()
				.setCustomField("Hover option A (long description for tooltip)");
		Myexample3262MultiHover hover4 = new Myexample3262MultiHover()
				.setCustomField("Hover option B (another long text)");

		List<Myexample3262MultiHover> hoverList2 = Arrays.asList(hover3, hover4);

		// root 3: without Child
		Myexample3262 root3 = createBaseEntity("Root 3  (without children)")
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId()).setCustomFieldMultivalueList(multiList2)
				.setCustomFieldMultivalueHoverList(hoverList2);
		repository.save(root3);

		Myexample3262Multi multi5 = new Myexample3262Multi().setCustomField("Multivalue option 5");
		Myexample3262Multi multi6 = new Myexample3262Multi().setCustomField("Multivalue option 6");
		List<Myexample3262Multi> multiList3 = Arrays.asList(multi5, multi6);

		Myexample3262MultiHover hover5 = new Myexample3262MultiHover()
				.setCustomField("Hover option A (long description for tooltip)");
		Myexample3262MultiHover hover6 = new Myexample3262MultiHover()
				.setCustomField("Hover option B (another long text)");
		List<Myexample3262MultiHover> hoverList3 = Arrays.asList(hover5, hover6);

		// root 4: without Child
		Myexample3262 root4 = createBaseEntity("Root 4 (without children)")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueList(multiList3)
				.setCustomFieldMultivalueHoverList(hoverList3);
		repository.save(root4);


		Myexample3262Multi multi7 = new Myexample3262Multi().setCustomField("Multivalue option 7");
		Myexample3262Multi multi8 = new Myexample3262Multi().setCustomField("Multivalue option 8");
		List<Myexample3262Multi> multiList5 = Arrays.asList(multi7, multi8);
		Myexample3262MultiHover hover7 = new Myexample3262MultiHover()
				.setCustomField("Hover option A (long description for tooltip)");
		Myexample3262MultiHover hover8 = new Myexample3262MultiHover()
				.setCustomField("Hover option B (another long text)");
		List<Myexample3262MultiHover> hoverList5 = Arrays.asList(hover7, hover8);

		// root 5
		Myexample3262 root5 = createBaseEntity("Root 5 (with children)")
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueList(multiList5)
				.setCustomFieldMultivalueHoverList(hoverList5);
		repository.save(root5);

		// ---- Create 3 child for root5 ----
		for (int i = 1; i <= 3; i++) {
			Myexample3262 child = createBaseEntity("Child " + i + " of Root 5")
					.setParentId(root5.getId())
					.setCustomFieldFileUpload(file.getData().getName())
					.setCustomFieldFileUploadId(file.getData().getId());
			child.setCustomFieldPickListEntity(pickEntity)
					.setCustomFieldInlineEntity(inlineEntity)
					.setCustomFieldMultivalueList(Arrays.asList(new Myexample3262Multi().setCustomField("Multivalue option " + i),
							new Myexample3262Multi().setCustomField("Multivalue option " + (i + 1))))
					.setCustomFieldMultivalueHoverList(Arrays.asList(new Myexample3262MultiHover()
							.setCustomField("Hover option B (another long text)"), new Myexample3262MultiHover()
							.setCustomField("Hover option B (another long text)")));
			repository.save(child);
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

