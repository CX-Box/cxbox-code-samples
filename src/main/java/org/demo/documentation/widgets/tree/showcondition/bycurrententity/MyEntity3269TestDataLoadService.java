package org.demo.documentation.widgets.tree.showcondition.bycurrententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3269TestDataLoadService {

	@Autowired
	MyEntity3269Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repository.save(new MyEntity3269().setCustomField(4L));
		repository.save(new MyEntity3269().setCustomField(8L));
		repository.save(new MyEntity3269().setCustomField(9L));
		// root 1: without Child
		MyEntity3269 root1 = createBaseEntity("Root 1",4L);

		repository.save(root1);

		// root 2: without Child
		MyEntity3269 root2 = createBaseEntity("Root 2 (without children)",8L);
		repository.save(root2);

		// root 3: without Child
		MyEntity3269 root3 = createBaseEntity("Root 3  (without children)",9L);
		repository.save(root3);

		// root 4: without Child
		MyEntity3269 root4 = createBaseEntity("Root 4 (without children)",4L) ;
		repository.save(root4);

		// root 5
		MyEntity3269 root5 = createBaseEntity("Root 5 (with children)",7L) ;
		repository.save(root5);

		// ---- Create 3 child for root5 ----
		for (int i = 1; i <= 3; i++) {
			MyEntity3269 child = createBaseEntity("Child " + i + " of Root 1",i+5L)
					.setParentId(String.valueOf(root5.getId()));
			repository.save(child);
		}
	}
	private MyEntity3269 createBaseEntity(String customFieldInput,Long customField) {
		return new MyEntity3269()
				.setCustomField(customField)
				.setCustomFieldInput(customFieldInput) ;
	}
 

}