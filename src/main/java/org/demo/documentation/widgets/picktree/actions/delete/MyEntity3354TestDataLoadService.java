package org.demo.documentation.widgets.picktree.actions.delete;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup.MyEntity3354Pick;
import org.demo.documentation.widgets.picktree.actions.delete.forpicktreepopup.MyEntity3354PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3354TestDataLoadService {

	@Autowired
	MyEntity3354Repository repository;

	@Autowired
	MyEntity3354PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repository.save(new MyEntity3354().setCustomField("test data"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3354Pick().setCustomField("test data6"));
		MyEntity3354Pick myEntity3354PickGroup = repositoryPick.save(new MyEntity3354Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3354PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3354PickGroup.getId())));
	}

}