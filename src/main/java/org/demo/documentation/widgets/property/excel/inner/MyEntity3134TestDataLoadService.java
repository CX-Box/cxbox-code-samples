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
	MyEntity3134MultiRepository repositoryMulti;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositorySugg.deleteAll();
		repositoryPick.deleteAll();
		repositoryInlinePick.deleteAll();
		repositoryMulti.deleteAll();
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
		// values of the pickList field: a tree of 3 levels, shown by PickTreePopup on the tree tab
		MyEntity3134Pick pickGroup1 = savePick("Pick group 1", null);
		MyEntity3134Pick myEntityPick = savePick("Test data Pick", pickGroup1);
		savePick("Test data Pick 2", pickGroup1);
		MyEntity3134Pick pickGroup2 = savePick("Pick group 2", null);
		MyEntity3134Pick pickGroup21 = savePick("Pick group 2.1", pickGroup2);
		savePick("Test data Pick 3", pickGroup21);
		MyEntity3134InlinePick myEntityPick2 = new MyEntity3134InlinePick().setCustomField("Test data Pick2");
		repositoryInlinePick.save(myEntityPick2);
		// values of the multivalue field: two groups of options, shown by AssocTreePopup on the tree tab
		MyEntity3134Multi multiGroup1 = saveMulti("Multi group 1", null);
		MyEntity3134Multi myEntity3 = saveMulti("Test data 3", multiGroup1);
		MyEntity3134Multi myEntity4 = saveMulti("Test data 4", multiGroup1);
		MyEntity3134Multi multiGroup2 = saveMulti("Multi group 2", null);
		saveMulti("Test data 5", multiGroup2);
		saveMulti("Test data 6", multiGroup2);
		List<MyEntity3134Multi> list2 = new ArrayList<>();
		list2.add(myEntity3);
		list2.add(myEntity4);
		MyEntity3134 myEntity3134new = createBaseEntity("Test data", null)
				.setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
				.setCustomFieldPickListEntity(myEntityPick)
				.setCustomFieldInlineEntity(myEntityPick2)
				.setCustomFieldFileUpload(file.getData().getName())
				.setCustomFieldSuggectionPickListEntity(myEntiMyEntity3134SuggectionPickyPick)
				.setCustomFieldFileUploadId(file.getData().getId());
		repository.save(myEntity3134new);
		save(myEntity3134new.setCustomFieldMultivalueHoverList(list), list2);
		// the tree tab: the first record is the root with 2 children, the first child has a child (leaf)
		MyEntity3134 child1 = repository.save(createBaseEntity("Test data child 1", myEntity3134new)
				.setCustomFieldPickListEntity(myEntityPick));
		save(child1, List.of(myEntity3));
		repository.save(createBaseEntity("Test data child 2", myEntity3134new));
		repository.save(createBaseEntity("Test data child 1.1", child1));
	}

	private MyEntity3134 createBaseEntity(String customField, MyEntity3134 parent) {
		return new MyEntity3134().setCustomField(customField)
				.setCustomFieldCheckbox(true)
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
				.setCustomFieldDateTime(LocalDateTime.now())
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldDate(LocalDateTime.now())
				.setCustomFieldNumber(7L)
				.setCustomFieldPercent(9L)
				.setCustomFieldHint("Test data Hint")
				.setCustomFieldMoney(10000.0)
				.setCustomFieldRadio(CustomFieldRadioEnum.LOW)
				.setCustomFieldMultipleSelect(Collections.singleton(CustomFieldMultipleSelectEnum.LOW))
				.setParentId(parent == null ? null : parent.getId());
	}

	// the options are already saved and shared by several records: persist of a new record rejects them, merge accepts them.
	// They are read again before every save: a merge may raise their version, and a merge of a stale copy fails.
	private void save(MyEntity3134 entity, List<MyEntity3134Multi> multivalue) {
		entity.setCustomFieldMultivalueList(repositoryMulti.findAllById(multivalue.stream().map(MyEntity3134Multi::getId).toList()));
		repository.save(entity);
	}

	private MyEntity3134Pick savePick(String customField, MyEntity3134Pick parent) {
		return repositoryPick.save(new MyEntity3134Pick()
				.setCustomField(customField)
				.setParentId(parent == null ? null : parent.getId()));
	}

	private MyEntity3134Multi saveMulti(String customField, MyEntity3134Multi parent) {
		return repositoryMulti.save(new MyEntity3134Multi()
				.setCustomField(customField)
				.setParentId(parent == null ? null : parent.getId()));
	}

}
