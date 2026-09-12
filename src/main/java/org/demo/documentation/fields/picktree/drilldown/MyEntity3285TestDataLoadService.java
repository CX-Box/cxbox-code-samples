package org.demo.documentation.fields.picktree.drilldown;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3285TestDataLoadService {

	@Autowired
	MyEntity3285Repository repository;

	@Autowired
	MyEntity3285PickRepository repository3285Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3285Pick.deleteAll();
		MyEntity3285Pick myEntity3285Pick = new MyEntity3285Pick().setCustomField("Test data");
		repository3285Pick.save(myEntity3285Pick);
		repository.save(new MyEntity3285().setCustomFieldEntity(myEntity3285Pick));
		MyEntity3285Pick myEntity3285PickGroup = repository3285Pick.save(new MyEntity3285Pick().setCustomField("Test group"));
		repository3285Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3285PickGroup.getId()))
				.forEach(e -> repository3285Pick.save(e.setParentId(myEntity3285PickGroup.getId())));
	}

}