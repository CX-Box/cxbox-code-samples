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
		repository.save(new MyEntity359().setCustomField("test data 1"));
		repository.save(new MyEntity359().setCustomField("test data 2"));
		repository.save(new MyEntity359().setCustomField("test data 3"));
		repository.save(new MyEntity359().setCustomField("test data 4"));
		repository.save(new MyEntity359().setCustomField("test data 5"));
		repository.save(new MyEntity359().setCustomField("test data 6"));
		repository.save(new MyEntity359().setCustomField("test data 7"));
		repository.save(new MyEntity359().setCustomField("test data 8"));

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
	}

}