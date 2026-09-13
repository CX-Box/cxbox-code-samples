package org.demo.documentation.widgets.property.pagination.availablelimitselist;

import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.cxbox.api.service.session.InternalAuthorizationService;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.list.MyEntity3867;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.list.MyEntity3867Repository;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue.MyEntity3867Multi;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue.MyEntity3867MultiRepository;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup.MyEntity3867Pick;
import org.demo.documentation.widgets.property.pagination.availablelimitselist.picklistpopup.MyEntity3867PickListPopupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyEntity3867TestDataLoadService {

	@Autowired
	MyEntity3867Repository repository;

	@Autowired
	MyEntity3867MultiRepository repositoryMulti;

	@Autowired
	MyEntity3867PickListPopupRepository repositoryPick;

	@Autowired
	InternalAuthorizationService authzService;

	@Transactional
	@PostConstruct
	public void load() {
		authzService.loginAs(authzService.createAuthentication(InternalAuthorizationService.VANILLA));
		repository.deleteAll();
		repositoryMulti.deleteAll();
		repositoryPick.deleteAll();

		repository.save(new MyEntity3867().setCustomField("test data"));
		repository.save(new MyEntity3867().setCustomField("test data7"));
		repository.save(new MyEntity3867().setCustomField("test data3"));
		repository.save(new MyEntity3867().setCustomField("test data4"));
		repository.save(new MyEntity3867().setCustomField("test data5"));
		repository.save(new MyEntity3867().setCustomField("test data6"));
		repository.save(new MyEntity3867().setCustomField("test data7"));
		repository.save(new MyEntity3867().setCustomField("test data8"));
		repository.save(new MyEntity3867().setCustomField("test data9"));
		repository.save(new MyEntity3867().setCustomField("test data10"));

		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data7"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data3"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data4"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data5"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data6"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data7"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data8"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data9"));
		repositoryMulti.save(new MyEntity3867Multi().setCustomField("test data10"));

		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data7"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data3"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data4"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data5"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data6"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data7"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data8"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data9"));
		repositoryPick.save(new MyEntity3867Pick().setCustomField("test data10"));

		// the tree tab: the first record is the root, the others are its children
		List<MyEntity3867> all = repository.findAll();
		all.stream().skip(1).forEach(e -> repository.save(e.setParentId(all.get(0).getId())));
	}

}