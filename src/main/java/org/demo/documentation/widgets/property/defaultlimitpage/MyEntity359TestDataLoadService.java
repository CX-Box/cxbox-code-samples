package org.demo.documentation.widgets.property.defaultlimitpage;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359Assoc;
import org.demo.documentation.widgets.property.defaultlimitpage.forassoc.MyEntity359AssocRepository;
import org.demo.documentation.widgets.property.defaultlimitpage.forpick.MyEntity359Pick;
import org.demo.documentation.widgets.property.defaultlimitpage.forpick.MyEntity359PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity359TestDataLoadService {

	@Autowired
	MyEntity359Repository repository;

	@Autowired
	MyEntity359AssocRepository repositoryAssoc;

	@Autowired
	MyEntity359PickRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 1"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 2"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 3"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 4"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 5"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 6"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 7"));
		repositoryAssoc.save(new MyEntity359Assoc().setCustomField("test data 8"));

		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 1"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 2"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 3"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 4"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 5"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 6"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 7"));
		repositoryPick.save(new MyEntity359Pick().setCustomField("test data 8"));


		// root 1: without Child
		MyEntity359 root1 = createBaseEntity("Root 1");

		repository.save(root1);

		// root 2: without Child
		MyEntity359 root2 = createBaseEntity("Root 2 (without children)");
		repository.save(root2);

		// root 3: without Child
		MyEntity359 root3 = createBaseEntity("Root 3  (without children)");
		repository.save(root3);

		// root 4: without Child
		MyEntity359 root4 = createBaseEntity("Root 4 (without children)") ;
		repository.save(root4);

		// root 5
		MyEntity359 root5 = createBaseEntity("Root 5 (with children)") ;
		repository.save(root5);

		// ---- Create 3 child for root5 ----
		for (int i = 1; i <= 3; i++) {
			MyEntity359 child = createBaseEntity("Child " + i + " of Root 1")
					.setParentId(String.valueOf(root5.getId()));
			repository.save(child);
		}
	}

	private MyEntity359 createBaseEntity(String customFieldValue) {
		return new MyEntity359()
				.setCustomField(customFieldValue)                                    // input
				.setCustomFieldMoney(12345.67) ;                                      // money
	}

}