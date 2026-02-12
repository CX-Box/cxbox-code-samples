package org.demo.documentation.widgets.picklist.actions.create;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picklist.actions.create.inlinepicklist.MyEntity3072InlinePick;
import org.demo.documentation.widgets.picklist.actions.create.inlinepicklist.MyEntity3072InlinePickRepository;
import org.demo.documentation.widgets.picklist.actions.create.picklist.MyEntity3072Pick;
import org.demo.documentation.widgets.picklist.actions.create.picklist.MyEntity3072PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3072TestDataLoadService {

	@Autowired
	MyEntity3072Repository repository;

	@Autowired
	MyEntity3072PickRepository repositoryPick;

	@Autowired
	MyEntity3072InlinePickRepository repositoryInlinePick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3072Pick myEntity3072Pick = new MyEntity3072Pick().setCustomFieldPick("Test data");
		repositoryPick.save(myEntity3072Pick);
		MyEntity3072InlinePick myEntity3072InlinePick = new MyEntity3072InlinePick().setCustomFieldPick("Test data Inline");
		repositoryInlinePick.save(myEntity3072InlinePick);
		repository.save(new MyEntity3072().setCustomFieldEntity(myEntity3072Pick).setCustomFieldInlinePicklistEntity(myEntity3072InlinePick));
	}


}