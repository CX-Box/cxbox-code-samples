package org.demo.documentation.widgets.picktree.allpropertiesfield;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup.MyEntity3357PickTreePopup;
import org.demo.documentation.widgets.picktree.allpropertiesfield.forpicktreepopup.MyEntity3357PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3357TestDataLoadService {

	@Autowired
	MyEntity3357Repository repository;

	@Autowired
	MyEntity3357PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3357().setCustomField("test data"));
		repositoryPick.save(new MyEntity3357PickTreePopup()
				.setCustomField("test data")
				.setCustomFieldColorSort("test data 6")
				.setCustomFieldColorValidation("test data")
				.setCustomFieldDrilldown("test data 2")
				.setCustomFieldColorConst(60L)
				.setCustomFieldRequired("test data")
				.setCustomFieldColorConst(2L));
		MyEntity3357PickTreePopup myEntity3357PickTreePopupGroup = repositoryPick.save(new MyEntity3357PickTreePopup().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3357PickTreePopupGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3357PickTreePopupGroup.getId())));
	}

}