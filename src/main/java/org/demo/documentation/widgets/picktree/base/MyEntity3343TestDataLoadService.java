package org.demo.documentation.widgets.picktree.base;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.cxbox.core.file.dto.CxboxResponseDTO;
import org.cxbox.core.file.dto.FileUploadDto;
import org.demo.documentation.widgets.picktree.base.allfields.MyEntity3343;
import org.demo.documentation.widgets.picktree.base.allfields.MyEntity3343Repository;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.*;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343Pick;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup.MyEntity3343PickRepository;
import org.demo.documentation.widgets.picktree.base.onefield.MyEntity3351;
import org.demo.documentation.widgets.picktree.base.onefield.MyEntity3351Repository;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351Pick;
import org.demo.documentation.widgets.picktree.base.onefield.picktreepopup.MyEntity3351PickRepository;
import org.demo.services.CustomFileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MyEntity3343TestDataLoadService {

	private final CustomFileUploadServices customFileUploadServices;
	@Autowired
	MyEntity3351PickRepository repository3351Pick;
	@Autowired
	MyEntity3351Repository repository3351;
	@Autowired
	MyEntity3343Repository repository;
	@Autowired
	MyEntity3343PickRepository repository2;
	@Autowired
	MyEntity3343PickInlinePickRepository repositoryPick;
	@Autowired
	MyEntity3343PickPickRepository repositoryPick2;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		CxboxResponseDTO<FileUploadDto> file = customFileUploadServices.uploadTxt("1");
		MyEntity3343Multi myEntity1 = new MyEntity3343Multi().setCustomField(
				"Saturn's interior is thought to be composed of a rocky core, surrounded by a deep layer of metallic hydrogen, an intermediate layer of liquid hydrogen and liquid helium");
		MyEntity3343Multi myEntity2 = new MyEntity3343Multi().setCustomField(
				"Despite consisting mostly of hydrogen and helium, most of Saturn's mass is not in the gas phase, because hydrogen becomes a non-ideal liquid when the density is above 0.01 g/cm3, which is reached at a radius containing 99.9% of Saturn's mass.");
		List<MyEntity3343Multi> list2 = new ArrayList<>();
		list2.add(myEntity1);
		list2.add(myEntity2);
		MyEntity3343PickPicktree myEntityPick = new
				MyEntity3343PickPicktree().setCustomField("Test data Pick");
		MyEntity3343PickInlinePicktree myEntityPick2 = new MyEntity3343PickInlinePicktree().setCustomField("Test data Pick2");
		repositoryPick2.save(myEntityPick);
		repositoryPick.save(myEntityPick2);
		MyEntity3343MultiMulti myEntity3 = new MyEntity3343MultiMulti().setCustomField("Test data 3");
		MyEntity3343MultiMulti myEntity4 = new MyEntity3343MultiMulti().setCustomField("Test data 4");
		List<MyEntity3343MultiMulti> list = new ArrayList<>();
		list.add(myEntity3);
		list.add(myEntity4);
		MyEntity3343Pick myEntity3343new = new MyEntity3343Pick()
				.setCustomField("Test data")
				.setCustomFieldPick("Test data Pick")
				.setCustomFieldCheckbox(true)
				.setCustomFieldDictionary(CustomFieldDictionaryEnum.HIGH)
				.setCustomFieldDateTime(LocalDateTime.now())
				.setCustomFieldDateTimeWithSeconds(LocalDateTime.now())
				.setCustomFieldDate(LocalDateTime.now())
				.setCustomFieldText("Unlike a digital typeface, a metal font would not include a single definition of each character, but commonly used characters (such as vowels and periods) would have more physical type-pieces included.")
				.setCustomFieldNumber(7L)
				.setCustomFieldPercent(9L)
				.setCustomFieldMoney(10000.0)
				.setCustomFieldRadio(CustomFieldRadioEnum.LOW)
				.setCustomFieldPicktreeEntity(myEntityPick)
				.setCustomFieldInput("Test data")
				.setCustomFieldFileUploade(file.getData().getName())
				.setCustomFieldFileUploadeId(file.getData().getId())
				.setCustomFieldInlinePicktreeEntity(myEntityPick2);
		repository2.save(myEntity3343new.setCustomFieldMultivalueHoverList(list).setCustomFieldMultivalueList(list2));
		repository.save(new MyEntity3343().setCustomFieldEntity(myEntity3343new));

		repository3351.deleteAll();
		repository3351.save(new MyEntity3351().setCustomField("test data"));
		repository3351.save(new MyEntity3351().setCustomField("test data2"));
		repository3351.save(new MyEntity3351().setCustomField("test data3"));

		repository3351Pick.deleteAll();
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data2"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data3"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data4"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data5"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data6"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data3"));
		repository3351Pick.save(new MyEntity3351Pick().setCustomField("test data3"));
		MyEntity3343PickInlinePicktree myEntity3343PickInlinePicktreeGroup = repositoryPick.save(new MyEntity3343PickInlinePicktree().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3343PickInlinePicktreeGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3343PickInlinePicktreeGroup.getId())));
		MyEntity3343PickPicktree myEntity3343PickPicktreeGroup = repositoryPick2.save(new MyEntity3343PickPicktree().setCustomField("Test group"));
		repositoryPick2.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3343PickPicktreeGroup.getId()))
				.forEach(e -> repositoryPick2.save(e.setParentId(myEntity3343PickPicktreeGroup.getId())));
		MyEntity3343Pick myEntity3343PickGroup = repository2.save(new MyEntity3343Pick().setCustomFieldPick("Test group"));
		repository2.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3343PickGroup.getId()))
				.forEach(e -> repository2.save(e.setParentId(myEntity3343PickGroup.getId())));
		MyEntity3351Pick myEntity3351PickGroup = repository3351Pick.save(new MyEntity3351Pick().setCustomField("Test group"));
		repository3351Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3351PickGroup.getId()))
				.forEach(e -> repository3351Pick.save(e.setParentId(myEntity3351PickGroup.getId())));
	}

}