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
import org.demo.documentation.widgets.tree.base.allType.repository.MyEntity3262MultiRepository;
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
	MyEntity3262MultiRepository repositoryMulti;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));

		repository.deleteAll();
		repositoryPick.deleteAll();
		repositoryMulti.deleteAll();

		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("sample");

		// values of the pick fields: a tree of 3 levels, shown by PickTreePopup in "Tree widget customization columns"
		Myexample3262Pick pickGroup1 = savePick("Pick group 1", "Pick group 1", null);
		Myexample3262Pick pickEntity = savePick("PickList target", "Inline PickList target", pickGroup1);
		Myexample3262Pick inlineEntity = savePick("PickList target2", "Inline PickList target2", pickGroup1);
		Myexample3262Pick pickGroup2 = savePick("Pick group 2", "Pick group 2", null);
		Myexample3262Pick pickGroup21 = savePick("Pick group 2.1", "Pick group 2.1", pickGroup2);
		savePick("PickList target3", "Inline PickList target3", pickGroup21);

		// values of the multivalue fields: two groups of options, shown by AssocTreePopup in "Tree widget customization columns"
		Myexample3262Multi multiGroup1 = saveMulti("Multivalue group 1", null);
		Myexample3262Multi multiGroup2 = saveMulti("Multivalue group 2", null);
		List<Myexample3262Multi> multiOptions = new ArrayList<>();
		for (int i = 1; i <= 8; i++) {
			multiOptions.add(saveMulti("Multivalue option " + i, i <= 4 ? multiGroup1 : multiGroup2));
		}

		// root 1: without Child
		Myexample3262 root1 = createBaseEntity("Root 1 without children")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueHoverList(hoverList());
		save(root1, multiOptions.subList(0, 2));

		// root 2: without Child
		Myexample3262 root2 = createBaseEntity("Root 2 (without children)")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId());
		save(root2, List.of());

		// root 3: without Child
		Myexample3262 root3 = createBaseEntity("Root 3  (without children)")
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueHoverList(hoverList());
		save(root3, multiOptions.subList(2, 4));

		// root 4: without Child
		Myexample3262 root4 = createBaseEntity("Root 4 (without children)")
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueHoverList(hoverList());
		save(root4, multiOptions.subList(4, 6));

		// root 5
		Myexample3262 root5 = createBaseEntity("Root 5 (with children)")
				.setCustomFieldInlineEntity(inlineEntity)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldPickListEntity(pickEntity)
				.setCustomFieldFileUploadId(file.getData().getId())
				.setCustomFieldMultivalueHoverList(hoverList());
		save(root5, multiOptions.subList(6, 8));

		// ---- Create 3 child for root5, the first child has 2 children (leaves) ----
		for (int i = 1; i <= 3; i++) {
			Myexample3262 child = createBaseEntity("Child " + i + " of Root 5")
					.setParentId(root5.getId())
					.setCustomFieldFileUpload(file.getData().getName())
					.setCustomFieldFileUploadId(file.getData().getId())
					.setCustomFieldPickListEntity(pickEntity)
					.setCustomFieldInlineEntity(inlineEntity)
					.setCustomFieldMultivalueHoverList(hoverList());
			save(child, multiOptions.subList(i - 1, i + 1));
			if (i == 1) {
				for (int j = 1; j <= 2; j++) {
					Myexample3262 grandchild = createBaseEntity("Child " + j + " of Child 1")
							.setParentId(child.getId())
							.setCustomFieldPickListEntity(pickEntity)
							.setCustomFieldInlineEntity(inlineEntity);
					save(grandchild, multiOptions.subList(0, 1));
				}
			}
		}
	}

	private Myexample3262Pick savePick(String customField, String customField2, Myexample3262Pick parent) {
		return repositoryPick.save(new Myexample3262Pick()
				.setCustomField(customField)
				.setCustomField2(customField2)
				.setParentId(parent == null ? null : parent.getId()));
	}

	private Myexample3262Multi saveMulti(String customField, Myexample3262Multi parent) {
		return repositoryMulti.save(new Myexample3262Multi()
				.setCustomField(customField)
				.setParentId(parent == null ? null : parent.getId()));
	}

	private List<Myexample3262MultiHover> hoverList() {
		return new ArrayList<>(List.of(
				new Myexample3262MultiHover().setCustomField("Hover option A (long description for tooltip)"),
				new Myexample3262MultiHover().setCustomField("Hover option B (another long text)")
		));
	}

	// the options are already saved and shared by several records: persist of a new record rejects them, merge accepts them.
	// They are read again before every save: a merge may raise their version, and a merge of a stale copy fails.
	private void save(Myexample3262 entity, List<Myexample3262Multi> multivalue) {
		repository.save(entity);
		entity.setCustomFieldMultivalueList(repositoryMulti.findAllById(multivalue.stream().map(Myexample3262Multi::getId).toList()));
		repository.save(entity);
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

