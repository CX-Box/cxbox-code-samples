package org.demo.documentation.widgets.tree.actions.create.basic;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3265TestDataLoadService {

	@Autowired
	MyEntity3265Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		// root 1: without Child
		MyEntity3265 root1 = createBaseEntity("Root 1");

		repository.save(root1);

		// root 2: without Child
		MyEntity3265 root2 = createBaseEntity("Root 2 (without children)");
		repository.save(root2);

		// root 3: without Child
		MyEntity3265 root3 = createBaseEntity("Root 3  (without children)");
		repository.save(root3);

		// root 4: without Child
		MyEntity3265 root4 = createBaseEntity("Root 4 (without children)") ;
		repository.save(root4);

		// root 5
		MyEntity3265 root5 = createBaseEntity("Root 5 (with children)") ;
		repository.save(root5);

		// ---- Create 3 child for root5 ----
		for (int i = 1; i <= 3; i++) {
			MyEntity3265 child = createBaseEntity("Child " + i + " of Root 1")
					.setParentId(String.valueOf(root5.getId()));
			repository.save(child);
		}
	}

	private MyEntity3265 createBaseEntity(String customFieldValue) {
		return new MyEntity3265()
				.setCustomField(customFieldValue)                                    // input 
				.setCustomFieldMoney(12345.67) ;                                      // money  
	}


}