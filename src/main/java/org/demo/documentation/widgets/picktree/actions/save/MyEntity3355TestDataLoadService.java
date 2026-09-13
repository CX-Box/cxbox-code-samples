package org.demo.documentation.widgets.picktree.actions.save;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup.MyEntity3355Pick;
import org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup.MyEntity3355PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3355TestDataLoadService {

	@Autowired
	MyEntity3355Repository repository;
	@Autowired
	MyEntity3355PickRepository repositoryPick;
	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryPick.deleteAll();
		repository.save(new MyEntity3355().setCustomField("test data"));

		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data2"));
		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3355Pick().setCustomField("test data6"));
		MyEntity3355Pick myEntity3355PickGroup = repositoryPick.save(new MyEntity3355Pick().setCustomField("Test group"));
		repositoryPick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3355PickGroup.getId()))
				.forEach(e -> repositoryPick.save(e.setParentId(myEntity3355PickGroup.getId())));
	}

}