package org.demo.documentation.widgets.tree.showcondition.byparententity;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.tree.showcondition.byparententity.child.MyEntity3277;
import org.demo.documentation.widgets.tree.showcondition.byparententity.child.MyEntity3277Repository;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276;
import org.demo.documentation.widgets.tree.showcondition.byparententity.parent.MyEntity3276Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity32762TestDataLoadService {
	@Autowired
	MyEntity3276Repository repositoryParent;

	@Autowired
	MyEntity3277Repository repositoryChild;


	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {

		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repositoryChild.deleteAll();
		repositoryParent.deleteAll();
		// root 1: without Child
		MyEntity3276 root1 = createBaseEntity("Root 1", 3L);
		repositoryParent.save(root1);
		// root 2: without Child

		MyEntity3276 root2 = createBaseEntity("Root 2 (without children)", 5L);

		repositoryParent.save(root2);
		// root 3: without Child

		MyEntity3276 root3 = createBaseEntity("Root 3 (without children)", 7L);
		repositoryParent.save(root3);
		// root 4: without Child

		MyEntity3276 root4 = createBaseEntity("Root 4 (without children)", 2L);
		repositoryParent.save(root4);
		// root 5

		MyEntity3276 root5 = createBaseEntity("Root 5 (with children)", 7L);
		repositoryParent.save(root5);
		// ---- Create 3 child for root5 ----

		for (int i = 1; i <= 3; i++) {
			MyEntity3276 child = createBaseEntity("Child " + i + " of Root 1", i + 3L)
					.setParentTreeId(String.valueOf(root5.getId()));
			repositoryParent.save(child);
		}
		// root 1: without Child

		MyEntity3277 root77_1 = createBaseEntity77("Root 1");
		repositoryChild.save(root77_1);
		//root 2:without Child
		MyEntity3277 root77_2 = createBaseEntity77("Root 2 (without children)");
		repositoryChild.save(root77_2);
		//root 3:without Child
		MyEntity3277 root77_3 = createBaseEntity77("Root 3 (without children)");
		repositoryChild.save(root77_3);
		//root 4:without Child
		MyEntity3277 root77_4 = createBaseEntity77("Root 4 (without children)");
		repositoryChild.save(root77_4);
		//root 5
		MyEntity3277 root77_5 = createBaseEntity77("Root 5 (with children)");
		repositoryChild.save(root77_5);
		//----Create 3 child for root5----
		for (int i = 1; i <= 3; i++) {
			MyEntity3277 child = createBaseEntity77("Child " + i + " of Root 1").setParentTreeId(String.valueOf(root5.getId()));
			repositoryChild.save(child);
		}
	}

	private MyEntity3276 createBaseEntity(String customFieldValue, Long customFieldNumber) {
		return new MyEntity3276().setCustomField(customFieldValue).setCustomFieldMoney(12345.67).setCustomFieldNumber(customFieldNumber);

	}

	private MyEntity3277 createBaseEntity77(String customFieldValue) {
		return new MyEntity3277().setCustomField(customFieldValue).setCustomFieldMoney(12345.67);

	}

}