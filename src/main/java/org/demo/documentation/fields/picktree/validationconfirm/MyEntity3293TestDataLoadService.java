package org.demo.documentation.fields.picktree.validationconfirm;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3293TestDataLoadService {

	@Autowired
	MyEntity3293Repository repository;

	@Autowired
	MyEntity3293PickRepository repository3293Pick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository3293Pick.deleteAll();
		MyEntity3293Pick myEntity3293Pick = new MyEntity3293Pick().setCustomField("Test data");
		repository3293Pick.save(myEntity3293Pick);
		repository.save(new MyEntity3293().setCustomFieldEntity(myEntity3293Pick));
		MyEntity3293Pick myEntity3293PickGroup = repository3293Pick.save(new MyEntity3293Pick().setCustomField("Test group"));
		repository3293Pick.findAll().stream()
				.filter(e -> !e.getId().equals(myEntity3293PickGroup.getId()))
				.forEach(e -> repository3293Pick.save(e.setParentId(myEntity3293PickGroup.getId())));
	}

}