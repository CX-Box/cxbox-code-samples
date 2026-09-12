package org.demo.documentation.widgets.picktree.actions.create;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.actions.create.inlinepicktree.MyEntity3348InlinePick;
import org.demo.documentation.widgets.picktree.actions.create.inlinepicktree.MyEntity3348InlinePickRepository;
import org.demo.documentation.widgets.picktree.actions.create.picktree.MyEntity3348Pick;
import org.demo.documentation.widgets.picktree.actions.create.picktree.MyEntity3348PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3348TestDataLoadService {

	@Autowired
	MyEntity3348Repository repository;

	@Autowired
	MyEntity3348PickRepository repositoryPick;

	@Autowired
	MyEntity3348InlinePickRepository repositoryInlinePick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		MyEntity3348Pick myEntity3348Pick = new MyEntity3348Pick().setCustomFieldPick("Test data");
		repositoryPick.save(myEntity3348Pick);
		MyEntity3348InlinePick myEntity3348InlinePick = new MyEntity3348InlinePick().setCustomFieldPick("Test data Inline");
		repositoryInlinePick.save(myEntity3348InlinePick);
		repository.save(new MyEntity3348().setCustomFieldEntity(myEntity3348Pick).setCustomFieldInlinePicktreeEntity(myEntity3348InlinePick));
		MyEntity3348InlinePick myEntity3348InlinePickGroup = repositoryInlinePick.save(new MyEntity3348InlinePick().setCustomFieldPick("Test group"));
		repositoryInlinePick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3348InlinePickGroup.getId()))
				.forEach(e -> repositoryInlinePick.save(e.setParentId(myEntity3348InlinePickGroup.getId())));
		MyEntity3348Pick myEntity3348PickGroup = repositoryPick.save(new MyEntity3348Pick().setCustomFieldPick("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3348PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3348PickGroup.getId())));
	}


}