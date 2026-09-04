package org.demo.documentation.widgets.tree.actions.create.withwidget;


import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3279TestDataLoadService {

	@Autowired
	MyEntity3279Repository repository;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();

		// root 1: without Child
		MyEntity3279 root1 = createBaseEntity("Root 1 without children");

		repository.save(root1);

		// root 2: without Child
		MyEntity3279 root2 = createBaseEntity("Root 2 (without children)");
		repository.save(root2);

		// root 3: without Child
		MyEntity3279 root3 = createBaseEntity("Root 3  (without children)");
		repository.save(root3);

		// root 4: without Child
		MyEntity3279 root4 = createBaseEntity("Root 4 (without children)") ;
		repository.save(root4);

		// root 5
		MyEntity3279 root5 = createBaseEntity("Root 5 (with children)") ;
		repository.save(root5);

		// ---- Create 3 child for root5 ----
		for (int i = 1; i <= 3; i++) {
			MyEntity3279 child = createBaseEntity("Child " + i + " of Root 5")
					.setParentId(root5.getId());
			repository.save(child);
		}
	}

	private MyEntity3279 createBaseEntity(String customFieldValue) {
		return new MyEntity3279()
				.setCustomField(customFieldValue)                                    // input 
				.setCustomFieldMoney(12345.67) ;                                      // money  
	}

}